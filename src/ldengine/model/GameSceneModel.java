/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.model;

import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;

/**
 *
 * @author Luca
 */
public class GameSceneModel {
    
    private Group group = new Group();
    
    private final double width = 866;
    private final double height = 700;
    
    private PerspectiveCamera camera = new PerspectiveCamera(true);

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


     public PerspectiveCamera getCamera() {
        return camera;
    }

    public void setCamera(PerspectiveCamera camera) {
        this.camera = camera;
    }
    
    
    
}
