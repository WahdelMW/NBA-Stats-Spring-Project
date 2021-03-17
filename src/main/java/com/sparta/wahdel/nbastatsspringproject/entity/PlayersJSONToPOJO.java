package com.sparta.wahdel.nbastatsspringproject.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayersJSONToPOJO {

    private Root root;
    private List<PlayersPOJO> players;

    public PlayersJSONToPOJO() throws IOException {
        ObjectMapper om = new ObjectMapper();
        root = om.readValue(new URL("http://data.nba.net/data/10s/prod/v1/2020/players.json"), Root.class);
        players = root.league.standard;
    }

    public HashMap<Integer, PlayersPOJO> getPlayers() {
        HashMap<Integer, PlayersPOJO> playersMap = new HashMap<>();
        for (PlayersPOJO player: players) {
            playersMap.put(Integer.parseInt(player.getPersonId()), player);
        }
        return playersMap;
    }

    public List<PlayersPOJO> getPlayerList() {
        return players;
    }

    public String getFirstName() {
        return root.league.standard.get(0).getFirstName();
    }

    public String getLastName() {
        return root.league.standard.get(0).getLastName();
    }

    public String getTeamId() {
        return root.league.standard.get(0).getTeamId();
    }

    public String getPlayerId() {
        return root.league.standard.get(0).getPersonId();
    }

    public int getPlayerCount() {
        return root.league.standard.size();
    }

    @Override
    public String toString() {
        return "PlayersListPOJO{" +
                getFirstName() + " " +
                getLastName() + " " +
                getPlayerId() + " " +
                getTeamId() + "}";
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlayersPOJO{
        private String firstName;
        private String lastName;
        private String personId;
        private String teamId;

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

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getTeamId() {
            return teamId;
        }

        public void setTeamId(String teamId) {
            this.teamId = teamId;
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
