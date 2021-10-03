import emulator.Lexer;
import emulator.Parser;
import emulator.models.Instruction;
import emulator.models.tokens.Token;
import java.util.*;
import org.junit.jupiter.api.*;

@DisplayName("Parser Test")
public class ParserTest {
  public static Lexer lexer;
  public static Parser parser;
  public static String code;

  @BeforeAll
  static void setup() {
    code = ";this is a comment\n"
           + "MOV AX, 5; This is another comment\n"
           + "MOV AX, 12\n"
           + "MOV BX, 3";
  }

  @Test
  @DisplayName("Test 1")
  void SimpleTest() {
    lexer = new Lexer(code);
    ArrayList<Token> tokens = lexer.tokenize();

    parser = new Parser(tokens);
    

    ArrayList<Instruction> list = parser.parse();
    for(Instruction i:list){
      System.out.printf("%s %s %s\n", i.mnemonic.value, i.op1.value, i.op2.value);
    }
  }
}
