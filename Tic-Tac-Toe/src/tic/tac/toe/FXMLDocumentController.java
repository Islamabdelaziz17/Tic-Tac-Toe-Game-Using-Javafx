
package tic.tac.toe;
import Arduino.SerialControl;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static javafx.util.Duration.seconds;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortException;


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
    
    Alert oWon = new Alert(AlertType.CONFIRMATION);
    
        
    
    /*Line line1,line2;
    Circle circle;*/
    
    int playerTurn = 0;
    //int prevPos=4;
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
               
               if(SerialControl.reading != null)
                {
                    setupButton(SerialControl.reading);
                    SerialControl.reading = null;
                }
        
            };
        };
        t.schedule(tt, new Date(),100);
           
          

       
       
//         EventHandler<ActionEvent> event1 = new
//                          EventHandler<ActionEvent>() {
//            public void handle(ActionEvent e)
//            {
//                // set alert type
//                xWon.setAlertType(AlertType.INFORMATION);
// 
//                // set content text
//                xWon.setContentText("WINNER Dialog");
// 
//                // show the dialog
//                xWon.show();
//            }
//        };
         
//          EventHandler<ActionEvent> event2 = new
//                          EventHandler<ActionEvent>() {
//            public void handle(ActionEvent e)
//            {
//                // set alert type
//                oWon.setAlertType(AlertType.CONFIRMATION);
//                oWon.
// 
//                // set content text
//                oWon.setContentText("WINNER Dialog");
// 
//                // show the dialog
//                oWon.show();
//            }
//        };
       
       // WinnerText.setText(button00.getText());
        
    }    
    
    @FXML
    private void HandleButton(ActionEvent event) 
    {
        
        setupButton(SerialControl.reading);
       
        
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
    /*public void DrawX()
    {
        line1 = new Line(50, 50, 100, 100);
        line2 = new Line(20, 50, -35, 100);
        
        line1.setStroke(Color.rgb(165, 191, 214));
        line1.setStrokeWidth(15);
        
        line2.setStroke(Color.rgb(165, 191, 214));
        line2.setStrokeWidth(15);
    }
    
    public void DrawX(Button button)
    {
        
        GameGrid.add(new Pane(line1,line2),(int)button.getLayoutY(),(int)button.getLayoutX());
        GameGrid.add(line2,(int)button.getLayoutY(),(int)button.getLayoutX());
        GameGrid.setManaged(false);
    }
    
    public void DrawO()
    {
       
        /*circle = new Circle(0,0, 35);
        circle.setFill(null);
        circle.setStroke(Color.rgb(165, 191, 214));
        circle.setStrokeWidth(15);
    }
    
    
    
    public void DrawO(Button button)
    {
        O = new Text("O");
        O.setFill(null);
        O.setFont(new Font(70));
        O.setStroke(Color.rgb(165, 191, 214));
        O.setStrokeWidth(5);
        button.setGraphic(O);
        //GameGrid.add(circle,(int)button.getLayoutY(),(int)button.getLayoutX());
    }*/
     
     public void setupButton(String x) 
     {  
           int cell;
         if(SerialControl.reading != null)
         {
           cell = controlGame(x);
           
           //ButtonAction(cell,SerialControl.reading);
         }

// buttonAction(cell,1);
//         cell = controlGame('D');
//         buttonAction(cell,1);
//         cell = controlGame('D');
//        buttonAction(cell,0);
//        cell = controlGame('R');
//         buttonAction(cell,1);
        
//        button.setOnMouseClicked(mouseEvent -> {
//            setPlayerSymbol(button);
//            button.setDisable(true);
//            checkIfGameIsOver();
//        });
    }
     
     public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0){
            Draw(button,"X");
            WinnerText.setText("Player 1 turn");
            playerTurn = 1;
        } else{
            Draw(button,"O");
            WinnerText.setText("Player 2 turn");
            playerTurn = 0;
        }
    }
     
        public void fireAlert(char winner){
                if (winner == 'O'){
                    oWon.setAlertType(AlertType.INFORMATION);
                    oWon.setTitle("Congrats");
                    
                    oWon.setHeaderText("O is the winner");
                    // set content text
                
                    oWon.setContentText("Press Ok to continue");

                    // show the dialog

                    Optional<ButtonType> result = oWon.showAndWait();
                    ButtonType dialogbutton = result.orElse(ButtonType.CANCEL);

                    if (dialogbutton == ButtonType.OK) {
                    WinnerText.setText("OKKKK");
                    } 
                    else {
                    WinnerText.setText("cancel");
                    }
                }
                else if (winner == 'X'){
                    oWon.setAlertType(AlertType.INFORMATION);
                    oWon.setTitle("Congrats");
                    
                    oWon.setHeaderText("X is the winner");
                    // set content text
                
                    oWon.setContentText("Press Ok to continue");

                    // show the dialog

                    Optional<ButtonType> result = oWon.showAndWait();
                    ButtonType dialogbutton = result.orElse(ButtonType.CANCEL);

                    if (dialogbutton == ButtonType.OK) {
                    WinnerText.setText("OKKKK");
                    } 
                    else {
                    WinnerText.setText("cancel");
                    }
                }
        }
            
        
        public void checkIfGameIsOver()
        {
            int player1counter = 0 ;
            int player2counter = 0;
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
                lines.get(a).setVisible(true);
                buttons.forEach(button ->
                {
                    button.setGraphic(null);
                    button.setDisable(false);
                    button.setText(null);
                    
                });
                lines.get(a).setVisible(false);
                
                if(player1counter == 3)
                {
                    fireAlert('X');
                    buttons.forEach(button ->
                    {
                        button.setDisable(true);
                    });
                }
                
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
                if(player2counter == 3)
                {
                    fireAlert('O');
                    buttons.forEach(button ->
                    {
                         button.setDisable(true);
                    });
                }
            }
       }
        }
        
       public int controlGame(String cellll ){
           
           String input = cellll;
           buttons.get(x).setStyle("-fx-background-color:#FFE40C");
           
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
            buttons.get(x).setStyle("-fx-background-color: #8a2be2");
            return x;
       }
       
       public void ButtonAction(int pos, String buttonAction)
       {
           
           
           if ("F".equals(buttonAction) )
           {
           setPlayerSymbol(buttons.get(pos));
           buttons.get(pos).setDisable(true);
           checkIfGameIsOver();
           }
       
       
       
      // prevPos = pos;
       }
         
       
       
}







     







