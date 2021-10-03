package emulator.models.tokens;

public class Mnemonic extends Token {
  public String name, value;

  /**
   * 
   * @param value
   * @param position
   * @param lineNumber
   */
  public Mnemonic(String value, int position, int lineNumber) {
    super(value, position, lineNumber);
    this.name = "MNEMONIC";
    this.value = value;
    this.position = position;
    this.lineNumber = lineNumber;
  }
}
