/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.sceneobjects;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.LightBase;

/**
 *
 * @author Luca
 */
public class LightPool {
    
    public ObservableList<LightBase> pool = FXCollections.observableArrayList();
    
    private static LightPool instance = null;
     
    private void LightPool(){
        
        
        
    }
    
    public static LightPool getInstance(){
        
        if(instance == null){
            
            instance = new LightPool();
            
        }
        
        return instance;
        
    }

    
}
