package emulator.cpu;

public class Memory {
  public final int MEM_SIZE = 1000;
  private int[] memory;

  /**
   * @constructor
   */
  public Memory() {
    this.memory = new int[MEM_SIZE];
    this.initMem();
  }

  private void initMem() {
    for (int i = 0; i < MEM_SIZE; i++)
      memory[i] = 0;
  }

  /**
   * 
   * @param addr int memory address
   * @param val int 16 bit value 
   */
  public void set(final int addr, final int val) {
    if (val > 65536) {
      // throw error
      // can't set greater than 16 bit value in memory location
    }
    this.memory[addr] = val;
  }

  /**
   * 
   * @param addr int memory address
   * @return int value at that address
   */
  public int get(final int addr) { return this.memory[addr]; }
}