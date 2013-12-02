package com.emts.service;

import java.util.HashMap;
import java.util.List;

import com.emts.model.Client;
import com.emts.model.Publication;

public interface PrintReportService {
	public List<Client> getAllClient();
	public List<Publication> getAllPublication();
	public HashMap<String,Object[]> pieChartReport(Integer clientId, String fromDate, String toDate, Integer publicationId, String param);
}
