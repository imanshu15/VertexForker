/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.meta;

import com.jme3.network.AbstractMessage;
import com.jme3.network.serializing.Serializable;
import com.vertexforker.entity.Player;

/**
 *
 * @author Imanshu
 */
@Serializable
public class PlayerMessage extends AbstractMessage{
    
    private String playerdata;
    
    public PlayerMessage(){}
    
    public PlayerMessage(String playerdata){ this.playerdata = playerdata; }
    
    public String getPlayer(){ return playerdata; }
    
}
