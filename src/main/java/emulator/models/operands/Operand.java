package emulator.models.operands;

import emulator.models.tokens.Token;

public class Operand extends Token {
  public String name;
  public String value;
  public int size, position, lineNumber;

  /**
   *
   * @param value
   * @param position
   * @param lineNumber
   */
  public Operand(String value, int position, int lineNumber) {
    super("OPERAND",value, position, lineNumber);
    this.value = value;
    this.name = "OPERAND";
    this.size = 0;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}