package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.pojo.TeamPOJO;
import com.sparta.wahdel.nbastatsspringproject.repository.TeamPojoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamPojoService {
    private TeamPojoRepository teamPojoRepository;

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
