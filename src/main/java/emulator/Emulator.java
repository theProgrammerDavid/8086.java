package emulator;
import java.util.ArrayList;

import emulator.cpu.Core;
import emulator.parser.Lexer;
import emulator.parser.Parser;
import emulator.parser.models.Token;

public class Emulator {
  private Core cpu;

  public Emulator() { this.cpu = new Core(); }

  public void loadCode(final String code){
    ArrayList<Token> tokens = new Lexer(code).tokenize()
    
  }
}
