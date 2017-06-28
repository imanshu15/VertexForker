/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.vertexforker.meta.PlayerMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jme3.network.Filters;
import com.jme3.network.HostedConnection;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;
import com.jme3.network.Server;
import com.vertexforker.entity.Player;
import com.vertexforker.manager.PlayerSessionManager;
import com.vertexforker.manager.ServerDataManager;
import com.vertexforker.meta.MessageToken;
import com.vertexforker.screens.GameFrame;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Imanshu
 */
public class ServerListener implements MessageListener<HostedConnection> {

    private Server server;
    private GameFrame gameFrame;
    public static ServerDataManager svrData;
    private PlayerSessionManager sessionManager;

    public ServerListener(Server server, GameFrame gameFrame, Player player) {
        this.server = server;
        this.gameFrame = gameFrame;
        svrData = new ServerDataManager();
        //Add initial player - server player
        sessionManager = PlayerSessionManager.getInstance();
        player.setPlayerPosition(0);
        player.setDefinedNoOfPlayers(svrData.getNoOfPlayersDefined());
        String playerSessionKey = sessionManager.addNewPlayer(player);
        sessionManager.setLocalPlayerKey(playerSessionKey);
    }

    @Override
    public void messageReceived(HostedConnection source, Message m) {

        if (m instanceof com.vertexforker.meta.Message) {

            com.vertexforker.meta.Message tm = (com.vertexforker.meta.Message) m;
            System.out.println(tm.getMessage());
            server.broadcast(Filters.notEqualTo(source), new com.vertexforker.meta.Message(tm.getMessage()));

        } else if (m instanceof PlayerMessage) {
            Gson gson = new GsonBuilder().create();
            PlayerMessage pm = (PlayerMessage) m;
            Player player = gson.fromJson(pm.getPlayer(), Player.class);

            switch (player.getRequestType()) {
                case CONNECT:
                    connectPlayer(player);
                    break;
                case DISCONNECT:
                    disconnectPlayer(player);
                    break;
            }

        }
    }

    private void connectPlayer(Player player) {
        Gson gson = new GsonBuilder().create();
        MessageToken erroMessage;

        if (!svrData.isGameStarted()) {
            if (sessionManager.getAllPlayers().size() < svrData.getNoOfPlayersDefined()) {

                //Set player position
                player.setPlayerPosition(sessionManager.getAllPlayers().size());
                //Set defined no of players
                player.setDefinedNoOfPlayers(svrData.getNoOfPlayersDefined());

                sessionManager.addNewPlayer(player);
                if (sessionManager.getAllPlayers().size() == svrData.getNoOfPlayersDefined()) {
                    //Set game started to true
                    ConcurrentHashMap<String, Player> allPlayers = sessionManager.getAllPlayers();
                    for (Map.Entry<String, Player> entry : allPlayers.entrySet()) {
                        Player ply = entry.getValue();
                        ply.setGameStarted(true);
                        allPlayers.put(entry.getKey(), ply);
                        svrData.setGameStarted(true);
                    }
                }
                gameFrame.setUpGameScreen();
                server.broadcast(new PlayerMessage(gson.toJson(sessionManager.getAllPlayers())));
                System.out.println(player.getPlayerName() + " Connected");
            } else {
                erroMessage = new MessageToken();
                erroMessage.setCode(MessageToken.Code.TABLE_IS_FULL);
                erroMessage.setMessage("No Space");
                server.broadcast(new com.vertexforker.meta.Message(gson.toJson(erroMessage)));
            }
        } else {
            erroMessage = new MessageToken();
            erroMessage.setCode(MessageToken.Code.GAME_STARTED);
            erroMessage.setMessage("Game has already started");
            server.broadcast(new com.vertexforker.meta.Message(gson.toJson(erroMessage)));
        }
    }

    private void disconnectPlayer(Player player) {
        Gson gson = new GsonBuilder().create();
        sessionManager.removePlayer(player);
        gameFrame.setUpGameScreen();
        if (sessionManager.getAllPlayers().size() > 1) {
            server.broadcast(new PlayerMessage(gson.toJson(sessionManager.getAllPlayers())));
        }else{
            
        }
        System.out.println(player.getPlayerName() + " Disconnected");
    }

}
