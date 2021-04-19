package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;
import com.sparta.wahdel.nbastatsspringproject.repository.PlayerPojoRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerPojoService {

    private final PlayerPojoRepository playerPojoRepository;

    public PlayerPojoService() {
        playerPojoRepository = new PlayerPojoRepository();

    }

    public Iterable<PlayersDetailsPOJO.PlayersPOJO> getAllPlayers() {
        return playerPojoRepository.getPlayerList();
    }

    public Iterable<PlayersDetailsPOJO.PlayersPOJO> getPlayersByTeamId(int teamId) {
        return playerPojoRepository.getPlayersByTeamId(teamId);
    }

    public Iterable<PlayersDetailsPOJO.PlayersPOJO> getPlayersFromListOfPlayerIds(Iterable<Integer> playerIds) {
        return playerPojoRepository.getListPlayersFromListOfPlayerIds(playerIds);
    }
}
