
import chessexample.chessExample.DraggableImageView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Start extends Application {
	
	
	Button startButton;
	Label player1, player2;
	FlowPane pane1, pane2;
    Scene startScene, gameBoard;
    Stage thestage;
    GridPane root;
    StackPane[][] board;
    
    
    public void menu(Stage PrimaryStage) {
    	
    	thestage = PrimaryStage;
    Scene scene = new Scene(new Group());
    PrimaryStage.setTitle("Get Started");
    PrimaryStage.setWidth(800);
    PrimaryStage.setHeight(800);
    
    VBox vbox = new VBox();
    vbox.setLayoutX(20);
    vbox.setLayoutY(20);
    
    Image playIcon = new Image(getClass().getResourceAsStream("play.png"));
    
    Button startButton = new Button("Play");
    startButton.setGraphic(new ImageView(playIcon));
    startButton.setOnAction(e-> ButtonClicked(e));
    	
    
    vbox.getChildren().add(startButton);
    vbox.setSpacing(10);
    ((Group)scene.getRoot()).getChildren().add(vbox);
    
    pane1 = new FlowPane();
    pane2 = new FlowPane();
    pane1.setVgap(10);
    pane2.setVgap(10);
    
   // Image background = new Image()    Set background as image?
    
    pane1.setStyle("-fx-background-color: tan; -fx-padding: 10px;");
    //make pane2 the gameboard instead!
    
    startScene = new Scene(pane1, 800, 800);
    gameBoard = new Scene(pane2, 800, 800);
    
    PrimaryStage.setTitle("Chess Game!");
    PrimaryStage.setScene(startScene);
    PrimaryStage.show();
    	}


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
    
	public void ButtonClicked(ActionEvent e)
    {
        if (e.getSource()==startButton)
            thestage.setScene(gameBoard);
        else
            thestage.setScene(startScene);
    }

   /* 
    @Override
    public void start(Stage primaryStage) {
        
        createBoard();
        
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
        
        Pane t = new Pane();
       
    
        root.add(t, 1, 0);
        
        

    }
    
public void createBoard(){
        
        this.root = new GridPane();
        root.setAlignment(Pos.CENTER);
        final int size = 8 ;
        this.board = new StackPane[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                StackPane square = new StackPane();
            
                
                square.setStyle("-fx-background-color: "+color+";");
                root.add(square, col, row);
                board[col][row] = square;
            }
        }
      
        
    }    */
}
    
