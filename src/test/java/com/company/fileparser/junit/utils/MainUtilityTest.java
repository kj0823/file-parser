package com.company.fileparser.junit.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.company.fileparser.utils.MainUtility;
import java.util.Random;
import org.junit.Test;

public class MainUtilityTest {

  @Test
  public void givenSizeOneArrayShouldNotThrowException() {
    try {
      MainUtility.validateInput(new String[] {"valid path"});
    } catch (Exception e) {
      fail("Exception during execution of givenFilePathDoesNotExistShouldThrowException ");
    }
  }

  @Test
  public void giveneSizeMoreThanOneInputArrayShouldThrowError() {
    Random rand = new Random();
    int i = rand.nextInt(20);
    Exception exception =
        assertThrows(Exception.class, () -> MainUtility.validateInput(new String[i + 2]));
    String actualMessage = exception.getMessage();
    String expectedMessage = "Argument length must be size one";
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void givenEmptyArrayShouldThrowError() {

    Exception exception =
        assertThrows(Exception.class, () -> MainUtility.validateInput(new String[] {}));
    String actualMessage = exception.getMessage();
    String expectedMessage = "Argument length must be size one";
    assertTrue(actualMessage.contains(expectedMessage));
  }
}
