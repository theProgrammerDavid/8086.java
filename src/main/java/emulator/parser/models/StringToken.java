package emulator.parser.models;
import emulator.parser.models.operands.Operand;

public class StringToken extends Operand {
  public String name, value;
  public int position, lineNumber;

  public StringToken(String value, int position, int lineNumber) {
    super(value, position, lineNumber);
    this.name = "STRING";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
