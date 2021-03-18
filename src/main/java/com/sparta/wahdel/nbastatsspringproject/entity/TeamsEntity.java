package com.sparta.wahdel.nbastatsspringproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teams", schema = "nba_stats")
public class TeamsEntity {
    private int teamId;
    private String cityName;
    private String teamName;

    @Id
    @Column(name = "team_id")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "team_name")
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamsEntity that = (TeamsEntity) o;
        return teamId == that.teamId && Objects.equals(cityName, that.cityName) && Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, cityName, teamName);
    }
}
