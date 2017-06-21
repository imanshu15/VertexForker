/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jme3.network.Client;
import com.jme3.network.MessageListener;
import com.vertexforker.entity.Player;
import com.vertexforker.manager.ServerDataManager;
import com.vertexforker.screens.GameFrame;
import java.util.ArrayList;

/**
 *
 * @author Imanshu
 */
public class ClientListener implements MessageListener<Client>{
 
    private Client client;
    private ServerDataManager svrData;
    private GameFrame gameFrame;
    
    public ClientListener(Client client,GameFrame gameFrame){
        this.client = client;
        svrData = new ServerDataManager();
        this.gameFrame = gameFrame;
    }
   
    @Override
    public void messageReceived(Client source, com.jme3.network.Message m) {
       
        if(m instanceof TextMessage){
            
            TextMessage tm = (TextMessage) m;
            System.out.println("Server - " + tm.getMessage());
        }
        if(m instanceof PlayerMessage){
            
            PlayerMessage pm = (PlayerMessage) m;
            Gson gson=new GsonBuilder().create();
            TypeToken<ArrayList<Player>> token = new TypeToken<ArrayList<Player>>(){};
            ArrayList<Player> players = gson.fromJson( pm.getPlayer(), token.getType());
            for(Player p : players) {
                svrData.addPlayer(p);
                gameFrame.setUpGameScreen(p);
            }
            
            //gameFrame.setUpGameScreen(player);
            
        }
        
        
    }
    
}
