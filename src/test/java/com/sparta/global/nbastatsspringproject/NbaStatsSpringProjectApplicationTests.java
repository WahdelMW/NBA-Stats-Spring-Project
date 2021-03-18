package com.sparta.global.nbastatsspringproject;

import com.sparta.wahdel.nbastatsspringproject.controller.PlayerController;
import com.sparta.wahdel.nbastatsspringproject.controller.TeamController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NbaStatsSpringProjectApplicationTests {

    @Autowired
    PlayerController playerController;

    @Autowired
    TeamController teamController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(playerController);
    }

}
