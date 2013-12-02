package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.City;
import com.emts.model.State;
import com.emts.util.IConstant;

@Repository
public class CityDaoImpl implements CityDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("unchecked")
	public List<Object> getAllState() {
		List<Object> state=null;
		state=hibernateTemplate.find("from State where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return state;
	}
	@SuppressWarnings("unchecked")
	public List<Object> getAllCountry() {
		List<Object> country=null;
		country=hibernateTemplate.find("from Country where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return country;
	}
	public void addcityName(City city) {
	State state=(State)hibernateTemplate.get(State.class, city.getState().getStateId());
	city.setState(state);
		hibernateTemplate.saveOrUpdate(city);
	}
	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		List<Object> cityContent=null;
		cityContent=hibernateTemplate.find("from City where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return cityContent;
	}
	public void removeContent(Integer Id) {
		City city=(City)hibernateTemplate.get(City.class, Id);
		city.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if(null!=city)
		{
			hibernateTemplate.update(city);
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> updateCity(Integer Id) {
		List<Object> city=null;
		 city=hibernateTemplate.find("from City city where city.cityId=?",Id);
		return city;
	}
}
