package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class ButtonAndLabelApplication extends Application {

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button buttonComponent = new Button("This is a button");
        Label textComponent = new Label("Text element");

        FlowPane componentGroup = new FlowPane();

        componentGroup.getChildren().add(textComponent);
        componentGroup.getChildren().add(buttonComponent);
        Scene view = new Scene(componentGroup);

        stage.setScene(view);
        stage.show();

    }

}
