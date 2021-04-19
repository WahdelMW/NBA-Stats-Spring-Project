package com.sparta.wahdel.nbastatsspringproject.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayersDetailsPOJO {

    private Root root;
    private List<PlayersPOJO> players;

    public PlayersDetailsPOJO() throws IOException {
        ObjectMapper om = new ObjectMapper();
        root = om.readValue(new URL("http://data.nba.net/data/10s/prod/v1/2020/players.json"), Root.class);
        players = root.league.standard;
    }

    public HashMap<Integer, PlayersPOJO> getPlayers() {
        HashMap<Integer, PlayersPOJO> playersMap = new HashMap<>();
        for (PlayersPOJO player: players) {
            playersMap.put(player.getPersonId(), player);
        }
        return playersMap;
    }

    public List<PlayersPOJO> getPlayerList() {
        return players;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlayersPOJO{
        private String firstName;
        private String lastName;
        private int personId;
        private int teamId;
        private String heightFeet;
        private String heightInches;
        private String pos;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getPersonId() {
            return personId;
        }

        public void setPersonId(int personId) {
            this.personId = personId;
        }

        public int getTeamId() {
            return teamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }

        public String getHeightFeet() {
            return heightFeet;
        }

        public void setHeightFeet(String heightFeet) {
            this.heightFeet = heightFeet;
        }

        public String getHeightInches() {
            return heightInches;
        }

        public void setHeightInches(String heightInches) {
            this.heightInches = heightInches;
        }

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class League{
        public List<PlayersPOJO> standard;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Root{
        public League league;
    }
}
