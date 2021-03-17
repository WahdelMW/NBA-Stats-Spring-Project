package com.sparta.wahdel.nbastatsspringproject.controller;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerRestController {

    private PlayerService playerService;

    @Autowired
    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/rest/players")
    public Iterable<PlayersEntity> findAll() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/rest/players/{id}")
    public PlayersEntity findById(@PathVariable(value = "id") int playerId) {
        return playerService.getById(playerId);
    }

    @PostMapping("/players")
    public PlayersEntity newPlayer(@RequestBody PlayersEntity playersEntity) {
        playerService.savePlayer(playersEntity);
        return playersEntity;
    }
}
