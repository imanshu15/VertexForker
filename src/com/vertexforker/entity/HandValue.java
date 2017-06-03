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
public class HandValue {

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the highCard
     */
    public int getHighCard() {
        return highCard;
    }

    /**
     * @param highCard the highCard to set
     */
    public void setHighCard(int highCard) {
        this.highCard = highCard;
    }
    
    private int total;
    private int highCard;
}
