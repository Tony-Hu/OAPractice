package coursera;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumUniqueArraySumTest {

  @Test
  public void getMinimumUniqueSum() {
    MinimumUniqueArraySum minimumUniqueArraySum = new MinimumUniqueArraySum();
    int[] test1 = new int[]{3,2,1,2,7};
    assertEquals(17, minimumUniqueArraySum.getMinimumUniqueSum(test1));
  }
}