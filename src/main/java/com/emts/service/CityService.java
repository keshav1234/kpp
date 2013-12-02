package com.emts.service;

import java.util.List;

import com.emts.model.City;
import com.emts.model.Country;
import com.emts.model.State;

public interface CityService {
	public List<State>getAllState();
	public List<Country>getAllCountry();
	public void addcityName(City city);
	public List<City> getContent();
	public void removeContent(Integer Id);
	public City updateCity(Integer Id);
}
