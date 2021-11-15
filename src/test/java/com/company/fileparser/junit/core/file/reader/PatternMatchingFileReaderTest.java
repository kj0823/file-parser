package com.company.fileparser.junit.core.file.reader;

import static org.junit.jupiter.api.Assertions.*;

import com.company.fileparser.core.file.reader.DefaultPatternMatchingFileReader;
import com.company.fileparser.core.file.reader.PatternMatchingFileReader;
import com.company.fileparser.testutils.PathUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.collections4.ListUtils;
import org.junit.AfterClass;
import org.junit.Test;

public class PatternMatchingFileReaderTest {
  private static final PatternMatchingFileReader reader = new DefaultPatternMatchingFileReader();
  private static final String fileAbsolutePath =
      PathUtils.getAbsolutePathOfTestResource() + File.separator + "testChangedPerimsion.tab";
  private static final File file = new File(fileAbsolutePath);

  @Test
  public void givenFileSupportedFileWithValidInputShouldNotThrowError() {
    List<List<String>> parse = Collections.emptyList();
    PatternMatchingFileReader reader = new DefaultPatternMatchingFileReader();
    try {
      parse =
          reader.parseFile(
              PathUtils.getAbsolutePathOfTestResource() + File.separator + "testTrailing.tab",
              Pattern.compile("\t"));
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

  @Test
  public void givenSupportedFileExtensionWithValidAndWithtabsForFixedWidthExtension() {
    List<List<String>> parse = Collections.emptyList();
    PatternMatchingFileReader reader = new DefaultPatternMatchingFileReader();
    try {
      parse =
          reader.parseFile(
              PathUtils.getAbsolutePathOfTestResource() + File.separator + "test.fixedwidth",
              Pattern.compile("\\s{4}"));
    } catch (Exception e) {
      fail("unexpected Exception has been thrown");
    }
    List<List<String>> expectedList =
        Arrays.asList(
            Arrays.asList("this is", "tab  test", "onemore"),
            Arrays.asList("tab\ttab", "tab\tdaf"),
            Arrays.asList("realtab follwedby", "anothertab  endalso \thas tab"));
    assertTrue(ListUtils.isEqualList(expectedList, parse));
  }

  @Test
  public void givenFileCannotOpeneWithValidInputShouldThrowErrorWithPermissionDeniedError() {

    file.setReadable(false);
    Exception exception =
        assertThrows(
            Exception.class, () -> reader.parseFile(fileAbsolutePath, Pattern.compile("\t")));
    String actualMessage = exception.getMessage();
    String expectedMessage = "Permission denied";
    assertTrue(actualMessage.contains(expectedMessage));
    // Maven should need read perminssion when running from commandline
    file.setReadable(true);
  }

  @AfterClass
  public static void after() {
    file.setReadable(true);
  }
}
