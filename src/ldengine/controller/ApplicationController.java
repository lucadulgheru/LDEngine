/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldengine.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ldengine.data.DBConnection;
import ldengine.data.LoggedUser;
import ldengine.model.CameraModel;
import ldengine.model.GameSceneModel;
import ldengine.sceneobjects.Axes;
import ldengine.sceneobjects.FocusedObject;
import ldengine.sceneobjects.LightPool;
import ldengine.sceneobjects.ShapePool;
import ldengine.view.CameraView;
import ldengine.view.GameSceneView;
import org.junit.Test;

/**
 *
 * @author Luca
 */
public class ApplicationController {
    
    @FXML
    private FlowPane applicationTab;
    @FXML
    private MenuItem menuSphere;
    @FXML
    private MenuItem menuCylinder;
    @FXML
    private MenuItem menuBox;
    @FXML
    private MenuItem menuAmbient;
    @FXML
    private MenuItem menuPoint;
    @FXML
    private JFXRadioButton radioKeyboard;
    @FXML
    private JFXRadioButton radioMouse;
    
    @FXML
    private Pane scenePane;
    
    @FXML
    public ElementsController elementsTabController;
    
    @FXML
    public TunerController tunerTabController;
    
    
    ShapePool shapePool = ShapePool.getInstance();
    LightPool lightPool = LightPool.getInstance();
    
    DBConnection conn;
    LoggedUser loggedUser;
    
    FocusedObject focusedObject = FocusedObject.getInstance();
    
    boolean keyboardToggle = false;
    
    boolean mouseToggle = false;
    
    double x=0, y=0;
           
    
    
     // =========================================================================
    
    private Group gameGroup;
    
    private SubScene gameScene;
    
    private PerspectiveCamera camera;
    
    private final PhongMaterial material = new PhongMaterial();
   
    
    Axes axes = new Axes();
    
    // MIDDLE PANE - WHICH IS THE ACTUAL 3D SCENE
    
    private final GameSceneModel gameSceneModel = new GameSceneModel();
    private final GameSceneView gameSceneView = new GameSceneView();
    
    private final GameSceneController gameSceneController = new GameSceneController(gameSceneModel, gameSceneView);
    

    
    // CAMERA
    
    private final CameraModel cameraModel = new CameraModel();
    private final CameraView cameraView = new CameraView();
    
    private final CameraController cameraController = new CameraController(cameraModel, cameraView);
    
    
    
    private void focusObject(Shape3D shape){
        
         if(!shapePool.pool.isEmpty()){  
          
               if(focusedObject.shape != null)
                   
                   focusedObject.shape.setDrawMode(DrawMode.FILL);
               
            focusedObject.shape = shape;     

            focusedObject.shape.setDrawMode(DrawMode.LINE);
            
            elementsTabController.toggleFocusedObject();
          
          
            if(shape instanceof Box){

                tunerTabController.enableBoxTuner();

            }
          
          
            else if(shape instanceof Cylinder){
              
                tunerTabController.enableCylinderTuner();
              
            }
          
            else if(shape instanceof Sphere){
              
              tunerTabController.enableSphereTuner();
              
            }
          
          System.out.println("Focused object is: " + focusedObject.shape);
               
    }
         
    }
    
    
    
  
    

    // SHAPE GENERATION METHODS
    
    
    @FXML
    private void generateSphere() throws SQLException{
               
        Sphere sphere = new Sphere(25);

        sphere.setId("Default sphere");
             
        sphere.setOnMouseClicked(e-> {
           
                focusObject(sphere);
                
           x = e.getSceneX() - sphere.getTranslateX();
           y = e.getSceneY() - sphere.getTranslateY();
                    
       });
        
        
        sphere.setOnMouseDragged(e-> {
                
           sphere.setTranslateX(e.getSceneX() - x);
           sphere.setTranslateY(e.getSceneY() - y);
           
            
        });
        
       
        
        
        gameSceneController.insertIntoScene(sphere);
        
        shapePool.pool.add(sphere);
        
        conn.insertShape(1, "ID=Default sphere | POSITION [0,0,0] | COLOR = WHITE | SIZE = [25]");
        
        System.out.println("User '" + loggedUser.username + "' added default sphere: ID=Default sphere | POSITION [0,0,0] | COLOR = WHITE | SIZE = [25]");
          
    }     
    
