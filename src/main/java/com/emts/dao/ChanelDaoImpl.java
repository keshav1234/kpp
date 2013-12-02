package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.Chanel;
import com.emts.model.State;
import com.emts.util.IConstant;
@Repository
public class ChanelDaoImpl implements ChanelDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("unchecked")
	public List<Object> getAllState() {
		List<Object> state=null;
		state=hibernateTemplate.find("from State where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return state;
	}
	public void addChanelName(Chanel chanel) {
		State state=(State)hibernateTemplate.get(State.class, chanel.getState().getStateId());
		chanel.setState(state);
		hibernateTemplate.saveOrUpdate(chanel);
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		List<Object> chanelContent=null;
		chanelContent=hibernateTemplate.find("from Chanel where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return chanelContent;
	}
	public void removeContent(Integer Id) {
		Chanel chanel=(Chanel)hibernateTemplate.get(Chanel.class, Id);
		chanel.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if(null!=chanel)
		{
			hibernateTemplate.update(chanel);
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> updateChanel(Integer Id) {
		List<Object> chanel=null;
		chanel=hibernateTemplate.find("from Chanel chanel where chanel.channelId=?",Id );
		return chanel;
	}

}
