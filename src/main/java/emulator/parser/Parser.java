package emulator.parser;
import emulator.parser.models.Instruction;
import emulator.parser.models.Token;
import emulator.parser.models.errors.InvalidSyntaxException;
import java.util.ArrayList;

public class Parser {
  
  private ArrayList<Instruction> instructions;
  public Parser(Token[] tokens) { this.tokens = tokens; }

  static ArrayList<Instruction>
  getInstructionsFromTokens(ArrayList<Token> tokens) {
    ArrayList<Instruction> instructions = new ArrayList<>();
    tokens.forEach((token) -> {
      if (token.name.compareTo("NEWLINE") == 0) {
      }
    });
    return instructions;
  }

  public ArrayList<Instruction> parse(){

  }
}