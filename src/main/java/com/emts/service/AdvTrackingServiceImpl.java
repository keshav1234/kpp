package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emts.dao.AdvTrackingDao;
import com.emts.model.AdvType;
import com.emts.model.AdvertisementTracking;
import com.emts.model.Chanel;
import com.emts.model.City;
import com.emts.model.Client;
import com.emts.model.Party;
import com.emts.model.State;
import com.emts.util.IConstant;

@Service
public class AdvTrackingServiceImpl implements AdvTrackingService{
@Autowired AdvTrackingDao advTrackingDao;

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<State> getAllState() {
	List<State> state=new ArrayList<State>();
	state=(List)advTrackingDao.getAllState();
	return state;
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<City> getAllCity() {
	List<City> city=new ArrayList<City>();
	city=(List)advTrackingDao.getAllCity();
	return city;
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Chanel> getAllChanel() {
	List<Chanel> chanel=new ArrayList<Chanel>();
	chanel=(List)advTrackingDao.getAllChanel();
	return chanel;
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Client> getAllClient() {
	List<Client> client=new ArrayList<Client>();
	client=(List)advTrackingDao.getAllClient();
	return client;
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Party> getAllParty() {
	List<Party> party=new ArrayList<Party>();
	party=(List)advTrackingDao.getAllParty();
	return party;
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<AdvType> getAlladvType() {
	List<AdvType> advType=new ArrayList<AdvType>();
	advType=(List)advTrackingDao.getAlladvType();
	return advType;
}

public void addAdvTracking(AdvertisementTracking advTracking) {
	advTracking.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
	advTrackingDao.addAdvTracking(advTracking);
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<AdvertisementTracking> getContent() {
	List<AdvertisementTracking>advTrackingContent=new ArrayList<AdvertisementTracking>();
	advTrackingContent=(List)advTrackingDao.getContent();
	return advTrackingContent;
}

public void deleteAdvTracking(Integer Id) {
	advTrackingDao.deleteAdvTracking(Id);
	
}

public AdvertisementTracking updateAdvTracking(Integer Id) {
	List<Object> advTracking=new ArrayList<Object>();
	AdvertisementTracking updateAdvTracking=new AdvertisementTracking();
	advTracking=advTrackingDao.updateAdvTracking(Id);
	/*List convert to object*/
	for (Object object : advTracking) {
		updateAdvTracking= (AdvertisementTracking) object; 
	}
	return updateAdvTracking;
}

public void repeatAdvTracking(AdvertisementTracking advTracking) {
	advTracking.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
	advTrackingDao.repeatAdvTracking(advTracking);	
}
}

