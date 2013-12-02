package com.emts.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emts.model.AdvType;
import com.emts.model.AdvertisementTracking;
import com.emts.model.Chanel;
import com.emts.model.City;
import com.emts.model.Client;
import com.emts.model.NewsType;
import com.emts.model.Party;
import com.emts.model.PieChart;
import com.emts.model.PrintTracking;
import com.emts.model.Publication;
import com.emts.model.Sector;
import com.emts.model.State;
import com.emts.model.SubSector;
import com.emts.model.Tracking;
import com.emts.service.AdvTrackingService;
import com.emts.service.PrintTrackService;
import com.emts.service.SaveTrackService;
import com.emts.service.SearchStoryCodeService;
import com.emts.validator.AdvTrackingValidator;
import com.emts.validator.PrintTrackingValidator;
import com.emts.validator.SaveTrackingValidator;

@Controller
public class TrackingController {

	@Autowired 
	private SaveTrackingValidator saveTrackingValidator;

	@Autowired 
	private AdvTrackingService advTrackingService;

	@Autowired 
	private SaveTrackService saveTrackService;

	@Autowired 
	private AdvTrackingValidator advTrackingValidator;
	
	@Autowired
	private PrintTrackService printTrackService;
	
	@Autowired
	private PrintTrackingValidator printTrackingValidator;
	
