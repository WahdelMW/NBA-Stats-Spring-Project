package com.sparta.wahdel.nbastatsspringproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "players", schema = "nba_stats")
public class PlayersEntity {
    private Long id;
    private int playerId;
    private String firstName;
    private String lastName;
    private int points;
    private int rebounds;
    private int assists;
    private int steals;
    private int blocks;
    private int fouls;
    private int turnovers;
    private double fg;
    private double ThreePt;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "player_id")
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Basic
    @Column(name = "rebounds")
    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    @Basic
    @Column(name = "assists")
    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    @Basic
    @Column(name = "steals")
    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    @Basic
    @Column(name = "blocks")
    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    @Basic
    @Column(name = "fouls")
    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    @Basic
    @Column(name = "turnovers")
    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    @Basic
    @Column(name = "fg%")
    public double getFg() {
        return fg;
    }

    public void setFg(double fg) {
        this.fg = fg;
    }

    @Basic
    @Column(name = "3pt%")
    public double getThreePt() {
        return ThreePt;
    }

    public void setThreePt(double threePt) {
        ThreePt = threePt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayersEntity that = (PlayersEntity) o;
        return playerId == that.playerId && points == that.points && rebounds == that.rebounds && assists == that.assists && steals == that.steals && blocks == that.blocks && fouls == that.fouls && turnovers == that.turnovers && Double.compare(that.fg, fg) == 0 && Double.compare(that.ThreePt, ThreePt) == 0 && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, firstName, lastName, points, rebounds, assists, steals, blocks, fouls, turnovers, fg, ThreePt);
    }
}
