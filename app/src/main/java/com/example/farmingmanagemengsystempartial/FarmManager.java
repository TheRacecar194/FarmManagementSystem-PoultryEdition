package com.example.farmingmanagemengsystempartial;

import java.util.HashMap;

public class FarmManager {
    private static FarmManager instance;
    private HashMap<String, FarmData> farms; // Mapping farm name to its data

    private FarmManager() {
        farms = new HashMap<>();
    }

    public static synchronized FarmManager getInstance() {
        if (instance == null) {
            instance = new FarmManager();
        }
        return instance;
    }

    public HashMap<String, FarmData> getFarms() {
        return farms;
    }

    public void addFarm(String farmName, int numberOfChickens, float averageWeight) {
        farms.put(farmName, new FarmData(numberOfChickens, averageWeight));
    }

    public static class FarmData {
        int numberOfChickens;
        float averageWeight;

        public FarmData(int numberOfChickens, float averageWeight) {
            this.numberOfChickens = numberOfChickens;
            this.averageWeight = averageWeight;
        }
    }
}