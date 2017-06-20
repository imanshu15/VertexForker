/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.jme3.network.AbstractMessage;
import com.vertexforker.entity.Player;

/**
 *
 * @author Imanshu
 */
public class PlayerMessage extends AbstractMessage{
    
    private Player player;
    
    public PlayerMessage(){}
    
    public PlayerMessage(Player player){ this.player = player; }
    
    public Player getPlayer(){ return player; }
    
}
