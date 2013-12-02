package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emts.dao.CountryDao;
import com.emts.model.Country;
import com.emts.util.IConstant;
@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryDao countrydao;
	
	
	@Transactional
	public void addCountryname(Country country)
	{
	    country.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
		countrydao.addCountryname(country);
		
	}

	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Country> getContent() {
		List<Country>countryContent=new ArrayList<Country>();
		countryContent=(List)countrydao.getContent();
		return countryContent;
	}

	@Transactional
	public void removeContent(Integer Id) {
		
		countrydao.removeContent(Id);
		
	}
	public Country editContent(Integer Id) {
		List<Object> country=new ArrayList<Object>();
		Country editCountry = new Country();
		country=countrydao.editContent(Id);
		/*List convert to object*/
		for (Object object : country) {
			editCountry= (Country) object; 
		}
		return editCountry;
	}

}
