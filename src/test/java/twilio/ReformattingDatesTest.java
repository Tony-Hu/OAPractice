package twilio;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReformattingDatesTest {
  @Test
  public void testConvertDates() {
    ReformattingDates reformattingDates = new ReformattingDates();
    var testList = Arrays.asList("1st Mar 1984", "2nd Feb 2013", "4th Apr 1900");
    var resultList = new String[] {"1984-03-01", "2013-02-02", "1900-04-04"};
    assertArrayEquals(resultList, reformattingDates.reformatDate(testList).toArray(new String[0]));
  }
}