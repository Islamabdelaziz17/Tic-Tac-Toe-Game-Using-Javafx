
package tic.tac.toe;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 *
 * @author islam
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private GridPane GameGrid;
    
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
    private ImageView Imageviewb1;
    
    @FXML
    private ImageView Imageviewb2;
    
    @FXML
    private ImageView Imageviewb3;
    
    @FXML
    private ImageView Imageviewb4;
    
      @FXML
    private ImageView Imageviewb5;
    
    @FXML
    private ImageView Imageviewb6;
    
    @FXML
    private ImageView Imageviewb7;
    
    @FXML
    private ImageView Imageviewb8;
    
    @FXML
    private ImageView Imageviewb9;
    
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
    
    
    Alert oWon = new Alert(AlertType.CONFIRMATION);
    
    
    /*Line line1,line2;
    Circle circle;*/
    
    int playerTurn = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

       buttons = new ArrayList<>(Arrays.asList(button00,button01,button02,button10,button11,button12,button20,button21,button22));
       lines = new ArrayList<>(Arrays.asList(Hline1,Hline2,Hline3,Dline1,Dline2,Vline1,Vline2,Vline3));
       
       buttons.forEach(button ->
       {
            setupButton(button,playerTurn);
            button.setFocusTraversable(false);
       });
       
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
       
        WinnerText.setText(button00.getText());
        
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
     @FXML
     private void setupButton(Button button, int playerTurn) 
     {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
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
        public void checkIfGameIsOver(){
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
            if (line.equals("XXX")) {
                WinnerText.setText("X won!");
                fireAlert('X');
                lines.get(a).setVisible(true);
                 buttons.forEach(button ->
       {
            button.setDisable(true);
       });
             }

            //O winner
            else if (line.equals("OOO")) {
                WinnerText.setText("O won!");
                fireAlert('O');
                lines.get(a).setVisible(true);
                buttons.forEach(button ->
       {
            button.setDisable(true);
       });
            }
       }
   }
     
     
     
}
