package com.sparta.wahdel.nbastatsspringproject.controller;

import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;
import com.sparta.wahdel.nbastatsspringproject.entity.TeamsEntity;
import com.sparta.wahdel.nbastatsspringproject.repository.PlayerPojoRepository;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerService;
import com.sparta.wahdel.nbastatsspringproject.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeamController {

    private TeamService teamService;
    private PlayerService playerService;

    @Autowired
    public TeamController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @GetMapping("/fantasyTeams")
    public String getFantasyTeams(ModelMap modelMap) {
        Iterable<TeamsEntity> fantasyTeams = teamService.getTeamsByIsFantasy(true);
        modelMap.addAttribute("fantasyTeams", fantasyTeams);
        return "fantasyTeams";
    }

    @GetMapping("/teams")
    public String getNBATeams(ModelMap modelMap) {
        Iterable<TeamsEntity> teams = teamService.getTeamsByIsFantasy(false);
        modelMap.addAttribute("teams", teams);
        return "teams";
    }

    @GetMapping("/teams/{id}")
    public String getTeamById(@PathVariable(value = "id") int teamId, ModelMap modelMap) {
        TeamsEntity team = teamService.getTeamById(teamId);
        try {
            PlayerPojoRepository playerPojoRepository = new PlayerPojoRepository();
            Iterable<PlayersDetailsPOJO.PlayersPOJO> players = getPlayersPOJOS(teamId, team, playerPojoRepository);
            modelMap.addAttribute("team", team);
            modelMap.addAttribute("players", players);
            return "team";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fantasyTeams";
    }

    private Iterable<PlayersDetailsPOJO.PlayersPOJO> getPlayersPOJOS(int teamId, TeamsEntity team, PlayerPojoRepository playerPojoRepository) {
        Iterable<PlayersDetailsPOJO.PlayersPOJO> players;
        if (team.isFantasy()) {
            List<Integer> teamPlayerIds = new ArrayList<>();
            for (Integer playerId :playerService.getAllIdsOfPlayersOnTeam(teamId)) {
                teamPlayerIds.add(playerId);
            }
            players = playerPojoRepository.getListPlayersFromListOfPlayerIds(teamPlayerIds);
        } else {
            players = playerPojoRepository.getPlayersByTeamId(teamId);
        }
        return players;
    }
}
