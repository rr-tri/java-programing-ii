package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        layout.setCenter(new TextArea("text area"));
        
        HBox textLayout = new HBox();
        textLayout.getChildren().add(new Label("Letters: 0"));
        textLayout.getChildren().add(new Label("Words: 0"));
        textLayout.getChildren().add(new Label("The longest word is:"));
        textLayout.setSpacing(10);
        
        layout.setBottom(textLayout);
        
        Scene scene = new Scene(layout);
        
        stage.setScene(scene);
        stage.show();
    }

}
