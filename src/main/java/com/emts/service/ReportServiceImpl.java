package com.emts.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emts.dao.ReportDao;
import com.emts.model.Chanel;
import com.emts.model.Client;
import com.emts.model.Tracking;
@Service
public class ReportServiceImpl implements ReportService{
@Autowired
private ReportDao reportDao;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Client> getAllClient() {
		List<Client> client=new ArrayList<Client>();
		client=(List)reportDao.getAllClient();
		return client;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Chanel> getAllChanel() {
		List<Chanel> chanel=new ArrayList<Chanel>();
		chanel=(List)reportDao.getAllChanel();
		return chanel;
	}
	public HashMap<String, Object[]> pieChartReport(Integer clientId, String fromDate, String toDate,Integer channelId, String param) {
	return	reportDao.pieChartReport( clientId,  fromDate,  toDate, channelId, param);
	}
	@SuppressWarnings("rawtypes")
	public HashMap<String, List<Object>> genrateSectorWisePieChartReport(Integer clientId, String fromDate, String toDate, Integer channelId, String param) {
		
		HashMap<String, List<Object>> map= reportDao.genrateSectorWisePieChartReport( clientId,  fromDate,  toDate, channelId, param);
		HashMap<String, List<Object>> sectorMap =new HashMap<String, List<Object>>();
		 Set set = map.keySet();
		 Iterator iterator = set.iterator();
		 
		 while(iterator.hasNext())
		 {
			 List<Object> sectorPositiveList=   (List<Object>) map.get(iterator.next());
			 List<Object> sectorNegitiveList=   (List<Object>) map.get(iterator.next());
			/* for(int j=0;j<sectorPositiveList.size();j++)
			 {
			   Object[] obj = (Object[])sectorPositiveList.get(j);
			   ArrayList positiveSector = new ArrayList(Arrays.asList(obj));
			   sectorMap.put("positiveSector"+j, positiveSector);
			 }
			 for(int j=0;j<sectorNegitiveList.size();j++)
			 {
			   Object[] obj = (Object[])sectorNegitiveList.get(j);
			   ArrayList negativeSector = new ArrayList(Arrays.asList(obj));
			   sectorMap.put("negativeSector"+j, negativeSector);
			 }*/
			 sectorMap.put("sectorPositiveList", sectorPositiveList);
			 sectorMap.put("sectorNegitiveList", sectorNegitiveList); 
			   
		 }
		 return sectorMap;
	}
	public HashMap<String, List<Object>> channelWisePieChart(Integer clientId, String fromDate,
			String toDate, String param) {
		return reportDao.channelWisePieChart( clientId,  fromDate,  toDate, param);
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Tracking> EMTPDFReport(String fromDate, String toDate, Integer channelId) {
		List<Tracking> pdfTracking=new ArrayList<Tracking>();
		pdfTracking=(List)reportDao.EMTPDFReport( fromDate,  toDate, channelId);
		return pdfTracking;
	}
	
}
