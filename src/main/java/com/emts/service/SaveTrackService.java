package com.emts.service;

import java.util.List;

import com.emts.model.Chanel;
import com.emts.model.City;
import com.emts.model.Client;
import com.emts.model.NewsType;
import com.emts.model.Sector;
import com.emts.model.State;
import com.emts.model.SubSector;
import com.emts.model.Tracking;

public interface SaveTrackService {
	public void addSaveTracking(Tracking saveTracking);
	public List<State>getAllState();
	public List<City> getAllCity() ;
	public List<Sector> getAllSector();
	public List<SubSector> getAllSubSector();
	public List<Chanel> getAllChanel();
	public List<Client> getAllClient();
	public List<NewsType> getAllNewsType();
	public List<Tracking> getContent();
	public void deleteTracking(Integer Id);
	public Tracking updateTracking(Integer Id);
}
