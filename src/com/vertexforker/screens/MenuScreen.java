/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.screens;

import com.bruynhuis.galago.screen.AbstractScreen;
import com.bruynhuis.galago.ui.Label;
import com.bruynhuis.galago.ui.listener.TouchButtonAdapter;
import com.bruynhuis.galago.ui.panel.ButtonPanel;
import com.jme3.scene.Spatial;

/**
 *
 * @author Imanshu
 */
public class MenuScreen extends AbstractScreen{
    
        
    private Label heading;
    private Button hostButton;
    private Button joinButton;
    private Button aboutButton;
    private Button exitButton;
    private ButtonPanel buttonPanel;

    @Override
    protected void init() {
        heading = new Label(hudPanel, "Vetex Forker", 50, window.getWidth(), 100);
        heading.centerTop(0, 10);
        
        buttonPanel = new ButtonPanel(hudPanel, window.getWidth(), window.getHeight());
        hudPanel.add(buttonPanel);
        
        hostButton = new Button(buttonPanel, "hostButton", "Host Game");
        hostButton.centerAt(0, 80);
        hostButton.addTouchButtonListener(new TouchButtonAdapter() {

            @Override
            public void doTouchUp(float touchX, float touchY, float tpf, String uid) {
                if (isActive()) {
                    baseApplication.getSoundManager().playSound("button");
                    showScreen("host");
                }
            }
            
        });        
        
        joinButton = new Button(buttonPanel, "joinButton", "Join Game");
        joinButton.centerAt(0, 0);
        joinButton.addTouchButtonListener(new TouchButtonAdapter() {

            @Override
            public void doTouchUp(float touchX, float touchY, float tpf, String uid) {
                if (isActive()) {
                    baseApplication.getSoundManager().playSound("button");
                    showScreen("join");
                }
            }
            
        });
        
        aboutButton = new Button(buttonPanel, "aboutButton", "About");
        aboutButton.centerAt(0, -80);
        aboutButton.addTouchButtonListener(new TouchButtonAdapter() {

            @Override
            public void doTouchUp(float touchX, float touchY, float tpf, String uid) {
                if (isActive()) {
                    baseApplication.getSoundManager().playSound("button");
                    showScreen("about");
                }
            }
                        
        });
        
        exitButton = new Button(buttonPanel, "exitButton", "Exit");
        exitButton.centerAt(0, -160);
        exitButton.addTouchButtonListener(new TouchButtonAdapter() {

            @Override
            public void doTouchUp(float touchX, float touchY, float tpf, String uid) {
                if (isActive()) {
                    baseApplication.getSoundManager().playSound("button");
                    exitScreen();
                }
            }
                        
        });
    }

    @Override
    protected void load() {
        
    }

    @Override
    protected void show() {
        setPreviousScreen(null);
        buttonPanel.show();
    }

    @Override
    protected void exit() {
        rootNode.detachAllChildren();
    }

    @Override
    protected void pause() {
    }
    
}
