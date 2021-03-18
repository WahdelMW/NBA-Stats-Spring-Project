package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.entity.TeamsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<TeamsEntity, Integer> {

    @Query("SELECT t FROM TeamsEntity t WHERE t.fantasy = ?1")
    List<TeamsEntity> findTeamsEntityByIsFantasy(boolean fantasy);
}
