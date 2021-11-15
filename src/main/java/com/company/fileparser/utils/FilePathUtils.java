package com.company.fileparser.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** It validates file path */
public class FilePathUtils {
  private static final Logger logger = LogManager.getLogger(FilePathUtils.class);

  private FilePathUtils() {}

  // throwing generic exception but in real world we will throw custom exception with appropriate
  // message

  /**
   * @param filePath absolute path of file location
   * @throws Exception if given path does not exist or not a file
   */
  public static void checkFilePathValid(String filePath) throws Exception {
    Path path = Paths.get(filePath);
    // call getFileName() and get FileName path object
    if (!Files.exists(path)) {
      logger.error("Provided file path does not exist");
      // throwing generic exception but in real world we will throw custom exception with
      // appropriate
      // message
      throw new Exception("Provided file path does not exist");
    }
    if (Files.isDirectory(path)) {
      logger.error("Provided file path must not be a directory");
      // throwing generic exception but in real world we will throw custom exception with
      // appropriate
      // message
      throw new Exception("Provided file path must not be a directory");
    }
  }
}
