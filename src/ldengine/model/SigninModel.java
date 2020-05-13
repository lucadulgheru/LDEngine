/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.model;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ldengine.utils.SceneHandler;
/**
 *
 * @author Luca
 */
public class SigninModel extends SceneHandler {
 
   


    public void signIn(Node currentContainer) throws IOException{
        
        Stage currentStage = (Stage)currentContainer.getScene().getWindow();
       
        currentStage.close();
         
         
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ldengine/view/ApplicationView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
     
        Scene scene = new Scene(root1);
        
        Stage stage = new Stage();
      
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("LDEngine");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        
    }
   
    
    
}
