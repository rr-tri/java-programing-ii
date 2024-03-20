package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane firstLayout = new GridPane();
        Label label = new Label("Enter your name and start");
        TextField input = new TextField();
        Button submit = new Button("Start");
        firstLayout.add(label, 0, 0);
        firstLayout.add(input, 0, 1);
        firstLayout.add(submit, 0, 2);

        firstLayout.setPrefSize(300, 180);
        firstLayout.setAlignment(Pos.CENTER);
        firstLayout.setVgap(10);
        firstLayout.setPadding(new Insets(20, 20, 20, 20));

       
        Label greeting = new Label("Welcome !");
        StackPane welcomeLayout = new StackPane();
        
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(greeting);
        welcomeLayout.setAlignment(Pos.CENTER);
        
         Scene firstView = new Scene(firstLayout);
        Scene secondView = new Scene(welcomeLayout);

        submit.setOnAction((e) -> {
            greeting.setText("Welcome " + input.getText() + "!");
            stage.setScene(secondView);
        });

        stage.setScene(firstView);
        stage.show();
    }
}
