package emulator;

import emulator.Cpu;
import emulator.models.Register;
import java.util.HashMap;

public class Emulator {
  private Cpu cpu;

  public Emulator() { this.cpu = new Cpu(); }

  /**
   *
   * @return Memory
   */
  public Memory getMemory() { return this.cpu.getMemory(); }

  /**
   * 
   * @return HashMap<String,Register>
   */
  public HashMap<String, Register> getRegisters() {
    return this.cpu.getRegisters();
  }

  /**
   *
   * @param code String
   */
  public void loadCode(final String code) {}
}