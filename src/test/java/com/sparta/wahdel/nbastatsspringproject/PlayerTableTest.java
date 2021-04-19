package com.sparta.wahdel.nbastatsspringproject;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayersEntity;
import com.sparta.wahdel.nbastatsspringproject.repository.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerTableTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void findById() {
        PlayersEntity player = playerRepository.findById(203507).orElseThrow();
        System.out.println(player);
        Assertions.assertEquals("Giannis", player.getFirstName());
    }

}
