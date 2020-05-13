/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.view;

import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Luca
 */
public class CameraView {
    
    
    
    public void moveX(PerspectiveCamera camera, double currentXPosition, double value){
        
        camera.translateXProperty().set(currentXPosition + value);
        
    }
    
     public void moveY(PerspectiveCamera camera, double currentYPosition, double value){
        
        camera.translateYProperty().set(currentYPosition + value);
        
    }
     
      public void moveZ(PerspectiveCamera camera, double currentZPosition, double value){
        
        camera.translateZProperty().set(currentZPosition + value);
        
    }
      
      
       public void rotateX(PerspectiveCamera camera, double value){
        
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(value);
        
    }
       
        public void rotateY(PerspectiveCamera camera, double value){
        
        camera.setRotationAxis(Rotate.Y_AXIS);
        camera.setRotate(value);
        
    }
        
         public void rotateZ(PerspectiveCamera camera, double value){
        
        camera.setRotationAxis(Rotate.Z_AXIS);
        camera.setRotate(value);
        
    }
         
         public PerspectiveCamera generateCamera(PerspectiveCamera camera, double zValue){
             
             camera.setNearClip(1);
             camera.setFarClip(2000);
             
             return camera;
             
         }
    
}
