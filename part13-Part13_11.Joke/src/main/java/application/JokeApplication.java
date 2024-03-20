package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button first = new Button("Joke");
        Button second = new Button("Answer");
        Button third = new Button("Explanation");
        menu.getChildren().addAll(first, second, third);

        layout.setTop(menu);

        StackPane firstLayout = createView("What do you call a bear with no teeth?");
        StackPane secondLayout = createView("A gummy bear.");
        StackPane thirdLayout = createView("The humor in the joke comes from the unexpected connection between a bear, a large and powerful animal, and the term \"gummy bear,\" which typically refers to small, colorful, chewy candies. By imagining a bear without teeth, it conjures up a comical image of a bear that would have difficulty eating its usual prey or food. Instead, it would resemble the soft and chewy texture of a gummy bear candy, hence the punchline \"A gummy bear.\"");

        first.setOnAction((event) -> layout.setCenter(firstLayout));
        second.setOnAction((event) -> layout.setCenter(secondLayout));
        third.setOnAction((event) -> layout.setCenter(thirdLayout));
        
        layout.setCenter(firstLayout);
        
        Scene scene = new Scene(layout);
        
        stage.setScene(scene);
        stage.show();

    }

    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.setPadding(new Insets(10, 10, 10, 10));
        Label t = new Label(text);
        t.setWrapText(true);
        layout.getChildren().add(t);
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
