package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {
}
