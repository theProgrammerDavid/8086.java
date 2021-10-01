package emulator.parser.models;
import emulator.parser.models.operands.Operand;

public class Comment extends Operand {
  public String name, value;
  public Comment(String value, int position, int lineNumber) {
    super(value, position, lineNumber);
    this.name = "COMMENT";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }

  public int position, lineNumber;
}
