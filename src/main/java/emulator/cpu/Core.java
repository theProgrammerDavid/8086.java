package emulator.cpu;

import emulator.cpu.Addressing;
import emulator.cpu.Memory;
import emulator.cpu.Registers;
import emulator.parser.Constants;
import java.util.ArrayList;

public class Core {
  private Registers registers;
  private Memory memory;
  private Addressing addressing;
  
  public Core() {
    this.registers = new Registers();
    this.memory = new Memory();
    this.addressing = new Addressing(memory, registers);
  }


  public void loadCode(final String code)
}
