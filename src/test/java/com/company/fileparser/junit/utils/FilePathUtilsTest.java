package com.company.fileparser.junit.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.company.fileparser.testutils.PathUtils;
import com.company.fileparser.utils.FilePathUtils;
import java.io.File;
import org.junit.Test;

public class FilePathUtilsTest {
  @Test
  public void givenValidPathShouldNotThrowException() {
    String absolutePath = PathUtils.getAbsolutePathOfTestResource();
    try {
      FilePathUtils.checkFilePathValid(absolutePath + File.separator + "test.fixedwidth");
    } catch (Exception e) {
      fail("Exception during execution of givenFilePathDoesNotExistShouldThrowException ");
    }
  }

  @Test
  public void givenValidDirectoryPathShouldThrowException() {
    String absolutePath = PathUtils.getAbsolutePathOfTestResource();
    Exception exception =
        assertThrows(Exception.class, () -> FilePathUtils.checkFilePathValid(absolutePath));
    String actualMessage = exception.getMessage();
    String expectedMessage = "Provided file path must not be a directory";
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void givenFileDoeNotExistShouldThrowException() {
    String absolutePath = PathUtils.getAbsolutePathOfTestResource();
    Exception exception =
        assertThrows(
            Exception.class,
            () ->
                FilePathUtils.checkFilePathValid(
                    absolutePath + File.separator + "test.DoesNotExist"));
    String actualMessage = exception.getMessage();
    String expectedMessage = "Provided file path does not exist";
    assertTrue(actualMessage.contains(expectedMessage));
  }
}
