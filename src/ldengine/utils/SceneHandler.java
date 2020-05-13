/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.utils;

import java.io.IOException;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import ldengine.data.DBConnection;
/**
 *
 * @author Luca
 */
public abstract class SceneHandler{
    
    
    public void swapScene(String viewPath, Node sceneDetector, Node replacementNode) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource(viewPath));
        
        Scene scene = sceneDetector.getScene();
        
        root.translateYProperty().set(scene.getHeight());
        
        AnchorPane parentContainer = (AnchorPane) scene.getRoot();
        
        parentContainer.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.25), kv);
        
        timeline.getKeyFrames().add(kf);
        
        timeline.setOnFinished(event1 -> {
            
            parentContainer.getChildren().remove(replacementNode);
            
        });
        
        timeline.play();
        
        
    }
    
    
    public void showAlert(String alertInfo, String alertType){
        
         Alert.AlertType at = null;
   
              
            if(alertType.equals("WARNING"))
                
               at = Alert.AlertType.WARNING;
            
            
            else if (alertType.equals("INFORMATION"))
                
               at = Alert.AlertType.INFORMATION;
        
            Alert a = new Alert(at);
            
            a.setContentText(alertInfo);
            a.setTitle("");
            
            a.show();
        
        
    }
    
}
