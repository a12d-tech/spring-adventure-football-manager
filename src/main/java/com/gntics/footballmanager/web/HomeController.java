package com.gntics.footballmanager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gntics.footballmanager.model.Team;
import com.gntics.footballmanager.service.FootballManagerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private FootballManagerService footballManagerService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("GET / => home");
		
		// populate db
		initDbWithSomeData();

		return "home";
	}
	
	private void initDbWithSomeData(){
		Team team1 = new Team();
		team1.setName("Paris Saint Germain");
		footballManagerService.saveTeam(team1);
	}

}
