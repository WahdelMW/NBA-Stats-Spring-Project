package com.sparta.wahdel.nbastatsspringproject.controller;

import com.sparta.wahdel.nbastatsspringproject.pojo.PlayerStatsPOJO;
import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class PlayerController {

    private PlayersDetailsPOJO playersDetailsPOJO;

    @Autowired
    public PlayerController() {
        try {
            playersDetailsPOJO = new PlayersDetailsPOJO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/players")
    public String getAllPlayers(ModelMap modelMap) {
        Iterable<PlayersDetailsPOJO.PlayersPOJO> players = playersDetailsPOJO.getPlayerList();
        modelMap.addAttribute("players", players);
        return "players";
    }

    @GetMapping("/players/{id}")
    public String findById(@PathVariable(value = "id") int playerId, ModelMap modelMap) {
        PlayersDetailsPOJO.PlayersPOJO player = playersDetailsPOJO.getPlayers().get(playerId);
        try {
            PlayerStatsPOJO playerStatsPOJO = new PlayerStatsPOJO(playerId);
            PlayerStatsPOJO.Latest playerStats = playerStatsPOJO.getPlayerStats();
            modelMap.addAttribute("player", player);
            modelMap.addAttribute("playerStats", playerStats);
            return "player";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
