package com.sparta.wahdel.nbastatsspringproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.wahdel.nbastatsspringproject.datastore.Lineup;
import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import com.sparta.wahdel.nbastatsspringproject.entity.TeamsEntity;
import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerPojoService;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerService;
import com.sparta.wahdel.nbastatsspringproject.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeamPlayerController {

    private PlayersDetailsPOJO playersDetailsPOJO;
    private PlayerService playerService;
    private TeamService teamService;
    private PlayerPojoService playerPojoService;

    public TeamPlayerController(PlayerService playerService, TeamService teamService) {
        try {
            this.playersDetailsPOJO = new PlayersDetailsPOJO();
            this.playerService = playerService;
            this.teamService = teamService;
            this.playerPojoService = new PlayerPojoService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/teams/{id}")
    public String getTeamById(@PathVariable(value = "id") int teamId, ModelMap modelMap) {
        TeamsEntity team = teamService.getTeamById(teamId);
        Iterable<PlayersDetailsPOJO.PlayersPOJO> players = getPlayersPOJOS(teamId, team);
        modelMap.addAttribute("team", team);
        modelMap.addAttribute("players", players);
        return "team";
    }

    private Iterable<PlayersDetailsPOJO.PlayersPOJO> getPlayersPOJOS(int teamId, TeamsEntity team) {
        Iterable<PlayersDetailsPOJO.PlayersPOJO> players;
        if (team.isFantasy()) {
            List<Integer> teamPlayerIds = new ArrayList<>();
            for (Integer playerId : playerService.getAllIdsOfPlayersOnTeam(teamId)) {
                teamPlayerIds.add(playerId);
            }
            players = playerPojoService.getPlayersFromListOfPlayerIds(teamPlayerIds);
        } else {
            players = playerPojoService.getPlayersByTeamId(teamId);
        }
        return players;
    }

    @PostMapping("/addPlayer/{id}")
    public String AddPlayers(@PathVariable(value = "id") int playerId, ModelMap modelMap) {
        if (Lineup.isFull()) {
            return verifyAddedPlayers(modelMap);
        } else {
            Lineup.addToStarters(playerId);
        }
        return "redirect:/players";
    }

    @GetMapping("/verifyAddedPlayers")
    private String verifyAddedPlayers(ModelMap modelMap) {
        Iterable<PlayersDetailsPOJO.PlayersPOJO> players;
        players = playerPojoService.getPlayersFromListOfPlayerIds(Lineup.getStarters());
        modelMap.addAttribute("players", players);
        modelMap.addAttribute("exceedMaxSize", false);
        modelMap.addAttribute("teams", getFantasyTeams());
        return "addPlayers";
    }

    @PostMapping("/addPlayers/{teamId}")
    public String newPlayer(@PathVariable(value = "teamId") int teamId, ModelMap modelMap) {
        ObjectMapper objectMapper = new ObjectMapper();
        PlayersEntity player;
        if(playerService.getPlayerCountByTeamId(teamId) + Lineup.getStarters().size() > 13)
        {
            modelMap.addAttribute("exceedMaxSize", true);
            modelMap.addAttribute("teams", getFantasyTeams());
            return "redirect:/addPlayers";
        }
        try {
            for (int playerId : Lineup.getStarters()) {
                player = objectMapper.readValue(createPlayerRequestBody(playerId, teamId), PlayersEntity.class);
                playerService.savePlayer(player);
            }
            Lineup.clear();
            TeamsEntity team = teamService.getTeamById(teamId);
            modelMap.addAttribute("team", team);
            return "playersAddedSuccess";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "playersAddedError";
    }

    private Iterable<TeamsEntity> getFantasyTeams() {
        return teamService.getTeamsByIsFantasy(true);
    }

    private String createPlayerRequestBody(int playerId, int teamId) {
        PlayersDetailsPOJO.PlayersPOJO player = playersDetailsPOJO.getPlayers().get(playerId);
        return "{\n" +
                "\"playerId\": \"" + player.getPersonId() + "\"," +
                "\n\"teamId\": \"" + teamId + "\"," +
                "\n\"firstName\": \"" + player.getFirstName() + "\"," +
                "\n\"lastName\": \"" + player.getLastName() + "\"" +
                "\n}";
    }
}
