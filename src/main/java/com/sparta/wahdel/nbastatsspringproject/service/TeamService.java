package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.entity.TeamsEntity;
import com.sparta.wahdel.nbastatsspringproject.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Iterable<TeamsEntity> getAllTeams() {
        Iterable<TeamsEntity> teams = teamRepository.findAll();
        return teams;
    }

    public TeamsEntity getTeamById(int teamId) {
        TeamsEntity team = teamRepository.findById(teamId).orElseThrow(() -> new NullPointerException());
        return team;
    }

    public Iterable<TeamsEntity> getTeamsByIsFantasy(boolean fantasy) {
        return teamRepository.findTeamsEntityByIsFantasy(fantasy);
    }

    public void save(TeamsEntity team) {
        teamRepository.save(team);
    }

    public void addFantasyTeam(String city, String teamName) {
        TeamsEntity newTeam = new TeamsEntity();
        newTeam.setCityName(city);
        newTeam.setTeamName(teamName);
        newTeam.setFantasy(true);
        teamRepository.save(newTeam);
    }
}