    @FXML
    private void generateBox() throws SQLException{
        
        Box box = new Box(25,25,25);
              
        box.setId("Default box");
        
        box.setOnMousePressed(e-> {
        
            focusObject(box);
            
           x = e.getSceneX() - box.getTranslateX();
           y = e.getSceneY() - box.getTranslateY();
                      
        });
        
        
        box.setOnMouseDragged(e-> {
                
          box.setTranslateX(e.getSceneX() - x);
          box.setTranslateY(e.getSceneY() - y);
           
            
        });
        
        
        gameSceneController.insertIntoScene(box);
        
        shapePool.pool.add(box);
        
        conn.insertShape(3, "ID=Default box | POSITION [0,0,0] | COLOR = WHITE | SIZE = [25, 25, 25]");
        
        System.out.println("User '" + loggedUser.username + "' added default box: ID=Default box | POSITION [0,0,0] | COLOR = WHITE | SIZE = [25, 25, 25]");
        
        
    } 
    
    @FXML
    private void generateCylinder() throws SQLException{
        
        Cylinder cylinder = new Cylinder(20, 30);
       
        
        cylinder.setId("Default cylinder");
            
        cylinder.setOnMouseClicked(e-> {
        
                focusObject(cylinder);
                
                 x = e.getSceneX() - cylinder.getTranslateX();
                 y = e.getSceneY() - cylinder.getTranslateY();
            
        });
        
         cylinder.setOnMouseDragged(e-> {
                
          cylinder.setTranslateX(e.getSceneX() - x);
          cylinder.setTranslateY(e.getSceneY() - y);
           
            
        });
        
        gameSceneController.insertIntoScene(cylinder);
        
        shapePool.pool.add(cylinder);
        
        conn.insertShape(2, "ID=Default cylinder | POSITION [0,0,0] | COLOR = WHITE | SIZE = [20, 30]");
        
        System.out.println("User '" + loggedUser.username + "' added default cylinder: ID=Default cylinder | POSITION [0,0,0] | COLOR = WHITE | SIZE = [20, 30]");
  
 
        
    } 
    
    
    private void createCustomShape(int p, int f, int c) throws SQLException{
        
        int i;
        
        // create container for the shape
        MeshView meshView = new MeshView();
        
        // this is the mesh that we're going to apply onto the meshview
        TriangleMesh mesh = new TriangleMesh();
        
       
        // gonna leave the texture coordinates to 0 cuz I'm not adding textures over it, colors only.
        mesh.getTexCoords().addAll(0,0);
        
        
        float h = 50;                    // Height
        float s = 100;                    // Side
        
  
        
   
   
        
        mesh.getPoints().addAll(
        0,    0,    0,            // Point 0 - Top
        0,    h,    -s/2,         // Point 1 - Front
        -s/2, h,    0,            // Point 2 - Left
        s/2,  h,    0,            // Point 3 - Back
        0,    h,    s/2           // Point 4 - Right
    );
       
        
        

        
    
            
            
            
        mesh.getFaces().addAll(
        0,0,  2,0,  1,0,          // Front left face
        0,0,  1,0,  3,0,          // Front right face
        0,0,  3,0,  4,0,          // Back right face
        0,0,  4,0,  2,0,          // Back left face
        4,0,  1,0,  2,0,          // Bottom rear face
        4,0,  3,0,  1,0           // Bottom front face
    ); 
          
        
        
        meshView.setMesh(mesh);
        
        meshView.setTranslateX(0);
        meshView.setTranslateY(0);
        meshView.setTranslateZ(0);
        
        PhongMaterial mat = new PhongMaterial();
        
        mat.setDiffuseColor(Color.BROWN);
        mat.setSpecularColor(Color.BROWN);
        
        meshView.setMaterial(mat);
        
        gameSceneController.insertIntoScene(meshView);
        
        shapePool.pool.add(meshView);
        
        conn.insertShape(4, "ID=Default custom | POSITION [0,0,0] | COLOR = WHITE | SIZE = [100, 50, 100]");
        
        System.out.println("User '" + loggedUser.username + "' added default custom: ID=Default custom | POSITION [0,0,0] | COLOR = WHITE | SIZE = [100, 50, 100]");
        
        
        
    }
    
