/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.jme3.network.Client;
import com.jme3.network.MessageListener;

/**
 *
 * @author Imanshu
 */
public class ClientListener implements MessageListener<Client>{
 
    private Client client;
    
    public ClientListener(Client client){
        this.client = client;
    }
   
    @Override
    public void messageReceived(Client source, com.jme3.network.Message m) {
       
        if(m instanceof TextMessage){
            
            TextMessage tm = (TextMessage) m;
            System.out.println("Server - " + tm.getMessage());
        }
        
    }
    
}
