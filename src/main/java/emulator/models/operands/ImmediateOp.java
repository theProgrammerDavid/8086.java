package emulator.models.operands;

import emulator.models.exceptions.*;
import util.Conversions;

public class ImmediateOp extends Operand {
  public String type;
  public int size;
  public int value;


  /**
   * 
   * @param value
   * @param position
   * @param lineNumber
   * @throws Exception
   * @throws InvalidTokenException
   */
  public ImmediateOp(String value, int position, int lineNumber)
      throws Exception, InvalidTokenException {
    super(value, position, lineNumber);
    this.type = "IMMEDIATE";

    int[] toNum = Conversions.toNumber(value);
    this.value = toNum[0];
    this.size = toNum[1];
  }
}
