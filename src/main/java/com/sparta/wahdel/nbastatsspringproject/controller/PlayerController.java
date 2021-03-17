package com.sparta.wahdel.nbastatsspringproject.controller;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import com.sparta.wahdel.nbastatsspringproject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlayerController {


    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/players")
    public String findAll(ModelMap modelMap) {
        Iterable<PlayersEntity> playersEntities = playerService.getAllPlayers();
        modelMap.addAttribute("players", playersEntities);
        return "players";
    }

    @GetMapping("/players/{id}")
    public String findById(@PathVariable(value = "id") int playerId, ModelMap modelMap) {
        PlayersEntity playersEntity = playerService.getById(playerId);
        modelMap.addAttribute("player", playersEntity);
        return "player";
    }

}
