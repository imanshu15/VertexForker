/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.manager;

import com.jme3.network.Network;
import com.jme3.network.Server;
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
         try {
            server = Network.createServer(ConnectionUtil.PORT);
            server.start();
            System.out.println("Server Started");
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Server Staring Error");
        }
        
    }
    
}
