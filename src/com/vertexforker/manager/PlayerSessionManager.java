/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.manager;

import com.vertexforker.entity.Player;
import com.vertexforker.util.EncryptionEngine;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class PlayerSessionManager {

    private static ConcurrentHashMap<String, Player> userSessions;
    private static String localPlayerKey;

    private PlayerSessionManager() {
        userSessions = new ConcurrentHashMap<>();
    }

    private static class PlayerSessionHelper {

        private static PlayerSessionManager playerSessionManager = new PlayerSessionManager();
    }

    public static PlayerSessionManager getInstance() {
        return PlayerSessionHelper.playerSessionManager;
    }

    public String addNewPlayer(Player player) {
        try {
            player.setSessionKey(generateKey(player));
            userSessions.put(player.getSessionKey(), player);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(PlayerSessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player.getSessionKey();
    }

    public boolean removePlayer(Player player) {
        boolean result = false;
        if (userSessions.containsKey(player.getSessionKey())) {
            userSessions.remove(player.getSessionKey());
            result = true;
        }
        return result;
    }

    private String generateKey(Player player) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return new EncryptionEngine().encrypt(player.getIpAddress() + player.getPlayerName());
    }

    public Player getPlayerBySessionKey(String sessionKey) {
        return userSessions.get(sessionKey);
    }

    public ConcurrentHashMap getAllPlayers() {
        for (Map.Entry<String, Player> entry : userSessions.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getPlayerName());
        }
        return userSessions;
    }

    public void replaceUserSessionMap(ConcurrentHashMap userSessionMap) {
        userSessions.clear();
        userSessions = userSessionMap;
    }

    public String getLocalPlayerKey() {
        return localPlayerKey;
    }

    public void setLocalPlayerKey(String aLocalPlayerKey) {
        localPlayerKey = aLocalPlayerKey;
    }

}
