package emulator.parser.models.operands;

import emulator.cpu.AddressingMode;
import emulator.parser.models.Token;

public class Operand extends Token{
  public String name;
  public String value;
  public AddressingMode type;
  /**
   *
   * @param value
   * @param position
   * @param lineNumber
   */
  public Operand(String value, int position, int lineNumber) {
    super("OPERAND", value);
    
    this.value = value;
    this.name = "OPERAND";
    this.size = 0;
    this.position = position;
    this.lineNumber = lineNumber;
  }
  public int size, position, lineNumber;
}
