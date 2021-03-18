package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import com.sparta.wahdel.nbastatsspringproject.pojo.PlayersDetailsPOJO;
import com.sparta.wahdel.nbastatsspringproject.repository.PlayerPojoRepository;
import com.sparta.wahdel.nbastatsspringproject.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

@Service
public class PlayerPojoService {

    private PlayerPojoRepository playerPojoRepository;

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
