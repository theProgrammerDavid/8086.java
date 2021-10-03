package emulator.models.exceptions;

public class InvalidSyntaxException extends Error {

  public String name;
  public int position, lineNumber;

  /**
   * 
   * @param token
   * @param position
   * @param lineNumber
   */
  public InvalidSyntaxException(int position, int lineNumber) {
    super();
    this.name = "Syntax Error";
    this.position = position;
    this.lineNumber = lineNumber;
  }
}