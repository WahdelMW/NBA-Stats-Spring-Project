package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<PlayersEntity, Integer> {

    @Query("SELECT p.playerId FROM PlayersEntity p WHERE p.teamId = ?1 ORDER BY p.lastName")
    List<Integer> findPlayerIdByTeamId(int teamId);

    @Query("SELECT COUNT(p) FROM PlayersEntity p WHERE p.teamId = ?1")
    Long getCountOfPlayersByTeamId(int teamId);
}
