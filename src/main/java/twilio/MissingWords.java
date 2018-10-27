package twilio;

import java.util.LinkedList;
import java.util.List;

//Time complexity - O(n), space complexity - O(1)
public class MissingWords {
  public List<String> missingWords(String s, String t) {
    List<String> result = new LinkedList<>();
    if (s.length() == t.length()) {
      return result;
    }
    StringBuilder sb = new StringBuilder();
    boolean isMissing = false;
    int i = 0;
    int j = 0;
    int oldJ = 0;
    while (i < s.length() && j < t.length()) {
      char cs = s.charAt(i);
      char ct = t.charAt(j);
      if (cs == ' ') {
        if (cs != ct) {
          isMissing = true;
        }
        if (isMissing) {
          result.add(sb.toString());
          j = oldJ;//turn back
        } else {
          j++;
          oldJ = j;//Update old J pos point to next char
        }
        i++;
        sb.setLength(0);
        isMissing = false;
      } else if (cs != ct) {
        isMissing = true;
        while (i < s.length() && (cs = s.charAt(i)) != ' ') {
          sb.append(cs);
          i++;
        }
      } else {
        sb.append(cs);
        i++;
        j++;
      }
    }
    while (i < s.length()) {
      char cs = s.charAt(i);
      if (cs == ' ') {
        if (isMissing) {
          result.add(sb.toString());
        }
        sb.setLength(0);
        isMissing = true;
      } else {
        sb.append(cs);
      }
      i++;
    }
    if (sb.length() > 0 && isMissing) {
      result.add(sb.toString());
    }
    return result;
  }
}
