package emulator.parser.models;
import emulator.parser.models.operands.Operand;

public class NewLine extends Operand {
  public String name, value;
  int position, lineNumber;

  public NewLine(String value, int position, int lineNumber) {
    super(value, position, lineNumber);
    this.name = "NEWLINE";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
