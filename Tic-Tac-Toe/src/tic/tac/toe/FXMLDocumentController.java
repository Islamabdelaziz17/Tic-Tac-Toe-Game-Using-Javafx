
package tic.tac.toe;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
    
    ArrayList<Button> buttons;
    
    /*Line line1,line2;
    Circle circle;*/
    
    int PlayerTurn = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

       buttons = new ArrayList<>(Arrays.asList(button00,button01,button02,button10,button11,button12,button20,button21,button22));
       buttons.forEach(button ->
       {
            setupButton(button,PlayerTurn);
            //button.setFocusTraversable(false);
       });

        //WinnerText.setText("X-WON!");
        
    }    
    
    public void Draw(Button button,String turn)
    {
        Text text = new Text(turn);
        text.setFill(null);
        text.setFont(new Font(100));
        text.setStroke(Color.rgb(138, 43, 226));
        text.setStrokeWidth(5);
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
     private void setupButton(Button button, int PlayerTurn) 
     {
        button.setOnMouseClicked(mouseEvent -> 
        {
            Draw(button,"O");
        });
    }
    
}
