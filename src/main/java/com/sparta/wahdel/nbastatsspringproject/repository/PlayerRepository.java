package com.sparta.wahdel.nbastatsspringproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository implements CrudRepository<PlayerEntity, Long> {
}
