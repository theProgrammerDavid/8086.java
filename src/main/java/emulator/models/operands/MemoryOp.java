package emulator.models.operands;

import util.Conversions;

/**
 * Instance of MemoryOp will have value as type int
 */
public class MemoryOp extends Operand {

  public String type;
  public int value;

  /**
   * 
   * @param value
   * @param position
   * @param lineNumber
   * @throws Exception
   * @throws NumberFormatException
   */
  public MemoryOp(String value, int position, int lineNumber)
      throws Exception, NumberFormatException {
    super(value, position, lineNumber);
    this.type = "MEMORY";
    this.size = 16;
    this.value = Conversions.toNumber(value.substring(1, -1))[0];
  }
}