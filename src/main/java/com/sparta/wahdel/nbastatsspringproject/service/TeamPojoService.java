package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.pojo.TeamPOJO;
import com.sparta.wahdel.nbastatsspringproject.repository.TeamPojoRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamPojoService {
    private final TeamPojoRepository teamPojoRepository;

    public TeamPojoService() {
        this.teamPojoRepository = new TeamPojoRepository();
    }

    public Iterable<TeamPOJO.Standard> getAllTeams() {
        return teamPojoRepository.getAllTeams();
    }

    public Iterable<TeamPOJO.Standard> getNBATeams() {
        return teamPojoRepository.getNBATeams();
    }
}
