package coursera;

import java.util.HashSet;
import java.util.Set;

public class MinimumUniqueArraySum {
  public int getMinimumUniqueSum(int[] arr) {
    Set<Integer> set = new HashSet<>();
    int sum = 0;
    for (int e : arr) {
      while (set.contains(e)) {
        e++;
      }
      set.add(e);
      sum += e;
    }
    return sum;
  }
}
