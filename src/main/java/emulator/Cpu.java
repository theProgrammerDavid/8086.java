package emulator;

import emulator.models.Register;
import emulator.models.Registers;
import java.util.HashMap;

public class Cpu {
  private Memory memory;
  private Registers registers;

  public Cpu() {
    this.memory = new Memory();
    this.registers = new Registers();
  }

  public HashMap<String, Register> getRegisters() {
    return this.registers.regs;
  }

  public Memory getMemory() { return this.memory; }
}
