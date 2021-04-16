package com.sparta.wahdel.nbastatsspringproject;

import com.sparta.wahdel.nbastatsspringproject.datastore.Lineup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LineupTest {

    @AfterEach
    public void tearDown() {
        Lineup.clear();
    }

    @Test
    public void getStarters() {
        Assertions.assertNotNull(Lineup.getStarters());
    }

    @Test
    public void addStarter() {
        Lineup.addToStarters(1);
        Assertions.assertFalse(Lineup.getStarters().isEmpty());
    }

    @Test
    public void clearStarters() {
        addStarter();
        Lineup.clear();
        Assertions.assertTrue(Lineup.getStarters().isEmpty());
    }

    @Test
    public void checkIsFullFalse() {
        Assertions.assertFalse(Lineup.isFull());
    }

    @Test
    public void checkIsFullTrue() {
        for (int count = 0; count < 5; count++) {
            Lineup.addToStarters(count);
        }
        Assertions.assertTrue(Lineup.isFull());
    }
}
