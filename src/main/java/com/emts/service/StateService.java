package com.emts.service;

import java.util.List;

import com.emts.model.Country;
import com.emts.model.State;

public interface StateService {
	public List<Country>getAllCountry();
	public void addStateName(State state);
	public List<State> getContent();
	public void removeContent(Integer Id);
	public State updateState(Integer Id);
}
