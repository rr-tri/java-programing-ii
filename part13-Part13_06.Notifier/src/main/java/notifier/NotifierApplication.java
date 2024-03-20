package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox layout = new VBox();
        TextField text = new TextField();
        Button update = new Button("Update");
        Label textLabel = new Label("");
        
        update.setOnAction((e) -> {
            textLabel.setText(text.getText());
        });
        
        layout.getChildren().add(text);
        layout.getChildren().add(update);
        layout.getChildren().add(textLabel);
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
    

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }
    
}
