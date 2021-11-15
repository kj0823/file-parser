package com.company.fileparser.junit.entry;

import static org.junit.jupiter.api.Assertions.*;

import com.company.fileparser.entry.Main;
import com.company.fileparser.testutils.PathUtils;
import java.io.File;
import java.util.Random;
import org.junit.Test;

public class MainTest {
  @Test
  public void givenValidInputShouldNotThrowException() {
    String absolutePath = PathUtils.getAbsolutePathOfTestResource();
    try {
      Main.main(new String[] {absolutePath + File.separator + "test.fixedwidth"});
    } catch (Exception e) {
      fail("Exception during execution of givenFilePathDoesNotExistShouldThrowException ");
    }
  }

  @Test
  public void givenNewOperatoronMainClassShouldCreateSucucessfulObject() {
    try {
      new Main();
    } catch (Exception e) {
      fail("Exception during execution of givenFilePathDoesNotExistShouldThrowException ");
    }
  }

  @Test
  public void giveneSizeMoreThanOneInputArrayShouldThrowError() {
    Random rand = new Random();
    int i = rand.nextInt(20);
    Exception exception = assertThrows(Exception.class, () -> Main.main(new String[i + 2]));
    String actualMessage = exception.getMessage();
    String expectedMessage = "Argument length must be size one";
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void givenEmptyArrayShouldThrowError() {

    Exception exception = assertThrows(Exception.class, () -> Main.main(new String[] {}));
    String actualMessage = exception.getMessage();
    String expectedMessage = "Argument length must be size one";
    assertTrue(actualMessage.contains(expectedMessage));
  }
}
