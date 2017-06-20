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
import com.vertexforker.entity.Player;
import com.vertexforker.manager.ServerDataManager;

/**
 *
 * @author Imanshu
 */
public class ServerListener implements MessageListener<HostedConnection>{

    private Server server;
    private ServerDataManager dataManager;
    
    public ServerListener(Server server,ServerDataManager dataManager){
        this.server =server;
        this.dataManager = dataManager;
    }
    
    @Override
    public void messageReceived(HostedConnection source, Message m) {
        
        if(m instanceof TextMessage){
           TextMessage tm = (TextMessage) m;
            System.out.println(tm.getMessage());
           server.broadcast(Filters.notEqualTo(source),new TextMessage(tm.getMessage()));
        }else
        if(m instanceof PlayerMessage){
            PlayerMessage pm = (PlayerMessage) m;
            Player player = pm.getPlayer();
            server.broadcast(new PlayerMessage(player));
            System.out.println(player.getPlayerName() + " Connected");
        }
        
    }
    
    
    
}
