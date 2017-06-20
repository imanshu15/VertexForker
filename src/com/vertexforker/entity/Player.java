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
     * @return the bet
     */
    public int getBet() {
        return bet;
    }

    /**
     * @param bet the bet to set
     */
    public void setBet(int bet) {
        this.bet = bet;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

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

    
    private int id;
    private String playerName;
    private int bet;
    private int score;
    private Card[] playerHand;
    private Card[] sortedPlayerHand;
    
    public Player(){
        playerName = "";
        bet = 0;
        score = 0;
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
