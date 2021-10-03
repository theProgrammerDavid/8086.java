package emulator.models;

public class FlagRegister extends Register {

  public FlagRegister(int value) { super(value); }

  public FlagRegister() { super(); }

  public void setFlag(final int flag) {
    final int param = this.get((short)-1) | flag;
    this.set(this.get(param), -1);
  }

  public void unsetFlag(final int flag) {
    final int param = this.get(-1) & ~flag;
    this.set(this.get(param), -1);
  }

  public int getFlag(final int flag) {
    return (this.get(-1) & flag) == 0 ? 0 : 1;
  }
}
