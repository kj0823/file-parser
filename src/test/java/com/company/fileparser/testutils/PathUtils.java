package com.company.fileparser.testutils;

import java.io.File;

public class PathUtils {
  public static String getAbsolutePathOfTestResource() {
    String path = "src/test/resources";
    File file = new File(path);
    return file.getAbsolutePath();
  }
}
