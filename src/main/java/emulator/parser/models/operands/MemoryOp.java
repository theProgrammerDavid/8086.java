package emulator.parser.models.operands;

import emulator.cpu.AddressingMode;
import util.Conversions;

/**
 * Instance of MemoryOp will have value as type int
 */
public class MemoryOp extends Operand {

  public AddressingMode type;
  public int value;

  public MemoryOp(String value, int position, int lineNumber)
      throws Exception, NumberFormatException {
    super(value, position, lineNumber);
    this.type = AddressingMode.MEMORY;
    this.size = 16;
    this.value = Conversions.toNumber(value.substring(1, -1))[0];
  }
}
