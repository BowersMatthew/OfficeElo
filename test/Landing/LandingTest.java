package Landing;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class LandingTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Landing.class.getResource("Landing.Fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Before
    public void setUp() throws Exception {
        ApplicationTest.launch(Landing.class);
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void mainWindowExists() {
        AnchorPane anchor = GuiTest.find("#landingAnchor");
        assertNotNull(anchor);
    }
}