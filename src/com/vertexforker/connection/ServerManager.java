/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.jme3.network.Network;
import com.jme3.network.Server;
import com.vertexforker.util.Token;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imanshu
 */
public class ServerManager {
    
    private Server server;
    
    
    public ServerManager(){
        ConnectionUtil.initSerializers();
         try {
            server = Network.createServer(ConnectionUtil.SERVER_PORT);
            server.addMessageListener(new ServerListener(server));
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Server Initializing Error");
        }
        
    }
    
    public Token startServer(){
        Token token = new Token();
         try {
            server.start();
            System.out.println("Server Started");
          
         } catch (Exception ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Server Staring Error");
            token.setSuccess(false);
            token.setError("Server Starting Error" );
        }
         
         return token;
    }
    
}
