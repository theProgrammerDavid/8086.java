package emulator.parser.models;
import emulator.parser.models.operands.Operand;

public class Separator extends Operand {
  public String name, value;
  public int position, lineNumber;

  public Separator(String value, int position, int lineNumber) {
    super(value, position, lineNumber);
    this.name = "SEPARATOR";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
