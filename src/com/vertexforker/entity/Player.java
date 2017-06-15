/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.entity;

/**
 *
 * @author Imanshu
 */
public class Player {

    /**
     * @return the playerHand
     */
    public Card[] getPlayerHand() {
        return playerHand;
    }

    /**
     * @param playerHand the playerHand to set
     */
    public void setPlayerHand(Card[] playerHand) {
        this.playerHand = playerHand;
    }

    /**
     * @return the sortedPlayerHand
     */
    public Card[] getSortedPlayerHand() {
        return sortedPlayerHand;
    }

    /**
     * @param sortedPlayerHand the sortedPlayerHand to set
     */
    public void setSortedPlayerHand(Card[] sortedPlayerHand) {
        this.sortedPlayerHand = sortedPlayerHand;
    }


    private String playerName;
    private Card[] playerHand;
    private Card[] sortedPlayerHand;
    
    public Player(){
        playerHand = new Card[2];
        sortedPlayerHand = new Card[2]; 
    }
    
        /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        
    }
    
}
