package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersDetailsPOJO;

import java.util.ArrayList;
import java.util.List;

public class PlayerPojoRepository {
    private PlayersDetailsPOJO playersDetailsPOJO;

    public PlayerPojoRepository(PlayersDetailsPOJO playersDetailsPOJO) {
        this.playersDetailsPOJO = playersDetailsPOJO;
    }

    public Iterable<PlayersDetailsPOJO.PlayersPOJO> getPlayerList() {
        return playersDetailsPOJO.getPlayerList();
    }

    public Iterable<PlayersDetailsPOJO.PlayersPOJO> getPlayerByTeamId(int teamId) {
        List<PlayersDetailsPOJO.PlayersPOJO> teamPlayers = new ArrayList<>();
        for (PlayersDetailsPOJO.PlayersPOJO player : playersDetailsPOJO.getPlayerList()) {
            if (player.getTeamId() == teamId) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }
}
