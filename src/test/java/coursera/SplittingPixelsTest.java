package coursera;

import org.junit.Test;

import static org.junit.Assert.*;

public class SplittingPixelsTest {

  @Test
  public void splittingPixels() {
    SplittingPixels splittingPixels = new SplittingPixels();
    String[] test1 = new String[] {
          "101111010110011011100100"
        , "110000010101011111101111"
        , "100110101100111111101101"
        , "010111011010010110000011"
        , "000000001111111111111111"};
    assertArrayEquals(new String[] {"White", "White","White","Green","Ambiguous"}, splittingPixels.splittingPixels(test1));
  }
}