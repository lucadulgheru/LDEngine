/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import ldengine.sceneobjects.BoxDecorator;
import ldengine.sceneobjects.ColorType;
import ldengine.sceneobjects.CylinderDecorator;
import ldengine.sceneobjects.FocusedObject;
import ldengine.sceneobjects.SphereDecorator;

/**
 *
 * @author Luca
 */
public class TunerController {
    @FXML
    private Accordion tunerTab;
    @FXML
    private TitledPane boxPane;
    @FXML
    private JFXTextField boxPosX;
    @FXML
    private JFXTextField boxPosZ;
    @FXML
    private JFXTextField boxPosY;
    @FXML
    private JFXTextField boxRotX;
    @FXML
    private JFXTextField boxRotZ;
    @FXML
    private JFXTextField boxRotY;
    @FXML
    private JFXTextField boxScaleX;
    @FXML
    private JFXTextField boxScaleZ;
    @FXML
    private JFXTextField boxScaleY;
    @FXML
    private JFXTextField boxId;
    @FXML
    private ImageView boxColorBlack;
    @FXML
    private ImageView boxColorBlue;
    @FXML
    private ImageView boxColorGreen;
    @FXML
    private ImageView boxColorOrange;
    @FXML
    private ImageView boxColorRed;
    @FXML
    private ImageView boxColorYellow;
    @FXML
    private JFXButton boxEdit;
    @FXML
    private TitledPane spherePane;
    @FXML
    private JFXTextField spherePosX;
    @FXML
    private JFXTextField spherePosZ;
    @FXML
    private JFXTextField spherePosY;
    @FXML
    private JFXTextField sphereRotX;
    @FXML
    private JFXTextField sphereRotZ;
    @FXML
    private JFXTextField sphereRotY;
    @FXML
    private JFXTextField sphereRadius;
    @FXML
    private JFXTextField sphereId;
    @FXML
    private ImageView sphereColorBlack;
    @FXML
    private ImageView sphereColorBlue;
    @FXML
    private ImageView sphereColorGreen;
    @FXML
    private ImageView sphereColorOrange;
    @FXML
    private ImageView sphereColorRed;
    @FXML
    private ImageView sphereColorYellow;
    @FXML
    private JFXButton sphereEdit;
    @FXML
    private TitledPane cylPane;
    @FXML
    private JFXTextField cylPosX;
    @FXML
    private JFXTextField cylPosZ;
    @FXML
    private JFXTextField cylPosY;
    @FXML
    private JFXTextField cylRotX;
    @FXML
    private JFXTextField cylRotZ;
    @FXML
    private JFXTextField cylRotY;
    @FXML
    private JFXTextField cylRadius;
    @FXML
    private JFXTextField cylId;
    @FXML
    private ImageView cylColorBlack;
    @FXML
    private ImageView cylColorBlue;
    @FXML
    private ImageView cylColorGreen;
    @FXML
    private ImageView cylColorOrange;
    @FXML
    private ImageView cylColorRed;
    @FXML
    private ImageView cylColorYellow;
    @FXML
    private JFXButton cylEdit;
    @FXML
    private JFXTextField cylHeight;
    @FXML
    private TitledPane customPane;
    
    @FXML
    private JFXToggleButton boxTogglePos;
    
    @FXML
    private JFXToggleButton boxToggleRot;
    
    @FXML
    private JFXToggleButton boxToggleScale;
    
    
    private ApplicationController applicationController;
    
    private final FocusedObject focusedObject = FocusedObject.getInstance();
    
    private final BoxDecorator boxDecorator = new BoxDecorator(); 
    private final SphereDecorator sphereDecorator = new SphereDecorator();
    private final CylinderDecorator cylinderDecorator = new CylinderDecorator();

    private ColorType color;

