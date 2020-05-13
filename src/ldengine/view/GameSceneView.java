/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import ldengine.model.GameSceneModel;

/**
 *
 * @author Luca
 */
public class GameSceneView {
    


    
    public SubScene generateGameScene(Group group, double width, double height, PerspectiveCamera camera){
        
        SubScene s = new SubScene(group, width, height);

        s.setCamera(camera);

        s.setFill(Color.color(0.3, 0.3, 0.3));

        return s;
        
                    
    }
    
    
    public void insertIntoScene(Group group, Node node){
            
        group.getChildren().add(node);
        
    }
    
    
}
