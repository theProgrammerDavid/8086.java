package emulator.parser.models.operands;
import emulator.cpu.AddressingMode;

public class RegisterOp extends Operand {

  public AddressingMode type;

  public RegisterOp(String value, int position, int lineNumber) {
    super(value, position, lineNumber);
    this.type = AddressingMode.REGISTER;

    if (this.value.endsWith("L") || this.value.endsWith("H"))
      this.size = 8;
    else
      this.size = 16;
  }
}
