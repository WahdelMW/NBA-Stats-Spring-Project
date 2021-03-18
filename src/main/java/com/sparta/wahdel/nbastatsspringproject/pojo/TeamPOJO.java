package com.sparta.wahdel.nbastatsspringproject.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamPOJO {
    private Root root;
    private List<Standard> allTeams;

    public TeamPOJO() throws IOException {
        ObjectMapper om = new ObjectMapper();
        root = om.readValue(new URL("http://data.nba.net/data/10s/prod/v1/2020/teams.json"), Root.class);
        allTeams = root.league.standard;
    }

    public List<Standard> getAllTeams() {
        return allTeams;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Standard {
        private boolean isNBAFranchise;
        private boolean isAllStar;
        private String city;
        private String teamId;
        private String nickname;

        public boolean isNBAFranchise() {
            return isNBAFranchise;
        }

        public void setNBAFranchise(boolean NBAFranchise) {
            isNBAFranchise = NBAFranchise;
        }

        public boolean isAllStar() {
            return isAllStar;
        }

        public void setAllStar(boolean allStar) {
            isAllStar = allStar;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getTeamId() {
            return teamId;
        }

        public void setTeamId(String teamId) {
            this.teamId = teamId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class League {
        public List<Standard> standard;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Root {
        public League league;
    }


}
