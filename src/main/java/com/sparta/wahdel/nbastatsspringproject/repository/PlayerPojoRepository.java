package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersDetailsPOJO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerPojoRepository {
    private PlayersDetailsPOJO playersDetailsPOJO;

    public PlayerPojoRepository() throws IOException {
        this.playersDetailsPOJO = new PlayersDetailsPOJO();
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

    public Iterable<PlayersDetailsPOJO.PlayersPOJO> getListPlayersFromListOfPlayerIds(List<Integer> playerIds) {
        List<PlayersDetailsPOJO.PlayersPOJO> teamPlayers = new ArrayList<>();
        for (PlayersDetailsPOJO.PlayersPOJO player : getPlayerList()) {
            if (playerIds.contains(player.getPersonId())) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }
}
