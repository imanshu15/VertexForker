/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.vertexforker.meta.PlayerMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jme3.network.Client;
import com.jme3.network.MessageListener;
import com.vertexforker.entity.Player;
import com.vertexforker.manager.PlayerSessionManager;
import com.vertexforker.manager.ServerDataManager;
import com.vertexforker.meta.Message;
import com.vertexforker.meta.MessageToken;
import com.vertexforker.screens.GameFrame;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Imanshu
 */
public class ClientListener implements MessageListener<Client> {

    private Client client;
    private ServerDataManager svrData;
    private GameFrame gameFrame;
    private PlayerSessionManager sessionManager;
    public static MessageToken latestServerMessage;

    public ClientListener(Client client, GameFrame gameFrame) {
        this.client = client;
        svrData = new ServerDataManager();
        this.gameFrame = gameFrame;
        sessionManager = PlayerSessionManager.getInstance();
    }

    @Override
    public void messageReceived(Client source, com.jme3.network.Message m) {

        if (m instanceof Message) {

            Message tm = (Message) m;
            Gson gson = new GsonBuilder().create();
            TypeToken<MessageToken> token = new TypeToken<MessageToken>() {
            };
            latestServerMessage = gson.fromJson(tm.getMessage(), token.getType());
            switch (latestServerMessage.getCode()) {
                case SERVER_DISCONNECTED:
                    if (source.isStarted()) {
                        source.close();
                    }
                    gameFrame.autoExitGame();
                    break;
            }
        }
        if (m instanceof PlayerMessage) {
            latestServerMessage = null;
            PlayerMessage pm = (PlayerMessage) m;
            Gson gson = new GsonBuilder().create();
            TypeToken<ConcurrentHashMap<String, Player>> token = new TypeToken<ConcurrentHashMap<String, Player>>() {
            };
            ConcurrentHashMap<String, Player> playerSessions = gson.fromJson(pm.getPlayer(), token.getType());
            sessionManager.replaceUserSessionMap(playerSessions);
            gameFrame.setUpGameScreen();
        }

    }
}
