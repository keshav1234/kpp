package com.emts.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.emts.model.AdvType;
import com.emts.model.Chanel;
import com.emts.model.City;
import com.emts.model.Client;
import com.emts.model.Country;
import com.emts.model.Party;
import com.emts.model.PopUp;
import com.emts.model.Publication;
import com.emts.model.Registration;
import com.emts.model.Sector;
import com.emts.model.State;
import com.emts.model.SubSector;
import com.emts.service.AdvTypeService;
import com.emts.service.ChanelService;
import com.emts.service.CityService;
import com.emts.service.ClientService;
import com.emts.service.CountryService;
import com.emts.service.LoginService;
import com.emts.service.PartyService;
import com.emts.service.PopUpService;
import com.emts.service.PublicationService;
import com.emts.service.RegistrationService;
import com.emts.service.SectorService;
import com.emts.service.StateService;
import com.emts.service.SubSectorService;
import com.emts.validator.AdvTypeValidator;
import com.emts.validator.ChanelValidator;
import com.emts.validator.CityValidator;
import com.emts.validator.ClientValidator;
import com.emts.validator.CountryValidator;
import com.emts.validator.LoginValidator;
import com.emts.validator.PartyValidator;
import com.emts.validator.PublicationValidator;
import com.emts.validator.RegistrationValidator;
import com.emts.validator.SectorValidator;
import com.emts.validator.StateValidator;
import com.emts.validator.SubSectorValidator;

