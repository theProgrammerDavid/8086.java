package ui;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainUi {
    private String code = "";


    public MainUi(){

    }

    public void setupUi(Stage stage){
        CodeEditor editor = new CodeEditor(this.code);
        Scene scene = new Scene(editor.get());
        stage.setScene(scene);
        stage.show();
    }
    
}
