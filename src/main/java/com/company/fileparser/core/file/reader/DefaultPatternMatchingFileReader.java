package com.company.fileparser.core.file.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/** Default Algorithm that matches against given pattern */
public class DefaultPatternMatchingFileReader implements PatternMatchingFileReader {
  /**
   * @param path absolute path of file location
   * @param pattern pattern object which uses to split a line into multiple tokens
   * @return list of words(tokenized split based on input pattern) group by line in @param path file
   * @throws IOException if file can not read or not able to parse
   */
  @Override
  public List<List<String>> parseFile(String path, Pattern pattern) throws IOException {
    List<List<String>> results = new ArrayList<>();
    File file = new File(path);
    List<String> list = readFile(file);
    for (String line : list) {
      String[] split = pattern.split(line);
      results.add(Arrays.asList(split));
    }
    return results;
  }
}
