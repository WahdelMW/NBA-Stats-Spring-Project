package com.sparta.wahdel.nbastatsspringproject;

import com.sparta.wahdel.nbastatsspringproject.pojo.TeamPOJO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class TeamPojoTest {

    private static TeamPOJO teamPOJO;
    private static List<TeamPOJO.Standard> teams;


    @BeforeAll
    public static void setupAll() {
        try {
            teamPOJO = new TeamPOJO();
            teams = teamPOJO.getAllTeams();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkIfNullTeamPOJO() {
        Assertions.assertNotNull(teamPOJO);
    }

    @Test
    void getTeams() {
        Assertions.assertNotNull(teams);
    }

    @Test
    void getPlayer() {
        TeamPOJO.Standard player = teams.get(0);
        Assertions.assertTrue(teams.contains(player));
    }

    @Test
    void getTeamId() {
        int teamId = teams.get(0).getTeamId();
        Assertions.assertTrue(teamId > 0);
    }

    @Test
    void getCityName() {
        String cityName = teams.get(0).getCity();
        Assertions.assertNotNull(cityName);
    }

    @Test
    void getTeamName() {
        String teamName = teams.get(0).getNickname();
        Assertions.assertNotNull(teamName);
    }


}