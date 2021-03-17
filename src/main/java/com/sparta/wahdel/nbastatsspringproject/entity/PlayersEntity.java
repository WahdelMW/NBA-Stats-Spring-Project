package com.sparta.wahdel.nbastatsspringproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "players", schema = "nba_stats")
public class PlayersEntity {
    private int playerId;
    private String firstName;
    private String lastName;
    private String position;
    private int points;
    private int rebounds;
    private int assists;
    private int steals;
    private int blocks;
    private int fouls;
    private int turnovers;
    private double fieldGoalPercent;
    private double threePointPercent;

    @Id
    @Column(name = "player_id")
    @JsonProperty("personId")
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    @Basic
    @Column(name = "first_name")
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "position")
    @JsonProperty("posFull")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "points")
    @JsonProperty("ppg")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Basic
    @Column(name = "rebounds")
    @JsonProperty("rpg")
    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    @Basic
    @Column(name = "assists")
    @JsonProperty("apg")
    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    @Basic
    @Column(name = "steals")
    @JsonProperty("spg")
    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    @Basic
    @Column(name = "blocks")
    @JsonProperty("bpg")
    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    @Basic
    @Column(name = "turnovers")
    @JsonProperty("topg")
    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    @Basic
    @Column(name = "fg%")
    @JsonProperty("fgp")
    public double getFieldGoalPercent() {
        return fieldGoalPercent;
    }

    public void setFieldGoalPercent(double fieldGoalPercent) {
        this.fieldGoalPercent = fieldGoalPercent;
    }

    @Basic
    @Column(name = "3pt%")
    @JsonProperty("tpp")
    public double getThreePointPercent() {
        return threePointPercent;
    }

    public void setThreePointPercent(double threePointPercent) {
        this.threePointPercent = threePointPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayersEntity that = (PlayersEntity) o;
        return playerId == that.playerId && points == that.points && rebounds == that.rebounds && assists == that.assists && steals == that.steals && blocks == that.blocks && fouls == that.fouls && turnovers == that.turnovers && Double.compare(that.fieldGoalPercent, fieldGoalPercent) == 0 && Double.compare(that.threePointPercent, threePointPercent) == 0 && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, firstName, lastName, position, points, rebounds, assists, steals, blocks, fouls, turnovers, fieldGoalPercent, threePointPercent);
    }
}
