/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ldengine.model.CameraModel;
import ldengine.view.CameraView;

/**
 *
 * @author Luca
 */
public class CameraController {
    
    
    private CameraModel cameraModel;
    private CameraView cameraView;
    
    
    public CameraController(CameraModel cameraModel, CameraView cameraView){
        
        this.cameraModel = cameraModel;
        this.cameraView = cameraView;
        
    }
    
    
    public PerspectiveCamera getCamera(){
        
        
        return cameraModel.getCamera();
        
    }
    
    public double getPosX(){
        
        
        return cameraModel.getPosX();
        
    }
    
    public double getPosY(){
        
        
        return cameraModel.getPosY();
        
    }
    
    public double getPosZ(){
        
        
        return cameraModel.getPosZ();
        
    }
    
    public void moveX(double value){
        
        cameraView.moveX(getCamera(), getPosX(), value);
        
    }
    
    public void moveY(double value){
        
        cameraView.moveY(getCamera(), getPosY(), value);
        
    }
    
    public void moveZ(double value){
        
        cameraView.moveZ(getCamera(), getPosZ(), value);
        
    }

    
    public void rotateX(double value){
        
        cameraView.rotateX(getCamera(), value);
        
    }
    
    public void rotateY(double value){
        
        cameraView.rotateY(getCamera(), value);
        
    }
    
    public void rotateZ(double value){
        
        cameraView.rotateZ(getCamera(), value);
        
    }
    
    
    
    public PerspectiveCamera generateCamera(){
        
        
        return cameraView.generateCamera(getCamera(), getPosZ());
        
    }
    

}