package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import com.sparta.wahdel.nbastatsspringproject.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Iterable<PlayersEntity> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void savePlayer(PlayersEntity playersEntity) {
        playerRepository.save(playersEntity);
    }

    public PlayersEntity getById(int playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new NullPointerException());
    }

    public Iterable<Integer> getAllIdsOfPlayersOnTeam(int teamId) {
        return playerRepository.findPlayerIdByTeamId(teamId);
    }

    public long getPlayerCountByTeamId(int teamId) {
        return playerRepository.getCountOfPlayersByTeamId(teamId);
    }
}
