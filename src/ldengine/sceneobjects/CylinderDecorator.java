/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.sceneobjects;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

/**
 *
 * @author Luca
 */
public class CylinderDecorator {
    
    protected Cylinder cylinder;
    protected PhongMaterial material;
    
    public CylinderDecorator(){
       
        
    }
    
    public void setCylinder(Cylinder cylinder){
        
        this.cylinder = cylinder;
        
    }
    
    
    public void applyTranslation(double x, double y, double z){
        
        cylinder.setTranslateX(x);
        cylinder.setTranslateY(y);
        cylinder.setTranslateZ(z);
        
    }
    
    public void applyScale(double radius, double height){
        
        cylinder.setRadius(radius);
        cylinder.setHeight(height);
        
    }
    
    public void applyColor(ColorType colorType){
        
        material = new PhongMaterial();
        
        switch(colorType){
            
            case BLACK:
            
                material.setDiffuseColor(Color.BLACK);
                material.setSpecularColor(Color.BLACK);
            
                break;
                
                
            case BLUE:
                
                material.setDiffuseColor(Color.BLUE);
                material.setSpecularColor(Color.BLUE);
            
                break;
                
                
            case GREEN:
                
                material.setDiffuseColor(Color.GREEN);
                material.setSpecularColor(Color.GREEN);
            
                break;
            
            
            case ORANGE:
                
                material.setDiffuseColor(Color.ORANGE);
                material.setSpecularColor(Color.ORANGE);
            
                break;
            
                
            case RED:
                
                material.setDiffuseColor(Color.RED);
                material.setSpecularColor(Color.RED);
            
                break;
                
                
            case YELLOW:
                
                
                material.setDiffuseColor(Color.YELLOW);
                material.setSpecularColor(Color.YELLOW);
            
                break;
            
        }
        
        cylinder.setMaterial(material);
        
    }
    
    public void applyId(String id){
        
        cylinder.setId(id);
        
    }
    
    
    
}
