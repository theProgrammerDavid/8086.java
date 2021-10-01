package emulator.parser;
import static java.util.Map.entry;

import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;

public class Constants {
  private static final int bitmask(final int index) { return 0b1 << index; }

  public static final Map<String, Integer> flags = Map.ofEntries(
      entry("sign", bitmask(7)), entry("zero", bitmask(6)),
      entry("auxiliary", bitmask(4)), entry("carry", bitmask(0)),
      entry("overflow", bitmask(11)), entry("directional", bitmask(10)),
      entry("interrupt", bitmask(9)), entry("trap", bitmask(8)),
      entry("parity", bitmask(2)));

  public static final String[] instructionMnemonics = {
      "AAA",  "AAD",   "AAM",   "AAS",   "ADC",   "ADD",    "AND",    "CALL",
      "CBW",  "CLC",   "CLD",   "CLI",   "CMC",   "CMP",    "CMPSB",  "CMPSW",
      "CWD",  "DAA",   "DAS",   "DEC",   "DIV",   "HLT",    "IDIV",   "IMUL",
      "IN",   "INC",   "INT",   "INTO",  "IRET",  "JA",     "JAE",    "JB",
      "JBE",  "JC",    "JCXZ",  "JE",    "JG",    "JGE",    "JL",     "JLE",
      "JMP",  "JNA",   "JNAE",  "JNB",   "JNBE",  "JNC",    "JNE",    "JNG",
      "JNGE", "JNL",   "JNLE",  "JNO",   "JNP",   "JNS",    "JNZ",    "JO",
      "JP",   "JPE",   "JPO",   "JS",    "JZ",    "LAHF",   "LDS",    "LEA",
      "LES",  "LODSB", "LODSW", "LOOP",  "LOOPE", "LOOPNE", "LOOPNZ", "LOOPZ",
      "MOV",  "MOVSB", "MOVSW", "MUL",   "NEG",   "NOP",    "NOT",    "OR",
      "OUT",  "POP",   "POPA",  "POPF",  "PUSH",  "PUSHA",  "PUSHF",  "RCL",
      "RCR",  "REP",   "REPE",  "REPNE", "REPNZ", "REPZ",   "RET",    "RETF",
      "ROL",  "ROR",   "SAHF",  "SAL",   "SAR",   "SBB",    "SCASB",  "SCASW",
      "SHL",  "SHR",   "STC",   "STD",   "STI",   "STOSB",  "STOSW",  "SUB",
      "TEST", "XCHG",  "XLATB", "XOR",
  };

  public static final String[] nonToken = {" ", "\t"};
  public static final String[] mainRegisters = {
      "AX", "BX", "CX", "DX", "AL", "BL", "CL", "DL", "AH", "BH", "CH", "DH",
  };
  public static final String[] segmentRegisters = {"DS", "ES", "SS", "CS"};

  public static final String[] indexRegisters = {"DI", "SI", "BP", "SP"};
  public static final String[] registers = ArrayUtils.addAll(
      mainRegisters, ArrayUtils.addAll(indexRegisters, segmentRegisters));
}
