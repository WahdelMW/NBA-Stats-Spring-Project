package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.entity.UsersEntity;
import com.sparta.wahdel.nbastatsspringproject.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Iterable<UsersEntity> getAllUsers() {
        return usersRepository.findAll();
    }

    public void saveUser(UsersEntity usersEntity) {
        usersRepository.save(usersEntity);
    }
}