/**
 * @author ajay.jirati
 *
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private LoginValidator loginValidator;
	
	@Autowired
	private PublicationService publicationService;
   
	@Autowired 
    private PublicationValidator publicationValidator;
	
	@Autowired
	private PopUpService popupservice;
	
	@Autowired
	private PartyService partyService;
	
	@Autowired
	private PartyValidator partyValidator;
	
	@Autowired 
	private StateService stateservice;
	
	@Autowired 
	private StateValidator statevalidator;
	
	@Autowired 
	private CityService cityservice;
	
	@Autowired 
	private CityValidator cityvalidator;
	
	@Autowired 
	private RegistrationService registrationservice;
	
	@Autowired 
	private ChanelService chanelservice;
	
	@Autowired 
	private ChanelValidator chanelvalidator;
	
	@Autowired 
	private CountryService countryservice;
	
	@Autowired 
	private CountryValidator countryvalidator;
	@Autowired 
	private SectorValidator sectorvalidator;
		
	@Autowired 
	private SectorService sectorservice;

	@Autowired 
	private SubSectorValidator subsectorvalidator;

	@Autowired 
	private SubSectorService subsectorservice;

	@Autowired 
	private AdvTypeValidator advtypevalidator;

	@Autowired 
	private AdvTypeService advtypeservice;

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientValidator clientValidator;
	
	@Autowired
	private RegistrationValidator registrationValidator;
	/**  Method for first landing page	 */
	@RequestMapping(value="/welcome", method = RequestMethod.GET)  
	public String welcome(@ModelAttribute("Member")Registration member) { 
		return "loginPage";  
	}

	@RequestMapping(value = "/onloginSubmit", method = { RequestMethod.POST })
	public String login(@ModelAttribute("Member")Registration  member,
			BindingResult result, ModelMap model, SessionStatus status,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Member : -"+member.getEmail());
		System.out.println("Member : -"+member.getPassword());
		
		loginValidator.validate(member, result);
		if (result.hasErrors()) {
			return "loginPage"; 	
		}
		member=  loginService.findByEmailAndPassword(member);
		if(member==null)
		{
			return "redirect:/welcome.do";
		}
		HttpSession session = request.getSession();
		session.setAttribute("member",member);
		//request.getSession().setAttribute(IConstant.SESSION_LOGGEDIN_USER, member);
		//model.addAttribute("userName", member.getFirstName());
		return "login"; 
	}

	/*Login Controller End*/
	/*Registration Controller Start*/
	@RequestMapping("/registration")
	public String NewUser(Map<String, Object> map,Model model)
	{
		map.put("Member",new Registration());
		return "registration";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("Member") Registration reg,BindingResult result ,ModelMap model,Map<String, Object> map) 
	{	
		registrationValidator.validate(reg, result);
		if(result.hasErrors())
		{
			return "registration";	
		}
		registrationservice.addUser(reg);
		return "registration";	
	}

	/*Registration Controller End*/
	/*State  Controller Start*/	
	@RequestMapping("/state")
	public String newState(Map<String, Object> map,Model model) {
		map.put("State",new State());
		List<Country> country=new ArrayList<Country>();	
		country=stateservice.getAllCountry();
		if(country!=null)
		{
			model.addAttribute("country",country);
		}
		List<State> stateContent=new ArrayList<State>();
		stateContent=stateservice.getContent();
		if(stateContent!=null)
		{
			model.addAttribute("stateContent",stateContent);
		}
		return "state";
	}
	@RequestMapping(value = "/StateAdd", method = {RequestMethod.GET,RequestMethod.POST })
	public String addState(@ModelAttribute("State") State state,BindingResult result ,ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer stateId) 
	{ 
		List<Country> country=new ArrayList<Country>();
		List<State> stateContent=new ArrayList<State>();
		String method = request.getMethod();
		if(method.equals("GET")) {
			state=stateservice.updateState(stateId);
			model.put("State", state);
			stateContent=stateservice.getContent();
		}
		else
		{
			stateContent=stateservice.getContent();
			if(stateContent!=null)
			{
				model.addAttribute("stateContent",stateContent);
			}
			statevalidator.validate(state, result);
			if(result.hasErrors())
			{
				country=stateservice.getAllCountry();
				model.addAttribute("country",country);
				return "state";
			}
			else
			{
				model.put("State", new State());
			}
			stateservice.addStateName(state);
		}
			stateContent=stateservice.getContent();
			if(stateContent!=null)
			{
				model.addAttribute("stateContent",stateContent);
			}	
			country=stateservice.getAllCountry();
			if(country!=null)
			{
				model.addAttribute("country",country);
			}
			return "state";
	}
	
	@RequestMapping(value="/stateDelete/{id}")
	public String deleteState(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		stateservice.removeContent(id);
		return "redirect:/state.do";
	}
	/*State  Controller End*/
	/*City Controller Start*/
	
	@RequestMapping("/city")
	public String newCity(Map<String, Object> map,Model model) {
		List<State> state=new ArrayList<State>();
		List<Country> country=new ArrayList<Country>();
		map.put("City",new City());
		state=cityservice.getAllState();
		country=cityservice.getAllCountry();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}
		if(country!=null)
		{
			model.addAttribute("country",country);
		}
		List<City> cityContent=new ArrayList<City>();
		cityContent=cityservice.getContent();
		if(cityContent!=null)
		{
			model.addAttribute("cityContent",cityContent);
		}
		return "city";
	}
	@RequestMapping(value = "/CityAdd", method = {RequestMethod.GET,RequestMethod.POST })
	public String addCity(@ModelAttribute("City") City city,BindingResult result ,ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer cityId) 
	{
		List<City> cityContent=new ArrayList<City>();
		List<Country> country=new ArrayList<Country>();
		List<State> state=new ArrayList<State>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			city=cityservice.updateCity(cityId);
			model.put("City", city);
			cityContent=cityservice.getContent();
		}
		else
		{
			cityContent=cityservice.getContent();
			if(cityContent!=null)
			{
				model.addAttribute("cityContent",cityContent);
			}
			cityvalidator.validate(city, result);
			if(result.hasErrors())
			{
				country=cityservice.getAllCountry();
				model.addAttribute("country",country);
				state=cityservice.getAllState();
				model.addAttribute("state",state);
				return "city";
			}
			else
			{
				model.put("City",new City());	
			}
			cityservice.addcityName(city);
		}
		country=cityservice.getAllCountry();
		if(country!=null)
		{
			model.addAttribute("country",country);
		}
		state=cityservice.getAllState();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}
		cityContent=cityservice.getContent();
		if(cityContent!=null)
		{
			model.addAttribute("cityContent",cityContent);
		}
		return "city";
	}
	@RequestMapping(value="/cityContent/{id}")
	public String deleteCity(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		cityservice.removeContent(id);
		return "redirect:/city.do";
	}
	/*City Controller End*/
	/*Channel  Controller Start*/
	
	@RequestMapping("/channel")
	public String newChannel(Map<String, Object> map,Model model) {
		List<State> state=new ArrayList<State>();
		map.put("Chanel",new Chanel());
		state=chanelservice.getAllState();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}
		List<Chanel>chanelContent=new ArrayList<Chanel>();
		chanelContent=chanelservice.getContent();
		if(chanelContent!=null)
		{
			model.addAttribute("chanelContent",chanelContent);
		}
		return "channel";
	}
	@RequestMapping(value = "/ChanelAdd", method = {RequestMethod.GET,RequestMethod.POST })
	public String addChanel(@ModelAttribute("Chanel") Chanel chanel,BindingResult result ,ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer chanelId) 
	{
		List<Chanel>chanelContent=new ArrayList<Chanel>();
		List<State> state=new ArrayList<State>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			chanel=chanelservice.updateChanel(chanelId);
			model.put("Chanel",chanel);
			chanelContent=chanelservice.getContent();
			model.addAttribute("chanelContent",chanelContent);
		}
		else
		{ 
			chanelvalidator.validate(chanel,result);
			if(result.hasErrors())
			{
				state=chanelservice.getAllState();
				model.addAttribute("state",state);
				chanelContent=chanelservice.getContent();
				model.addAttribute("chanelContent",chanelContent);
				return "channel";
			}
			chanelContent=chanelservice.getContent();
			if(chanelContent!=null)
			{
				model.addAttribute("chanelContent",chanelContent);
			}
			chanelservice.addChanelName(chanel);
			chanelContent=chanelservice.getContent();
			if(chanelContent!=null)
			{
				model.addAttribute("chanelContent",chanelContent);
			}
			model.put("Chanel", new Chanel());
		}
		state=chanelservice.getAllState();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}
		String w = "Channel add successfully!";
		model.addAttribute("message", w);
		return "channel";
	}
	@RequestMapping(value="/chanelContent/{id}")
	public String deleteChanel(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		chanelservice.removeContent(id);
		return "redirect:/channel.do";
	}
	/*Channel  Controller End*/
	/*Country Controller Start*/
	
	@RequestMapping("/country")
	public String newCountry(Map<String, Object> map,ModelMap model) {
		List<Country>countryContent=new ArrayList<Country>();
		countryContent=countryservice.getContent();
		map.put("Country",new Country());
		if(countryContent!=null)
		{
			model.addAttribute("countryContent",countryContent);
		}
		return "country";
	}

	@RequestMapping(value = "/countryAdd", method = { RequestMethod.GET,RequestMethod.POST })
	public String addCountry(@ModelAttribute("Country") Country country,BindingResult result ,
			ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer countryId) 
	{
		List<Country>countryContent=new ArrayList<Country>();
			String method = request.getMethod();
			if (method.equals("GET")) {
				country=countryservice.editContent(countryId);
				model.put("Country",country);
				countryContent=countryservice.getContent();
				model.addAttribute("countryContent",countryContent);
			}
			else
			{
				countryvalidator.validate(country, result);
				if(result.hasErrors())
				{
					countryContent=countryservice.getContent();
					model.addAttribute("countryContent",countryContent);
					return "country" ;	
				}
				countryservice.addCountryname(country);
				countryContent=countryservice.getContent();
				//TODO : Remove null check if we check null on JSP for table grid 
				if(countryContent!=null)
				{
					model.addAttribute("countryContent",countryContent);
				}
				model.put("Country",new Country());	
			}
			String w = "Country add successfully!";
			model.addAttribute("message", w);
			return "country";
	}

	@RequestMapping(value="/countryContent/{id}")
	public String delete(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		countryservice.removeContent(id);
		System.out.println("After removeContent method");
		return "redirect:/country.do";
	}
	/*@RequestMapping(value="/editContent/{id}")
	public String edit(@PathVariable("id") Integer id,Model model) {
		System.out.println("hiiii");
		List<Country>country=new ArrayList<Country>();
		country=countryservice.editContent(id); 
		if(country!=null)
		{
			model.addAttribute("country",country);
		}
		return "redirect:/editCountry.do";
    }*/


	@RequestMapping(value="/editCountry")
	public String showEdit(Model model) {

		return "editCountry";
	}

	/*Country Controller End*/
	/*Sector Controller Start*/
	
	@RequestMapping(value = "/sector",method=RequestMethod.GET)  
	public ModelAndView sector(@ModelAttribute("Sector")Sector sector,Model model) { 
		List<Sector> sectorContent=new ArrayList<Sector>();
		sectorContent=sectorservice.getContent();
		if(sectorContent!=null)
		{
			model.addAttribute("sectorContent",sectorContent);
		}
		return new ModelAndView("sector", "message", "");  
	}
	@RequestMapping(value = "/SectorAdd", method = { RequestMethod.GET,RequestMethod.POST })
	public String addSector(@ModelAttribute("Sector") Sector sector,BindingResult result ,ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer sectorId) 
	{
		List<Sector> sectorContent=new ArrayList<Sector>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			sector=sectorservice.updatSector(sectorId);
			model.put("Sector", sector);
			sectorContent=sectorservice.getContent();
			model.addAttribute("sectorContent",sectorContent);
		}
		else
		{
			sectorvalidator.validate(sector, result);
			if(result.hasErrors())
			{
				sectorContent=sectorservice.getContent();
				model.addAttribute("sectorContent",sectorContent);
				return "sector";
			}
			sectorservice.addSectorname(sector);
			sectorContent=sectorservice.getContent();
			if(sectorContent!=null)
			{
				model.addAttribute("sectorContent",sectorContent);
			}
			model.put("Sector", new Sector());
		}
		String w = "Sector Name add successfully!";
		model.addAttribute("message", w);
		return "sector";
	}
	@RequestMapping(value="/sectorContent/{id}")
	public String deleteSector(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		sectorservice.removeContent(id);
		return "redirect:/sector.do";
	}
	/*Sector Controller End*/	
	
	/*Sub Sector Controller Start*/
	
	@RequestMapping(value = "/subsector",method=RequestMethod.GET)  
	public String subsector(@ModelAttribute("SubSector")SubSector subsector,Model model) { 
		List<SubSector> subsectorContent=new ArrayList<SubSector>();
		subsectorContent=subsectorservice.getContent();
		if(subsectorContent!=null)
		{
			model.addAttribute("subsectorContent",subsectorContent);
		}
		return "subsector";  
	}
	@RequestMapping(value = "/SubSectorAdd", method = { RequestMethod.GET,RequestMethod.POST })
	public String addSubSector(@ModelAttribute("SubSector") SubSector subsector,BindingResult result ,ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer subSectorId) 
	{
		List<SubSector> subsectorContent=new ArrayList<SubSector>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			subsector=subsectorservice.updateSubSector(subSectorId);
			model.put("SubSector", subsector);
			subsectorContent=subsectorservice.getContent();
			model.addAttribute("subsectorContent",subsectorContent);
		}
		else
		{
			subsectorvalidator.validate(subsector, result);
			if(result.hasErrors())
			{
				subsectorContent=subsectorservice.getContent();
				model.addAttribute("subsectorContent",subsectorContent);
				return "subsector";
			}
			subsectorservice.addSubSectorname(subsector);	
			subsectorContent=subsectorservice.getContent();
			if(subsectorContent!=null)
			{
				model.addAttribute("subsectorContent",subsectorContent);
			}
			model.put("SubSector", new SubSector());
		}
		String w = "Sub Sector Name add successfully!";
		model.addAttribute("message", w);
		return "subsector";
	}
	@RequestMapping(value="/subsectorContent/{id}")
	public String deleteSubSector(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		subsectorservice.removeContent(id);
		return "redirect:/subsector.do";
	}
	/*Sub Sector Controller End*/

	/*Advertisement Type Controller Start*/
	@RequestMapping(value = "/advtype",method=RequestMethod.GET)  
	public String advtype(@ModelAttribute("AdvType")AdvType advtype,Model model) {
		List<AdvType> advTypeContent=new ArrayList<AdvType>();
		advTypeContent=advtypeservice.getContent();
		if(advTypeContent!=null)
		{
			model.addAttribute("advTypeContent",advTypeContent);
		}
		return "advtype";  
	}
	@RequestMapping(value = "/advTypeAdd", method = { RequestMethod.GET,RequestMethod.POST })
	public String addAdvType(@ModelAttribute("AdvType") AdvType advType,BindingResult result ,ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer advTypeId) 
	{
		List<AdvType> advTypeContent=new ArrayList<AdvType>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			advType=advtypeservice.updateAdvType(advTypeId);
			model.put("AdvType", advType);
			advTypeContent=advtypeservice.getContent();
			model.addAttribute("advTypeContent",advTypeContent);
		}
		else
		{
			advtypevalidator.validate(advType, result);
			if(result.hasErrors())
			{
				advTypeContent=advtypeservice.getContent();
				model.addAttribute("advTypeContent",advTypeContent);
				return "advtype";
			}
			advtypeservice.addAdvTypename(advType);
			advTypeContent=advtypeservice.getContent();
			if(advTypeContent!=null)
			{
				model.addAttribute("advTypeContent",advTypeContent);
			}
			model.put("AdvType", new AdvType());
		}
		String w = "Advertisement Name add successfully!";
		model.addAttribute("message", w);
		return "advtype";
	}
	@RequestMapping(value="/advTypeContent/{id}")
	public String deleteAdvType(@PathVariable("id") Integer id) {
		System.out.println("hiiii");
		advtypeservice.removeContent(id);
		return "redirect:/advtype.do";
	}
	/*Advertisement Type Controller End*/

	/**  Method for first landing page	 */
	@RequestMapping(value="/cancel", method = RequestMethod.GET)  
	public String cancel(@ModelAttribute("Member")Registration member) { 
		return "login";  
	}
	/* Client Controller Start */
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String newClient(Map<String, Object> map, Model model) {
		List<Client> clientContent = new ArrayList<Client>();
		clientContent = clientService.getContent();
		map.put("Client", new Client());
		if (clientContent != null) {
			model.addAttribute("clientContent", clientContent);
		}
		return "client";
	}
	@RequestMapping(value = "/clientAdd",  method= { RequestMethod.GET,RequestMethod.POST })
	public String addClientName(@ModelAttribute("Client") Client client,
			BindingResult result, ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer clientId) {
		List<Client> clientContent = new ArrayList<Client>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			client=clientService.updateClient(clientId);
			model.put("Client",client);
			clientContent = clientService.getContent();
			model.addAttribute("clientContent", clientContent);
		}
		else
		{
			clientValidator.validate(client, result);
			if (result.hasErrors()) 
			{
				clientContent = clientService.getContent();
				model.addAttribute("clientContent", clientContent);
				return "client";
			}
			clientService.addClientName(client);
			clientContent = clientService.getContent();
			if (clientContent != null)
			{
				model.addAttribute("clientContent", clientContent);
			}
			model.put("Client", new Client());
		}
		String w = "Client Name add successfully!";
		model.addAttribute("message", w);
		return "client";
	}
	@RequestMapping(value = "/clientContent/{id}")
	public String deleteClient(@PathVariable("id") Integer id) {
		clientService.removeContent(id);
		return "redirect:/client.do";
	}

