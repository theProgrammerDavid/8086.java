package emulator.models.tokens;

public class Token {
  public String value;
  public int position, lineNumber;


  /**
   * 
   * @param value
   * @param position
   * @param lineNumber
   */
  public Token(String value, int position, int lineNumber) {
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
