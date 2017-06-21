/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.manager;

import com.jme3.scene.Node;
import com.vertexforker.entity.Player;
import java.util.ArrayList;
import jme3tools.savegame.SaveGame;

/**
 *
 * @author Imanshu
 */
public class ServerDataManager {
    
    private ArrayList players;
    private Node gameData;
    private int noOfPlayersDefined;
    private int noOfPlayersConnected;
    
    public ServerDataManager(){
        gameData = (Node) SaveGame.loadGame("SaveGame/", "ForkerGameData");
        noOfPlayersDefined = gameData.getUserData("noPlayers");
        players = new ArrayList<Player>();
        noOfPlayersConnected = 0;
    }
    
    public void addPlayer(Player player){
        
        players.add(player);
        noOfPlayersConnected ++;
        
    }
    
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    
}
