package com.gntics.footballmanager.web;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.gntics.footballmanager.model.Team;
import com.gntics.footballmanager.service.FootballManagerService;

@Controller
@SessionAttributes("team")
public class TeamController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	@Autowired
	private FootballManagerService footballManagerService;
	
	@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public String listTeamsAndSetupForm(Map<String, Object> model){
		logger.info("GET /teams => index");
		
		Collection<Team> teams = footballManagerService.findAllTeams();
		Team team = new Team();
		
		model.put("teams", teams);
		model.put("team",  team);
		
		return "teams/index";
	}
	
	@RequestMapping(value = "/teams", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("team") Team team, BindingResult result, SessionStatus status){
		logger.info("POST /teams => create");

		boolean error = false;

	    if(team.getName().isEmpty()){
	        result.rejectValue("name", "error");
	        error = true;
	    }
	     
	    if(error) {
	        return "teams/new";
	    }
		
	    logger.info("POST /teams => create SUCCESS");
		
		this.footballManagerService.saveTeam(team);
		status.setComplete();

		return "redirect:teams";
	    
//		if (result.hasErrors()) {
//			logger.info("POST /teams => create HAS ERRORS **** ");
//
//            return "teams/index";
//		} else {
			
//			return "redirect:teams/" + team.getId();
//      }

	}
	
	
}
