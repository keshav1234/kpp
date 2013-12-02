package com.emts.dao;
import java.util.HashMap;
import java.util.List;
public interface ReportDao {
	public List<Object> getAllClient();
	public List<Object> getAllChanel();
	public HashMap<String,Object[]> pieChartReport(Integer clientId, String fromDate, String toDate, Integer channelId, String param);
	public HashMap<String, List<Object>> genrateSectorWisePieChartReport(Integer clientId, String fromDate, String toDate, Integer channelId, String param);
	public HashMap<String, List<Object>> channelWisePieChart(Integer clientId, String fromDate, String toDate, String param);
	public List<Object> EMTPDFReport(String fromDate, String toDate, Integer channelId);
}
