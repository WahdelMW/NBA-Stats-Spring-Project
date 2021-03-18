package com.sparta.wahdel.nbastatsspringproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.wahdel.nbastatsspringproject.entity.PlayersDetailsPOJO;
import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class PlayerRestController {

    private PlayerService playerService;

    private PlayersDetailsPOJO playersDetailsPOJO;

    @Autowired
    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
        try {
            playersDetailsPOJO = new PlayersDetailsPOJO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findById(@PathVariable(value = "id") int playerId) {
        PlayersDetailsPOJO.PlayersPOJO player = playersDetailsPOJO.getPlayers().get(playerId);
        String requestBody = "{\n" +
                "\"playerId\": \"" + player.getPersonId() + "\"," +
                "\n\"teamId\": \"1\"," +
                "\n\"firstName\": \"" + player.getFirstName() + "\"," +
                "\n\"lastName\": \"" + player.getLastName() + "\"" +
                "\n}";
        return requestBody;
    }

    @PostMapping("/rest/addPlayer/{id}")
    public String newPlayer(@PathVariable(value = "id") int playerId) {
        ObjectMapper objectMapper = new ObjectMapper();
        PlayersEntity player;
        try {
            player = objectMapper.readValue(findById(playerId), PlayersEntity.class);
            playerService.savePlayer(player);
            return "";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
