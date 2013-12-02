package com.emts.dao;

import java.util.HashMap;
import java.util.List;

public interface PrintReportDao {
	public List<Object> getAllClient();
	public List<Object> getAllPublication();
	public HashMap<String,Object[]> pieChartReport(Integer clientId, String fromDate, String toDate, Integer publicationId, String param);
}
