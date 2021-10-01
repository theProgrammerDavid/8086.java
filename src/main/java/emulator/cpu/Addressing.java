package emulator.cpu;
import emulator.cpu.models.*;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;
import org.apache.commons.lang3.ArrayUtils;
import emulator.parser.models.operands.*;

public class Addressing {
  private Memory memory;
  private Registers registers;

  public Addressing(final Memory mem, final Registers registers) {
    this.memory = mem;
    this.registers = registers;
  }

  public String get(Operand op, String value) throws Exception {
    if (op == null) {
      return null;
    }

    HashMap<String, Register> regs = this.registers.regs;

    switch (op.type) {
    case IMMEDIATE:
      return op.value;

    case REGISTER:
      if (op.value.charAt(1) == 'L' || op.value.charAt(1) == 'H') {
        final int[] prefixes = {'A', 'B', 'C', 'D'};
        if (!ArrayUtils.contains(prefixes, op.value.charAt(0))) {
          throw new Exception(
              "Only AX, BX, CX, DX registers can have 'L' or 'H' suffix");
        }
        final String index =
            MessageFormat.format("{}X", new Object[] {op.value.charAt(0)});

        final int result = regs.get(index).get(op.value.charAt(1) - '0');
        return String.valueOf(result);
      }
      return String.valueOf(regs.get(op.value).get(-1));

    case MEMORY:
      final Register val = regs.get("DS");
    //   final MemoryOp memOp = (MemoryOp) op;
      return this.memory.get(val.get(-1) + op.value, value);
      break;

    case RELATIVE:
      throw new Exception("Not Implemented yet");

    default:
      throw new Exception(
          "Invalid Addressing mode, should not happen normally");
    }
  }
}
