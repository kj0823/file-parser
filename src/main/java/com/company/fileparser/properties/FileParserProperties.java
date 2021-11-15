package com.company.fileparser.properties;

import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

/** Loads property file from resource folder */
public class FileParserProperties {
  // Hardcoded for now but in real project we will load all property files in resource folder
  private static final String PROP_FILE_PATH = "validExtensions.properties";
  private static FileParserProperties fileParserProperties = null;
  private FileBasedConfiguration configuration;

  // Hardcoded for now but in real project we will load all property files in resource folder using
  // apache/spring/other framework to load resource bundle
  // Ignored writing to test for exception as String is hard coded
  private FileParserProperties() throws ConfigurationException {
    Parameters params = new Parameters();
    FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
        new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
            .configure(params.properties().setFileName(PROP_FILE_PATH));

    configuration = builder.getConfiguration();
  }

  // Ideally we handle exception scenario  instead of  rethrowing due to time constraint  rethrow
  // could have catch exception either return null or rethrow custom error with custom message.

  /**
   * @return FileParserProperties singleton
   * @throws ConfigurationException if configuration files not found or not able to parse or read
   */
  public static FileParserProperties getInstance() throws ConfigurationException {
    if (fileParserProperties == null) fileParserProperties = new FileParserProperties();
    return fileParserProperties;
  }

  /**
   * @param key that matches in property file
   * @return value that corresponds in property file if key does not found it returns null
   */
  public String getPropertyValue(String key) {
    return (String) configuration.getProperty(key);
  }
}
