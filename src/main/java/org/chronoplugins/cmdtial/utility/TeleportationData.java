package org.chronoplugins.cmdtial.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TeleportationData {

    private static Map<UUID, String> selfData = new HashMap<>();
    private static Map<UUID, String> playerData = new HashMap<>();

    public static String getSelfData(UUID id) {
        return selfData.get(id);
    }

    public static String getPlayerData(UUID id) {
        return playerData.get(id);
    }

    public static void setData(UUID id, String value, String store) {
        switch (store) {
            case "self":
                selfData.put(id, value);
                break;
            case "player":
                playerData.put(id, value);
                break;
        }
    }

}
