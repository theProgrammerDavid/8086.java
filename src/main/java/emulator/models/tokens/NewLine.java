package emulator.models.tokens;

public class NewLine extends Token {
  public String name, value;

  /**
   *
   * @param value
   * @param position
   * @param lineNumber
   */
  public NewLine(String value, int position, int lineNumber) {
    super("NEWLINE", value, position, lineNumber);
    this.name = "NEWLINE";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
