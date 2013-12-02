package com.emts.dao;

import java.util.List;

import com.emts.model.Tracking;

public interface SaveTrackDao {
	public void addSaveTracking(Tracking saveTracking);
	public List<Object> getAllState();
	public List<Object> getAllCity(); 
	public List<Object> getAllSector(); 
	public List<Object> getAllSubSector(); 
	public List<Object> getAllChanel();
	public List<Object> getAllClient();
	public List<Object> getAllNewsType();
	public List<Object> getContent();
	public void deleteTracking(Integer Id);
	public List<Object> updateTracking(Integer Id);
}
