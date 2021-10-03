package emulator.models.exceptions;

public class InvalidTokenException extends Exception {
  public String name, token;
  public int position, lineNumber;

  /**
   * 
   * @param token
   * @param position
   * @param lineNumber
   */
  public InvalidTokenException(String token, int position, int lineNumber) {
    super();
    this.name = "Invlaid Token";
    this.token = token;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}