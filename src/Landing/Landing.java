package Landing;

import Utilities.Database.dbConnection;
import Utilities.Utilities;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

import static javafx.fxml.FXMLLoader.load;

public class Landing extends Application {

    public static void main(String[] args) {
        dbConnection.checkUpdates();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = load(getClass().getResource("Landing.fxml"));
        String title = "Office Elo";

        Utilities.setAndShow(primaryStage, root, title);
    }
}
