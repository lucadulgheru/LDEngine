/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import ldengine.data.DBConnection;
import ldengine.model.SigninModel;

/**
 *
 * @author Luca
 */
public class SigninController implements Initializable {
    

    @FXML
    private AnchorPane signinContainer;
 
    @FXML
    private JFXTextField textUsernameSignin;
    
    @FXML
    private JFXPasswordField textPasswordSignin;
    
    private DBConnection conn;
    
    public boolean signStatus = false;
    
    private SigninModel sm = new SigninModel();
    
    
    @FXML
    
    public void switchToSignup() throws IOException{
           
        sm.swapScene("/ldengine/view/SignupView.fxml", signinContainer, signinContainer);
        
    }
    
    
    
    @FXML 
    public void switchToReset() throws IOException{
        
       sm.swapScene("/ldengine/view/ResetView.fxml", signinContainer, signinContainer);
        
    }
    
    
    @FXML
    public void signIn() throws IOException, SQLException{
        
      
        
        if(conn.validateUser(textUsernameSignin.getText(), textPasswordSignin.getText())){
            
            signStatus = true;

            sm.signIn(signinContainer);
     
        }
        
        else {
            
          sm.showAlert("Wrong credentials", "WARNING");
            
            
        }
        
    }
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        try {
            conn = DBConnection.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
