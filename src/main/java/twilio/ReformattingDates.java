package twilio;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReformattingDates {
  static Map<String, String> monthMap = new HashMap<>();

  static {
    monthMap.put("Jan", "01");
    monthMap.put("Feb", "02");
    monthMap.put("Mar", "03");
    monthMap.put("Apr", "04");
    monthMap.put("May", "05");
    monthMap.put("Jun", "06");
    monthMap.put("Jul", "07");
    monthMap.put("Aug", "08");
    monthMap.put("Sep", "09");
    monthMap.put("Oct", "10");
    monthMap.put("Nov", "11");
    monthMap.put("Dec", "12");
  }
  public List<String> reformatDate(List<String> list) {
    List<String> result = new LinkedList<>();
    if (list == null || list.isEmpty()) {
      return result;
    }
    for (String s : list) {
      result.add(reformatSingleDate(s));
    }
    return result;
  }

  private String reformatSingleDate(String s) {
    StringBuilder sb = new StringBuilder();
    String[] splits = s.split("\\s+");
    sb.append(convertDay(splits[0]));
    sb.insert(0, "-").insert(0, monthMap.get(splits[1]))
        .insert(0, "-").insert(0, splits[2]);
    return sb.toString();
  }

  private String convertDay(String day) {
    String result = day.substring(0, day.length() - 2);
    if (result.length() < 2) {
      return "0" + result;
    } else {
      return String.valueOf(result);
    }
  }
}
