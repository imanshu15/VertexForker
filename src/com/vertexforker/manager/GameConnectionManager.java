/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.manager;

import com.jme3.scene.Node;
import com.vertexforker.connection.ClientManager;
import com.vertexforker.connection.ConnectionUtil;
import com.vertexforker.connection.ServerManager;
import java.util.Scanner;
import jme3tools.savegame.SaveGame;

/**
 *
 * @author Imanshu
 */
public class GameConnectionManager {
    
    public void hostGame(){
        
        
        int noPlayers = 0;
        String playerName = "";
        Scanner scanner = new Scanner(System.in);
        GameConnectionManager gcm = new GameConnectionManager();
        try{
            System.out.println("\n Number of players : ");
            noPlayers = scanner.nextInt();
            System.out.println("\n Player Name : ");
            playerName = scanner.nextLine();
        }catch(Exception ex){
            System.err.println("Invalid Input");
            hostGame();
        }
        
        Node gameData = new Node("GameData");
        gameData.setUserData("noPlayers", noPlayers);
        SaveGame.saveGame("SaveGame/", "ForkerGameData", gameData);
        
        Node playerData = new Node("PalyerData");
        playerData.setUserData("playerName", playerName);
        SaveGame.saveGame("SaveGame/", "ForkerPlayerData", playerData);
        
        ServerManager svrManager = new ServerManager();
        svrManager.startServer();
    
    }
    
     public void joinGame(){
         
         Scanner scanner = new Scanner(System.in);
         
         
         System.out.println("Enter Server IP Address : ");
         String ip = scanner.nextLine();
         if(ConnectionUtil.validate(ip)){
            ClientManager cManager = new ClientManager(ip);
            cManager.startClient();
         }else{
             System.err.println("Invalid Ip Address");
         }    
    
    }
    
    
}
