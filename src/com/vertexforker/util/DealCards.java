/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.util;

import com.vertexforker.entity.Card;
import com.vertexforker.entity.CardsDeck;
import com.vertexforker.entity.Player;
import java.util.ArrayList;

/**
 *
 * @author Imanshu
 */
public class DealCards extends CardsDeck{
    
     private ArrayList<Player> players;
     private ArrayList<Card> commonCards;
    
    public DealCards(){
        /*
        Node gameData = (Node) SaveGame.loadGame("SaveGame/","ForkerGameData");
        int noPlayers = Integer.parseInt(gameData.getUserData("noPlayers").toString());
        
        if(noPlayers == 0 || noPlayers < 2 || noPlayers > 5){
            System.err.println("Error"); 
        }else{
            
            for()
            
        }
        */
        players = new ArrayList<Player>();
        commonCards = new ArrayList<Card>();
        Deal();
       
    }
    
    public void Deal(){
        
       setUpCardDeck();
       getHand();
       
       
    }
    
    public void getHand(){
              
      
        for(int noPlayers = 0;noPlayers<2;noPlayers++){
            
            Card[] cardTemp = new Card[2];
            
             for(int i = 0; i <2 ; i++){
                    cardTemp[i] = deck.get(i);
                    deck.remove(i);
             }
             
          Player player = new Player();
          player.setPlayerHand(cardTemp);
          players.add(player);
          
        }
      
       System.out.println("--- Computer Hand ---");
       showHand(players.get(0).getPlayerHand());
       
       System.out.println("--- Player Hand ---");
       showHand(players.get(1).getPlayerHand());
        
       roundTwo();
       roundThree();
       roundFour();
    }
    
    public void roundOne(){
        
        
    }
    
    public void roundTwo(){
        
        for(int i=0;i<3;i++){
            commonCards.add(deck.get(i));
            deck.remove(i);
        }
        
        System.out.println("--- Common Cards - Round Two ---");
        showHand(commonCards);
        
    }
    
    public void roundThree(){
        
         commonCards.add(deck.get(0));
         deck.remove(0);
        
        System.out.println("--- Common Cards - Round Three ---");
        showHand(commonCards);
    }
    
    public void roundFour(){
    
         commonCards.add(deck.get(0));
         deck.remove(0);
        
        System.out.println("--- Common Cards - Round Four ---");
        showHand(commonCards);
        
    }
    
    public void showHand(Card[] hand){
        
         for(int i = 0; i < hand.length ; i++){
             Card card = hand[i];
             System.out.println(card.getCardValue() + " OF " +card.getCardSuit());        
         }
    }
    
     public void  showHand(ArrayList<Card> hand){
        for(int i = 0;i<hand.size();i++){
            Card card = hand.get(i);
            System.out.println(card.getCardValue() + " OF " +card.getCardSuit()); 
        }
    }
 
    
}
