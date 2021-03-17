package com.sparta.wahdel.nbastatsspringproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teams", schema = "nba_stats", catalog = "")
public class TeamsEntity {
    private Long id;
    private int teamId;
    private String cityName;
    private String teamName;
    private String conference;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Basic
    @Column(name = "conference")
    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamsEntity that = (TeamsEntity) o;
        return teamId == that.teamId && Objects.equals(cityName, that.cityName) && Objects.equals(teamName, that.teamName) && Objects.equals(conference, that.conference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, cityName, teamName, conference);
    }
}
