package com.sparta.wahdel.nbastatsspringproject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teams", schema = "nba_stats")
public class TeamsEntity {
    private int teamId;
    private int userId;
    private String cityName;
    private String teamName;
    private boolean fantasy;

    @Id
    @GeneratedValue(generator="myGenerator")
    @GenericGenerator(name="myGenerator", strategy="com.sparta.wahdel.nbastatsspringproject.utils.IDGenerator")
    @Column(name = "team_id")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Basic
    @Column(name = "is_fantasy")
    public boolean isFantasy() {
        return fantasy;
    }

    public void setFantasy(boolean fantasy) {
        this.fantasy = fantasy;
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
