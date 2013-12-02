package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emts.dao.ChanelDao;
import com.emts.model.Chanel;
import com.emts.model.State;
import com.emts.util.IConstant;

@Service
public class ChanelServiceImpl implements ChanelService {
	@Autowired ChanelDao chaneldao;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<State> getAllState() {
		List<State> state=new ArrayList<State>();
		state=(List)chaneldao.getAllState();
		return state;
		
	}
	@Transactional
	public void addChanelName(Chanel chanel) {
		chanel.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
		chaneldao.addChanelName(chanel);
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Chanel> getContent() {
		List<Chanel>chanelContent=new ArrayList<Chanel>();
		chanelContent=(List)chaneldao.getContent();
		return chanelContent;
	}
	public void removeContent(Integer Id) {
		chaneldao.removeContent(Id);
		
	}
	public Chanel updateChanel(Integer Id) {
		List<Object> chanel=new ArrayList<Object>();
		Chanel updateChanel=new Chanel();
		chanel=chaneldao.updateChanel(Id);
		for (Object object :chanel)
		{
			updateChanel=(Chanel)object;
		}
		return updateChanel;
	}

}
