package com.sparta.wahdel.nbastatsspringproject.datastore;

import java.util.HashSet;
import java.util.List;

public class Lineup {

    private static HashSet<Integer> starters;
    private static HashSet<Integer> bench;

    static
    {
        starters = new HashSet<>();
        bench = new HashSet<>();
    }

    public static HashSet<Integer> getStarters() {
        return starters;
    }

    public void setStarters(HashSet<Integer> starters) {
        this.starters = starters;
    }

    public static void addToStarters(int playerId) {
        starters.add(playerId);
    }

    public void removeFromStarters(int playerId) {
        if (starters.contains(playerId)) {
            starters.remove(playerId);
        }
    }

    public static void clear() {
        starters.clear();
        bench.clear();
    }

    public HashSet<Integer> getBench() {
        return bench;
    }

    public void setBench(HashSet<Integer> bench) {
        this.bench = bench;
    }

    public void addToBench(int playerId) {
        starters.add(playerId);
    }

    public void removeFromBench(int playerId) {
        if (starters.contains(playerId)) {
            starters.remove(playerId);
        }
    }
}
