/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.model;

import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Luca
 */
public class CameraModel {
    
    PerspectiveCamera camera = new PerspectiveCamera(true);
    
    private double posX;
    private double posY;
    private double posZ;
    
    private double rotX;
    private double rotY;
    private double rotZ;

    public PerspectiveCamera getCamera() {
        return camera;
    }

    public void setCamera(PerspectiveCamera camera) {
        this.camera = camera;
    }

    public double getPosX() {
        
        posX = camera.getTranslateX();
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        
        posY = camera.getTranslateY();
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getPosZ() {
        
        posZ = camera.getTranslateZ();
        return posZ;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public double getRotX() {
       
        camera.setRotationAxis(Rotate.X_AXIS);
        rotX = camera.getRotate();
        return rotX;
    }

    public void setRotX(double rotX) {
        this.rotX = rotX;
    }

    public double getRotY() {
        
        camera.setRotationAxis(Rotate.Y_AXIS);
        rotY = camera.getRotate();
        
        return rotY;
    }

    public void setRotY(double rotY) {
        this.rotY = rotY;
    }

    public double getRotZ() {
        
        camera.setRotationAxis(Rotate.Z_AXIS);
        rotZ = camera.getRotate();
        
        return rotZ;
    }

    public void setRotZ(double rotZ) {
        
        this.rotZ = rotZ;
    }
    
    
    
}
