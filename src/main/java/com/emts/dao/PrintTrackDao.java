package com.emts.dao;

import java.util.List;

import com.emts.model.PrintTracking;

public interface PrintTrackDao {
	public List<Object> getAllState();
	public List<Object> getAllCity(); 
	public List<Object> getAllClient();
	public List<Object> getAllSector(); 
	public List<Object> getAllSubSector();
	public List<Object> getAllPublication();
	public void addPrintTrack(PrintTracking printTracking);
	public List<Object> getContent();
	public void deleteTracking(Integer id);
	public List<Object> updatePrintTracking(Integer Id);
}
