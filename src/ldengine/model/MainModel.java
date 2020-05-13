/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Luca
 */
public class MainModel {
    
    private String imgPathBase = "C:/Users/Luca/Desktop/ProjetMTDL/img/StartingScreen/";
    
    private FileInputStream inputstream;
    
    private ArrayList<String> imgList = new ArrayList<>();
    
    private int i = 0;
    
    
    public MainModel(){
          
           imgList.add("StartingScreen2.jpg");
           imgList.add("StartingScreen3.jpg");
           imgList.add("StartingScreen4.jpg");
           imgList.add("StartingScreen1.jpg");
                
    }
    
    
    public void nextImage(ImageView imgView) throws FileNotFoundException, IOException{
        
  
          System.out.println("Next " + i);
        
             if(i<3)
                ++i;

            else i = 0;
        
            
            inputstream = new FileInputStream(imgPathBase + imgList.get(i));
            
            imgView.setImage(new Image(inputstream));
           
            inputstream.close();
       
        
        
    }
    
    
    public void previousImage(ImageView imgView) throws FileNotFoundException, IOException{
        
  
       
        
         System.out.println("Back " + i);
            
            
            if(i>0)
                --i;

            else i = 3;
        
            
            inputstream = new FileInputStream(imgPathBase + imgList.get(i));
            
            imgView.setImage(new Image(inputstream));
                
           
            inputstream.close();
            
            
           

        
        
        
    }
    
    
}
