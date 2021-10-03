package emulator;

import emulator.models.*;
import emulator.models.constants.*;
import emulator.models.exceptions.*;
import emulator.models.operands.*;
import emulator.models.tokens.*;
import java.util.*;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;

public class Lexer {

  private int position;
  private int lineNumber;
  private String buffer;
  private int bufferLength;

  public Lexer(final String buffer) {
    this.buffer = buffer;
    this.bufferLength = this.buffer.length();
  }

  public static boolean isNewLine(final String s) {
    // return Pattern.matches("^[\n\r]$", s);
    return s.compareTo("\n") == 0;
  }

  public static boolean isComment(final String s) {
    // return Pattern.matches("/^[;]$/", s);
    return s.compareTo(";") == 0;
  }
  public static boolean isAlpha(final String s) {
    return s.matches("[a-zA-Z]+");
  }
  public static boolean isNum(final String s) {
    try {
      Double.parseDouble(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  public static boolean isAlphaNum(final String s) {
    return s.matches("^[a-zA-Z0-9]*$");
  }
  public static boolean isBracket(final String s) {
    return Pattern.matches("\\[[^\\[]*\\]", s);
  }

  public static boolean isQuote(final String s) {
    return Pattern.matches("^[\'\"]", s);
  }

  public static boolean isSeparator(final String s) {
    return Pattern.matches("^[,]", s);
  }

  public void skipNonTokens() {
    while (this.position < this.bufferLength) {
      final String c = String.valueOf(this.buffer.charAt(this.position));
      if (ArrayUtils.contains(Constants.nonToken, c)) {
        this.position += 1;
      } else {
        break;
      }
    }
  }

  public Token processNewLine(final String c) {
    this.lineNumber += 1;
    final NewLine token = new NewLine(c, this.position, this.lineNumber);
    this.position += 1;
    return token;
  }

  public Token processComment() {
    int end = this.position + 1;
    while (end < this.bufferLength &&
           !Lexer.isNewLine(String.valueOf(this.buffer.charAt(end)))) {
            end += 1;
    }
    final Comment token = new Comment(this.buffer.substring(this.position, end),
                                      this.position, this.lineNumber);
    this.position = end;
    return token;
  }

  public Token processAlphaNum() throws InvalidTokenException {

    int end = this.position + 1;
    while (end < this.bufferLength &&
           Lexer.isAlphaNum(String.valueOf(this.buffer.charAt(end)))) {
      end += 1;
    }
    final String tok = this.buffer.substring(this.position, end);
    final String upperCaseTok = tok.toUpperCase();

    if (ArrayUtils.contains(Constants.instructionMnemonics, upperCaseTok)) {
      final Mnemonic token =
          new Mnemonic(upperCaseTok, this.position, this.lineNumber);
      this.position = end;
      return token;
    }

    if (ArrayUtils.contains(Constants.registers, upperCaseTok)) {
      final RegisterOp token =
          new RegisterOp(upperCaseTok, this.position, this.lineNumber);
      this.position = end;
      return token;
    }

    try {
      if (Pattern.matches("^(0X|0B|0|)[0-9A-F]+$", upperCaseTok)) {
        // ImmediateOp
        final ImmediateOp token =
            new ImmediateOp(upperCaseTok, this.position, this.lineNumber);
        this.position = end;
        return token;
      }

    } catch (final InvalidTokenException e) {
      throw new InvalidTokenException(upperCaseTok, position, lineNumber);
    } catch (final Exception e) {
    }
    // if no match
    throw new InvalidTokenException(upperCaseTok, position, lineNumber);
  }

  public Token processBrackets() throws Exception {
    final int end = this.buffer.indexOf("]", this.position + 1);
    if (end == -1) {
      throw new UnterminatedBracketException(position, lineNumber);
    }

    final String upperCaseTok =
        this.buffer.substring(this.position, end + 1).toUpperCase();

    final String relativeRegexStr = "/^\\[[A-Z]{2}\\+[A-Z]{2}\\]$/";
    final String memoryRegexStr = "\\[(0X|0B|0|)[0-9A-F]+\\]";
    Token token;
    if (Pattern.matches(memoryRegexStr, upperCaseTok)) {
      token = new MemoryOp(upperCaseTok, this.position, this.lineNumber);
      this.position = end + 1;
    } else if (Pattern.matches(relativeRegexStr, upperCaseTok)) {
      token = new RelativeOp(upperCaseTok, position, lineNumber);
      this.position = end + 1;
    } else {
      throw new InvalidTokenException(upperCaseTok, position, lineNumber);
    }

    return token;
  }

  public Token processQuote(final String quote)
      throws UnterminatedQuoteException {
    final int end = this.buffer.indexOf(quote, this.position + 1);
    if (end == -1) {
      throw new UnterminatedQuoteException(position, lineNumber);
    }

    final Token token = new StringToken(
        this.buffer.substring(this.position, end + 1), position, lineNumber);
    this.position = end + 1;
    return token;
  }

  public Token processSeparator(final String separator) {
    final int end = this.position + 1;

    final Token token = new Separator(separator, position, lineNumber);
    this.position = end;
    return token;
  }

  public Token nextToken() throws Exception {
    this.skipNonTokens();
    if (this.position >= this.bufferLength) {
      return null;
    }

    final String c = String.valueOf(this.buffer.charAt(this.position));
    System.out.println("Checking for " + c + " with position " + this.position);
    if (Lexer.isNewLine(c)) {
      return this.processNewLine(c);
    }

    if (Lexer.isComment(c)) {
      return this.processComment();
    }

    if (Lexer.isAlphaNum(c)) {
      return this.processAlphaNum();
    }

    if (Lexer.isBracket(c)) {
      return this.processBrackets();
    }

    if (Lexer.isQuote(c)) {
      return this.processQuote(c);
    }

    if (Lexer.isSeparator(c)) {
      return this.processSeparator(c);
    }

    throw new InvalidTokenException(c, position, lineNumber);
  }

  public ArrayList<Token> tokenize() {
    ArrayList<Token> tokens = new ArrayList<Token>();
    try {
      while (this.position < this.bufferLength) {
        System.out.printf("%d < %d\n", this.position, this.bufferLength);
        final Token nextTok = this.nextToken();

        System.out.println("next token");

        if (nextTok != null) {
          tokens.add(nextTok);
        }
      }

      tokens.add(new NewLine("\n", position + 1, lineNumber + 1));
    } catch (UnterminatedBracketException e) {
      e.printStackTrace();
    } catch (UnterminatedQuoteException e) {
      e.printStackTrace();
    } catch (InvalidTokenException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return tokens;
  }
}
