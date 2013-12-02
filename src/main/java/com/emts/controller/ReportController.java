package com.emts.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emts.model.Chanel;
import com.emts.model.Client;
import com.emts.model.PieChart;
import com.emts.model.Publication;
import com.emts.model.Tracking;
import com.emts.service.PrintReportService;
import com.emts.service.ReportService;

@Controller
public class ReportController {
	
@Autowired 
private ReportService reportService;

@Autowired 
private PrintReportService printReportService;
	
/*Pie Chart for Electronic Media Tracking*/

	@RequestMapping("/piechart")
	public String showPiechart(Map<String, Object> map,Model model)
	{
		map.put("PieChart",new PieChart());
		List<Client> client=new ArrayList<Client>();
		client=reportService.getAllClient();
		if(client!=null)
		{
			model.addAttribute("client", client);
		}
		List<Chanel> chanel=new ArrayList<Chanel>();
		chanel=reportService.getAllChanel();
		if(chanel!=null)
		{
			model.addAttribute("chanel", chanel);
		}
		return "piechart";
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/PieChartReport", method = {RequestMethod.GET,RequestMethod.POST })
	public String genrateReport(@ModelAttribute("PieChart") PieChart pieChart,BindingResult result ,ModelMap  model
			,HttpServletRequest request,@RequestParam(required=false) String param ) 
	{
		
		List<Client> client=new ArrayList<Client>();
		client=reportService.getAllClient();
		if(client!=null)
		{
			model.addAttribute("client", client);
		}
		List<Chanel> chanel=new ArrayList<Chanel>();
		chanel=reportService.getAllChanel();
		if(chanel!=null)
		{
			model.addAttribute("chanel", chanel);
		}
		/*All Channel and Individual Channel Negative Positive Report(Electronic Media Tracking)*/
		if(param!=null && (param.equals("{param=Channel}")||  param.equals("{param=AllChannel}")))
		{
		HashMap<String, Object[]> map=reportService.pieChartReport(pieChart.getClientId(),pieChart.getFromDate(),pieChart.getToDate(),pieChart.getChannelId(),param);
             Set  set = map.keySet();
             Iterator  it = set.iterator();
             int i=1;
             while(it.hasNext())
             {
            	Object[] obj=(Object[]) map.get(it.next());
            	@SuppressWarnings("unchecked")
				ArrayList list = new ArrayList(Arrays.asList(obj));
            	model.addAttribute("obj"+i++,list);
            	
             }
             return "generateAllChannelPieCharts";  
             
		}
		/*Sector Wise All Channel Negative Positive Report(Electronic Media Tracking)*/
		if(param!=null && param.equals("{param=Sector}"))
		{
			HashMap<String, List<Object>> sectorMap=   reportService.genrateSectorWisePieChartReport(pieChart.getClientId(),pieChart.getFromDate(),pieChart.getToDate(),pieChart.getChannelId(),param);
			 Set  set = sectorMap.keySet();
             Iterator  it = set.iterator();
             while(it.hasNext())
             {
            	 List<Object> sectorPositiveList= (List<Object>)sectorMap.get(it.next());
            	 List<Object> sectorNegativeList= (List<Object>)sectorMap.get(it.next());
            	 model.addAttribute("sectorPositiveList",sectorPositiveList);
            	 model.addAttribute("sectorNegativeList",sectorNegativeList);
             }
			
			return "generateElectronicMediaSectorWisePieChart";
		}
		/* Channel Wise Negative Positive Report(Electronic Media Tracking)*/
		if(param!=null && param.equals("{param=AllChannelNegativePositive}"))
		{
			System.out.println("AllChannelNegativePositive");
			HashMap<String, List<Object>> map = reportService.channelWisePieChart(pieChart.getClientId(),pieChart.getFromDate(),pieChart.getToDate(),param);
			Set set = map.keySet();
			Iterator iterator=set.iterator();
			while(iterator.hasNext())
			{
           	 List<Object> ChannelPositiveList= (List<Object>)map.get(iterator.next());
           	 List<Object> ChannelNegativeList= (List<Object>)map.get(iterator.next());
           	 List<Object> ChannelList= (List<Object>)map.get(iterator.next());
           	
           	 model.addAttribute("ChannelPositiveList",ChannelPositiveList);
           	 model.addAttribute("ChannelNegativeList",ChannelNegativeList);
           	 model.addAttribute("ChannelList",ChannelList);
           	 System.out.println("ChannelList----"+ChannelList.size());
			}
			return "generateChannelWisePieChart";
		}
		
		return "piechart";
	}
	
	@RequestMapping("/generateAllChannelPieCharts")
	public String AllChannelPieChart(Map<String, Object> map,ModelMap model)
	{
		System.out.println("generateAllChannelPieCharts Controller");
		return "generateAllChannelPieCharts";
	}
	@RequestMapping("/generateElectronicMediaSectorWisePieChart")
	public String sectorWiseReport(Map<String, Object> map,ModelMap model)
	{
		System.out.println("  generateElectronicMediaSectorWisePieChart for sectorWiseReport");
		return "generateElectronicMediaSectorWisePieChart";
	}
	@RequestMapping("/generateChannelWisePieChart")
	public String chanelWiseReport(Map<String, Object> map,ModelMap model)
	{
		System.out.println("Channel Wise PieChart Report");
		return "generateChannelWisePieChart";
	}
	
	
	/*PDF Report For channel(Electronic Media Tracking)*/
	@RequestMapping("/PDFReport")
	public String showPDFReport(Map<String, Object> map,Model model)
	{
		map.put("PieChart",new PieChart());
		List<Client> client=new ArrayList<Client>();
		client=reportService.getAllClient();
		if(client!=null)
		{
			model.addAttribute("client", client);
		}
		List<Chanel> chanel=new ArrayList<Chanel>();
		chanel=reportService.getAllChanel();
		if(chanel!=null)
		{
			model.addAttribute("chanel", chanel);
		}
		return "PDFReport";
	}
	@RequestMapping(value = "/EMTorPDFReport", method = {RequestMethod.GET,RequestMethod.POST })
	public String genratePDFReport(@ModelAttribute("PieChart") PieChart pieChart,BindingResult result ,ModelMap  model
			,HttpServletRequest request,@RequestParam(required=false) String param ) 
	{
		System.out.println("PDF Report Action");
		List<Tracking> pdfTracking=new ArrayList<Tracking>();
		pdfTracking=reportService.EMTPDFReport(pieChart.getFromDate(),pieChart.getToDate(),pieChart.getChannelId());
		if(pdfTracking!=null)
		{
			model.addAttribute("pdfTracking", pdfTracking);
		}

		System.out.println("pdfTracking Controller--"+pdfTracking);
		return "generatePDFReport";
	}
	

	@RequestMapping("/generateBarChart")
	public String showBarChart(Map<String, Object> map,Model model)
	{
		return "generateBarChart";
	}
	
	@RequestMapping("/printPieChart")
	public String showprintPieChart(Map<String, Object> map,Model model)
	{
		map.put("PieChart",new PieChart());
		List<Client> client=new ArrayList<Client>();
		client=printReportService.getAllClient();
		if(client!=null)
		{
			model.addAttribute("client", client);
		}
		List<Publication> publication = new ArrayList<Publication>();
		publication = printReportService.getAllPublication();
		if (publication != null) {
			model.addAttribute("publication", publication);
		}
		return "printPieChart";
	}
	
	
	@RequestMapping(value = "/PrintPieChartReport", method = {RequestMethod.GET,RequestMethod.POST })
	public String genratePrintReport(@ModelAttribute("PieChart") PieChart pieChart,BindingResult result ,ModelMap  model
			,HttpServletRequest request,@RequestParam(required=false) String param ) 
	{
		System.out.println("Print Chart Report"+param);
		return "printPieChart";
	}
	
	@RequestMapping("/generatePrintPDFReport")
	public String showprintPDFReport(Map<String, Object> map,Model model)
	{
		return "generatePrintPDFReport";
	}
}

