package by.bsu.fpmi.up.howto.webappsample;

import java.util.HashMap;
import java.util.Map;

public class KeyStorage {
    private Map<String, String> tokens = new HashMap<String, String>();

    public boolean checkByToken(String token) {
        return token != null && tokens.values().contains(token);
    }

    public boolean storeToken(String sessionId, String token) {
        return token != null && tokens.put(sessionId, token) == null;
    }

    public boolean checkBySession(String sessionId) {
        return sessionId != null && tokens.keySet().contains(sessionId);
    }
}
