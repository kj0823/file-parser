package com.company.fileparser.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** This class is a utility class for Main class */
public class MainUtility {
  private static final Logger logger = LogManager.getLogger(MainUtility.class);

  private MainUtility() {}

  /**
   * @param args arguments that are passed from command line
   * @throws Exception is thrown if args size is not exactly one
   */
  public static void validateInput(String[] args) throws Exception {
    checkArgumentLength(args);
  }

  // throwing generic exception but in real world we will throw custom exception with appropriate
  // message
  private static void checkArgumentLength(String[] args) throws Exception {

    if (ArrayUtils.isEmpty(args) || args.length != 1) {
      logger.error("Argument length must be size one");
      // throwing generic exception but in real world we will throw custom exception with
      // appropriate
      // message
      throw new Exception("Argument length must be size one");
    }
  }
}
