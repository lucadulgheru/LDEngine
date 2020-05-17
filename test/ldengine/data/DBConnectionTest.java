/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.data;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luca
 */
public class DBConnectionTest {
    
    public DBConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of executeQuery method, of class DBConnection.
     */
 /* 
    @Test
    public void testExecuteQuery() throws Exception {
        System.out.println("executeQuery");
        String query = "";
        DBConnection instance = new DBConnection();
        ResultSet expResult = null;
        ResultSet result = instance.executeQuery(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    */
    /**
     * Test of validateUser method, of class DBConnection.
     */
    
    
    
    @Test
    public void testValidateUser() throws Exception {
        
        DBConnection instance = new DBConnection();
        
        System.out.println("Testing the Sign In functionality...");
        
        
            // GOOD USER + GOOD PASS
        
            System.out.print("Testing good user + good pass .......");

            String good_username = "aolo";
            String good_password = "parola";

            boolean firstResult = true;

            boolean result1 = instance.validateUser(good_username, good_password);
        
                try{

                    assertEquals(firstResult, result1);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
        
             System.out.print("Testing bad user + bad pass .......");
           
             String bad_username = "bad_username";
             String bad_password = "bad_password";

             boolean secondResult = false;

             boolean result2 = instance.validateUser(bad_username, bad_password);
        
               try{

                    assertEquals(secondResult, result2);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
        
            System.out.print("Testing good user + bad pass .......");

            String good_username2 = "aolo";
            String bad_password2 = "bad_password";

            boolean thirdResult = false;

            boolean result3 = instance.validateUser(bad_username, bad_password);

            try{

                    assertEquals(thirdResult, result3);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
   
        
    }

    /**
     * Test of insertUser method, of class DBConnection.
     */
    
    /*
   
    @Test
    public void testInsertUser() throws Exception {
       
        
         DBConnection instance = new DBConnection();
        
        System.out.println("Testing the Sign Up functionality...");
        
        
            // GOOD USER + GOOD PASS
        
            System.out.print("Testing new user + new email .......");

            String new_username = "new_user";
            String new_password = "new_password";
            String new_email = "newemail@gmail.com";

            boolean firstResult = true;

            boolean result1 = instance.insertUser(new_username, new_password, new_email);
        
                try{

                    assertEquals(firstResult, result1);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
        
             System.out.print("Testing existing user + new email .......");
           
             String existing_username = "aolo";
             String bad_password = "bad_password";
             String new_email2 = "newemail2@gmail.com";

             boolean secondResult = false;

             boolean result2 = instance.insertUser(existing_username, bad_password, new_email2);
        
               try{

                    assertEquals(secondResult, result2);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
        
            System.out.print("Testing new user + existing email .......");

            String new_username2 = "new_username2";
            String bad_password2 = "bad_password";
            String existing_email = "test@gmail.com";

            boolean thirdResult = false;

            boolean result3 = instance.insertUser(new_username, bad_password2, existing_email);

            try{

                    assertEquals(thirdResult, result3);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
   
        
        
   
        
        
    }
    
  */
    
}
