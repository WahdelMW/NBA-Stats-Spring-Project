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

    public String createPlayerRequestBody(int playerId, int teamId) {
        PlayersDetailsPOJO.PlayersPOJO player = playersDetailsPOJO.getPlayers().get(playerId);
        String requestBody = "{\n" +
                "\"playerId\": \"" + player.getPersonId() + "\"," +
                "\n\"teamId\": \"" + teamId + "\"," +
                "\n\"firstName\": \"" + player.getFirstName() + "\"," +
                "\n\"lastName\": \"" + player.getLastName() + "\"" +
                "\n}";
        return requestBody;
    }

    @PostMapping("/rest/addPlayer/{id}")
    public void AddPlayers(@PathVariable(value ="id") int playerId) {
        Lineup.addToStarters(playerId);
    }

    @PostMapping("/rest/addPlayers/{id}")
    public String newPlayer(@PathVariable(value = "id") int teamId) {
        ObjectMapper objectMapper = new ObjectMapper();
        PlayersEntity player;
            try {
                for (int playerId : Lineup.getStarters()) {
                    player = objectMapper.readValue(createPlayerRequestBody(playerId, teamId), PlayersEntity.class);
                    playerService.savePlayer(player);
                }
                Lineup.clear();
                return "Successfully added players";
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        return null;
    }
}
