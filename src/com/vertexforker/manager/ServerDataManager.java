/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.manager;

import com.vertexforker.entity.Player;
import java.util.HashMap;

/**
 *
 * @author Imanshu
 */
public class ServerDataManager {
    
    private HashMap<Integer,Player> entities = new HashMap<Integer,Player>();
    
    public ServerDataManager(){
    
    }
    
    public void addOrRefreshUser(int id,Player player){
        entities.put(id, player);
    }
    
    public boolean isTherePlayerWithId(int id){
        return entities.containsKey(id);
    }
    
}
