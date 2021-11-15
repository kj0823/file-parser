package com.company.fileparser.junit.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.company.fileparser.testutils.PathUtils;
import com.company.fileparser.utils.ParseFileUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

public class ParseFileUtilsTest {
  @Test
  public void givenFilePathDoesNotExistShouldThrowException() {

    Exception exception =
        assertThrows(
            Exception.class,
            () ->
                ParseFileUtils.parse(
                    System.getProperty("user.dir") + File.separator + "directoryDoesNotExist"));
    String actualMessage = exception.getMessage();
    String expectedMessage = "Provided file path does not exist";
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void givenFilePathIsNullShouldThrowException() {
    assertThrows(Exception.class, () -> ParseFileUtils.parse(null));
  }

  @Test
  public void givenNotSupportedFileExtensionShouldThrowException() {

    Exception exception =
        assertThrows(
            Exception.class,
            () ->
                ParseFileUtils.parse(
                    PathUtils.getAbsolutePathOfTestResource()
                        + File.separator
                        + "test.notSupported"));
    String actualMessage = exception.getMessage();
    String expectedMessage = "given File Extension is not supported";
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void givenFileSupportedFileWithTab() {
    List<List<String>> parse = Collections.emptyList();
    try {
      parse =
          ParseFileUtils.parse(
              PathUtils.getAbsolutePathOfTestResource() + File.separator + "testTrailing.tab");
    } catch (Exception e) {
      fail("unexpected Exception has been thrown");
    }
    List<List<String>> expectedList =
        Arrays.asList(
            Arrays.asList("This is test with trailing tab"),
            Arrays.asList("this", "line contains ", "tabs in", "with ", "in the line"),
            Arrays.asList("", "there is a", "tab at the beginning"));
    assertTrue(ListUtils.isEqualList(expectedList, parse));
  }
}
