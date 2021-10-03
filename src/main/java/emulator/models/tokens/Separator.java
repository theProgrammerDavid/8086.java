package emulator.models.tokens;

public class Separator extends Token {
  public String name, value;

  /**
   *
   * @param value
   * @param position
   * @param lineNumber
   */
  public Separator(String value, int position, int lineNumber) {
    super("SEPARATOR", value, position, lineNumber);
    this.name = "SEPARATOR";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
