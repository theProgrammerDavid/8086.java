package util;

public class Conversions {
  public static final double log2 = Math.log(2);

  /**
   *
   * @param value String representation of number to be converted
   * @return int[2] - index 0 is the converted value in int. index 1 is the size
   *     in bits of the binary representation
   * @throws Exception, NumberFormatException
   */
  public static int[] toNumber(final String value)
      throws Exception, NumberFormatException {
    System.out.println("converting");
    int initVal = 0;
    if (value.startsWith("0B")) {
      initVal = Integer.parseInt(value, 2);
    } else if (value.startsWith("0X")) {
      initVal = Integer.parseInt(value, 16);
    } else if (value.startsWith("0")) {
      initVal = Integer.parseInt(value, 8);
    } else if (value.endsWith("H")) {
      initVal = Integer.parseInt(value.substring(0, value.length() - 1));
    } else {
      initVal = Integer.parseInt(value, 10);
    }

    final int size =
        (int)Math.ceil(Math.log((double)initVal) / Conversions.log2);
    if (initVal > 65536) {
      throw new Exception(
          "Value too large to convert. Only 16 bit numbers allowed");
    }

    int[] retVal = new int[2];
    retVal[0] = initVal;
    retVal[1] = size;
    return retVal;
  }

  public static final int getSize(final int initVal) throws Exception {
    final int size =
        (int)Math.ceil(Math.log((double)initVal) / Conversions.log2);
    if (initVal > 65536) {
      throw new Exception(
          "Value too large to convert. Only 16 bit numbers allowed");
    }

    return size;
  }
}
