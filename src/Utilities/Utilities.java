package Utilities;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Utilities {

    /**
     * A helper method to set a stage with its scene and title and display it
     * @param stage - Stage object
     * @param parent - Parent object loaded from fxml
     * @param title - title to display on the window
     */
    public static void setAndShow(Stage stage, Parent parent, String title) {
        Scene scene = new Scene(parent);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
