package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.application.Platform;
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
        TextArea input = new TextArea();
        Label l1 = new Label("Letters: 0");
        Label l2 = new Label("Words: 0");
        Label l3 = new Label("The longest word is:");

        input.textProperty().addListener((change, oldValue, newValue) -> {
            Platform.runLater(() -> {

                int characters = newValue.length();
                String[] parts = newValue.split(" ");
                int words = parts.length;
                String longest = Arrays.stream(parts)
                        .sorted((s1, s2) -> s2.length() - s1.length())
                        .findFirst()
                        .get();

                l1.setText("Letters: " + characters);
                l2.setText("Words: " + words);
                l3.setText("The longest word is: " + longest);

            });

        });

        layout.setCenter(input);

        HBox textLayout = new HBox();
        textLayout.getChildren().add(l1);
        textLayout.getChildren().add(l2);
        textLayout.getChildren().add(l3);
        textLayout.setSpacing(10);

        layout.setBottom(textLayout);

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }

}
