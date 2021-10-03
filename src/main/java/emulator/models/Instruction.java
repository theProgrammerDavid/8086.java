package emulator.models;
import emulator.models.operands.Operand;
import emulator.models.tokens.Mnemonic;

public class Instruction {
  public Mnemonic mnemonic;
  public Operand op1, op2;

  /**
   *
   * @param mnemonic
   * @param op1
   * @param op2
   */
  public Instruction(Mnemonic mnemonic, Operand op1, Operand op2) {
    this.mnemonic = mnemonic;
    this.op1 = op1;
    this.op2 = op2;
  }
}