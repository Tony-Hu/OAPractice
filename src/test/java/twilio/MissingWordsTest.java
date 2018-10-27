package twilio;

import org.junit.Test;

import static org.junit.Assert.*;

public class MissingWordsTest {

  @Test
  public void missingWords() {
    MissingWords missingWords = new MissingWords();
    String s1 = "I like cheese";
    String t1 = "like";
    assertArrayEquals(new String[] {"I", "cheese"}, missingWords.missingWords(s1, t1).toArray(new String[0]));

    String s2 = "ab bcd cd";
    String t2 = "bcd cd";
    assertArrayEquals(new String[] {"ab"}, missingWords.missingWords(s2, t2).toArray(new String[0]));

    String s3 = "ab bcd cd";
    String t3 = "ab";
    assertArrayEquals(new String[] {"bcd", "cd"}, missingWords.missingWords(s3, t3).toArray(new String[0]));

    String s4 = "I am using HackerRank to improve programming";
    String t4 = "am HackerRank to improve";
    assertArrayEquals(new String[] {"I", "using", "programming"}, missingWords.missingWords(s4, t4).toArray(new String[0]));
  }
}