	@Autowired
	private SearchStoryCodeService storyCodeService ;
	/*Save Tracking  Controller Start*/
	@RequestMapping(value = "/savetracking",method=RequestMethod.GET)  
	public String savetracking(@ModelAttribute("Tracking")Tracking tracking,Model model) {
		System.out.println("Tracking Controller");
		List<State> state=new ArrayList<State>();
		state=saveTrackService.getAllState();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}
		List<City> city=new ArrayList<City>();
		city=saveTrackService.getAllCity();
		if(city!=null)
		{
			model.addAttribute("city", city);
		}
		List<Sector> sector=new ArrayList<Sector>();
		sector=saveTrackService.getAllSector();
		if(sector!=null)
		{
			model.addAttribute("sector", sector);
		}
		List<SubSector> subsector=new ArrayList<SubSector>();
		subsector=saveTrackService.getAllSubSector();
		if(subsector!=null)
		{
			model.addAttribute("subsector", subsector);
		}
		List<Chanel> chanel=new ArrayList<Chanel>();
		chanel=saveTrackService.getAllChanel();
		if(chanel!=null)
		{
			model.addAttribute("chanel", chanel);
		}
		List<Client> client=new ArrayList<Client>();
		client=saveTrackService.getAllClient();
		if(client!=null)
		{
			model.addAttribute("client", client);
		}
		List<NewsType> newsType=new ArrayList<NewsType>();
		newsType=saveTrackService.getAllNewsType();
		if(newsType!=null)
		{
			model.addAttribute("newsType", newsType);
		}
		List<Tracking>trackingContent=new ArrayList<Tracking>();
		trackingContent=saveTrackService.getContent();
		if(trackingContent!=null)
		{
			model.addAttribute("trackingContent", trackingContent);
		}
		return "savetracking";  
	}
	@RequestMapping(value = "/SaveTrackAdd", method = {RequestMethod.GET,RequestMethod.POST })
	public String addSaveTrack(@ModelAttribute("Tracking") Tracking tracking,BindingResult result ,ModelMap  model
			,HttpServletRequest request,@RequestParam(required=false) Integer trackingId,@RequestParam(required=false) String isRepeat ) 
	{
		List<State> state=new ArrayList<State>();
		List<City> city=new ArrayList<City>();
		List<Sector> sector=new ArrayList<Sector>();
		List<SubSector> subsector=new ArrayList<SubSector>();
		List<Chanel> chanel=new ArrayList<Chanel>();
		List<Client> client=new ArrayList<Client>();
		List<NewsType> newsType=new ArrayList<NewsType>();
		List<Tracking>trackingContent=new ArrayList<Tracking>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			tracking=saveTrackService.updateTracking(trackingId);
			if(isRepeat!=null && isRepeat.equals("Y"))
			{
				tracking.setIsRepeat(true);	
			}
			else
			{
				tracking.setIsRepeat(false);
			}
			model.put("Tracking", tracking);
			trackingContent=saveTrackService.getContent();
			model.addAttribute("trackingContent", trackingContent);
		}
		else
		{
			saveTrackingValidator.validate(tracking, result);
			if(result.hasErrors())
			{
				state=advTrackingService.getAllState();
				model.addAttribute("state",state);	
				city=advTrackingService.getAllCity();
				model.addAttribute("city", city);
				chanel=advTrackingService.getAllChanel();
				model.addAttribute("chanel", chanel);
				client=saveTrackService.getAllClient();
				model.addAttribute("client", client);
				sector=saveTrackService.getAllSector();
				model.addAttribute("sector", sector);
				subsector=saveTrackService.getAllSubSector();
				model.addAttribute("subsector", subsector);
				newsType=saveTrackService.getAllNewsType();
				model.addAttribute("newsType", newsType);
				trackingContent=saveTrackService.getContent();
				model.addAttribute("trackingContent", trackingContent);
				return "savetracking";  
			}
			if(tracking.getIsRepeat()==null)
			{
				saveTrackService.addSaveTracking(tracking);	
			}
			else
			{
			if(tracking.getIsRepeat())
			{
				tracking.setTrackingId(null);
				saveTrackService.addSaveTracking(tracking);
			}
			else
			{
				saveTrackService.addSaveTracking(tracking);	
			}
			}
			trackingContent=saveTrackService.getContent();
			if(trackingContent!=null)
			{
				model.addAttribute("trackingContent", trackingContent);
			}
			model.put("Tracking", new Tracking());
			
		}
		state=saveTrackService.getAllState();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}
		
		city=saveTrackService.getAllCity();
		if(city!=null)
		{
			model.addAttribute("city", city);
		}
		
		sector=saveTrackService.getAllSector();
		if(sector!=null)
		{
			model.addAttribute("sector", sector);
		}
		
		subsector=saveTrackService.getAllSubSector();
		if(subsector!=null)
		{
			model.addAttribute("subsector", subsector);
		}
	
		chanel=saveTrackService.getAllChanel();
		if(chanel!=null)
		{
			model.addAttribute("chanel", chanel);
		}
		
		client=saveTrackService.getAllClient();
		if(client!=null)
		{
			model.addAttribute("client", client);
		}
		
		newsType=saveTrackService.getAllNewsType();
		if(newsType!=null)
		{
			model.addAttribute("newsType", newsType);
		}
		return "savetracking";  
	}
	@RequestMapping(value="/trackingContent/{id}")
	public String deleteTrack(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		saveTrackService.deleteTracking(id);
		return "redirect:/savetracking.do";
	}
	/*Save Tracking  Controller End*/
	/*Advertisement  Controller Start*/
	@RequestMapping(value = "/advertisement",method=RequestMethod.GET)  
	public String advertisement(@ModelAttribute("AdvertisementTracking")AdvertisementTracking advtracking,Model model) {  

		List<State> state=new ArrayList<State>();
		state=advTrackingService.getAllState();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}
		List<City> city=new ArrayList<City>();
		city=advTrackingService.getAllCity();
		if(city!=null)
		{
			model.addAttribute("city", city);
		}
		List<Chanel> chanel=new ArrayList<Chanel>();
		chanel=advTrackingService.getAllChanel();
		if(chanel!=null)
		{
			model.addAttribute("chanel", chanel);
		}
		List<Client> client=new ArrayList<Client>();
		client=advTrackingService.getAllClient();
		if(client!=null)
		{
			model.addAttribute("client", client);
		}
		List<Party> party=new ArrayList<Party>();
		party=advTrackingService.getAllParty();
		if(party!=null)
		{
			model.addAttribute("party", party);
		}
		List<AdvType> advType=new ArrayList<AdvType>();
		advType=advTrackingService.getAlladvType();
		if(advType!=null)
		{
			model.addAttribute("advType", advType);
		}
		List<AdvertisementTracking>advTrackingContent=new ArrayList<AdvertisementTracking>();
		advTrackingContent=advTrackingService.getContent();
		if(advTrackingContent!=null)
		{
			model.addAttribute("advTrackingContent",advTrackingContent);
		}
		return "advertisement";  
	}
	@RequestMapping(value = "/AdvTrackingAdd", method = {RequestMethod.GET,RequestMethod.POST })
	public String addAdvTrack(@ModelAttribute("AdvertisementTracking") AdvertisementTracking advTracking,BindingResult result ,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,@RequestParam(required=false) Integer advertismentId,@RequestParam(required=false) String isRepeat ) throws UnsupportedEncodingException 
	{
		
		List<State> state=new ArrayList<State>();
		List<City> city=new ArrayList<City>();
		List<Chanel> chanel=new ArrayList<Chanel>();
		List<Client> client=new ArrayList<Client>();
		List<Party> party=new ArrayList<Party>();
		List<AdvType> advType=new ArrayList<AdvType>();
		List<AdvertisementTracking>advTrackingContent=new ArrayList<AdvertisementTracking>();
		System.out.println("Advertisement Controller---"+advTracking.getTextArea());
		if(request.getCharacterEncoding() == null)
 		{
 			response.setCharacterEncoding("UTF-8");
 			response.setContentType("text/html; charset=utf-8");
 			request.setCharacterEncoding("UTF-8");
 		}
		String method = request.getMethod();
		if (method.equals("GET")) {
			advTracking=advTrackingService.updateAdvTracking(advertismentId);
			if(isRepeat!=null && isRepeat.equals("Y"))
			{
				advTracking.setIsRepeat(true);	
			}
			else
			{
				advTracking.setIsRepeat(false);
			}
			model.put("AdvertisementTracking", advTracking);
			advTrackingContent=advTrackingService.getContent();
			model.addAttribute("advTrackingContent",advTrackingContent);
		}
		else
		{
			advTrackingValidator.validate(advTracking, result);
			if(result.hasErrors())
			{
				state=advTrackingService.getAllState();
				model.addAttribute("state",state);
				city=advTrackingService.getAllCity();
				model.addAttribute("city", city);
				chanel=advTrackingService.getAllChanel();
				model.addAttribute("chanel", chanel);
				client=saveTrackService.getAllClient();
				model.addAttribute("client", client);
				party=advTrackingService.getAllParty();
				model.addAttribute("party", party);
				advType=advTrackingService.getAlladvType();
				model.addAttribute("advType", advType);
				advTrackingContent=advTrackingService.getContent();
				model.addAttribute("advTrackingContent",advTrackingContent);
				return "advertisement";  	
			}
			//TODO:
			if(advTracking.getIsRepeat()==null)
			{
				advTrackingService.addAdvTracking(advTracking);	
			}
			else
			{
			if(advTracking.getIsRepeat())
			{
				advTracking.setAdvertismentId(null);
				advTrackingService.addAdvTracking(advTracking);
			}
			else
			{
				advTrackingService.addAdvTracking(advTracking);	
			}
			}
			advTrackingContent=advTrackingService.getContent();
			if(advTrackingContent!=null)
			{
				model.addAttribute("advTrackingContent",advTrackingContent);
			}
			model.put("AdvertisementTracking", new AdvertisementTracking());
		}

		state=advTrackingService.getAllState();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}

		city=advTrackingService.getAllCity();
		if(city!=null)
		{
			model.addAttribute("city", city);
		}

		chanel=advTrackingService.getAllChanel();
		if(chanel!=null)
		{
			model.addAttribute("chanel", chanel);
		}

		client=saveTrackService.getAllClient();
		if(client!=null)
		{
			model.addAttribute("client", client);
		}

		party=advTrackingService.getAllParty();
		if(party!=null)
		{
			model.addAttribute("party", party);
		}

		advType=advTrackingService.getAlladvType();
		if(advType!=null)
		{
			model.addAttribute("advType", advType);
		}
		return "advertisement";  
	}

	@RequestMapping(value="/advTrackingContent/{id}")
	public String deleteAdvTrack(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		advTrackingService.deleteAdvTracking(id);
		return "redirect:/advertisement.do";
	}
	/*Advertisement  Controller End*/
	/* Save Print Tracking Controller Start */
	@RequestMapping(value = "/saveprinttracking", method = RequestMethod.GET)
	public String saveprinttracking(@ModelAttribute("PrintTracking") PrintTracking printTracking,
			ModelMap model) {
		List<State> state = new ArrayList<State>();
		state = printTrackService.getAllState();
		if (state != null) {
			model.addAttribute("state", state);
		}
		List<City> city = new ArrayList<City>();
		city = printTrackService.getAllCity();
		if (city != null) {
			model.addAttribute("city", city);
		}
		List<Sector> sector = new ArrayList<Sector>();
		sector = printTrackService.getAllSector();
		if (sector != null) {
			model.addAttribute("sector", sector);
		}
		List<SubSector> subsector = new ArrayList<SubSector>();
		subsector = printTrackService.getAllSubSector();
		if (subsector != null) {
			model.addAttribute("subsector", subsector);
		}
		List<Publication> publication = new ArrayList<Publication>();
		publication = printTrackService.getAllPublication();
		if (publication != null) {
			model.addAttribute("publication", publication);
		}
		List<Client> client = new ArrayList<Client>();
		client = printTrackService.getAllClient();
		if (client != null) {
			model.addAttribute("client", client);
		}
		List<PrintTracking> prinTrackingContent = new ArrayList<PrintTracking>();
		prinTrackingContent = printTrackService.getContent();
		if (prinTrackingContent != null) {
			model.addAttribute("prinTrackingContent", prinTrackingContent);
		}
		return "saveprinttracking";
	}

	@RequestMapping(value = "/PrintTrackAdd", method = {RequestMethod.GET,RequestMethod.POST })
	public String addPrintTrack(@ModelAttribute("PrintTracking") PrintTracking printTracking,BindingResult result,
			ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer printTrackingId,@RequestParam(required=false) String isRepeat) {
		List<State> state = new ArrayList<State>();
		List<City> city = new ArrayList<City>();
		List<Sector> sector = new ArrayList<Sector>();
		List<SubSector> subsector = new ArrayList<SubSector>();
		List<Client> client = new ArrayList<Client>();
		List<Publication> publication = new ArrayList<Publication>();
		List<PrintTracking> prinTrackingContent = new ArrayList<PrintTracking>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			printTracking=printTrackService.updatePrintTracking(printTrackingId);
			if(isRepeat!=null && isRepeat.equals("Y"))
			{
				printTracking.setIsRepeat(true);	
			}
			else
			{
				printTracking.setIsRepeat(false);
			}
			model.put("PrintTracking", printTracking);
			prinTrackingContent = printTrackService.getContent();
			model.addAttribute("prinTrackingContent", prinTrackingContent);
		}
		else
		{
			printTrackingValidator.validate(printTracking, result);
			if (result.hasErrors())
			{
				state = printTrackService.getAllState();
				model.addAttribute("state", state);
				city = printTrackService.getAllCity();
				model.addAttribute("city", city);
				sector = printTrackService.getAllSector();
				model.addAttribute("sector", sector);
				subsector = printTrackService.getAllSubSector();
				model.addAttribute("subsector", subsector);
				client = printTrackService.getAllClient();
				model.addAttribute("client", client);
				publication = printTrackService.getAllPublication();
				model.addAttribute("publication", publication);
				prinTrackingContent = printTrackService.getContent();
				model.addAttribute("prinTrackingContent", prinTrackingContent);
				return "saveprinttracking";
			}
			if(printTracking.getIsRepeat()==null)
			{
				printTrackService.addPrintTrack(printTracking);	
			}
			else
			{
			if(printTracking.getIsRepeat())
			{
				printTracking.setPrintTrackingId(null);
				printTrackService.addPrintTrack(printTracking);	
			}
			else
			{
				printTrackService.addPrintTrack(printTracking);	
			}
			}
			prinTrackingContent = printTrackService.getContent();
			if (prinTrackingContent != null) {
				model.addAttribute("prinTrackingContent", prinTrackingContent);
			}
			model.put("PrintTracking", new PrintTracking());
		}
		state = printTrackService.getAllState();
		if (state != null) {
			model.addAttribute("state", state);
		}
		city = printTrackService.getAllCity();
		if (city != null) {
			model.addAttribute("city", city);
		}
		sector = printTrackService.getAllSector();
		if (sector != null) {
			model.addAttribute("sector", sector);
		}
		subsector = printTrackService.getAllSubSector();
		if (subsector != null) {
			model.addAttribute("subsector", subsector);
		}
		client = printTrackService.getAllClient();
		if (client != null) {
			model.addAttribute("client", client);
		}
		publication = printTrackService.getAllPublication();
		if (publication != null) {
			model.addAttribute("publication", publication);
		}
		return "saveprinttracking";
	}

	@RequestMapping(value = "/prinTrackingContent/{id}")
	public String deletePrintTrack(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		printTrackService.deletePrintTrack(id);
		return "redirect:/saveprinttracking.do";

		/* Save Print Tracking Controller End */
}
	@RequestMapping("/search")
	public String search(Map<String, Object> map,Model model)
	{
		map.put("PieChart",new PieChart());
		return "search";
	}
	@RequestMapping(value = "/StoryCode", method = {RequestMethod.GET,RequestMethod.POST })
	public String searchCode(@ModelAttribute("PieChart") PieChart storyCode,BindingResult result,
			ModelMap model,HttpServletRequest request) 
	{
		List<Tracking> searchResult = new ArrayList<Tracking>();
		 searchResult =storyCodeService.SeachStoryCode(storyCode.getStoryCode());
		if (searchResult != null) {
			model.addAttribute("searchResult", searchResult);
		}
		return "search";
	}
}
