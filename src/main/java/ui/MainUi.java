package ui;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.Files;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.NamedFunction;

public class MainUi {

  private String code = "";
  private Stage stage;
  private String title = "";
  private String currentFile = "";
  private CodeEditor editor = new CodeEditor(this.code);

  private final NamedFunction[] fileMenuCallbacks = {
      new NamedFunction("New File", () -> { this.code = ""; }),
      new NamedFunction("Open", () -> { openFile(); }),
      new NamedFunction("Save", () -> { this.save(); }),
      new NamedFunction("Save As", () -> { this.saveFile(this.stage); }),
      new NamedFunction("Preferences", () -> {}),
      new NamedFunction("Exit", () -> { exit(); }),
  };

  private void exit() { stage.close(); }

  private void setTitle(final String title) { this.stage.setTitle(title); }

  private void openFile() {
    FileChooser openFileDialog = new FileChooser();
    openFileDialog.setTitle("Open File");
    File openFile = openFileDialog.showOpenDialog(this.stage);

    if (openFile != null) {
      this.currentFile = openFile.getAbsolutePath();
      this.title = openFile.getName() + " ~ 8086.java";
      setTitle(this.title);
      try {
        this.editor.setCode(Files.readString(Paths.get(this.currentFile)));
      } catch (IOException e) {
      }
    }
  }

  private void save() {
    if (this.currentFile.equals("")) {
      this.saveFile(this.stage);
    } else {
      try (PrintWriter out = new PrintWriter(this.currentFile)) {
        out.println(this.editor.getCodeAndSnapshot());
      } catch (Exception e) {
      }
    }
  }

  private void saveFile(Stage stage) {

    FileChooser saveFile = new FileChooser();
    saveFile.setTitle("Save File");

    FileChooser.ExtensionFilter extFilter =
        new FileChooser.ExtensionFilter("Assembly files (*.asm)", "*.asm");
    saveFile.getExtensionFilters().add(extFilter);

    File outputFile = saveFile.showSaveDialog(stage);

    if (outputFile != null) {
      this.currentFile = outputFile.getAbsolutePath();

      try (PrintWriter out =
               new PrintWriter(outputFile.getAbsolutePath() + ".asm")) {
        out.println(this.editor.getCodeAndSnapshot());
      } catch (Exception e) {
      }
    }
  }

  public MainUi() {}

  private Menu getFileMenu() {
    Menu fileMenu = new Menu("File");

    for (NamedFunction nf : fileMenuCallbacks) {
      MenuItem m = new MenuItem(nf.getName());
      m.setOnAction((event) -> { nf.callFunction(); });
      fileMenu.getItems().add(m);
    }

    return fileMenu;
  }

  private VBox createMenu() {
    VBox menuBox = new VBox();
    MenuBar mainMenu = new MenuBar();

    mainMenu.getMenus().add(getFileMenu());

    menuBox.getChildren().addAll(mainMenu);
    return menuBox;
  }

  private VBox createEditor(CodeEditor editor) {
    final Button revertEdits = new Button("Revert edits");
    final Button runCode = new Button("Run");

    revertEdits.setOnAction((event) -> editor.revertEdits());

    runCode.setOnAction(
        (event) -> { System.out.println(editor.getCodeAndSnapshot()); });

    final HBox editorlayout = new HBox();
    editorlayout.getChildren().addAll(runCode, revertEdits);

    final VBox layout = new VBox();
    layout.getChildren().addAll(editor, editorlayout);
    layout.setStyle("-fx-background-color: grey; -fx-padding: 10;");
    return layout;
  }

  public void setupUi(Stage stage) {
    this.stage = stage;
    VBox mainVbox = new VBox();

    mainVbox.getChildren().add(createMenu());

    mainVbox.getChildren().add(this.createEditor(editor));

    Scene scene = new Scene(mainVbox);
    stage.setTitle("8086.java");
    stage.setScene(scene);
    stage.show();
  }
}
