package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;

import java.io.IOException;
import java.util.*;

public class PlayerPojoRepository {
    private PlayersDetailsPOJO playersDetailsPOJO;

    public PlayerPojoRepository() {
        try {
            this.playersDetailsPOJO = new PlayersDetailsPOJO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Iterable<PlayersDetailsPOJO.PlayersPOJO> getPlayerList() {
        return playersDetailsPOJO.getPlayerList();
    }

    public Iterable<PlayersDetailsPOJO.PlayersPOJO> getPlayersByTeamId(int teamId) {
        List<PlayersDetailsPOJO.PlayersPOJO> teamPlayers = new ArrayList<>();
        for (PlayersDetailsPOJO.PlayersPOJO player : getPlayerList()) {
            if (player.getTeamId() == teamId) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }

    public Iterable<PlayersDetailsPOJO.PlayersPOJO> getListPlayersFromListOfPlayerIds(Iterable<Integer> playerIds) {
        return getPlayersPOJOS(playerIds);
    }

    private List<PlayersDetailsPOJO.PlayersPOJO> getPlayersPOJOS(Iterable<Integer> playerIds) {
        List<PlayersDetailsPOJO.PlayersPOJO> teamPlayers = new ArrayList<>();
        List<Integer> players = new ArrayList<>();
        for (int id:playerIds) {
            players.add(id);
        }
        
        for (PlayersDetailsPOJO.PlayersPOJO player : getPlayerList()) {
            if (players.contains(player.getPersonId())) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }
}
