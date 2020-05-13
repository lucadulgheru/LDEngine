/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.sceneobjects;


import javafx.scene.shape.Shape3D;

/**
 *
 * @author Luca
 */
public class FocusedObject {
    
    public Shape3D shape;
    
    private static FocusedObject instance = null;
    
    private void FocusedObject(){}
    
    public static FocusedObject getInstance(){
        
        if(instance == null){
            
            instance = new FocusedObject();
            
        }
        
        return instance;
        
    }
    
    
}
