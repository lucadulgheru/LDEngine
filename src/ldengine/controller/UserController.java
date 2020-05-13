/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import ldengine.model.UserModel;
import ldengine.view.UserView;

/**
 *
 * @author Luca
 */
public class UserController {
 
    private UserModel userModel;
    private UserView userView;
    
    public UserController(UserModel userModel, UserView userView){
        
        this.userModel = userModel;
        this.userView = userView;
        
    }
    
    public void setId(int id){
        
        userModel.setId(id);
        
    }
    
     public int getId(){
        
        return userModel.getId();
        
    }
       
    
    public void setUsername(String username){
        
        userModel.setUsername(username);
        
    }
    
    public String getUsername(){
        
       return userModel.getUsername();
        
    }
    
    
    public void setPassword(String password){
        
        userModel.setUsername(password);
        
    }
    
    public String getPassword(){
        
       return userModel.getPassword();
        
    }
    
    public void setEmail(String email){
        
        userModel.setEmail(email);
        
    }
    
    public String getEmail(){
        
       return userModel.getEmail();
        
    }
    
    public void updateView(){
        
        userView.displayUserInfo(getId(), getUsername(), getPassword(), getEmail());
        
        
    }
    
    
}
