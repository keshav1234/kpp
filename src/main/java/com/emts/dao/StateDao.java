package com.emts.dao;

import java.util.List;

import com.emts.model.State;

public interface StateDao {
	public List<Object> getAllCountry();
	public void addStateName(State state);
	public List<Object> getContent();
	public void removeContent(Integer Id);
	public List<Object> updateState(Integer Id);
}
