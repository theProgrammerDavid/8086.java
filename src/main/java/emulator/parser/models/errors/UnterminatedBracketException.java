package emulator.parser.models.errors;

public class UnterminatedBracketException extends Exception {
  public String name;
  public int position, lineNumber;

  /**
   * 
   * @param position
   * @param lineNumber
   */
  public UnterminatedBracketException(int position,
                                      int lineNumber) {
    super();
    this.name = "Untermindated Bracket";
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
