package com.company.fileparser.junit.properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.company.fileparser.properties.FileParserProperties;
import org.junit.Test;

public class FileParserPropertiesTest {

  @Test
  // Prepare the class for which we want to mock a static method
  public void givenGetInstanceMethodCalledShouldReturnSuccessfullInstance() {
    try {
      FileParserProperties instance = FileParserProperties.getInstance();
      assertNotNull(instance);
    } catch (Exception e) {
      fail("unexpected Exception has been thrown");
    }
  }
}
