package emulator;

import emulator.models.Instruction;
import emulator.models.exceptions.*;
import emulator.models.operands.ImmediateOp;
import emulator.models.operands.MemoryOp;
import emulator.models.operands.RegisterOp;
import emulator.models.operands.RelativeOp;
import emulator.models.tokens.Mnemonic;
import emulator.models.tokens.Separator;
import emulator.models.tokens.Token;
import emulator.models.operands.Operand;
import java.util.ArrayList;

public class Parser {
  private ArrayList<ArrayList<Object>> rawInstructions;
  private ArrayList<Instruction> instructions;

  public Parser(ArrayList<Token> tokens) {
    this.rawInstructions = Parser.getInstructionsFromTokens(tokens);
    this.instructions = new ArrayList<>();
  }

  static ArrayList<ArrayList<Object>>
  getInstructionsFromTokens(ArrayList<Token> tokens) {
    ArrayList<ArrayList<Object>> inst = new ArrayList<>();
    ArrayList<Object> instruction = new ArrayList<>();

    tokens.forEach((token) -> {
      if (token == null)
        return;
      if (token.name.compareTo("NEWLINE") == 0) {
        if (instruction.size() > 0) {
          inst.add(new ArrayList<>(instruction));
        }
        instruction.clear();
      } else if (token.name.compareTo("COMMENT") != 0) {
        instruction.add(token);
        if (token instanceof ImmediateOp) {

        } else if (token instanceof MemoryOp) {

        } else if (token instanceof RegisterOp) {

        } else if (token instanceof RelativeOp) {

        } else if (token instanceof Separator) {
        }
      }
    });

    return inst;
  }

  public ArrayList<Instruction> parse() throws InvalidSyntaxException {


    this.rawInstructions.forEach((item) -> {
      if (item instanceof ArrayList) {

        ArrayList<Object> list = (ArrayList<Object>)item;

        if (list.size() > 4) {
          throw new InvalidSyntaxException(0, 0);
        }
        if (list.size() > 2 && !(list.get(2) instanceof Separator)) {
          throw new InvalidSyntaxException(0, 0);
        }
        System.out.printf("%s %s %s\n", list.get(0), list.get(1),
        list.get(3)); this.instructions.add(new Instruction(
            (Mnemonic)list.get(0), (Operand)list.get(1), (Operand)list.get(3)));
      }
    });

    return this.instructions;
  }
}