    @FXML
    private void editBox(ActionEvent event) {
        
      //double px, py, pz;
      //double rx, ry, rz;
      //double w, h, d;
     
        
      boxDecorator.setBox((Box)focusedObject.shape);
          
      boxDecorator.applyTranslation(Double.valueOf(boxPosX.getText()), Double.valueOf(boxPosY.getText()), Double.valueOf(boxPosZ.getText()));
      
      boxDecorator.applyScale(Double.valueOf(boxScaleX.getText()), Double.valueOf(boxScaleY.getText()), Double.valueOf(boxScaleZ.getText()));
      
      boxDecorator.applyColor(color);
      
      boxDecorator.applyId(boxId.getText());
 
        
    }

    @FXML
    private void editSphere(ActionEvent event) {
        
      sphereDecorator.setSphere((Sphere)focusedObject.shape);
          
      sphereDecorator.applyTranslation(Double.valueOf(spherePosX.getText()), Double.valueOf(spherePosY.getText()), Double.valueOf(spherePosZ.getText()));
      
      sphereDecorator.applyScale(Double.valueOf(sphereRadius.getText()));
      
      sphereDecorator.applyColor(color);
      
      sphereDecorator.applyId(sphereId.getText());
        
        
    }

    @FXML
    private void editCylinder(ActionEvent event) {
        
        
      cylinderDecorator.setCylinder((Cylinder)focusedObject.shape);
          
      cylinderDecorator.applyTranslation(Double.valueOf(cylPosX.getText()), Double.valueOf(cylPosY.getText()), Double.valueOf(cylPosZ.getText()));
      
      cylinderDecorator.applyScale(Double.valueOf(cylRadius.getText()), Double.valueOf(cylHeight.getText()));
      
      cylinderDecorator.applyColor(color);
        
      cylinderDecorator.applyId(cylId.getText());
        
    }
    
    
    
    @FXML
    private void toggleColor(MouseEvent event){
        
      
        if(boxColorBlack.isPressed() || cylColorBlack.isPressed() || sphereColorBlack.isPressed()){
          
          color = ColorType.BLACK;

      }
      
      else if (boxColorBlue.isPressed() || cylColorBlue.isPressed() || sphereColorBlue.isPressed()){
          
          color = ColorType.BLUE;

          
      }
      
      else if(boxColorGreen.isPressed() || cylColorGreen.isPressed() || sphereColorGreen.isPressed()){
          
          color = ColorType.GREEN;

          
      }
      
      else if (boxColorOrange.isPressed() || cylColorOrange.isPressed() || sphereColorOrange.isPressed()){
          
          color = ColorType.ORANGE;

          
      }
        
      else if(boxColorRed.isPressed() || cylColorRed.isPressed() || sphereColorRed.isPressed()){
          
          color = ColorType.RED;
  
          
      }
      
      else if (boxColorYellow.isPressed() || cylColorYellow.isPressed() || sphereColorYellow.isPressed()){
          
          color = ColorType.YELLOW;
        
      }
              
            
        
    
        
        
        
    }
    
    
    public void enableBoxTuner(){
        
     
        boxPane.setDisable(false);
        boxPane.setExpanded(true);
        cylPane.setDisable(true);
        spherePane.setDisable(true);
        customPane.setDisable(true);
        
    }
    
    public void enableSphereTuner(){
        
        spherePane.setDisable(false);
        spherePane.setExpanded(true);
        cylPane.setDisable(true);
        boxPane.setDisable(true);
        customPane.setDisable(true);
        
    }
    
    
    public void enableCylinderTuner(){
        
        cylPane.setDisable(false);
        cylPane.setExpanded(true);
        boxPane.setDisable(true);
        spherePane.setDisable(true);
        customPane.setDisable(true);
        
    }
    
    
    
   
    
    
       public void injectApplicationController(ApplicationController applicationController){
        
        this.applicationController = applicationController;
            
        
    }
       
       
       public void initialize(){
           
           
           
           
           
       }
   

}
