/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import ldengine.model.MainModel;

/**
 *
 * @author Luca
 */
public class MainController implements Initializable{

    @FXML
    private AnchorPane parentContainer;
    
    @FXML
    private AnchorPane templateContainer;
    
    @FXML
    private ImageView imgView;

    private MainModel mainModel = new MainModel();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

        
        try {
    
          Parent root = FXMLLoader.load(getClass().getResource("/ldengine/view/SigninView.fxml"));
            
          parentContainer.getChildren().remove(templateContainer);
          
          parentContainer.getChildren().add(root);
           
            
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
     
    }
    
    
    
    @FXML
    private void nextImage() throws FileNotFoundException, IOException{
        
  
        mainModel.nextImage(imgView);
        
    }
    
    @FXML
    private void previousImage() throws FileNotFoundException, IOException{
        
  
        mainModel.previousImage(imgView);
        
    }
    
    
}
