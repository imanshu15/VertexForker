/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.meta;

/**
 *
 * @author d.jayasinghe
 */
public class MessageToken {

    public enum Code {

        SERVER_STARTED,
        CLIENT_CONNECTED,
        TABLE_IS_FULL,
        GAME_STARTED,
        SERVER_DISCONNECTED
    }

    private Code code;
    private String message;

    public MessageToken() {

    }

    /**
     * @return the code
     */
    public Code getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Code code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
