package com.company.fileparser.entry;

import com.company.fileparser.utils.MainUtility;
import com.company.fileparser.utils.ParseFileUtils;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** This class is for entry into jar using commandline or running from IDE */
public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);

  /**
   * @param args arguments that can be passed along with Java
   * @throws Exception Throws exception if args array size is not exactly one if supplied one
   *     argument is not a valid file path with supported exception
   */
  public static void main(String[] args) throws Exception {

    logger.debug("program started it will print line tokens to console using log4j");
    MainUtility.validateInput(args);
    List<List<String>> parsedTokens = ParseFileUtils.parse(args[0]);
    for (List<String> lineTokens : parsedTokens) {
      logger.debug(lineTokens);
    }
    logger.debug("program completed");
  }
}
