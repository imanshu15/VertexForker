/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.jme3.network.Client;
import com.jme3.network.ClientStateListener;
import com.jme3.network.Network;
import com.vertexforker.entity.Player;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imanshu
 */
public class ClientManager implements ClientStateListener{
    
    private Client client;
    
    public ClientManager(String serverIp){
        ConnectionUtil.initSerializers();
        try {
            client = Network.connectToServer(serverIp, ConnectionUtil.SERVER_PORT);
            client.addMessageListener(new ClientListener(client));
            
        }catch(Exception ex) {  
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Initializing Error");
        }
    }
    
    public boolean startClient(Player player){
       boolean value = true; 
       try {
            client.start();   
            System.out.println("Client Connected");
            clientConnected(client);
            client.send(new PlayerMessage(player));
            
        }catch(Exception ex) {
            
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Starting Error");
            value = false;
        }
       return value;
    }

    @Override
    public void clientConnected(Client c) {
        client.send(new TextMessage("Client Connected [ " + c.getId() + " ] "));
    }

    @Override
    public void clientDisconnected(Client c, DisconnectInfo info) {
        
    }
    
}
