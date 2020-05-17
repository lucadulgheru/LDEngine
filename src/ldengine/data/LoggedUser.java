/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.data;

/**
 *
 * @author Luca
 */
public class LoggedUser {
    
    private static LoggedUser instance = null;
    
    public String username = "";
    public int user_id = 0;
    
    
    public static LoggedUser getInstance(){
        
        
        if(instance == null)
            
              instance = new LoggedUser();
        
        
        return instance;
        
    }
    
    public void setUsername(String username){
        
        username = username;
        
    }
    
    public void setId(int user_id){
        
        user_id = user_id;
        
    }
    
}
