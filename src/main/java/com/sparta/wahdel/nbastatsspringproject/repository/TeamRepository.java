package com.sparta.wahdel.nbastatsspringproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository implements CrudRepository<TeamRepository, Integer> {
}
