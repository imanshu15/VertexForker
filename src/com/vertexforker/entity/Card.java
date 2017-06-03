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
public class Card {
    
    public enum SUIT{
        HEARTS,
        SPADES,
        DIAMONDS,
        CLUBS
    }

    public enum VALUE{
        TWO,THREE,FOUR,FIVE,SIX,
        SEVEN,EIGHT,NINE,TEN,
        JACK,QUEEN,KING,ACE
    }
    
    private SUIT cardSuit;
    private VALUE cardValue;
    
    public Card(){}
    
    public Card(SUIT suit, VALUE value){
        cardSuit = suit;
        cardValue = value;
    }
    
    public SUIT getCardSuit(){
        return this.cardSuit;
    }
    
    public VALUE getCardValue(){
        return this.cardValue;
    }
}
