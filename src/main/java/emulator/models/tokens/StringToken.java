package emulator.models.tokens;

public class StringToken extends Token {
  public String name;

  
  /**
   * 
   * @param value
   * @param position
   * @param lineNumber
   */
  public StringToken(String value, int position, int lineNumber) {
    super(value, position, lineNumber);
    this.name = "STRING";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
