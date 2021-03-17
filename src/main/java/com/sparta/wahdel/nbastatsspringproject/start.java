package com.sparta.wahdel.nbastatsspringproject;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersJSONToPOJO;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class start {
    public static void main(String[] args) {
        try {
            PlayersJSONToPOJO playersJSONToPOJO = new PlayersJSONToPOJO();
            HashMap<Integer, PlayersJSONToPOJO.PlayersPOJO> players = playersJSONToPOJO.getPlayers();
            List<PlayersJSONToPOJO.PlayersPOJO> playerList = playersJSONToPOJO.getPlayerList();
//            for (PlayersJSONToPOJO player: players) {
//                System.out.println(player.getPlayerId() + ", " + player + " " + player.getLastName());
//            }
            System.out.println(players.size() == playerList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
