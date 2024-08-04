package data;

import java.util.HashMap;

public class Constants {
    private static final HashMap<String, Integer> TIMEOUTS = new HashMap<>();

    public Constants() {
        TIMEOUTS.put("Minimum", 10000);
        TIMEOUTS.put("Medium", 30000);
        TIMEOUTS.put("Maximum", 60000);
    }

    public static Integer getMinTimeOut() {
        return TIMEOUTS.get("Minimum");
    }

    public static Integer getMedTimeOut() {
        return TIMEOUTS.get("Medium");
    }

    public static Integer getMaxTimeOut() {
        return TIMEOUTS.get("Maximum");
    }
}
