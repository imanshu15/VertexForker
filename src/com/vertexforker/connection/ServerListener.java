/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.jme3.network.Filters;
import com.jme3.network.HostedConnection;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;
import com.jme3.network.Server;

/**
 *
 * @author Imanshu
 */
public class ServerListener implements MessageListener<HostedConnection>{

    private Server server;
    
    public ServerListener(Server server){
        this.server =server;
    }
    
    @Override
    public void messageReceived(HostedConnection source, Message m) {
        
        if(m instanceof TextMessage){
           TextMessage tm = (TextMessage) m;
           server.broadcast(Filters.notEqualTo(source),new TextMessage(tm.getMessage()));
        }
        
    }
    
    
    
}
