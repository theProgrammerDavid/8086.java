package util;

public class NamedFunction {
  private String name;
  private Callback fn;

  public NamedFunction(final String name, Callback callback) {
    this.name = name;
    this.fn = callback;
  }

  public String getName() { return this.name; }

  public void callFunction() { fn.call(); }
}