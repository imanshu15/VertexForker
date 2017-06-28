/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.vertexforker.meta.Message;
import com.vertexforker.meta.PlayerMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jme3.network.Client;
import com.jme3.network.Network;
import com.vertexforker.entity.Player;
import com.vertexforker.manager.PlayerSessionManager;
import com.vertexforker.meta.MessageToken;
import com.vertexforker.screens.GameFrame;
import com.vertexforker.meta.Token;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imanshu
 */
public class ClientManager{

    private static Client client;
    private static PlayerSessionManager sessionManager;

    public ClientManager() {
    }

    public Token startClient(String serverIp, GameFrame gm, Player player) {
        Token token = new Token();
        try {
            ConnectionUtil.initSerializers();
            client = Network.connectToServer(serverIp, ConnectionUtil.SERVER_PORT);
            client.addMessageListener(new ClientListener(client, gm));
            sessionManager = PlayerSessionManager.getInstance();

            client.start();
            System.out.println("Client Connected");
            clientConnected(client);

            //Add new player
            player.setRequestType(Player.Request.CONNECT);
            String playerSessionKey = sessionManager.addNewPlayer(player);
            sessionManager.setLocalPlayerKey(playerSessionKey);

            Gson gson = new Gson();
            client.send(new PlayerMessage(gson.toJson(sessionManager.getPlayerBySessionKey(playerSessionKey))));

        } catch (Exception ex) {

            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Starting Error");
            token.setSuccess(false);
            token.setError("Connection Starting Error");
        }
        return token;
    }

    public static Token endClient() {
        Token token = new Token();
        try {
            //Remove local player
            Player player = sessionManager.getPlayerBySessionKey(sessionManager.getLocalPlayerKey());
            sessionManager.removePlayer(player);
            player.setRequestType(Player.Request.DISCONNECT);

            Gson gson = new Gson();
            client.send(new PlayerMessage(gson.toJson(player)));
            if (client.isStarted()) {
                client.close();
            }
        } catch (Exception ex) {

            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Starting Error");
            token.setSuccess(false);
            token.setError("Connection Starting Error");
        }
        return token;
    }

    public void clientConnected(Client c) {
        Gson gson = new GsonBuilder().create();
        MessageToken mt = new MessageToken();
        mt.setCode(MessageToken.Code.CLIENT_CONNECTED);
        mt.setMessage("Client Connected [ " + c.getId() + " ] ");
        client.send(new Message(gson.toJson(mt)));
    }
}
