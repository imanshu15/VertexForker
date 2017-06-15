/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.entity;

import java.util.ArrayList;
import java.util.Random;



/**
 *
 * @author Imanshu
 */
public class CardsDeck extends Card{
        
    static final int NO_CARDS =  52; // Number of cards 
    protected ArrayList<Card> deck; //Array of playing cards
    
    public CardsDeck(){
        deck = new ArrayList<Card>();
    }
    
    public ArrayList<Card> getDeck(){ //Get the current card deck
        return this.deck;
    }
    
    public void setUpCardDeck(){
        
        int i = 0;
        
        for(SUIT suit : SUIT.values()){
            
            for(VALUE value : VALUE.values()){
                deck.add(i,new Card(suit,value));
                i++;
            }
            
        } 
        shuffleCards();
        
    }
    
    public void shuffleCards(){
        
        Random rand = new Random();
        Card temp;
        
       for (int i = 0;i<100;i++){
            
            for(int j=0;j<NO_CARDS;j++){
                
                int k = rand.nextInt(52);
                temp = deck.get(j);
                deck.set(j, deck.get(k));
                deck.set(k, temp);
                
            }
          
      } 
    }
    
    public void showDeck(){
        System.err.println("-------- Deck -------");
        for(int i = 0;i<deck.size();i++){
            Card card = deck.get(i);
            System.out.println(card.getCardValue() + " OF " +card.getCardSuit()); 
        }
    }
    
}
