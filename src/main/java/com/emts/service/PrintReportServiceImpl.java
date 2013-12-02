package com.emts.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emts.dao.PrintReportDao;
import com.emts.model.Client;
import com.emts.model.Publication;

@Service
public class PrintReportServiceImpl implements PrintReportService{
@Autowired PrintReportDao printReportDao;

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Client> getAllClient() {
	List<Client> client=new ArrayList<Client>();
	client=(List)printReportDao.getAllClient();
	return client;
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<Publication> getAllPublication() {
    List<Publication> publication = new ArrayList<Publication>();
    publication = (List)printReportDao.getAllPublication();
	return publication;
}

public HashMap<String, Object[]> pieChartReport(Integer clientId,
		String fromDate, String toDate, Integer publicationId, String param) {
	return printReportDao.pieChartReport(clientId, fromDate, toDate, publicationId, param);
}
}
