package com.sparta.wahdel.nbastatsspringproject.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerPOJO {

    private Root root;

    public PlayerPOJO() throws IOException {
        ObjectMapper om = new ObjectMapper();
        root = om.readValue(new URL("http://data.nba.net/data/10s/prod/v1/2020/players.json"), Root.class);
    }

    public String getFirstName() {
        String firstName = root.league.standard.get(0).getFirstName();
        return firstName;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Standard{
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
    public static class League{
        public List<Standard> standard;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Root{
        public League league;
    }


}
