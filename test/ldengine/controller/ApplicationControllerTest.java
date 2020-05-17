/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import javafx.scene.shape.Shape3D;
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
public class ApplicationControllerTest {
    
    public ApplicationControllerTest() {
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
     * Test of toggleKeyboard method, of class ApplicationController.
     */
    
    /*
    @Test
    public void testToggleKeyboard() {
        System.out.println("Testing the keyboard movement functionality...");
        
        ApplicationController instance = new ApplicationController();
        
        System.out.print("ENABLE keyboard movement .....");
        
        // ENABLE
        
        boolean expected_enable = true;
        
        instance.toggleKeyboard();
        
        boolean result_enable = instance.keyboardToggle;
        
        
        try{

                    assertEquals(expected_enable, result_enable);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
        
        // DISABLE
        
        System.out.print("DISABLE keyboard movement .....");
        
        boolean expected_disable = false;
        
        instance.toggleKeyboard();
        
        boolean result_disable = instance.keyboardToggle;
        
        try{

                    assertEquals(expected_disable, result_disable);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
      
    }
    
    */

    /**
     * Test of toggleMouse method, of class ApplicationController.
     */
    

    @Test
    public void testToggleMouse() {
        
        System.out.println("Testing the mouse movement functionality...");
        
        ApplicationController instance = new ApplicationController();
        
        System.out.print("ENABLE mouse movement .....");
        
        // ENABLE
        
        boolean expected_enable = true;
        
        instance.toggleMouse();
        
        boolean result_enable = instance.mouseToggle;
        
        
        try{

                    assertEquals(expected_enable, result_enable);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
        
        // DISABLE
        
        System.out.print("DISABLE mouse movement .....");
        
        boolean expected_disable = false;
        
        instance.toggleMouse();
        
        boolean result_disable = instance.mouseToggle;
        
        try{

                    assertEquals(expected_disable, result_disable);

                    System.out.println("PASSED");

                }

                catch (Exception e){

                    System.out.println("FAILED");

                }
        
        
        
    }
 
    
}
