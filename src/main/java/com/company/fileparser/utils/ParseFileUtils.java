package com.company.fileparser.utils;

import com.company.fileparser.core.file.reader.DefaultPatternMatchingFileReader;
import com.company.fileparser.core.file.reader.PatternMatchingFileReader;
import com.company.fileparser.properties.FileParserProperties;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

/** Utility Class that is an entry into API */
public class ParseFileUtils {

  private ParseFileUtils() {}

  /**
   * @param fileAbsolutePath absolute path file location including extension
   * @return list of words(tokenized words based on extension) group by line
   * @throws Exception if file is not able to read or not supported extension
   */
  public static List<List<String>> parse(String fileAbsolutePath) throws Exception {
    FilePathUtils.checkFilePathValid(fileAbsolutePath);
    String extension = FilenameUtils.getExtension(fileAbsolutePath);
    FileParserProperties fileParserProperties = FileParserProperties.getInstance();
    String extensionRegEx = fileParserProperties.getPropertyValue(extension);
    if (StringUtils.isBlank(extensionRegEx)) {
      // throwing generic exception but in real world we will throw custom exception with
      // appropriate
      // message
      throw new Exception("given File Extension is not supported");
    }
    Pattern pattern = Pattern.compile(extensionRegEx);
    PatternMatchingFileReader reader = new DefaultPatternMatchingFileReader();
    return reader.parseFile(fileAbsolutePath, pattern);
  }
}
