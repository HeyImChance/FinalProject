package chessexample;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class chessExample extends Application {
    
    GridPane root;
    StackPane[][] board;

    @Override
    public void start(Stage primaryStage) {
        
        createBoard();
        
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
        
        Pane t = new Pane();
        DraggableImageView background = new DraggableImageView(new Image("Capture.PNG", 40, 40, true, true, true));
        t.getChildren().add(background);
        root.add(t, 1, 0);
        
        

    }
    
    public static class DraggableImageView extends ImageView {
        private double mouseX ;
        private double mouseY ;
        public DraggableImageView(Image image) {
            super(image);

            setOnMousePressed(event -> {
                mouseX = event.getSceneX() ;
                mouseY = event.getSceneY() ;
            });

            setOnMouseDragged(event -> {
               double deltaX = event.getSceneX() - mouseX ;
               double deltaY = event.getSceneY() - mouseY ;
               relocate(getLayoutX() + deltaX, getLayoutY() + deltaY);
               mouseX = event.getSceneX() ;
               mouseY = event.getSceneY() ;
            });
            

        }
    }
    
    public void createBoard(){
        
        this.root = new GridPane();
        root.setAlignment(Pos.CENTER);
        final int size = 8 ;
        this.board = new StackPane[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                StackPane square = new StackPane();
                String color ;
                if ((row + col) % 2 == 0) {
                    color = "white";
                } else {
                    color = "green";
                }
                square.setStyle("-fx-background-color: "+color+";");
                root.add(square, col, row);
                board[col][row] = square;
            }
        }
        for (int i = 0; i < size; i++) {
            root.getColumnConstraints().add(new ColumnConstraints(0, 200, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            root.getRowConstraints().add(new RowConstraints(0, 200, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

