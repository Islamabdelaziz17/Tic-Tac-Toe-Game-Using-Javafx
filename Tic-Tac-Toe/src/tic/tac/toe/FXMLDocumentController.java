
package tic.tac.toe;

import Arduino.SerialControl;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * FXML Controller class
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
   
    @FXML
    private Line Hline1;
    
    @FXML
    private Line Hline2;
    
    @FXML
    private Line Hline3;
    
    @FXML
    private Line Vline1;
    
    @FXML
    private Line Vline2;
    
    @FXML   
    private Line Vline3;
   
    @FXML
    private Line Dline1;
    
    @FXML
    private Line Dline2;
    
    ArrayList<Button> buttons;
    ArrayList<Line> lines;
    
    @FXML
    private Label Counter1;
     
    @FXML
    private Label Counter2;
    
    @FXML
    private Button multiplayerbutton;
    
    int checknine = 0;
    
    Alert oWon = new Alert(Alert.AlertType.CONFIRMATION);
    
        
    
    /*Line line1,line2;
    Circle circle;*/
    
    int playerTurn = 0;
    int player1counter = 0 ;
    int player2counter = 0;
    static public boolean playermode;
    int x  =4;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

       buttons = new ArrayList<>(Arrays.asList(button00,button01,button02,button10,button11,button12,button20,button21,button22));
       lines = new ArrayList<>(Arrays.asList(Hline1,Hline2,Hline3,Dline1,Dline2,Vline1,Vline2,Vline3));
      
        SerialControl.detectPort();
        SerialControl.disconnectArduino();
        SerialControl.connectArduino(SerialControl.port);
        
    // creating timer task, timer
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            
            @Override
            public void run() {
                if(playermode)
                {
                   if (playerTurn % 2 != 0){

                       Random random = new Random();
                       int index = random.nextInt(buttons.size());
                       while(buttons.get(index).isDisabled()){

                            index = random.nextInt(buttons.size());
                       }

                       ButtonAction(index, "F");

                   }
                   else
                   {
                        if(SerialControl.reading != null)
                         {
                             setupButton(SerialControl.reading);
                             SerialControl.reading = null;
                         }

                    }
                }
                else
                {
                    if(SerialControl.reading != null)
                    {
                        setupButton(SerialControl.reading);
                        SerialControl.reading = null;
                    }
                }
            };    
        };
        t.schedule(tt, new Date(),1);
    }
       
    
    
    @FXML
    private void HandleButton(ActionEvent event) 
    {
        
        //SerialControl.disconnectArduino();
       
        
    }
    public void Draw(Button button,String turn)
    {
        Text text = new Text(turn);
        text.setFill(null);
        text.setFont(new Font(100));
        text.setStroke(Color.rgb(138, 43, 226));
        text.setStrokeWidth(5);
        button.setText(turn);
        button.setGraphic(text);
    }
   
     
    
    
     
     public void setupButton(String x) 
     {  
           int cell;
         if(SerialControl.reading != null)
         {
           cell = controlGame(x);
           
           ButtonAction(cell,SerialControl.reading);
         }


    }
     
     public void setPlayerSymbol(Button button){
        
        if(button.isDisabled())
        {
            System.out.println("Already Pressed");
        }
        else
        {
            if(playerTurn % 2 == 0){
            Draw(button,"X");
            WinnerText.setText("Player 2 turn");
            playerTurn = 1;
        } else{
            Draw(button,"O");
            WinnerText.setText("Player 1 turn");
            playerTurn = 0;
        }
        }
        
        
    }
     
        public void fireAlert(char winner){
                if (winner == 'O'){
                    oWon.setAlertType(Alert.AlertType.INFORMATION);
                    oWon.setTitle("Congrats");
                    
                    oWon.setHeaderText("O is the winner");
                    // set content text
                
                    oWon.setContentText("Press Ok to continue");
                    
                    // show the dialog

                    Optional<ButtonType> result = oWon.showAndWait();
                    ButtonType dialogbutton = result.orElse(ButtonType.CANCEL);

                    if (dialogbutton == ButtonType.OK) 
                    {
                       player1counter = 0;
                        player2counter = 0;
                        Counter1.setText(Integer.toString(player1counter));
                        Counter2.setText(Integer.toString(player2counter));
                        buttons.forEach(button ->
                        {
                            button.setGraphic(null);
                            button.setDisable(false);
                            button.setText(null);

                        });
                    
                    } 
                    else {
                        
                    }
                }
                else if (winner == 'X'){
                    oWon.setAlertType(Alert.AlertType.INFORMATION);
                    oWon.setTitle("Congrats");
                    
                    oWon.setHeaderText("X is the winner");
                    // set content text
                
                    oWon.setContentText("Press Ok to continue");

                    // show the dialog

                    Optional<ButtonType> result = oWon.showAndWait();
                    ButtonType dialogbutton = result.orElse(ButtonType.CANCEL);

                    if (dialogbutton == ButtonType.OK) 
                    {
                        player1counter = 0;
                        player2counter = 0;
                        Counter1.setText(Integer.toString(player1counter));
                        Counter2.setText(Integer.toString(player2counter));
                        buttons.forEach(button ->
                        {
                            button.setGraphic(null);
                            button.setDisable(false);
                            button.setText(null);
                            System.out.println("xxxxxxxxxxxxx");
                        });
                    } 
                    else 
                    {
                       
                    }
                }
               
        }
            
        
        public void checkIfGameIsOver()
        {
            
            int a;
            for ( a = 0; a < 8; a++) {
            String line = null;
             
            switch (a) {
                case 0 : 
                    line = button00.getText() + button01.getText() + button02.getText();
                    break;
                case 1 : 
                    line =button10.getText() + button11.getText() + button12.getText();
                    break;            
                case 2 : 
                    line =button20.getText() + button21.getText() + button22.getText();
                    break;
                case 3 : 
                    line =button00.getText() + button11.getText() + button22.getText();
                    break;
                case 4 : 
                    line =button02.getText() + button11.getText() + button20.getText();
                    break;
                case 5 : 
                    line =button00.getText() + button10.getText() + button20.getText();
                    break;
                case 6 : 
                    line =button01.getText() + button11.getText() + button21.getText();
                    break;
                case 7 : 
                    line =button02.getText() + button12.getText() + button22.getText();
                    break;
                default : 
                    break;
            }
            
            //X winner
            if (line.equals("XXX")) 
            {
                
                WinnerText.setText("X won!");
                player1counter++;
                Counter1.setText(Integer.toString(player1counter));
                System.out.println(Integer.toString(player1counter));
                lines.get(a).setVisible(true);
                buttons.forEach(button ->
                {
                    button.setGraphic(null);
                    button.setDisable(false);
                    button.setText(null);
                    
                });
                lines.get(a).setVisible(false);
                
                if(player1counter == 1)
                {
                    buttons.forEach(button ->
                    {
                        button.setDisable(true);
                    });
                    fireAlert('X');
                
                }
                else if(checknine == 9)
                {
                    buttons.forEach(button ->
                    {
                        button.setGraphic(null);
                        button.setDisable(false);
                        button.setText(null);
                    });
                    checknine = 0;
                }
                checknine = 0;
             }

            //O winner
            else if (line.equals("OOO")) 
            {
                
                WinnerText.setText("O won!");
                
                player2counter++;
                Counter2.setText(Integer.toString(player2counter));
                lines.get(a).setVisible(true);
                buttons.forEach(button ->
                {
                    button.setGraphic(null);
                    button.setDisable(false);
                    button.setText(null);
                });
                 lines.get(a).setVisible(false);
                if(player2counter == 1)
                {
                    buttons.forEach(button ->
                    {
                         button.setDisable(true);
                    });
                    fireAlert('O');
                   
                }
                checknine = 0;
                
            }
            else if(checknine == 9)
            {
                buttons.forEach(button ->
                {
                    button.setGraphic(null);
                    button.setDisable(false);
                    button.setText(null);
                });
                checknine = 0;
            }
       }
        }
        
       public int controlGame(String cellll ){
           
           String input = cellll;
           buttons.get(x).setStyle("-fx-border-color:#FFE40C;-fx-border-width:5px;");
           
           if ( "U".equals(input)){
               if (x == 0 || x== 1 || x ==2 ){
                   
                   x+= 6;
               }
               else {
                   x-= 3;
                   System.out.println(input);
               }
           }
            if ( "D".equals(input)){
               if (x == 7 || x== 8 || x ==9 ){
                   x = x - 6;
               }
               else {
                   x = x + 3;
               }   
           }
            if ( "R".equals(input)){
               if (x == 2 || x== 5 || x ==8 ){
                   x = x - 2;
               }
               else {
                   x = x + 1;
               }   
           }
          if ( "L".equals(input)){
               if (x == 0 || x== 3 || x ==6 ){
                   
                   x = x + 2;
               }
               else {
                   
                   x = x - 1;
               }   
           }
            x%=buttons.size();
            buttons.get(x).setStyle("-fx-border-color:#8a2be2;-fx-border-width:10px;");
            return x;
       }
       
       public void ButtonAction(int pos, String buttonAction)
       {
           
           if(SerialControl.reading != null)
           {
           if ("F".equals(buttonAction) ||  "u".equals(buttonAction))
           {
                    Thread t = new Thread(() -> {

                     Platform.runLater(() -> {
                         setPlayerSymbol(buttons.get(pos));
                          buttons.get(pos).setDisable(true);
                          checknine++;
                          checkIfGameIsOver();
                     });
                    });
                    t.start();
           }
            SerialControl.reading = null;
          
           }
       
 
       }
 
       
       public void getRandomElements() {
        
        Random random = new Random();
        int index = random.nextInt(buttons.size());

        buttons.get(index).setText("O");
        buttons.get(index).setDisable(true);
        buttons.remove(buttons.get(index));
    }
}
