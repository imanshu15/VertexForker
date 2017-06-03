/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.util;

import com.vertexforker.entity.Card;
import com.vertexforker.entity.HandValue;

/**
 *
 * @author Imanshu
 */

public class HandEvaluator extends Card{

    /**
     * @return the cards
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * @param cards the cards to set
     */
    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    /**
     * @return the handValue
     */
    public HandValue getHandValue() {
        return handValue;
    }

    /**
     * @param handValue the handValue to set
     */
    public void setHandValue(HandValue handValue) {
        this.handValue = handValue;
    }
    
    public enum Hand{
        NOTHING,
        ONEPAIR,
        TWOPAIR,
        THREEKIND,
        STRAIGHT,
        FLUSH,
        FULLHOUSE,
        FOURKIND
    }
    
    
    private int heartSum,diamondSum,clubSum,spadesSum;
    private Card[] cards;
    private HandValue handValue;
    
    public HandEvaluator(Card[] sortedHand){
        
        heartSum = 0;
        diamondSum = 0;
        clubSum = 0;
        spadesSum = 0;
        cards = new Card[5];
        handValue = new HandValue();
    }
    
    //public Hand EvaluateHand(){
       // getNumberOfSuit();    
   // }
    

    
}
