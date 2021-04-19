package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.entity.TeamsEntity;
import com.sparta.wahdel.nbastatsspringproject.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

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

    private void save(TeamsEntity team) {
        teamRepository.save(team);
    }

    public void saveTeam(String city, String teamName, int userId) {
        TeamsEntity newTeam = createTeam(city, teamName, userId);
        newTeam.setFantasy(true);
        save(newTeam);
    }

    public void saveTeam(int teamId, String city, String teamName) {
        TeamsEntity newTeam = createTeam(city, teamName, 1);
        newTeam.setTeamId(teamId);
        save(newTeam);
    }

    private TeamsEntity createTeam(String city, String teamName, int userId) {
        TeamsEntity newTeam = new TeamsEntity();
        newTeam.setCityName(city);
        newTeam.setTeamName(teamName);
        newTeam.setUserId(userId);
        return newTeam;
    }
}
