package emulator.cpu;
import emulator.cpu.models.*;
import java.util.HashMap;

public class Registers {
  public HashMap<String, Register> regs;
  public final String[] regNames = {"AX", "BX", "CX", "DX",   "IP",
                                     "DI", "SI", "BP", "SP",   "DS",
                                     "ES", "CS", "SS", "flags"};
                                     public final Register[] registers = {
      new Register(),    new Register(),    new Register(),
      new Register(),    new Register(),    new Register(),
      new Register(),    new Register(400), new Register(400),
      new Register(0),   new Register(400), new Register(600),
      new Register(200), new FlagRegister()};
  public Registers() {
    regs = new HashMap<>();

    for (int i = 0; i < regNames.length; i++) {
      regs.put(regNames[i], registers[i]);
    }
  }
}
