package com.emts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.Country;
import com.emts.util.IConstant;
@Repository
public class CountryDaoImpl implements CountryDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void addCountryname(Country country) {
		hibernateTemplate.saveOrUpdate(country);
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		List<Object> countryContent=null;
		countryContent=hibernateTemplate.find("from Country where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return countryContent;
	}
	public void removeContent(Integer Id) {
		Country country=(Country)hibernateTemplate.get(Country.class,Id);
		country.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if(null!=country)
		{
			System.out.println("if Block");
			hibernateTemplate.update(country);
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> editContent(Integer Id) {
		List<Object> country=null;
		 country=hibernateTemplate.find("from Country c where c.countryId=?",Id);
		return country;
		
	}

}
