package com.gntics.footballmanager.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gntics.footballmanager.model.Player;
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

    Collection<Team> teams = footballManagerService.findAllTeams();

    if (teams.isEmpty()) {
      populateDb();
    }

  }

  private void populateDb(){

    List<Team> teamList = new ArrayList<Team>();

    Team team1 = new Team("Paris Saint Germain - PSG");
    Team team2 = new Team("Olympique Lyonnais - OL");
    Team team3 = new Team("Saint-Etienne - ASSE");
    Team team4 = new Team("Olympique de Marseille - OM");

    teamList.add(team1);
    teamList.add(team2);
    teamList.add(team3);
    teamList.add(team4);

    // save teams in db
    for (Team t : teamList) {
      footballManagerService.saveTeam(t);
    }

    List<Player> playerList = new ArrayList<Player>();

    Player player_1 = new Player("Adrien", "Rabiot", (Integer) 19, "MIL");
    Player player_2 = new Player("Blaise", "Matuidi", (Integer) 27, "MIL");
    Player player_3 = new Player("David", "Luiz", (Integer) 27, "DEF");
    Player player_4 = new Player("Devon", "Romil", (Integer) 18, "MIL");
    Player player_5 = new Player("Edinson", "Cavani", (Integer) 28, "ATT");
    Player player_6 = new Player("Ezequiel", "Lavezzi", (Integer) 29, "ATT");
    Player player_7 = new Player("Gregory", "Van der Wiel", (Integer) 27, "DEF");
    Player player_8 = new Player("Javier", "Pastore", (Integer) 25, "MIL");
    Player player_9 = new Player("Jean", "Bahebeck", (Integer) 21, "ATT");
    Player player_10 = new Player("Jean-Kévin", "Augustin", (Integer) 17, "ATT");
    Player player_11 = new Player("Jeremi", "Kimmakon", (Integer) 20, "MIL");
    Player player_12 = new Player("Lucas", "Tony", (Integer) 22, "MIL");
    Player player_13 = new Player("Lucas", "Digne", (Integer) 21, "DEF");
    Player player_14 = new Player("Marco", "Verratti", (Integer) 22, "MIL");
    Player player_15 = new Player("Paul", "Marquinhos", (Integer) 20, "DEF");
    Player player_16 = new Player("Maxwell", "House", (Integer) 33, "DEF");
    Player player_17 = new Player("Mike", "Maignan", (Integer) 19, "GAR");
    Player player_18 = new Player("Mory", "Diaw", (Integer) 21, "GAR");
    Player player_19 = new Player("Nicolas", "Douchez", (Integer) 34, "GAR");
    Player player_20 = new Player("Presnel", "Kimpembe", (Integer) 19, "DEF");
    Player player_21 = new Player("Roli", "Pereira De Sa", (Integer) 18, "ATT");

    playerList.add(player_1);
    playerList.add(player_2);
    playerList.add(player_3);
    playerList.add(player_4);
    playerList.add(player_5);
    playerList.add(player_6);
    playerList.add(player_7);
    playerList.add(player_8);
    playerList.add(player_9);
    playerList.add(player_10);
    playerList.add(player_11);
    playerList.add(player_12);
    playerList.add(player_13);
    playerList.add(player_14);
    playerList.add(player_15);
    playerList.add(player_16);
    playerList.add(player_17);
    playerList.add(player_18);
    playerList.add(player_19);
    playerList.add(player_20);
    playerList.add(player_21);

    team1.addPlayer(player_1);
    team1.addPlayer(player_3);
    team1.addPlayer(player_5);
    team1.addPlayer(player_7);

    team2.addPlayer(player_2);
    team2.addPlayer(player_4);
    team2.addPlayer(player_6);
    team2.addPlayer(player_8);

    team3.addPlayer(player_9);
    team3.addPlayer(player_10);
    team3.addPlayer(player_11);

    team4.addPlayer(player_12);
    team4.addPlayer(player_13);
    team4.addPlayer(player_14);

    for (Player p : playerList) {
      footballManagerService.savePlayer(p);
    }

  }

}
