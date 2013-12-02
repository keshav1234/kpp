package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emts.dao.SaveTrackDao;
import com.emts.model.Chanel;
import com.emts.model.City;
import com.emts.model.Client;
import com.emts.model.NewsType;
import com.emts.model.Sector;
import com.emts.model.State;
import com.emts.model.SubSector;
import com.emts.model.Tracking;
import com.emts.util.IConstant;

@Service
public class SaveTrackServiceImpl implements SaveTrackService {
@Autowired SaveTrackDao savetrackdao;
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<State> getAllState() {
	List<State> state=new ArrayList<State>();
	state=(List)savetrackdao.getAllState();
	return state;
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<City> getAllCity() {
	List<City> city=new ArrayList<City>();
	city=(List)savetrackdao.getAllCity();
	return city;
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Sector> getAllSector() {
	List<Sector> sector=new ArrayList<Sector>();
	sector=(List)savetrackdao.getAllSector();
	return sector;
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<SubSector> getAllSubSector() {
	List<SubSector> subsector=new ArrayList<SubSector>();
	subsector=(List)savetrackdao.getAllSubSector();
	return subsector;
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Chanel> getAllChanel() {
	List<Chanel> chanel=new ArrayList<Chanel>();
	chanel=(List)savetrackdao.getAllChanel();
	return chanel;
}
public void addSaveTracking(Tracking saveTracking) {
	saveTracking.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
	/*saveTracking.setStoryCode(saveTracking.getChanel().getShortChannelName()+"-"+ saveTracking.getDate()+"-"+saveTracking.getTrackingId());*/
	savetrackdao.addSaveTracking(saveTracking);
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Client> getAllClient() {
	List<Client> client=new ArrayList<Client>();
	client=(List)savetrackdao.getAllClient();
	return client;
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<NewsType> getAllNewsType() {
	List<NewsType> newsType=new ArrayList<NewsType>();
	newsType=(List)savetrackdao.getAllNewsType();
	return newsType;
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Tracking> getContent() {
	List<Tracking>trackingContent=new ArrayList<Tracking>();
	trackingContent=(List)savetrackdao.getContent();
	return trackingContent;
}
public void deleteTracking(Integer Id) {
	savetrackdao.deleteTracking(Id);
}
public Tracking updateTracking(Integer Id) {
	List<Object> tracking=new ArrayList<Object>();
	Tracking updateTracking=new Tracking();
	tracking=savetrackdao.updateTracking(Id);	/*List convert to object*/
	for (Object object : tracking) {
		updateTracking= (Tracking) object; 
	}
	return updateTracking;
}
}
