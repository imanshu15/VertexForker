/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.screens;

import com.bruynhuis.galago.screen.AbstractScreen;
import com.bruynhuis.galago.ui.field.TextField;
import com.bruynhuis.galago.ui.Label;
import com.bruynhuis.galago.ui.listener.TouchButtonAdapter;
import com.bruynhuis.galago.ui.panel.ButtonPanel;
import com.jme3.math.ColorRGBA;
import com.vertexforker.connection.ClientManager;
import com.vertexforker.connection.ConnectionUtil;
import com.vertexforker.game.Main;
import javax.swing.JOptionPane;

/**
 *
 * @author Imanshu
 */
public class JoinScreen extends AbstractScreen{
    private Main mainApplication;
    private TextField textBox;
    private Label heading;
    private Label error;
    private Button joinButton;
    private Button backButton;
    private Button exitButton;
    private ButtonPanel buttonPanel;

    @Override
    protected void init() {
        
        mainApplication = (Main)baseApplication;
        
        heading = new Label(hudPanel, "Vetex Forker \n Join Game", 50, window.getWidth(), 200);
        heading.centerTop(0, 10);
        
        textBox = new TextField(hudPanel, "ipAddress");
        textBox.centerAt(-100, 80);
        textBox.setMaxLength(15);
        
        error = new Label(hudPanel, "Server IP Address", 20, window.getWidth(), 100);
        error.centerTop(-100, 250);
        
        buttonPanel = new ButtonPanel(hudPanel, window.getWidth(), window.getHeight());
        hudPanel.add(buttonPanel);
        
        joinButton = new Button(buttonPanel, "joinButton", "Join");
        joinButton.centerAt(200, 80);
        joinButton.addTouchButtonListener(new TouchButtonAdapter() {

            @Override
            
            public void doTouchUp(float touchX, float touchY, float tpf, String uid) {
                if (isActive()) {
                    baseApplication.getSoundManager().playSound("button");
                    
                    String clientIp = textBox.getText();
                    
                    if(!ConnectionUtil.validate(clientIp)){
                         error.setText("Invalid IP Address");
                         error.setTextColor(ColorRGBA.Red);
                    }else{
                       String userName = JOptionPane.showInputDialog("Player Name : ");
                       error.setText("Connecting..");
                       ClientManager cManager = new ClientManager(clientIp);
                       cManager.startClient();
                    }
                }
            }
            
        });        
         
        backButton = new Button(buttonPanel, "backButton", "Back ");
        backButton.centerAt(0, -80);
        backButton.addTouchButtonListener(new TouchButtonAdapter() {

            @Override
            public void doTouchUp(float touchX, float touchY, float tpf, String uid) {
                if (isActive()) {
                    baseApplication.getSoundManager().playSound("button");
                    showScreen("menu");
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
