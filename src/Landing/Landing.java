package Landing;

import Utilities.Utilities;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class Landing extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = load(getClass().getResource("Landing.fxml"));
        String title = "Office Elo";

        Utilities.setAndShow(primaryStage, root, title);
    }
}
