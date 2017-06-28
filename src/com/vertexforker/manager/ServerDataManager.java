/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.manager;

import com.jme3.scene.Node;
import jme3tools.savegame.SaveGame;

/**
 *
 * @author Imanshu
 */
public class ServerDataManager {

    private Node gameData;
    private int noOfPlayersDefined;
    private boolean gameStarted;

    public ServerDataManager() {
        gameData = (Node) SaveGame.loadGame("SaveGame/", "ForkerGameData");
        noOfPlayersDefined = gameData.getUserData("noPlayers");
    }

    /**
     * @return the noOfPlayersDefined
     */
    public int getNoOfPlayersDefined() {
        return noOfPlayersDefined;
    }

    /**
     * @return the gameStarted
     */
    public boolean isGameStarted() {
        return gameStarted;
    }

    /**
     * @param gameStarted the gameStarted to set
     */
    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

}
