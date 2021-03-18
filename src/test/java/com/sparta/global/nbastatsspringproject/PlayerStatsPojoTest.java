package com.sparta.global.nbastatsspringproject;

import com.sparta.wahdel.nbastatsspringproject.pojo.PlayerStatsPOJO;
import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class PlayerStatsPojoTest {
    private static PlayerStatsPOJO kingJamesStatsPOJO;
    private static PlayerStatsPOJO notPlayedStatsPOJO;


    @BeforeAll
    public static void setupAll() {
        try {
            int kingJamesPlayerId = 2544;
            int notPlayedPlayerId = 1630261;
            kingJamesStatsPOJO = new PlayerStatsPOJO(kingJamesPlayerId);
            notPlayedStatsPOJO = new PlayerStatsPOJO(notPlayedPlayerId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //PlayerStatsPOJO
    @Test
    void checkIfNullPlayerStatsPOJO() {
        Assertions.assertNotNull(kingJamesStatsPOJO);
    }

    @Test
    void getPpg() {
        double pointsPerGame = kingJamesStatsPOJO.getPpg();
        Assertions.assertTrue(pointsPerGame >= 0.0);
    }

    @Test
    void getRpg() {
        double reboundsPerGame = kingJamesStatsPOJO.getRpg();
        Assertions.assertTrue(reboundsPerGame >= 0.0);
    }

    @Test
    void getApg() {
        double assistsPerGame = kingJamesStatsPOJO.getApg();
        Assertions.assertTrue(assistsPerGame >= 0.0);
    }

    @Test
    void getMpg() {
        double minutesPerGame = kingJamesStatsPOJO.getMpg();
        Assertions.assertTrue(minutesPerGame >= 0.0);
    }

    @Test
    void getTopg() {
        double turnoversPerGame = kingJamesStatsPOJO.getTopg();
        Assertions.assertTrue(turnoversPerGame >= 0.0);
    }

    @Test
    void getSpg() {
        double stealsPerGame = kingJamesStatsPOJO.getSpg();
        Assertions.assertTrue(stealsPerGame >= 0.0);
    }

    @Test
    void getBpg() {
        double blocksPerGame = kingJamesStatsPOJO.getBpg();
        Assertions.assertTrue(blocksPerGame >= 0.0);
    }

    @Test
    void getTpp() {
        double threePointPercentage = kingJamesStatsPOJO.getTpp();
        Assertions.assertTrue(threePointPercentage >= 0.0);
    }

    @Test
    void getFtp() {
        double freeThrowPercentage = kingJamesStatsPOJO.getFtp();
        Assertions.assertTrue(freeThrowPercentage >= 0.0);
    }

    @Test
    void getFgp() {
        double fieldGoalPercentage = kingJamesStatsPOJO.getFgp();
        Assertions.assertTrue(fieldGoalPercentage >= 0.0);
    }

    @Test
    void getFgm() {
        int fieldGoalsMade = kingJamesStatsPOJO.getFgm();
        Assertions.assertTrue(fieldGoalsMade >= 0);
    }

    @Test
    void getFga() {
        int fieldGoalsAttempted = kingJamesStatsPOJO.getFga();
        Assertions.assertTrue(fieldGoalsAttempted >= 0);
    }

    @Test
    void getTpm() {
        int threePointersMade = kingJamesStatsPOJO.getTpm();
        Assertions.assertTrue(threePointersMade >= 0);
    }

    @Test
    void getTpa() {
        int threePointersAttempted = kingJamesStatsPOJO.getTpa();
        Assertions.assertTrue(threePointersAttempted >= 0);
    }

    @Test
    void getFtm() {
        int freeThrowsMade = kingJamesStatsPOJO.getFtm();
        Assertions.assertTrue(freeThrowsMade >= 0);
    }

    @Test
    void getFta() {
        int freeThrowsAttempted = kingJamesStatsPOJO.getFta();
        Assertions.assertTrue(freeThrowsAttempted >= 0);
    }

    @Test
    void getGamesPlayed() {
        int gamesPlayed = kingJamesStatsPOJO.getGamesPlayed();
        Assertions.assertTrue(gamesPlayed >= 0);
    }

    @Test
    void getGamesStarted() {
        int gamesStarted = kingJamesStatsPOJO.getGamesStarted();
        Assertions.assertTrue(gamesStarted >= 0);
    }

    @Test
    void getPlusMinus() {
        int plusMinus = kingJamesStatsPOJO.getPlusMinus();
        Assertions.assertTrue(plusMinus >= 0);
    }

    //Stats for player not played in season
    @Test
    void checkIfNullPlayerStatsPOJONotPlayed() {
        Assertions.assertNotNull(notPlayedStatsPOJO);
    }

    @Test
    void getPpgNotPlayed() {
        double pointsPerGame = notPlayedStatsPOJO.getPpg();
        Assertions.assertEquals(0.0, pointsPerGame);
    }

    @Test
    void getRpgNotPlayed() {
        double reboundsPerGame = notPlayedStatsPOJO.getRpg();
        Assertions.assertEquals(0.0, reboundsPerGame);
    }

    @Test
    void getApgNotPlayed() {
        double assistsPerGame = notPlayedStatsPOJO.getApg();
        Assertions.assertEquals(0.0, assistsPerGame);
    }

    @Test
    void getMpgNotPlayed() {
        double minutesPerGame = notPlayedStatsPOJO.getMpg();
        Assertions.assertEquals(0.0, minutesPerGame);
    }

    @Test
    void getTopgNotPlayed() {
        double turnoversPerGame = notPlayedStatsPOJO.getTopg();
        Assertions.assertEquals(0.0, turnoversPerGame);
    }

    @Test
    void getSpgNotPlayed() {
        double stealsPerGame = notPlayedStatsPOJO.getSpg();
        Assertions.assertEquals(0.0, stealsPerGame);
    }

    @Test
    void getBpgNotPlayed() {
        double blocksPerGame = notPlayedStatsPOJO.getBpg();
        Assertions.assertEquals(0.0, blocksPerGame);
    }

    @Test
    void getTppNotPlayed() {
        double threePointPercentage = notPlayedStatsPOJO.getTpp();
        Assertions.assertEquals(0.0, threePointPercentage);
    }

    @Test
    void getFtpNotPlayed() {
        double freeThrowPercentage = notPlayedStatsPOJO.getFtp();
        Assertions.assertEquals(0.0, freeThrowPercentage);
    }

    @Test
    void getFgpNotPlayed() {
        double fieldGoalPercentage = notPlayedStatsPOJO.getFgp();
        Assertions.assertEquals(0.0, fieldGoalPercentage);
    }

    @Test
    void getFgmNotPlayed() {
        int fieldGoalsMade = notPlayedStatsPOJO.getFgm();
        Assertions.assertEquals(0, fieldGoalsMade);
    }

    @Test
    void getFgaNotPlayed() {
        int fieldGoalsAttempted = notPlayedStatsPOJO.getFga();
        Assertions.assertEquals(0, fieldGoalsAttempted);
    }

    @Test
    void getTpmNotPlayed() {
        int threePointersMade = notPlayedStatsPOJO.getTpm();
        Assertions.assertEquals(0, threePointersMade);
    }

    @Test
    void getTpaNotPlayed() {
        int threePointersAttempted = notPlayedStatsPOJO.getTpa();
        Assertions.assertEquals(0, threePointersAttempted);
    }

    @Test
    void getFtmNotPlayed() {
        int freeThrowsMade = notPlayedStatsPOJO.getFtm();
        Assertions.assertEquals(0, freeThrowsMade);
    }

    @Test
    void getFtaNotPlayed() {
        int freeThrowsAttempted = notPlayedStatsPOJO.getFta();
        Assertions.assertEquals(0, freeThrowsAttempted);
    }

    @Test
    void getGamesPlayedNotPlayed() {
        int gamesPlayed = notPlayedStatsPOJO.getGamesPlayed();
        Assertions.assertEquals(0, gamesPlayed);
    }

    @Test
    void getGamesStartedNotPlayed() {
        int gamesStarted = notPlayedStatsPOJO.getGamesStarted();
        Assertions.assertEquals(0, gamesStarted);
    }

    @Test
    void getPlusMinusNotPlayed() {
        int plusMinus = notPlayedStatsPOJO.getPlusMinus();
        Assertions.assertEquals(0, plusMinus);
    }
}