/* Client Controller End */
/* Party Controller Start */
	@RequestMapping("/party")
	public String newParty(Map<String, Object> map, Model model) {
		List<Party> partyContent = new ArrayList<Party>();
		partyContent = partyService.getContent();
		map.put("Party", new Party());
		if (partyContent != null) {
			model.addAttribute("partyContent", partyContent);
		}
		return "party";
	}

	// party action start
	@RequestMapping(value = "/partyAdd", method = { RequestMethod.GET,RequestMethod.POST })
	public String addPartyName(@ModelAttribute("Party") Party party,BindingResult result, ModelMap model,HttpServletRequest request,@RequestParam(required = false) Integer partyId) {
		List<Party> partyContent = new ArrayList<Party>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			party = partyService.updateParty(partyId);
			model.put("Party", party);
			partyContent = partyService.getContent();
			model.addAttribute("partyContent", partyContent);
		} 
		else
		{
			partyValidator.validate(party, result);
			if (result.hasErrors()) 
			{
				partyContent = partyService.getContent();
				model.addAttribute("partyContent", partyContent);
				return "party";
			}
			partyService.addPartyName(party);
			partyContent = partyService.getContent();
			if (partyContent != null) 
			{
				model.addAttribute("partyContent", partyContent);
			}
			model.put("Party", new Party());
		}
		return "party";
	}

	@RequestMapping(value = "/partyContent/{id}")
	public String deleteParty(@PathVariable("id") Integer id) {
		// System.out.println("hiiii");
		partyService.removeContent(id);
		// System.out.println("After removeContent method");
		return "redirect:/party.do";
	}

