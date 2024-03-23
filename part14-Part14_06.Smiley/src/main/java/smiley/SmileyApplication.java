package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(400, 400);

        root.setCenter(canvas);

        GraphicsContext painter = canvas.getGraphicsContext2D();

        painter.setFill(Color.BLACK);
        /*
        .fillRect(x,y,w,h);
        Parameters:
            x - the X position of the upper left corner of the rectangle.
            y - the Y position of the upper left corner of the rectangle.
            w - the width of the rectangle.
            h - the height of the rectangle. 
        
         */
        painter.fillRect(125, 60, 50, 50);
        painter.fillRect(225, 60, 50, 50);
        painter.fillRect(125, 225, 150, 50);
        painter.fillRect(75, 175, 50, 50);
        painter.fillRect(275, 175, 50, 50);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
