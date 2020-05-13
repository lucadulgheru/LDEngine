/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import ldengine.controller.UserController;
import ldengine.data.DBConnection;
import ldengine.model.UserModel;
import ldengine.view.UserView;

/**
 *
 * @author Luca
 */
public class LDEngine extends Application {
    
    
    @Override
    public void start(Stage stage) throws SQLException, IOException {
        

        Parent root = FXMLLoader.load(getClass().getResource("/ldengine/view/MainView.fxml"));
       
        
        Scene scene = new Scene(root);
        stage.setTitle("LDEngine");
        stage.setScene(scene);
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
