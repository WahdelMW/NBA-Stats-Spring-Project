package com.sparta.wahdel.nbastatsspringproject;

import com.sparta.wahdel.nbastatsspringproject.entity.PlayerPOJO;

import java.io.IOException;

public class players {
    public static void main(String[] args) {
        try {
            PlayerPOJO playerPOJO = new PlayerPOJO();
            System.out.println(playerPOJO.getFirstName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
