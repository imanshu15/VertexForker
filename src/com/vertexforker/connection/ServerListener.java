/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jme3.network.Filters;
import com.jme3.network.HostedConnection;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;
import com.jme3.network.Server;
import com.vertexforker.entity.Player;
import com.vertexforker.manager.ServerDataManager;
import com.vertexforker.screens.GameFrame;

/**
 *
 * @author Imanshu
 */
public class ServerListener implements MessageListener<HostedConnection>{

    private Server server;
    private GameFrame gameFrame;
    private ServerDataManager svrData;
   
    
    public ServerListener(Server server,GameFrame gameFrame,Player player){
        this.server =server;
        this.gameFrame = gameFrame;
        svrData = new ServerDataManager();
        svrData.addPlayer(player);
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
            Gson gson=new GsonBuilder().create();
            Player player =gson.fromJson( pm.getPlayer(),Player.class);
            svrData.addPlayer(player);
            server.broadcast(new PlayerMessage(gson.toJson(svrData.getPlayers())));
            gameFrame.setUpGameScreen(player);
            System.out.println(player.getPlayerName() + " Connected");
            
        }
        
    }
    
    
    
}
