package emulator.cpu.models;

public class Register {
  public int l;
  public int h;
  public int value;

  /**
   *
   * @param value int Initial value of the register
   */
  public Register(final int value) {
    this.l = 0;
    this.h = 0;
    this.value = value;
  }

  public Register() {
    this.l = 0;
    this.h = 0;
    this.value = 0;
  }

  /**
   *
   * @param half int -1 for complete value, 0 for value in L register, 1 for
   *     value in H register
   * @return int value in the specified register
   */
  public int get(final int half) {
    if (half == -1) {
      return this.value;
    }

    if (half == 0)
      return this.l;
    else
      return this.h;
  }

  /**
   *
   * @param value
   * @param half int -1 for complete value, 0 for value in L register, 1 for
   *     value in H register
   */
  public void set(final int value, final int half) {
    if (value > 256) {
      // 256 is 2**8
      // throw error
    } else if (value > 65536) {
      // 65536 is 2**16
      // throw error
    }

    if (value == -1) {
      this.value = value;
      this.l = (int)(value & 255);
      this.h = (int)(value >>> 8);
      return;
    }

    if (value == 0) {
      this.l = (int)value;
    } else if (value == 1) {
      this.h = (int)value;
    }

    this.value = (int)((this.h << 8) + this.l);
  }
}
