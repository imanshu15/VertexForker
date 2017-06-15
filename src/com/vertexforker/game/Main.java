package com.vertexforker.game;

import com.bruynhuis.galago.app.Base2DApplication;
import com.bruynhuis.galago.resource.EffectManager;
import com.bruynhuis.galago.resource.ModelManager;
import com.bruynhuis.galago.resource.ScreenManager;
import com.bruynhuis.galago.resource.SoundManager;
import com.bruynhuis.galago.resource.TextureManager;
import com.jme3.scene.Node;
import com.vertexforker.manager.GameConnectionManager;
import com.vertexforker.screens.HostScreen;
import com.vertexforker.screens.JoinScreen;
import com.vertexforker.screens.MenuScreen;
import com.vertexforker.util.DealCards;
import java.util.Scanner;
import jme3tools.savegame.SaveGame;


/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends Base2DApplication {

    public Main() {
        super("Vertex Forker", 800, 640, "vertexForker.save", "Interface/Fonts/KenVectorFuture.fnt", null, false);
    }
      
    public static void main(String[] args) {
       //new Main(); GUI GAME
       
       /* CONSOLE GAME
        System.out.println("Vertex Forker");
        
        System.out.println("Host - 1");
        System.out.println("Join - 2");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        GameConnectionManager gcm = new GameConnectionManager();
        switch(x){
            case 1 : gcm.hostGame();break;
            case 2 : gcm.joinGame();break;
            default : System.out.println("Invalid Input");break;
        } 
        
        */
      
        
        //dc.showHand();
        
        Node gameData = new Node("GameData");
        gameData.setUserData("noPlayers", 8);
        SaveGame.saveGame("SaveGame/", "ForkerGameData", gameData);
        DealCards dc = new DealCards();
        //dc.Deal();
    }
    
       @Override
    protected void preInitApp() {
    }

    @Override
    protected void postInitApp() {
        showScreen("menu");
    }

    @Override
    protected boolean isPhysicsEnabled() {
        return true;
    }
    
       @Override
    protected void initScreens(ScreenManager sm) {
        sm.loadScreen("menu", new MenuScreen());
        sm.loadScreen("host", new HostScreen());
        sm.loadScreen("join", new JoinScreen());
    }

    @Override
    public void initModelManager(ModelManager mm) {
        
    }
    
     @Override
    protected void initSound(SoundManager sm) {
        sm.loadSoundFx("button", "Sounds/sfx_twoTone.ogg");
        sm.setSoundVolume("button", 0.2f);
    }

    @Override
    protected void initEffect(EffectManager em) {
        
    }

    @Override
    protected void initTextures(TextureManager tm) {
        
    }
    
    public static void startGame(){
        
        System.out.println("\nHOST - 1 \nJOIN - 2 \nENTER - ");
        int a = 0;
        Scanner scanner = new Scanner(System.in);
        GameConnectionManager gcm = new GameConnectionManager();
        try{
            a = scanner.nextInt();
        }catch(Exception ex){
            System.err.println("Invalid Input");
        }
        
        switch(a){
        
            case 1 : gcm.hostGame(); break;
            case 2 : gcm.joinGame(); break;
            default : startGame(); break;
        }
    }
    

}
