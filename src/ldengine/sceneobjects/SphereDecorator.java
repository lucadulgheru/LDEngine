/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.sceneobjects;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

/**
 *
 * @author Luca
 */
public class SphereDecorator {
    
    
    protected Sphere sphere;
    protected PhongMaterial material;
    
    public SphereDecorator(){
       
        
    }
    
    public void setSphere(Sphere sphere){
        
        this.sphere = sphere;
        
    }
    
    
    public void applyTranslation(double x, double y, double z){
        
        sphere.setTranslateX(x);
        sphere.setTranslateY(y);
        sphere.setTranslateZ(z);
        
    }
    
    public void applyScale(double radius){
        
        sphere.setRadius(radius);
        
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
        
        sphere.setMaterial(material);
        
    }
    
    public void applyId(String id){
        
        sphere.setId(id);
        
    }
    
    
}
