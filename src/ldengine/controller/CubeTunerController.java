/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.PhongMaterial;
import ldengine.sceneobjects.FocusedObject;
import ldengine.sceneobjects.ShapePool;
import ldengine.sceneobjects.ColorType;

/**
 *
 * @author Luca
 */
public class CubeTunerController implements Initializable {

    @FXML
    JFXTextField txtPosX, txtPosY, txtPosZ;
    
    @FXML
    JFXTextField txtRotX, txtRotY, txtRotZ;
    
    @FXML
    JFXTextField txtScaleX, txtScaleY, txtScaleZ;
    
    @FXML
    JFXTextField txtShapeId;
    
    PhongMaterial material = new PhongMaterial();
    
    ShapePool shapePool = ShapePool.getInstance();
    
    FocusedObject focusedObject = FocusedObject.getInstance();
    
    ColorType color;
    

    
    
    
    @FXML
    public void insertCube(){
           
       
        
        
    }
    
    
    @FXML
    public void resetDefault(){
        
        
        
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        
    }
    
}
