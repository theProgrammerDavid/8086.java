import javafx.application.Application;
import javafx.stage.Stage;

import ui.MainUi;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
       new MainUi().setupUi(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}