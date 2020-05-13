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
      
    private Connection conn;
    private Statement stmt;
    private String secret = "secretKeyThatsNotSoSecret";

    
    public DBConnection() throws SQLException{
        
         this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ldengine","root","luk610"); 
         this.stmt = conn.createStatement();
         
         PasswordHandler.setKey(secret);
        
         
    }
    

    public ResultSet executeQuery(String query) throws SQLException{
        
        ResultSet rset = stmt.executeQuery(query);
        
        return rset;
        
    }
    
    
    public boolean validateUser(String username, String password) throws SQLException{
        
        
        String encrypted_password = PasswordHandler.encrypt(password, secret);
        
        ResultSet rset = stmt.executeQuery("SELECT * FROM users where username='" + username + "' AND password='" + encrypted_password +"';");
        
        if(rset.isBeforeFirst())
            
            return true;
        
        
     
            return false;
        
        
    }
    
    public void insertUser(String username, String password, String email) throws SQLException{
        
      String encrypted_password = PasswordHandler.encrypt(password, secret);
        
      String sql = "INSERT INTO users (username, password, email) " +
                   "VALUES ('" + username + "', '" + encrypted_password + "', '" + email + "')";
      
      
      stmt.executeUpdate(sql);
        
    }
    
   
    
    
}
