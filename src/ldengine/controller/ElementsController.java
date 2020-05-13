/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import ldengine.sceneobjects.FocusedObject;
import ldengine.sceneobjects.ShapePool;

/**
 *
 * @author Luca
 */
public class ElementsController {
    @FXML
    private AnchorPane elementsContainer;
    @FXML
    private JFXListView listContainer;
    @FXML
    private JFXButton btnDeleteItem;
    @FXML
    private JFXButton btnRefreshList;
    @FXML
    private JFXToggleButton toggleId;
    
    
    ShapePool shapePool = ShapePool.getInstance();
    
    FocusedObject focusedObject = FocusedObject.getInstance();

    boolean isToggled = false;
   
    private ApplicationController applicationController;
    
    // REMOVE ITEM FROM LIST + SCENE

    @FXML
    public void removeItem(){
        
        if(!shapePool.pool.isEmpty()){

            int index = listContainer.getSelectionModel().getSelectedIndex();

            applicationController.removeShape(shapePool.pool.get(index));

            listContainer.getItems().remove(index);
        
        }
    }
    
    // REFRESH LIST + ID'S
    
    @FXML
    private void refreshList(ActionEvent event) {
        
        listContainer.refresh();
        
    }

    @FXML
    private void toggleId(ActionEvent event) {
    }
    
    
    public void toggleFocusedObject(){
        
        
        //shapePool.pool.indexOf(focusedObject.shape);
        
        //listContainer.selectionModelProperty().set(listContainer.getSelectionModel().equals());
        
    }
    
    
    public void injectApplicationController(ApplicationController applicationController){
        
        this.applicationController = applicationController;
        
    }
    

    

    public void initialize() {
               
        listContainer.setItems(shapePool.pool);
        
        
        listContainer.setCellFactory(param -> new ListCell<Shape3D>() {
        @Override
        protected void updateItem(Shape3D item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null || item.toString() == null) {
                setText(null);
            } else {
                setText(item.toString());
            }
        }
    });
        
 
        
     // daca dai click pe tabel si niciun obiect nu e focusat => exceptie
        
        listContainer.setOnMouseClicked(e->{
            
          if(!shapePool.pool.isEmpty()){  
        
          int index = listContainer.getSelectionModel().getSelectedIndex();
          
               if(focusedObject.shape != null)
                   
                   focusedObject.shape.setDrawMode(DrawMode.FILL);
               
          focusedObject.shape = shapePool.pool.get(index);     
          
          focusedObject.shape.setDrawMode(DrawMode.LINE);
          
          
          if(focusedObject.shape instanceof Box){
              
              applicationController.tunerTabController.enableBoxTuner();
              
          }
          
          else if(focusedObject.shape instanceof Cylinder){
              
              
              applicationController.tunerTabController.enableCylinderTuner();
              
          }
          
          else if(focusedObject.shape instanceof Sphere){
              
              applicationController.tunerTabController.enableSphereTuner();
              
          }
          
                 
          System.out.println("Focused object is: " + focusedObject.shape);
          
          }
        
        });
        
    }

    
}
