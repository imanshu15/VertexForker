/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.manager;

import com.jme3.network.Client;
import com.jme3.network.Network;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imanshu
 */
public class ClientManager {
    
    private Client client;
    
    public ClientManager(){
        
        try {
            client = Network.connectToServer(ConnectionUtil.IP_ADDRESS, ConnectionUtil.PORT);
            client.start();
            
            System.out.println("Client Connected");
        } catch (IOException ex) {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
}
