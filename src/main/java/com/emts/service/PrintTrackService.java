package com.emts.service;
import java.util.List;
import com.emts.model.City;
import com.emts.model.Client;
import com.emts.model.PrintTracking;
import com.emts.model.Publication;
import com.emts.model.Sector;
import com.emts.model.State;
import com.emts.model.SubSector;
public interface PrintTrackService {
	public List<State> getAllState();
	public List<City> getAllCity();
	public List<Client> getAllClient();
	public List<Sector> getAllSector();
	public List<SubSector> getAllSubSector();
	public List<Publication> getAllPublication();
	public void addPrintTrack(PrintTracking printTracking);
	public List<PrintTracking> getContent();
	public void deletePrintTrack(Integer id);
	public PrintTracking updatePrintTracking(Integer Id);
	
 }
