package util;

/**
 * Class to Instantiate ActionEvents and Event Handlers
 * Instead of using java.util.function.Function<T,R>, this uses util.Callback 
 * to create an interface which we then use to instantiate EventHandlers with 
 * the appropriate events.
 * 
 * eg. 
 * NamedFunction nf(...);
 * node.setOnAction((event) -> { nf.callFunction(); });
 */
public class NamedFunction {
  private String name;
  private Callback fn;

/**
 * @constructor
 * @param name String
 * @param callback util.Callback
 */

  public NamedFunction(final String name, Callback callback) {
    this.name = name;
    this.fn = callback;
  }


  /**
   * Returns name of the NamedFunction instance
   * @return String
   */
  public String getName() { return this.name; }

  /**
   * Blocking function call
   * @return void
   */
  public void callFunction() { fn.call(); }
}