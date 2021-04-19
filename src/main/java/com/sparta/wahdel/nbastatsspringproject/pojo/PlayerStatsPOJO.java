package com.sparta.wahdel.nbastatsspringproject.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatsPOJO {

    private final Root root;
    private final Latest playerStats;

    public PlayerStatsPOJO(int playerId) throws IOException {
        ObjectMapper om = new ObjectMapper();
        String jsonUrl = "http://data.nba.net/data/10s/prod/v1/2020/players/" +
                playerId +
                "_profile.json";
        root = om.readValue(new URL(jsonUrl), Root.class);
        playerStats = root.league.standard.stats.latest;
    }

    public Latest getPlayerStats() {
        return playerStats;
    }

    public double getPpg() {
        return root.league.standard.stats.latest.getPpg();
    }

    public double getRpg() {
        return root.league.standard.stats.latest.getRpg();
    }

    public double getApg() {
        return root.league.standard.stats.latest.getApg();
    }

    public double getMpg() {
        return root.league.standard.stats.latest.getMpg();
    }

    public double getTopg() {
        return root.league.standard.stats.latest.getTopg();
    }

    public double getSpg() {
        return root.league.standard.stats.latest.getSpg();
    }

    public double getBpg() {
        return root.league.standard.stats.latest.getBpg();
    }

    public double getTpp() {
        return root.league.standard.stats.latest.getTpp();
    }

    public double getFtp() {
        return root.league.standard.stats.latest.getFtp();
    }

    public double getFgp() {
        return root.league.standard.stats.latest.getFgp();
    }

    public int getFgm() {
        return root.league.standard.stats.latest.getFgm();
    }

    public int getFga() {
        return root.league.standard.stats.latest.getFga();
    }

    public int getTpm() {
        return root.league.standard.stats.latest.getTpm();
    }

    public int getTpa() {
        return root.league.standard.stats.latest.getTpa();
    }

    public int getFtm() {
        return root.league.standard.stats.latest.getFtm();
    }

    public int getFta() {
        return root.league.standard.stats.latest.getFta();
    }

    public int getGamesPlayed() {
        return root.league.standard.stats.latest.getGamesPlayed();
    }

    public int getGamesStarted() {
        return root.league.standard.stats.latest.getGamesStarted();
    }

    public int getPlusMinus() {
        return root.league.standard.stats.latest.getPlusMinus();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Latest {
        private double ppg;
        private double rpg;
        private double apg;
        private double mpg;
        private double topg;
        private double spg;
        private double bpg;
        private double tpp;
        private double ftp;
        private double fgp;
        private int fgm;
        private int fga;
        private int tpm;
        private int tpa;
        private int ftm;
        private int fta;
        private int gamesPlayed;
        private int gamesStarted;
        private int plusMinus;

        private double convertIfNull(double stat) {
            double value = stat;
            if (value < 0.0) {
                value = 0.0;
            }
            return value;
        }

        private int convertIfNull(int stat) {
            int value = stat;
            if (value < 0) {
                value = 0;
            }
            return value;
        }

        public double getPpg() {
            return convertIfNull(ppg);
        }

        public void setPpg(double ppg) {
            this.ppg = ppg;
        }

        public double getRpg() {
            return convertIfNull(rpg);
        }

        public void setRpg(double rpg) {
            this.rpg = rpg;
        }

        public double getApg() {
            return convertIfNull(apg);
        }

        public void setApg(double apg) {
            this.apg = apg;
        }

        public double getMpg() {
            return convertIfNull(mpg);
        }

        public void setMpg(double mpg) {
            this.mpg = mpg;
        }

        public double getTopg() {
            return convertIfNull(topg);
        }

        public void setTopg(double topg) {
            this.topg = topg;
        }

        public double getSpg() {
            return convertIfNull(spg);
        }

        public void setSpg(double spg) {
            this.spg = spg;
        }

        public double getBpg() {
            return convertIfNull(bpg);
        }

        public void setBpg(double bpg) {
            this.bpg = bpg;
        }

        public double getTpp() {
            return convertIfNull(tpp);
        }

        public void setTpp(double tpp) {
            this.tpp = tpp;
        }

        public double getFtp() {
            return convertIfNull(ftp);
        }

        public void setFtp(double ftp) {
            this.ftp = ftp;
        }

        public double getFgp() {
            return convertIfNull(fgp);
        }

        public void setFgp(double fgp) {
            this.fgp = fgp;
        }

        public int getFgm() {
            return convertIfNull(fgm);
        }

        public void setFgm(int fgm) {
            this.fgm = fgm;
        }

        public int getFga() {
            return convertIfNull(fga);
        }

        public void setFga(int fga) {
            this.fga = fga;
        }

        public int getTpm() {
            return convertIfNull(tpm);
        }

        public void setTpm(int tpm) {
            this.tpm = tpm;
        }

        public int getTpa() {
            return convertIfNull(tpa);
        }

        public void setTpa(int tpa) {
            this.tpa = tpa;
        }

        public int getFtm() {
            return convertIfNull(ftm);
        }

        public void setFtm(int ftm) {
            this.ftm = ftm;
        }

        public int getFta() {
            return convertIfNull(fta);
        }

        public void setFta(int fta) {
            this.fta = fta;
        }

        public int getGamesPlayed() {
            return convertIfNull(gamesPlayed);
        }

        public void setGamesPlayed(int gamesPlayed) {
            this.gamesPlayed = gamesPlayed;
        }

        public int getGamesStarted() {
            return convertIfNull(gamesStarted);
        }

        public void setGamesStarted(int gamesStarted) {
            this.gamesStarted = gamesStarted;
        }

        public int getPlusMinus() {
            return convertIfNull( plusMinus);
        }

        public void setPlusMinus(int plusMinus) {
            this.plusMinus = plusMinus;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Stats {
        public Latest latest;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Standard {
        public Stats stats;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class League {
        public Standard standard;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Root {
        public League league;
    }


}
