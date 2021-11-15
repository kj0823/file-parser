package com.company.fileparser.core.file.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Interface that can be implemented by various algorithms */
public interface PatternMatchingFileReader {
  Logger logger = LogManager.getLogger(PatternMatchingFileReader.class);

  List<List<String>> parseFile(String path, Pattern pattern) throws IOException;

  /**
   * @param file file
   * @return list of lines in a file
   * @throws IOException if file can not read for any reason
   */
  default List<String> readFile(File file) throws IOException {
    List<String> lines;
    try {
      lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
    } catch (IOException e) {
      logger.error("Exception while reading file {}", file.getAbsolutePath());
      throw e;
    }
    return lines;
  }
}
