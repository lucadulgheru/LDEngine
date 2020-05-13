/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.sceneobjects;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Shape3D;

/**
 *
 * @author Luca
 */
public class ShapePool {
    
    public ObservableList<Shape3D> pool = FXCollections.observableArrayList();
    
    private static ShapePool instance = null;
     
    private void ShapePool(){
        
        
        
    }
    
    public static ShapePool getInstance(){
        
        if(instance == null){
            
            instance = new ShapePool();
            
        }
        
        return instance;
        
    }

    
}
