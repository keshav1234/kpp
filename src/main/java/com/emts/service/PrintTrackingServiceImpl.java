package com.emts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emts.dao.PrintTrackDao;
import com.emts.model.City;
import com.emts.model.Client;
import com.emts.model.PrintTracking;
import com.emts.model.Publication;
import com.emts.model.Sector;
import com.emts.model.State;
import com.emts.model.SubSector;
import com.emts.util.IConstant;
@Service
public class PrintTrackingServiceImpl implements PrintTrackService {
@Autowired PrintTrackDao printTrackDao ;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<State> getAllState() {
		List<State> state=new ArrayList<State>();
		state=(List)printTrackDao.getAllState();
		return state;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<City> getAllCity() {
		List<City> city=new ArrayList<City>();
		city=(List)printTrackDao.getAllCity();
		return city;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Client> getAllClient() {
		List<Client> client=new ArrayList<Client>();
		client=(List)printTrackDao.getAllClient();
		return client;
      }
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Sector> getAllSector() {
		List<Sector> sector=new ArrayList<Sector>();
		sector=(List)printTrackDao.getAllSector();
		return sector;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SubSector> getAllSubSector() {
		List<SubSector> subsector=new ArrayList<SubSector>();
		subsector=(List)printTrackDao.getAllSubSector();
		return subsector;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Publication> getAllPublication() {
        List<Publication> publication = new ArrayList<Publication>();
        publication = (List)printTrackDao.getAllPublication();
		return publication;
	}
	public void addPrintTrack(PrintTracking printTracking){
		printTracking.setIsDeleted(IConstant.IS_DELETED_ACTIVE);
		printTrackDao.addPrintTrack(printTracking);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrintTracking> getContent() {
     List<PrintTracking> printTrackingList = new ArrayList<PrintTracking>();
     printTrackingList = (List)printTrackDao.getContent();
		return printTrackingList;
	}
	public void deletePrintTrack(Integer id) {
		printTrackDao.deleteTracking(id);
		
	}
	public PrintTracking updatePrintTracking(Integer Id) {
		List<Object> printTracking=new ArrayList<Object>();
		PrintTracking updatePrintTracking=new PrintTracking();
		printTracking=printTrackDao.updatePrintTracking(Id);	/*List convert to object*/
		for (Object object : printTracking) {
			updatePrintTracking= (PrintTracking) object; 
		}
		return updatePrintTracking;
	}
	}
	

