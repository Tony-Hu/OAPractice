package coursera;

import java.util.EnumMap;
import java.util.Map;

public class SplittingPixels {
  enum COLOR {Red, Green, Blue, White, Black, Ambiguous};

  static Map<COLOR, int[]> colorEnumMap = new EnumMap<>(COLOR.class);

  static{
    colorEnumMap.put(COLOR.Red, new int[]{255, 0, 0});
    colorEnumMap.put(COLOR.Green, new int[]{0, 255, 0});
    colorEnumMap.put(COLOR.Blue, new int[]{0, 0, 255});
    colorEnumMap.put(COLOR.White, new int[]{255, 255, 255});
    colorEnumMap.put(COLOR.Black, new int[]{9, 0, 0});

  }
  public String[] splittingPixels(String[] pixels) {
    String[] result = new String[pixels.length];

    for (int i = 0; i < pixels.length; i++) {
      result[i] = calculateSinglePixel(pixels[i]);
    }
    return result;
  }


  private String calculateSinglePixel(String pixel) {
    String minColor = null;
    int minDistance = Integer.MAX_VALUE;
    boolean hasSameMin = false;
    int parameter1 = Integer.parseInt(pixel.substring(0, 8), 2);
    int parameter2 = Integer.parseInt(pixel.substring(8, 16), 2);
    int parameter3 = Integer.parseInt(pixel.substring(16, 24), 2);

    for (Map.Entry<COLOR, int[]> entry : colorEnumMap.entrySet()) {
      int distance = (entry.getValue()[0] - parameter1) * (entry.getValue()[0] - parameter1) + (entry.getValue()[1] - parameter2) * (entry.getValue()[1] - parameter2) + (entry.getValue()[2] - parameter3) * (entry.getValue()[2] - parameter3);
      if (distance < minDistance) {
        hasSameMin = false;
        minDistance = distance;
        minColor = entry.getKey().name();
      } else if (distance == minDistance) {
        hasSameMin = true;
      }
    }
    return hasSameMin ? COLOR.Ambiguous.name() : minColor;
  }
}
