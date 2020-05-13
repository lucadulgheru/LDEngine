/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.sceneobjects;

import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.shape.Shape3D;

/**
 *
 * @author Luca
 */
public class ShapeDecorator extends Shape3D{

    protected Shape3D shape;
    
    public ShapeDecorator(Shape3D shape){
        
        this.shape = shape;
        
    }
    
    
      public void applyTranslation(double x, double y, double z){
        
        shape.setTranslateX(x);
        shape.setTranslateY(y);
        shape.setTranslateZ(z);
        
    }
    
    
    @Override
    protected NGNode impl_createPeer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
