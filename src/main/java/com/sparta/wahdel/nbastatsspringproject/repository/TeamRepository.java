package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.entity.TeamsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<TeamsEntity, Integer> {
}
