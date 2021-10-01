package emulator.parser.models;
import emulator.parser.models.operands.Operand;

public class Mnemonic extends Operand{
  public String name, value;
  int position, lineNumber;

  public Mnemonic(String value, int position, int lineNumber) {
    super(value,position,lineNumber);
    this.name = "MNEMONIC";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
