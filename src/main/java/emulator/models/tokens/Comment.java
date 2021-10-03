package emulator.models.tokens;

public class Comment extends Token {
  public String name, value;

  /**
   * 
   * @param value
   * @param position
   * @param lineNumber
   */
  public Comment(String value, int position, int lineNumber) {
    super("COMMENT",value, position, lineNumber);
    this.name = "COMMENT";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
