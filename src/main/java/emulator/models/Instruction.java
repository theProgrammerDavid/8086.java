package emulator.models;
import emulator.models.tokens.Mnemonic;

public class Instruction {
  private Mnemonic mnemonic;
  public String op1, op2;

  /**
   *
   * @param mnemonic
   * @param op1
   * @param op2
   */
  public Instruction(Mnemonic mnemonic, String op1, String op2) {
    this.mnemonic = mnemonic;
    this.op1 = op1;
    this.op2 = op2;
  }
}