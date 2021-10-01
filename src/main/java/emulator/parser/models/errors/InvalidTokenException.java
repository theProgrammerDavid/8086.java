package emulator.parser.models.errors;

public class InvalidTokenException extends Exception {
  public String name, token;
  public int position, lineNumber;

  public InvalidTokenException(String token, int position, int lineNumber) {
    super();
    this.name = "Invlaid Token";
    this.token = token;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
