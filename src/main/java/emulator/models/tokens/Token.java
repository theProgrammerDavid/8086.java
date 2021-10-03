package emulator.models.tokens;

public class Token {
  public String value, name;
  public int position, lineNumber;


  /**
   * 
   * @param value
   * @param position
   * @param lineNumber
   */
  public Token(String name, String value, int position, int lineNumber) {
    this.name = name;
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
