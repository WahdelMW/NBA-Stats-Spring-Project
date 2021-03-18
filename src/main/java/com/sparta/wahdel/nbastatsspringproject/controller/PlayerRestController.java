package com.sparta.wahdel.nbastatsspringproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.wahdel.nbastatsspringproject.datastore.Lineup;
import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;
import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

@RestController
public class PlayerRestController {

    private PlayersDetailsPOJO playersDetailsPOJO;

    @Autowired
    public PlayerRestController() {
        try {
            playersDetailsPOJO = new PlayersDetailsPOJO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
