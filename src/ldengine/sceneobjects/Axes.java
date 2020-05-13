/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.sceneobjects;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

/**
 *
 * @author Luca
 */
public class Axes {
    
     final PhongMaterial xMaterial = new PhongMaterial();  
     final PhongMaterial yMaterial = new PhongMaterial();    
     final PhongMaterial zMaterial = new PhongMaterial();
     
         // actual model for each axis
     
     final Box xAxis = new Box(1500.0, 0.5, 0.5);
     final Box yAxis = new Box(0.5, 1500.0, 0.5);
     final Box zAxis = new Box(0.5, 0.5, 1500.0);
     
     Group axisGroup = new Group();
     
     
     public Axes(){
         
        axisGroup.setId("XYZ axes");
         
        xMaterial.setDiffuseColor(Color.DARKRED);
        xMaterial.setSpecularColor(Color.RED);

        yMaterial.setDiffuseColor(Color.DARKGREEN);
        yMaterial.setSpecularColor(Color.GREEN);
       
        zMaterial.setDiffuseColor(Color.DARKBLUE);
        zMaterial.setSpecularColor(Color.BLUE);
        
        xAxis.setMaterial(xMaterial);
        yAxis.setMaterial(yMaterial);
        zAxis.setMaterial(zMaterial);
        

        axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
         
         
     }
     
   
      
     public Group generateAxes(){
         
         
         return axisGroup;
         
     }
     

    
}
