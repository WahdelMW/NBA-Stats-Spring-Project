package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayersEntity, Integer> {
}
