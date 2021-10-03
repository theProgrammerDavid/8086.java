package emulator.models.exceptions;

public class UnterminatedBracketException extends Exception {
  public String name;
  public int position, lineNumber;

  /**
   *
   * @param position
   * @param lineNumber
   */
  public UnterminatedBracketException(int position, int lineNumber) {
    super();
    this.name = "Untermindated Bracket";
    this.position = position;
    this.lineNumber = lineNumber;
  }
}