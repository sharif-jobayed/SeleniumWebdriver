package com.theInternetHerokuApp.data;

public class Constants {
    private static int minSec;
    private static int medSec;
    private static int maxSec;

    public Constants () {
        minSec = 5;
        medSec = 30;
        maxSec = 60;
    }

    public static int getMinSec() {
        return minSec;
    }

    public static int getMedSec() {
        return medSec;
    }

    public static int getMaxSec() {
        return maxSec;
    }
}
