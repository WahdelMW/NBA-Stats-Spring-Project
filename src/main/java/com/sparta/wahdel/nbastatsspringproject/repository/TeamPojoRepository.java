package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.pojo.TeamPOJO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamPojoRepository {
    private TeamPOJO teamPOJO;

    public TeamPojoRepository() {
        try {
            this.teamPOJO = new TeamPOJO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Iterable<TeamPOJO.Standard> getAllTeams() {
        return teamPOJO.getAllTeams();
    }

    //Todo: isNBAFranchise not read correctly, should not always be set to false
    public Iterable<TeamPOJO.Standard> getNBATeams() {
        List<TeamPOJO.Standard> nbaTeams = new ArrayList<>();
        for (TeamPOJO.Standard team : getAllTeams()) {
            if (!team.isAllStar()) {
                System.out.println("Name: " + team.getNickname());
                System.out.println("Franchise: " + team.isNBAFranchise());
                nbaTeams.add(team);
            }
        }
        return nbaTeams;
    }
}
