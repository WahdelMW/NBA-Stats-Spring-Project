package com.sparta.wahdel.nbastatsspringproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.wahdel.nbastatsspringproject.datastore.Lineup;
import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;
import com.sparta.wahdel.nbastatsspringproject.entity.TeamsEntity;
import com.sparta.wahdel.nbastatsspringproject.repository.PlayerPojoRepository;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerPojoService;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerService;
import com.sparta.wahdel.nbastatsspringproject.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeamController {

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
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
}
