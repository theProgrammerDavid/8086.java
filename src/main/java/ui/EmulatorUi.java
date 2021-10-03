package ui;

import emulator.Lexer;
import emulator.models.tokens.Comment;
import emulator.models.tokens.Token;
import java.util.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.NamedFunction;

public class EmulatorUi {
  private Scene scene;
  private double stepDelay;
  private String code;
  private Lexer lexer;

  public EmulatorUi() {
    this.setupScene();
    this.stepDelay = 0;
  }

  /**
   *
   * @param code String user's code
   */
  public void setCode(final String code) {
    this.code = code;
    System.out.printf("code is %s\n", code);
    this.lexer = new Lexer(this.code);
    System.out.println("Tokenizing");
    ArrayList<Token> list = lexer.tokenize();
    System.out.printf("Size is %d\n", list.size());
    for (Object i : list) {
      if (i instanceof Token) {
        Token t = (Token)i;
        System.out.printf("Token at line %d, %d with value \n", t.lineNumber, t.position, t.value );
      }
      else if(i instanceof Comment){
        Comment c = (Comment)i;
        System.out.printf("Comment with name: %s, value: %s, line %d %d\n", c.name, c.value, c.lineNumber, c.position);

      }
    }
  }

  private Node setupRegisterView() {
    VBox registerBox = new VBox();
    Label regionName = new Label("Registers");

    registerBox.getChildren().addAll(regionName);
    return registerBox;
  }

  private Node setupMemoryView() {
    VBox memBox = new VBox();

    return memBox;
  }

  private Node setupInstructionView() {
    VBox instructionBox = new VBox();

    return instructionBox;
  }

  private HBox setupActionBar() {
    HBox hbox = new HBox();

    Button loadButton = new Button("Load");
    loadButton.setOnAction((event) -> {});

    Button reloadButton = new Button("Reload");
    reloadButton.setOnAction((event) -> {});

    Button stepBackButton = new Button("Step Back");
    reloadButton.setOnAction((event) -> {});

    Button singleStepButton = new Button("Single Step");
    reloadButton.setOnAction((event) -> {});

    Button runButton = new Button("Run");
    reloadButton.setOnAction((event) -> {});

    Slider stepDelaySlider = new Slider(0, 2, 0.1f);
    stepDelaySlider.setShowTickLabels(true);
    stepDelaySlider.setMajorTickUnit(0.2f);
    stepDelaySlider.setBlockIncrement(0.2f);

    stepDelaySlider.valueProperty().addListener(
        (number, old, newVal) -> { this.stepDelay = newVal.intValue(); });

    hbox.getChildren().addAll(loadButton, reloadButton, stepBackButton,
                              singleStepButton, runButton, stepDelaySlider);

    return hbox;
  }
  private void setupScene() {
    VBox vBox = new VBox();
    HBox emulatorCompBox = new HBox();

    vBox.getChildren().addAll(setupActionBar());

    emulatorCompBox.getChildren().addAll(setupRegisterView(), setupMemoryView(),
                                         setupInstructionView());

    this.scene = new Scene(vBox);
  }
  public Scene getScene() { return this.scene; }
}
