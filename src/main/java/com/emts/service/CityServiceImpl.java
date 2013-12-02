package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emts.dao.CityDao;
import com.emts.model.City;
import com.emts.model.Country;
import com.emts.model.State;
import com.emts.util.IConstant;

@Service
public class CityServiceImpl implements CityService{
@Autowired CityDao citydao;
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<State> getAllState() {
	List<State> state=new ArrayList<State>();
	state=(List)citydao.getAllState();
	return state;
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Country> getAllCountry() {
	List<Country> country=new ArrayList<Country>();
	country=(List)citydao.getAllCountry();
	return country;
}
@Transactional
public void addcityName(City city) {
	city.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
	citydao.addcityName(city);
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<City> getContent() {
	List<City> cityContent=new ArrayList<City>();
	cityContent=(List)citydao.getContent();
	return cityContent;
}
public void removeContent(Integer Id) {
	citydao.removeContent(Id);
	
}
public City updateCity(Integer Id) {
	List<Object> city=new ArrayList<Object>();
	City updateCity = new City();
	city=citydao.updateCity(Id);
	/*List convert to object*/
	for (Object object : city) {
		updateCity= (City) object; 
	}
	return updateCity;
}
}
