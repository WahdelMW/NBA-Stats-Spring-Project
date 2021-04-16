package com.sparta.wahdel.nbastatsspringproject.datastore;

import java.util.HashSet;

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

    public static boolean isFull() {
        return getNumberOfStarters() >= 5;
    }

    public static void addToStarters(int playerId) {
        if(!isFull()) {
            starters.add(playerId);
        }
    }

    public static void removeFromStarters(int playerId) {
        if (starters.contains(playerId)) {
            starters.remove(playerId);
        }
    }

    public static int getNumberOfStarters() {
        return starters.size();
    }

    public static boolean isStarterEmpty() {
        return starters.isEmpty();
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
