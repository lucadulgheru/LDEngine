/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.input.KeyEvent;
import ldengine.model.GameSceneModel;
import ldengine.view.GameSceneView;

/**
 *
 * @author Luca
 */
public class GameSceneController {
    
    private GameSceneModel gameSceneModel;
    private GameSceneView gameSceneView;
    
    
    public GameSceneController(GameSceneModel gameSceneModel, GameSceneView gameSceneView){
        
        this.gameSceneModel = gameSceneModel;
        this.gameSceneView = gameSceneView;
        
    }
    
   public Group getGroup() {
        return gameSceneModel.getGroup();
    }

    public void setGroup(Group group) {
        gameSceneModel.setGroup(group);
    }


    public double getWidth(){
        
        return gameSceneModel.getWidth();
        
    }
    
    
    public double getHeight(){
        
        return gameSceneModel.getHeight();
        
    }
    
     public PerspectiveCamera getCamera() {
        return gameSceneModel.getCamera();
    }

    public void setCamera(PerspectiveCamera camera) {
        gameSceneModel.setCamera(camera);
    }
    
    
    public SubScene generateGameScene(){
        
       return gameSceneView.generateGameScene(getGroup(), getWidth() , getHeight(), getCamera());
        
        
    }
    
    public void insertIntoScene(Node insertableObject){
        
        gameSceneModel.getGroup().getChildren().add(insertableObject);
        
    }

    
    public void removeFromScene(Node removableObject){
        
        gameSceneModel.getGroup().getChildren().remove(removableObject);
        
    }
  
    public void handleMouse(){
        
        
        
    }
    
}
