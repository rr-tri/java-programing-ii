package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
       launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
       Button buttonComponent = new Button("This is a button");
        TextField textComponent = new TextField();

        FlowPane componentGroup = new FlowPane();

        componentGroup.getChildren().add(textComponent);
        componentGroup.getChildren().add(buttonComponent);
        Scene view = new Scene(componentGroup);

        stage.setScene(view);
        stage.show();
    }

}
