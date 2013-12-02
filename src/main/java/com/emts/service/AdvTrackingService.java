package com.emts.service;

import java.util.List;

import com.emts.model.AdvType;
import com.emts.model.AdvertisementTracking;
import com.emts.model.Chanel;
import com.emts.model.City;
import com.emts.model.Client;
import com.emts.model.Party;
import com.emts.model.State;

public interface AdvTrackingService {
	public List<State>getAllState();
	public List<City> getAllCity() ;
	public List<Chanel> getAllChanel();
	public void addAdvTracking(AdvertisementTracking advTracking);
	public List<Client> getAllClient();
	public List<Party> getAllParty();
	public List<AdvType> getAlladvType();
	public List<AdvertisementTracking> getContent();
	public void deleteAdvTracking(Integer Id);
	public AdvertisementTracking updateAdvTracking(Integer Id);
	public void repeatAdvTracking(AdvertisementTracking advTracking);
}
