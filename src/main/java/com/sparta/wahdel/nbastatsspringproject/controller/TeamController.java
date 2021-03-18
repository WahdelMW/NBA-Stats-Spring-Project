package com.sparta.wahdel.nbastatsspringproject.controller;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersDetailsPOJO;
import com.sparta.wahdel.nbastatsspringproject.entity.TeamsEntity;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerService;
import com.sparta.wahdel.nbastatsspringproject.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class TeamController {

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/fantasyTeams")
    public String getFantasyTeams(ModelMap modelMap) {
        Iterable<TeamsEntity> fantasyTeams = teamService.getAllTeams();
        modelMap.addAttribute("fantasyTeams", fantasyTeams);
        return "fantasyTeams";
    }

    @GetMapping("/teams/{id}")
    public String getTeamById(@PathVariable(value = "id") int teamId, ModelMap modelMap) {
        TeamsEntity team = teamService.getTeamById(teamId);
        try {
            PlayersDetailsPOJO playersDetailsPOJO = new PlayersDetailsPOJO();
            Iterable<PlayersDetailsPOJO.PlayersPOJO> players = playersDetailsPOJO.getPlayerList();
            modelMap.addAttribute("team", team);
            modelMap.addAttribute("players", players);
            return "team";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "teamError";
    }
}
