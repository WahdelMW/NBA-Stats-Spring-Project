package com.sparta.wahdel.nbastatsspringproject.service;

import com.sparta.wahdel.nbastatsspringproject.entity.UsersEntity;
import com.sparta.wahdel.nbastatsspringproject.repository.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LoginCredentialService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public LoginCredentialService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersEntity getCurrentUser(String username) {
        Optional<UsersEntity> user = usersRepository.getUserByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return user.get();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        UsersEntity user = getCurrentUser(username);
        grantedAuthoritySet.add(new SimpleGrantedAuthority(user.getRole()));
        //Todo: Find why user.getPassword() returns hash of already hashed password.
        String password = usersRepository.getPasswordByUsername(username);
        return new User(user.getUsername(), password, grantedAuthoritySet);
    }
}