    @FXML
    private void generateCustom(){
        
        
        Stage popupwindow=new Stage();
      
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Custom shape");


        Label lblNumberPoints = new Label("Number of points ");
        Label lblNumberFaces = new Label("Number of faces ");
        Label lblNumberCorners = new Label("Number of corners ");
        
     
        
        JFXTextField txtNumberPoints = new JFXTextField();
        JFXTextField txtNumberFaces = new JFXTextField();
        JFXTextField txtNumberCorners = new JFXTextField();


        JFXButton btn_done = new JFXButton("Apply");


        VBox layout = new VBox();

        layout.getChildren().addAll(lblNumberPoints, txtNumberPoints, lblNumberFaces, txtNumberFaces, lblNumberCorners, txtNumberCorners, btn_done);
      
        layout.setAlignment(Pos.CENTER);
        
        btn_done.setOnAction(e -> {
            try {
                createCustomShape(Integer.parseInt(txtNumberPoints.getText()), Integer.parseInt(txtNumberFaces.getText()), Integer.parseInt(txtNumberCorners.getText()));
                popupwindow.close();
            } catch (SQLException ex) {
                Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Scene scene1= new Scene(layout, 300, 250);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();
       
        
    }
    
    @FXML
    private void generateAmbientLight(){
        
        
        AmbientLight ambientLight = new AmbientLight();
        
        ambientLight.setId("Default AmbientLight");
               
        gameSceneController.insertIntoScene(ambientLight);
        
        lightPool.pool.add(ambientLight);
        
        
    }
    
    @FXML
    private void generatePointLight(){
        
        PointLight pointLight = new PointLight();
        
        pointLight.setId("Default PointLight");
               
        gameSceneController.insertIntoScene(pointLight);
        
        lightPool.pool.add(pointLight);
        
        
    }
    
    
       public void removeShape(Shape3D shape){
        
        gameSceneController.getGroup().getChildren().remove(shape);
        
        
    }
    
    
    
    
    // IO INTERACTION METHODS


    @FXML
    public void toggleKeyboard() {
        
        
         keyboardToggle = keyboardToggle == false;
        
    }


    @FXML
    public void toggleMouse() {
        
        
        mouseToggle = mouseToggle == false;
        
        
    }
    
    @FXML
    public void changePassword(){
        
        Stage popupwindow=new Stage();
      
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Change password");
        
        
        Label lbl_pass = new Label("Type your new password");
        Label lbl_confirm = new Label("Confirm your new password");
        
        JFXPasswordField txt_pass = new JFXPasswordField();
        JFXPasswordField txt_confirm = new JFXPasswordField();
        
        JFXButton btn_done = new JFXButton("Apply");
        
        VBox layout = new VBox();

        layout.getChildren().addAll(lbl_pass, txt_pass, lbl_confirm, txt_confirm, btn_done);
      
        layout.setAlignment(Pos.CENTER);
        
         btn_done.setOnAction(e -> {
              
                 try {
                        
                            conn.updatePass(txt_pass.getText());
                        
                            System.out.println(txt_pass.getText());
                            
                            popupwindow.close();
                        
                             
                 } catch (SQLException ex) {
                 Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
             }});
        
        Scene scene1= new Scene(layout, 300, 250);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();
        
        
        
    }
    
    
 
    
    @FXML
    private void initialize() throws SQLException{
        
        conn = DBConnection.getInstance();
        loggedUser = LoggedUser.getInstance();
        
        // inject this controller -> interactions between controllers
        
        elementsTabController.injectApplicationController(this);
        tunerTabController.injectApplicationController(this);
        
        
        
        
        //generate axes + add to scene
        
        gameSceneController.insertIntoScene(axes.generateAxes());
              
        gameScene = gameSceneController.generateGameScene();   
            
        camera = cameraController.generateCamera();
           
    
        
        // KEYBOARD ENABLE/DISABLE
        
            if(!radioKeyboard.isDisabled()){
            
            applicationTab.setOnKeyPressed(e-> { 
                
                
                if(keyboardToggle == false){
                
                        e.consume();
                    
                    return;
                
                    }
                             
              
                switch(e.getCode()) {
                        
                
                case A:
                    
                    cameraController.moveX(-5);
                    System.out.println("X = " + cameraController.getPosX());
                    break;
                    
                case D:
                    
                    cameraController.moveX(5);
                    System.out.println("X = " + cameraController.getPosX());
                    break;
                    
                    
                case Q:
                    
                    cameraController.moveY(5);
                    System.out.println("Y = " + cameraController.getPosY());
                    break;
                    
                case E:
                    
                    cameraController.moveY(-5);
                    System.out.println("Y = " + cameraController.getPosY());
                    break;   
                    
                    
                case S:
                    
                    cameraController.moveZ(-5);
                    System.out.println("Z = " + cameraController.getPosZ());
                    break;
                    
                case W:
                    
                    cameraController.moveZ(5);
                    System.out.println("Z = " + cameraController.getPosZ());
                    break;
                
            }});
            
            
        }
            
            
            // MOUSE ENABLE/DISABLE
            
            applicationTab.setOnMouseDragged(
                    
                    
                    e->{
                        
                      if(mouseToggle == false){
                
                      e.consume();
                    
                    return;
                
                    }
                        
            
                
                
                cameraController.rotateX(e.getX());
                cameraController.rotateY(e.getY());
  
            
            }
            
            
            );

           
  
            
            cameraController.moveZ(-300);
            
            gameScene.setCamera(camera);
        
        
        
        
        
        
        
  
        // Kept a dummy pane and i'm replacing it with the actual game scene
        applicationTab.getChildren().set(3, gameScene);
      
      
        
 
        
        
    }
    
}




