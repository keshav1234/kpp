package com.emts.dao;

import java.util.List;

import com.emts.model.City;

public interface CityDao {
	public List<Object> getAllState();
	public List<Object> getAllCountry();
	public void addcityName(City city);
	public List<Object> getContent();
	public void removeContent(Integer Id);
	public List<Object> updateCity(Integer Id);
}
