/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.google.gson.Gson;
import com.jme3.app.SimpleApplication;
import com.jme3.network.Network;
import com.jme3.network.Server;
import com.vertexforker.entity.Player;
import com.vertexforker.meta.Message;
import com.vertexforker.meta.MessageToken;
import com.vertexforker.meta.PlayerMessage;
import com.vertexforker.screens.GameFrame;
import com.vertexforker.meta.Token;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imanshu
 */
public class ServerManager {

    private static Server server;

    public ServerManager(GameFrame game, Player player) {

        ConnectionUtil.initSerializers();
        try {
            server = Network.createServer(ConnectionUtil.SERVER_PORT);
            server.addMessageListener(new ServerListener(server, game, player));
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Server Initializing Error");
        }

    }

    public Token startServer() {
        Token token = new Token();
        try {
            server.start();
            System.out.println("Server Started");

        } catch (Exception ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Server Staring Error");
            token.setSuccess(false);
            token.setError("Server Starting Error");
        }

        return token;
    }

    public static Token endServer() {
        Token token = new Token();
        try {
            Gson gson = new Gson();
            MessageToken messageToken = new MessageToken();
            messageToken.setCode(MessageToken.Code.SERVER_DISCONNECTED);
            messageToken.setMessage("Server has disconnected.");
            server.broadcast(new Message(gson.toJson(messageToken)));
            if (server.isRunning()) {
                server.close();
            }
        } catch (Exception ex) {

            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Starting Error");
            token.setSuccess(false);
            token.setError("Connection Starting Error");
        }
        return token;
    }
}
