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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import ldengine.data.DBConnection;
import ldengine.model.SignupModel;

/**
 *
 * @author Luca
 */
public class SignupController implements Initializable {
    
    
    private DBConnection conn;

    @FXML
    private AnchorPane signupContainer;
    
    @FXML
    private JFXTextField textUsernameSignup;
    
    @FXML
    private JFXPasswordField textPasswordSignup;
    
    @FXML
    private JFXTextField textEmailSignup;
   
    private SignupModel sm = new SignupModel();
    
    @FXML
    private void switchToSignin() throws IOException{
        
        sm.swapScene("/ldengine/view/SigninView.fxml", signupContainer, signupContainer);
        
        
    }
    
    @FXML
    private void registerUser() throws SQLException{
        

        if(conn.insertUser(textUsernameSignup.getText(), textPasswordSignup.getText(), textEmailSignup.getText()))
        
            sm.showAlert("Account registered successfully!", "INFORMATION");
            
         else 
            
            sm.showAlert("Account failed to register!", "WARNING");
        
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            conn = DBConnection.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
