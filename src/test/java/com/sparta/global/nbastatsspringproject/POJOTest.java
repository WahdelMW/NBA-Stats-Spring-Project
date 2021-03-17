package com.sparta.global.nbastatsspringproject;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayerStatsPOJO;
import com.sparta.wahdel.nbastatsspringproject.entity.PlayersDetailsPOJO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@SpringBootTest
public class POJOTest {

    @Autowired
    private static PlayersDetailsPOJO playersDetailsPOJO;

    private static PlayerStatsPOJO playerStatsPOJO;

    private static int lbjPlayerId;

    private static List<PlayersDetailsPOJO.PlayersPOJO> players;


    @BeforeAll
    public static void setupAll() {
        try {
            playersDetailsPOJO = new PlayersDetailsPOJO();
            lbjPlayerId = 2544;
            playerStatsPOJO = new PlayerStatsPOJO(lbjPlayerId);
            players = playersDetailsPOJO.getPlayerList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @BeforeEach
//    public void setupEach() {
//
//    }

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
    void getNoValuePlayerTeamId() {
        int teamId = players.get(players.size() - 1).getTeamId();
        Assertions.assertTrue(teamId == 0);
    }

    //    PlayerStatsPOJO
    @Test
    void checkIfNullPlayerStatsPOJO() {
        Assertions.assertNotNull(playerStatsPOJO);
    }

    @Test
    void getPpg() {
        double pointsPerGame = playerStatsPOJO.getPpg();
        Assertions.assertTrue(pointsPerGame >= 0.0);
    }

    @Test
    void getRpg() {
        double reboundsPerGame = playerStatsPOJO.getRpg();
        Assertions.assertTrue(reboundsPerGame >= 0.0);
    }

    @Test
    void getApg() {
        double assistsPerGame = playerStatsPOJO.getApg();
        Assertions.assertTrue(assistsPerGame >= 0.0);
    }

    @Test
    void getMpg() {
        double minutesPerGame = playerStatsPOJO.getMpg();
        Assertions.assertTrue(minutesPerGame >= 0.0);
    }

    @Test
    void getTopg() {
        double turnoversPerGame = playerStatsPOJO.getTopg();
        Assertions.assertTrue(turnoversPerGame >= 0.0);
    }

    @Test
    void getSpg() {
        double stealsPerGame = playerStatsPOJO.getSpg();
        Assertions.assertTrue(stealsPerGame >= 0.0);
    }

    @Test
    void getBpg() {
        double blocksPerGame = playerStatsPOJO.getBpg();
        Assertions.assertTrue(blocksPerGame >= 0.0);
    }

    @Test
    void getTpp() {
        double threePointPercentage = playerStatsPOJO.getTpp();
        Assertions.assertTrue(threePointPercentage >= 0.0);
    }

    @Test
    void getFtp() {
        double freeThrowPercentage = playerStatsPOJO.getFtp();
        Assertions.assertTrue(freeThrowPercentage >= 0.0);
    }

    @Test
    void getFgp() {
        double fieldGoalPercentage = playerStatsPOJO.getFgp();
        Assertions.assertTrue(fieldGoalPercentage >= 0.0);
    }

    @Test
    void getFgm() {
        int fieldGoalsMade = playerStatsPOJO.getFgm();
        Assertions.assertTrue(fieldGoalsMade >= 0);
    }

    @Test
    void getFga() {
        int fieldGoalsAttempted = playerStatsPOJO.getFga();
        Assertions.assertTrue(fieldGoalsAttempted >= 0);
    }

    @Test
    void getTpm() {
        int threePointersMade = playerStatsPOJO.getTpm();
        Assertions.assertTrue(threePointersMade >= 0);
    }

    @Test
    void getTpa() {
        int threePointersAttempted = playerStatsPOJO.getTpa();
        Assertions.assertTrue(threePointersAttempted >= 0);
    }

    @Test
    void getFtm() {
        int freeThrowsMade = playerStatsPOJO.getFtm();
        Assertions.assertTrue(freeThrowsMade >= 0);
    }

    @Test
    void getFta() {
        int freeThrowsAttempted = playerStatsPOJO.getFta();
        Assertions.assertTrue(freeThrowsAttempted >= 0);
    }

    @Test
    void getGamesPlayed() {
        int gamesPlayed = playerStatsPOJO.getGamesPlayed();
        Assertions.assertTrue(gamesPlayed >= 0);
    }

    @Test
    void getGamesStarted() {
        int gamesStarted = playerStatsPOJO.getGamesStarted();
        Assertions.assertTrue(gamesStarted >= 0);
    }

    @Test
    void getPlusMinus() {
        int plusMinus = playerStatsPOJO.getPlusMinus();
        Assertions.assertTrue(plusMinus >= 0);
    }
}


