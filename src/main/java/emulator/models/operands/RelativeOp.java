package emulator.models.operands;

public class RelativeOp extends Operand {

  public String type;

  /**
   * 
   * @param value
   * @param position
   * @param lineNumber
   */
  public RelativeOp(String value, int position, int lineNumber) {
    super(value, position, lineNumber);
    this.type = "RELATIVE";
    this.size = 16;
  }
}