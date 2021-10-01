package emulator.parser.models.errors;

public class UnterminatedQuoteException extends Exception {
  public String name;
  public int position, lineNumber;

  public UnterminatedQuoteException(int position,
                                    int lineNumber) {
    super();
    this.name = "Untermindated Quote";
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
