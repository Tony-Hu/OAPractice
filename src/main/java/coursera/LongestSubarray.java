package coursera;

public class LongestSubarray {

  public int maxLength(int[] a, int k) {
    if (a == null || a.length == 0) {
      return 0;
    }
    long sum = 1;
    int total = 0;
    int startIndex = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      while (sum >= k && startIndex < i) {
        sum -= a[startIndex];
        startIndex++;
      }
      if (sum < k) {
        total += (i - startIndex + 1);
      }
    }
    return total;
  }
}
