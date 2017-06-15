/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.screens;

import com.bruynhuis.galago.screen.AbstractScreen;
import com.bruynhuis.galago.ui.Label;
import com.bruynhuis.galago.ui.field.TextField;
import com.bruynhuis.galago.ui.listener.TouchButtonAdapter;
import com.bruynhuis.galago.ui.panel.ButtonPanel;
import com.jme3.math.ColorRGBA;
import com.vertexforker.connection.ServerManager;
import com.vertexforker.util.Token;
import javax.swing.JOptionPane;

/**
 *
 * @author Imanshu
 */
public class HostScreen extends AbstractScreen{
        
    private Label heading;
    private TextField textBox;
    private Button hostButton;
    private Button backButton;
     private Label error;
    private Button exitButton;
    private ButtonPanel buttonPanel;

    @Override
    protected void init() {
        heading = new Label(hudPanel, "Vetex Forker \n Host Game", 50, window.getWidth(), 100);
        heading.centerTop(0, 10);
        
        textBox = new TextField(hudPanel, "noOfPlayers");
        textBox.centerAt(-100, 80);
        textBox.setMaxLength(15);
        
        error = new Label(hudPanel, "Number of users", 20, window.getWidth(), 100);
        error.centerTop(-100, 250);
        
         buttonPanel = new ButtonPanel(hudPanel, window.getWidth(), window.getHeight());
        hudPanel.add(buttonPanel);
        
        hostButton = new Button(buttonPanel, "hostButton", "Host");
        hostButton.centerAt(200, 80);
        hostButton.addTouchButtonListener(new TouchButtonAdapter() {

            @Override
            public void doTouchUp(float touchX, float touchY, float tpf, String uid) {
                if (isActive()) {
                    baseApplication.getSoundManager().playSound("button");
                    String userName = JOptionPane.showInputDialog("Player Name : ");
                    String playersStr = textBox.getText();
                    int noPlayers = 0;
                    boolean valid = true;
                    
                    try{
                       noPlayers = Integer.parseInt(playersStr);
                    }catch(Exception ex){
                        error.setText("Enter a number");
                        error.setTextColor(ColorRGBA.Red);
                        valid = false;
                    }
                    
                    if(valid){
                    
                        if(noPlayers != 2 && noPlayers !=3){
                            error.setText("Min 2 | Max 3");
                            error.setTextColor(ColorRGBA.Red);
                            valid = false;
                        }
                        
                        if(valid){
                            
                             ServerManager svrManager = new ServerManager();
                             Token token = svrManager.startServer();
                            
                             if(token.isSuccess()){
                                  error.setText("Server Started");
                                  error.setTextColor(ColorRGBA.White);
                                  textBox.setEnabled(false);
                                  hostButton.setEnabled(false);
                             }else{
                                 error.setText(token.getError());
                                 error.setTextColor(ColorRGBA.Red);
                             }
                             
                        }
                        
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
