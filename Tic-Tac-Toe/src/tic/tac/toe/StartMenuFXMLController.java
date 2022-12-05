/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tic.tac.toe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author islam
 * 
 * 
 */


public class StartMenuFXMLController implements Initializable {

    @FXML
    private Button multibutton;
    @FXML
    private AnchorPane StartPane;


    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void MoveToGameSceneMulti(ActionEvent event) throws Exception
    {
        AnchorPane Game= FXMLLoader.load(getClass().getResource("TicTacToeFXMLDocument.fxml"));
        StartPane.getChildren().setAll(Game);
        FXMLDocumentController.playermode = false;
    }
    @FXML
    private void MoveToGameSceneSingle(ActionEvent event) throws Exception
    {
        AnchorPane Game= FXMLLoader.load(getClass().getResource("TicTacToeFXMLDocument.fxml"));
        StartPane.getChildren().setAll(Game);
        FXMLDocumentController.playermode = true;
    }
    
    
}