/* Party Controller End */
/* Pop Up Entry Controller Start */
	@RequestMapping(value="/popupentry", method = RequestMethod.GET)  
	public String popupentry(Map<String, Object> map, Model model) {
		map.put("PopUp", new PopUp());
		return "popupentry";  
	}
	@RequestMapping(value = "/popupAdd",  method= { RequestMethod.GET,RequestMethod.POST })
	public String addPopUpMessage(@ModelAttribute("PopUp") PopUp popUp,BindingResult result, ModelMap model) {
			/*popUpValidator.validate(popUp, result);
			if (result.hasErrors()) {
				return "popupentry";  
			}*/
		popupservice.addPop(popUp);
		String w = "PopUp Message add successfully!";
		model.addAttribute("message", w);
		model.put("PopUp", new PopUp());
		return "popupentry";  
	}
	
	/* Publication Controller Start */

	@RequestMapping("/publication")
	public String newPublication(Map<String, Object> map, Model model) {
		List<State> state=new ArrayList<State>();
		state=publicationService.getAllState();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}
		List<Publication> publicationContent = new ArrayList<Publication>();
		publicationContent = publicationService.getContent();
		map.put("Publication", new Publication());
		if (publicationContent != null) {
			model.addAttribute("publicationContent", publicationContent);
		}
		return "publication";
	}
	@RequestMapping(value = "/publicationAdd", method = { RequestMethod.GET,RequestMethod.POST })
	public String addPublication(@ModelAttribute("Publication") Publication publication,BindingResult result ,
			ModelMap model,HttpServletRequest request,@RequestParam(required=false) Integer publicationId) 
	{
		List<State> state=new ArrayList<State>();
		List<Publication>publicationContent=new ArrayList<Publication>();
		String method = request.getMethod();
		if (method.equals("GET")) {
			publication=publicationService.updatePublication(publicationId);
			model.put("Publication",publication);
			publicationContent=publicationService.getContent();
			model.addAttribute("publicationContent",publicationContent);
		}
		else
		{
			publicationValidator.validate(publication, result);
			if(result.hasErrors())
			{
				state=publicationService.getAllState();
				model.addAttribute("state",state);
				publicationContent=publicationService.getContent();
				model.addAttribute("publicationContent",publicationContent);
				return "publication";
			}
			publicationService.addPublicationName(publication);
			publicationContent=publicationService.getContent();
			if(publicationContent!=null)
			{
				model.addAttribute("publicationContent",publicationContent);
			}
			model.put("Publication", new Publication());
		}
		state=publicationService.getAllState();
		if(state!=null)
		{
			model.addAttribute("state",state);
		}
		publicationContent=publicationService.getContent();
		if(publicationContent!=null)
		{
			model.addAttribute("publicationContent",publicationContent);
		}
		return "publication";
	}

	@RequestMapping(value = "/publicationContent/{id}")
	public String deletePublication(@PathVariable("id") Integer id) {
	publicationService.removeContent(id);
	return "redirect:/publication.do";
	}

	/* Publication Controller End */
	@RequestMapping("/logout")
	public String showLogout(Map<String, Object> map,Model model,HttpServletRequest request)
	{
		System.out.println("Login Controller for logout");
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/welcome.do";
	}
}

