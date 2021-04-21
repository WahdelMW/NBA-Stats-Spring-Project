package com.sparta.wahdel.nbastatsspringproject.repository;

import com.sparta.wahdel.nbastatsspringproject.entity.UsersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {

    Optional<UsersEntity> getUserByUsername(String username);

    @Query(value = "SELECT u.password FROM UsersEntity u WHERE u.username = ?1")
    String getPasswordByUsername(String Username);
}
