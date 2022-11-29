/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tic.tac.toe;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;


/**
 *
 * @author islam
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button00;
    
    @FXML
    private Button button01;
    
    @FXML
    private Button button02;
    
    @FXML
    private Button button10;
    
    @FXML  
    private Button button11;
    
    @FXML   
    private Button button12;
    
    @FXML
    private Button button20;
    
    @FXML  
    private Button button21;
    
    @FXML   
    private Button button22;
    
    @FXML
    private Label WinnerText;
    
    ArrayList<Button> buttons;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       buttons = new ArrayList<>(Arrays.asList(button00,button01,button02,button10,button11,button12,button20,button21,button22));
       buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
     WinnerText.setText("X-WON!");
        
    }    
    
     @FXML
     private void setupButton(Button button) {
        
        button.setOnMouseClicked(mouseEvent -> {
            //setPlayerSymbol(button);
             button.setText("X");
            //checkIfGameIsOver();
        });
    }
    
}
