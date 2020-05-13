/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.sceneobjects;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

/**
 *
 * @author Luca
 */
public class BoxDecorator extends Box {
   
    protected Box box;
    protected PhongMaterial material;
    
    public BoxDecorator(){
       
        
    }
    
    public void setBox(Box box){
        
        this.box = box;
        
    }
    
    
    public void applyTranslation(double x, double y, double z){
        
        box.setTranslateX(x);
        box.setTranslateY(y);
        box.setTranslateZ(z);
        
    }
    
    public void applyScale(double width, double height, double depth){
        
        
        box.setWidth(width);
        box.setHeight(height);
        box.setDepth(depth);
        
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
        
        box.setMaterial(material);
        
    }
    
    public void applyId(String id){
        
        box.setId(id);
        
    }
    
    
}
