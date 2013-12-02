package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.Country;
import com.emts.model.State;
import com.emts.util.IConstant;
@Repository
public class StateDaoImpl implements StateDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<Object> getAllCountry() {
		List<Object> country=null;
		country=hibernateTemplate.find("from Country where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return country;
	}

	public void addStateName(State state) {
		Country country=(Country)hibernateTemplate.get(Country.class,state.getCountry().getCountryId());
		state.setCountry(country);
		hibernateTemplate.saveOrUpdate(state);
	}

	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		List<Object> stateContent=null;
		stateContent=hibernateTemplate.find("from State where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return stateContent;
	}

	public void removeContent(Integer Id) {
		State state=(State)hibernateTemplate.get(State.class ,Id);
		state.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if(null!=state)
		{
			hibernateTemplate.update(state);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object> updateState(Integer Id) {
		List<Object> state=null;
		 state=hibernateTemplate.find("from State state where state.stateId=?",Id);
		return state;
		
	}

}
