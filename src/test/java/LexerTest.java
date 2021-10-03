import emulator.Lexer;
import emulator.models.tokens.Comment;
import emulator.models.tokens.NewLine;
import emulator.models.tokens.Token;
import java.util.*;
import org.junit.jupiter.api.*;

@DisplayName("Lexer Test")
public class LexerTest {
  public static Lexer lexer;
  public static String code;

  @BeforeAll
  static void setup() {
    LexerTest.code = ";this is a comment\n"
                     + "MOV AX, 5; This is another comment\n"
                     + "MOV AX, 12\n"
                     + "MOV BX, 3";
  }

  @Test
  @DisplayName("Test 1")
  void SimpleTest() {
    LexerTest.lexer = new Lexer(code);
    ArrayList<Token> list = lexer.tokenize();

    for (Object i : list) {
      if (i instanceof Comment) {
        Comment c = (Comment)i;
        System.out.printf("Comment with name: %s, value: %s, line %d %d\n",
                          c.name, c.value, c.lineNumber, c.position);
      } else if (i instanceof NewLine) {
        NewLine n = (NewLine)i;
        System.out.printf("Newline at line %d %d with name %s and value %s\n",
                          n.lineNumber, n.position, n.name, n.value);
      } else {
        Token t = (Token)i;
        System.out.printf("Token at line %d, %d with value %s\n", t.lineNumber,
                          t.position, t.value);
      }
    }
  }
}
