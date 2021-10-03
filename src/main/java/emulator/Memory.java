package emulator;

public class Memory {
  public final int MEM_SIZE = 1000;
  public int[] mem;

  public Memory() { this.mem = new int[this.MEM_SIZE]; }

  public void initializeMem() {
    for (int i = 0; i < this.MEM_SIZE; i++) {
      this.mem[i] = 0;
    }
  }

  /**
   *
   * @param addr
   * @param val
   * @throws Exception
   */
  public void set(int addr, int val) throws Exception {
    if (val > 65536) {
      throw new Exception(
          "Can't set greater than 16 bit value in memory location");
    }

    this.mem[addr] = val;
  }

  /**
   *
   * @param addr
   * @return
   */
  public int get(int addr) { return this.mem[addr]; }
}
