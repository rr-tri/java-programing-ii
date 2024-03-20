package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        GridPane gridPane = new GridPane();

        Button nav2 = new Button("To the second view!");
        borderPane.setTop(new Label("First view!"));
        borderPane.setCenter(nav2);

        Button nav3 = new Button("To the third view!");
        vBox.getChildren().addAll(nav3, new Label("Second view!"));

        gridPane.add(new Label("Third view!"), 0, 0);
        Button nav1 = new Button("To the first view!");
        gridPane.add(nav1, 1, 1);

        Scene firstView = new Scene(borderPane);
        Scene secondView = new Scene(vBox);
        Scene thirdView = new Scene(gridPane);

        nav2.setOnAction((event) -> stage.setScene(secondView));
        nav3.setOnAction((event) -> stage.setScene(thirdView));
        nav1.setOnAction((event) -> stage.setScene(firstView));

        stage.setScene(firstView);
        stage.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}
