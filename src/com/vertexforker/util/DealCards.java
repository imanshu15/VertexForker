/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.util;

import com.vertexforker.entity.Card;
import com.vertexforker.entity.CardsDeck;

/**
 *
 * @author Imanshu
 */
public class DealCards extends CardsDeck{
    
    private Card[] playerHand;
    private Card[] sortedPlayerHand;

    
    public DealCards(){
        
        playerHand = new Card[5];
        sortedPlayerHand = new Card[5];     
    }
    
    public void Deal(){
        
       setUpCardDeck();
       getHand();
    }
    
    public void getHand(){
        
        Card[] deck = getDeck();
        for(int i = 0; i <5 ; i++)
            playerHand[i] = deck[i];
        
    }
    
 
    
}
