package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.entity.UsersEntity;
import com.sparta.wahdel.nbastatsspringproject.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Iterable<UsersEntity> getAllUsers() {
        return usersRepository.findAll();
    }

    public void save(UsersEntity usersEntity) {
        usersRepository.save(usersEntity);
    }

    public void saveUser(String username, String password, String role) {
        UsersEntity newUser = new UsersEntity();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        newUser.setEnabled((byte) 1);
        save(newUser);
    }

    public Optional<UsersEntity> getUserByUsername(String username) {
        return usersRepository.getUserByUsername(username);
    }
}
