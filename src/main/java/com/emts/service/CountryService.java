package com.emts.service;

import java.util.List;

import com.emts.model.Country;

public interface CountryService {
	public void addCountryname(Country country);
	public List<Country> getContent();
	public void removeContent(Integer Id);
	public Country editContent(Integer Id);
}
