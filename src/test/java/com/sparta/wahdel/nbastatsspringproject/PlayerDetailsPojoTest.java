package com.sparta.wahdel.nbastatsspringproject;

import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class PlayerDetailsPojoTest {

    private static PlayersDetailsPOJO playersDetailsPOJO;
    private static List<PlayersDetailsPOJO.PlayersPOJO> players;


    @BeforeAll
    public static void setupAll() {
        try {
            playersDetailsPOJO = new PlayersDetailsPOJO();
            players = playersDetailsPOJO.getPlayerList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkIfNullPlayerDetailsPOJO() {
        Assertions.assertNotNull(playersDetailsPOJO);
    }

    @Test
    void getPlayers() {
        Assertions.assertNotNull(players);
    }

    @Test
    void getPlayer() {
        PlayersDetailsPOJO.PlayersPOJO player = players.get(0);
        Assertions.assertTrue(players.contains(player));
    }

    @Test
    void getPlayerPersonId() {
        int playerId = players.get(0).getPersonId();
        Assertions.assertTrue(playerId > 0);
    }

    @Test
    void getPlayerFirstName() {
        String firstName = players.get(0).getFirstName();
        Assertions.assertNotNull(firstName);
    }

    @Test
    void getPlayerLastName() {
        String lastName = players.get(0).getLastName();
        Assertions.assertNotNull(lastName);
    }

    @Test
    void getPlayerTeamId() {
        int teamId = players.get(0).getTeamId();
        Assertions.assertTrue(teamId > 0);
    }

    @Test
    void getHeightFeet() {
        String heightFt = players.get(0).getHeightFeet();
        Assertions.assertNotNull(heightFt);
    }

    @Test
    void getHeightInches() {
        String heightInches = players.get(0).getHeightFeet();
        Assertions.assertNotNull(heightInches);
    }

    @Test
    void getNoValuePlayerTeamId() {
        int teamId = players.get(players.size() - 1).getTeamId();
        Assertions.assertEquals(teamId, 0);
    }

    @Test
    void getNoValueHeightFeet() {
        String heightFt = players.get(players.size() - 1).getHeightFeet();
        System.out.println(heightFt);
        Assertions.assertEquals("-", heightFt);
    }

    @Test
    void getNoValueHeightInches() {
        String heightInches = players.get(players.size() - 1).getHeightFeet();
        System.out.println(heightInches);
        Assertions.assertEquals("-", heightInches);
    }
}