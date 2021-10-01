package emulator.parser.models;

public class Instruction {
  public String mnemonic, op1, op2;

  public Instruction(String mnemonic, String op1, String op2) {
    this.mnemonic = mnemonic;
    this.op1 = op1;
    this.op2 = op2;
  }
}
