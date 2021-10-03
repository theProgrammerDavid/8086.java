package emulator;

import emulator.models.Registers;

public class Cpu {
  private Memory memory;
  private Registers registers;

  public Cpu() {
    this.memory = new Memory();
    this.registers = new Registers();
  }
}
