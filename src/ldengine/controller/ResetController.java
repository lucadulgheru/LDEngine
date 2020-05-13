/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import ldengine.model.ResetModel;

/**
 *
 * @author Luca
 */
public class ResetController implements Initializable {
    
    @FXML
    private AnchorPane resetContainer;

    private ResetModel rm = new ResetModel();
    
    @FXML
    private void switchToSignin(ActionEvent event) throws IOException{
        
        rm.swapScene("/ldengine/view/SigninView.fxml", resetContainer, resetContainer);
        
    }
    
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        
    }
    
}
