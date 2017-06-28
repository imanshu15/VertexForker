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

    public enum Request{
        CONNECT,
        DISCONNECT
    }
    
    private String sessionKey;
    private Request requestType;
    private String playerName;
    private String ipAddress;
    private int score;
    private Card[] playerHand;
    private int playerPosition;
    private int definedNoOfPlayers;
    private boolean gameStarted;

    public Player() {
        playerName = "";
        score = 0;
        playerHand = new Card[2];
    }

    /**
     * @return the sessionKey
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * @param sessionKey the sessionKey to set
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
    
    /**
     * @return the requestType
     */
    public Request getRequestType() {
        return requestType;
    }

    /**
     * @param requestType the requestType to set
     */
    public void setRequestType(Request requestType) {
        this.requestType = requestType;
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

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
     * @return the playerPosition
     */
    public int getPlayerPosition() {
        return playerPosition;
    }

    /**
     * @param playerPosition the playerPosition to set
     */
    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    /**
     * @return the definedNoOfPlayers
     */
    public int getDefinedNoOfPlayers() {
        return definedNoOfPlayers;
    }

    /**
     * @param definedNoOfPlayers the definedNoOfPlayers to set
     */
    public void setDefinedNoOfPlayers(int definedNoOfPlayers) {
        this.definedNoOfPlayers = definedNoOfPlayers;
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
