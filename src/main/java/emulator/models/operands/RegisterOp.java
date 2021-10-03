package emulator.models.operands;

public class RegisterOp extends Operand {

  public String type;

  /**
   * 
   * @param value
   * @param position
   * @param lineNumber
   */
  public RegisterOp(String value, int position, int lineNumber) {
    super(value, position, lineNumber);
    this.type = "REGISTER";

    if (this.value.endsWith("L") || this.value.endsWith("H"))
      this.size = 8;
    else
      this.size = 16;
  }
}