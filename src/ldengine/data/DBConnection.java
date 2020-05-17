/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.data;

import java.sql.*;  
import ldengine.data.PasswordHandler;

/**
 *
 * @author Luca
 */
public class DBConnection {
      
    private static DBConnection instance = null;
    public static Connection conn;
    public static Statement stmt;
    private static String secret = "secretKeyThatsNotSoSecret";
    private LoggedUser loggedUser = LoggedUser.getInstance();

    
    public static DBConnection getInstance() throws SQLException{
        
         if(instance == null){
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ldengine","root","luk610"); 
            stmt = conn.createStatement();
          
            PasswordHandler.setKey(secret);
         
            instance = new DBConnection();
         }
         
         
         return instance;
        
         
    }
    

    public ResultSet executeQuery(String query) throws SQLException{
        
        ResultSet rset = stmt.executeQuery(query);
        
        return rset;
        
    }
    
    
    public boolean validateUser(String username, String password) throws SQLException{
        
        
        String encrypted_password = PasswordHandler.encrypt(password, secret);
        
        ResultSet rset = stmt.executeQuery("SELECT * FROM users where username='" + username + "' AND password='" + encrypted_password +"';");
        
        if(rset.isBeforeFirst()){
         
            while(rset.next()){
            loggedUser.user_id = rset.getInt("id");
            loggedUser.username = rset.getString("username");
                
              
                
            }
            
            return true;
        
        }
     
            return false;
        
        
    }
    
    public boolean insertUser(String username, String password, String email) throws SQLException{
        
      String encrypted_password = PasswordHandler.encrypt(password, secret);
      
      ResultSet rset = stmt.executeQuery("SELECT * FROM users where username='" + username + "' OR email='" + email +"';");
      
      if(rset.isBeforeFirst())

             return false;
      
        
      String sql = "INSERT INTO users (username, password, email) " +
                   "VALUES ('" + username + "', '" + encrypted_password + "', '" + email + "')";
      
      
      stmt.executeUpdate(sql);
      
      return true;
        
    }
    
    public boolean updatePass(String new_password) throws SQLException{
        
        
        String encrypted_password = PasswordHandler.encrypt(new_password, secret);
        
        String sql = "UPDATE users SET password='" + encrypted_password + "' WHERE username='" + loggedUser.username +"'";
        
        
        stmt.executeUpdate(sql);
        
        return true;
        
        
    }
    
    
    public boolean insertShape(int shape_id, String action_description) throws SQLException{
        
        String sql = "INSERT INTO actions (user_id, shape_id, action_description) " +
                   "VALUES ('" + loggedUser.user_id + "', '" + shape_id + "', '" + action_description + "')";
        
        
        stmt.executeUpdate(sql);
        
        return true;
        
    }
    
    
    
    
   
    
    
}
