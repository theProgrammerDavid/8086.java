package ui;

import emulator.Emulator;
import emulator.Lexer;
import emulator.Memory;
import emulator.Parser;
import emulator.models.Instruction;
import emulator.models.Register;
import emulator.models.tokens.Comment;
import emulator.models.tokens.Token;
import java.util.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.NamedFunction;

public class EmulatorUi {
  private Scene scene;
  private double stepDelay;
  private String code;
  private Lexer lexer;
  private Parser parser;

  private Emulator emulator;

  public EmulatorUi() {
    this.emulator = new Emulator();
    this.setupScene();
    this.stepDelay = 0;
  }

  /**
   *
   * @param code String user's code
   */
  public void setCode(final String code) {
    this.code = code;

    this.lexer = new Lexer(this.code);
    ArrayList<Token> list = lexer.tokenize();
    this.parser = new Parser(list);

    System.out.printf("Size is %d\n", list.size());

    ArrayList<Instruction> instructions = this.parser.parse();
    for (Instruction i : instructions) {
      System.out.println(i.toString());
    }
  }

  private GridPane setupRegisterView() {

    GridPane registerPane = new GridPane();
    registerPane.add(new Label("Registers"), 1, 0);
    registerPane.getStyleClass().add("registerPane");

    Label ax = new Label("AX");
    Label bx = new Label("AX");
    Label cx = new Label("AX");
    Label dx = new Label("AX");
    Label h = new Label("H");
    Label l = new Label("L");
    Label space = new Label(" ");

    HBox headers = new HBox();
    registerPane.add(h, 1, 1);
    registerPane.add(l, 2, 1);

    Map<String, Register> m = this.emulator.getRegisters();
    int row = 2;
    registerPane.add(new Label("AX"), 0, row);
    registerPane.add(new Label(String.valueOf(m.get("AX"))), 0, row);
    registerPane.add(new Label("AX"), 0, row);

    // for (Map.Entry<String, Register> set :
    //      this.emulator.getRegisters().entrySet()) {

    //   if (set.getKey().compareTo("AX") == 0 ||
    //       set.getKey().compareTo("BX") == 0 ||
    //       set.getKey().compareTo("CX") == 0 ||
    //       set.getKey().compareTo("DX") == 0) {
    //     registerPane.add(new Label(set.getKey()), 0, row);
    //     registerPane.add(new Label(String.valueOf(set.getValue().h)), 1,
    //     row); registerPane.add(new Label(String.valueOf(set.getValue().l)),
    //     2, row);
    //   } else {
    //     registerPane.add(new Label(set.getKey()), 0, row);
    //     registerPane.add(new Label(String.valueOf(set.getValue().value)), 1,
    //                      row);
    //   }

    //   row++;
    // }

    return registerPane;
  }

  private VBox setupMemoryView() {
    VBox memBox = new VBox();
    Memory mem = this.emulator.getMemory();
    Label regionName = new Label("Memory");

    ListView<String> memList = new ListView<String>();

    for (int i = 0; i < mem.MEM_SIZE; i++) {

      memList.getItems().add(new String(i + " " + mem.mem[i]));
    }
    memList.setPrefWidth(150);
    memBox.getChildren().addAll(regionName, memList);
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
    emulatorCompBox.setSpacing(5);
    emulatorCompBox.getChildren().addAll(setupRegisterView(), setupMemoryView(),
                                         setupInstructionView());

    vBox.getChildren().add(emulatorCompBox);
    this.scene = new Scene(vBox);
    System.out.println("Working Directory = " + System.getProperty("user.dir"));
    // this.scene.getStylesheets().add("src/main/java/assets/css/style.css");
    this.scene.getStylesheets().add("./src/main/java/ui/ui.css");
  }
  public Scene getScene() { return this.scene; }
}
