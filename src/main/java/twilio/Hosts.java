package twilio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hosts {
  public void processFile(String fileName) {
    Map<String, Integer> map = new HashMap<>();
    try (Scanner scanner = new Scanner(new File(fileName))) {

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        int endIndex = line.indexOf(' ');
        String host = line.substring(0, endIndex);
        map.put(host, map.getOrDefault(host, 0) + 1);
      }
    } catch (FileNotFoundException e) {
      System.err.println("File not found!");
    }
    
    try (PrintStream printStream = new PrintStream(new FileOutputStream("records_" + fileName))) {
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        printStream.println(entry.getKey() + " " + entry.getValue());
      }
    } catch (IOException e) {
      System.err.println("Out file error!");
    }
  }
}
