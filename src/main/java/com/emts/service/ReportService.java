package com.emts.service;
import java.util.HashMap;
import java.util.List;

import com.emts.model.Chanel;
import com.emts.model.Client;
import com.emts.model.Tracking;
public interface ReportService {
	public List<Client> getAllClient();
	public List<Chanel> getAllChanel();
	public HashMap<String, Object[]> pieChartReport(Integer clientId, String fromDate, String toDate,Integer channelId,String param);
	public HashMap<String, List<Object>> genrateSectorWisePieChartReport(Integer clientId,
			                                 String fromDate, String toDate, Integer channelId, String param);
	public HashMap<String, List<Object>> channelWisePieChart(Integer clientId, String fromDate,
			String toDate, String param);
	public List<Tracking> EMTPDFReport(String fromDate, String toDate, Integer channelId);
}
