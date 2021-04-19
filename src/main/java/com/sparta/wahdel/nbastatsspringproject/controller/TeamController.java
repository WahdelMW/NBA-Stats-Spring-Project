package com.sparta.wahdel.nbastatsspringproject.controller;

import com.sparta.wahdel.nbastatsspringproject.entity.TeamsEntity;
import com.sparta.wahdel.nbastatsspringproject.pojo.TeamPOJO;
import com.sparta.wahdel.nbastatsspringproject.service.TeamPojoService;
import com.sparta.wahdel.nbastatsspringproject.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class TeamController {

    private final TeamService teamService;
    private final TeamPojoService teamPojoService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
        this.teamPojoService = new TeamPojoService();
    }

    @GetMapping("/fantasyTeams")
    public String getFantasyTeams(ModelMap modelMap) {
        Iterable<TeamsEntity> fantasyTeams = teamService.getTeamsByIsFantasy(true);
        modelMap.addAttribute("fantasyTeams", fantasyTeams);
        return "fantasyTeams";
    }

    @PostMapping("/addFantasyTeam")
    public String addNewFantasyTeam(@RequestParam String cityName,
                                    @RequestParam String teamName) {
        //Todo: get current users Id, implement security service
        int userId = 1;
        teamService.saveTeam(cityName, teamName, userId);
        return "redirect:/fantasyTeams";
    }

    @GetMapping("/teams")
    public String getNBATeams(ModelMap modelMap) {
        Iterable<TeamsEntity> teams = teamService.getTeamsByIsFantasy(false);
        List<TeamsEntity> teamList =
                StreamSupport.stream(teams.spliterator(), false)
                        .collect(Collectors.toList());
        modelMap.addAttribute("teams", teamList);
        return "teams";
    }

    @PostMapping("/teams")
    public String postNBATeams() {
        TeamsEntity nbaTeam = new TeamsEntity();
        for (TeamPOJO.Standard team : teamPojoService.getNBATeams()) {
            teamService.saveTeam(team.getTeamId(), team.getCity(), team.getNickname());
        }
        return "redirect:/teams";
    }
}
