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
}
