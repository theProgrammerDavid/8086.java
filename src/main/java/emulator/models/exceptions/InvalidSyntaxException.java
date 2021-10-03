package emulator.models.exceptions;

public class InvalidSyntaxException extends Error {

  public String name;
  public int position, lineNumber;

  public InvalidSyntaxException(String token, int position, int lineNumber) {
    super();
    this.name = "Syntax Error";
    this.position = position;
    this.lineNumber = lineNumber;
  }
}