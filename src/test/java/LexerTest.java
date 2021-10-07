import emulator.Lexer;
import emulator.models.operands.ImmediateOp;
import emulator.models.operands.MemoryOp;
import emulator.models.operands.Operand;
import emulator.models.tokens.Comment;
import emulator.models.tokens.Mnemonic;
import emulator.models.tokens.NewLine;
import emulator.models.tokens.Token;
import java.util.*;
import org.junit.jupiter.api.*;

@DisplayName("Lexer Test")
public class LexerTest {
  public static Lexer lexer;
  public static String code;
  public static String immediateCode;

  @BeforeAll
  static void setup() {
    LexerTest.code = ";this is a comment\n"
                     + "MOV AX, 5; This is another comment\n"
                     + "MOV AX, 12\n"
                     + "MOV BX, 3";

    LexerTest.immediateCode = ";this is a comment\n"
                              + "MOV AX, 5; This is another comment\n"
                              + "MOV AX, 12\n"
                              + "MOV [500H], 30\n"
                              + "MOV BX, 3";
  }

  // @Test
  @DisplayName("Test 1")
  void SimpleTest() {
    LexerTest.lexer = new Lexer(code);
    ArrayList<Token> list = lexer.tokenize();

    for (Token i : list) {
      if (i instanceof Comment) {
        Comment c = (Comment)i;
        System.out.printf("Comment with name: %s, value: %s, line %d %d\n",
                          c.name, c.value, c.lineNumber, c.position);
      } else if (i instanceof NewLine) {
        NewLine n = (NewLine)i;
        System.out.printf("Newline at line %d %d with name %s and value %s\n ",
                          n.lineNumber, n.position, n.name, n.value);
      } else if (i instanceof Mnemonic) {
        Mnemonic m = (Mnemonic)i;
        System.out.printf("Mnemonic %d %d %s %s\n", m.lineNumber, m.position,
                          m.name, m.value);
      } else if (i instanceof ImmediateOp) {
        ImmediateOp op = (ImmediateOp)i;
        System.out.printf(
            "ImmediateOp at line %d % d with name and value %s %s \n",
            op.lineNumber, op.position, op.name, op.value);
      } else if (i instanceof Operand) {
        Operand op = (Operand)i;
        System.out.printf("Operand at %d %d %s %s\n", op.lineNumber,
                          op.position, op.name, op.value);
      }
    }
  }


  @Test
  @DisplayName("Test 2")
  void ImmediateTest() {
    LexerTest.lexer = new Lexer(immediateCode);
    ArrayList<Token> list = lexer.tokenize();

    for (Token i : list) {
      if (i instanceof Comment) {
        Comment c = (Comment)i;
        System.out.printf("Comment with name: %s, value: %s, line %d %d\n",
                          c.name, c.value, c.lineNumber, c.position);
      } else if (i instanceof NewLine) {
        NewLine n = (NewLine)i;
        System.out.printf("Newline at line %d %d with name %s and value %s\n ",
                          n.lineNumber, n.position, n.name, n.value);
      } else if (i instanceof Mnemonic) {
        Mnemonic m = (Mnemonic)i;
        System.out.printf("Mnemonic %d %d %s %s\n", m.lineNumber, m.position,
                          m.name, m.value);
      } else if (i instanceof ImmediateOp) {
        ImmediateOp op = (ImmediateOp)i;
        System.out.printf(
            "ImmediateOp at line %d % d with name and value %s %s \n",
            op.lineNumber, op.position, op.name, op.value);
      } 
      else if(i instanceof MemoryOp){
        MemoryOp op = (MemoryOp)i;
        System.out.printf(
            "MemoryOp at line %d % d with name and value %s %s \n",
            op.lineNumber, op.position, op.name, op.value);
      }
      
      else if (i instanceof Operand) {
        Operand op = (Operand)i;
        System.out.printf("Operand at %d %d %s %s\n", op.lineNumber,
                          op.position, op.name, op.value);
      }
    }
  }
}
