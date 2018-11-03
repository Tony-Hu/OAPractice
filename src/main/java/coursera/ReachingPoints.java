package coursera;

//LeetCode 780: https://leetcode.com/problems/reaching-points/
//LintCode 1036: <- any method can pass, no TLE. BAD!
public class ReachingPoints {
  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (true) {
      if (tx == sx && ty == sy) {
        return true;
      }
      if (tx < sx || ty < sy) {
        return false;
      }
      if (tx > ty) {
        if (ty == sy) {
          return (tx - sx) % ty == 0;
        }
        tx %= ty;
      } else {
        if (tx == sx) {
          return (ty - sy) % tx == 0;
        }
        ty %= tx;
      }
    }
  }
}
