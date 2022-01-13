package configuration;

import driver.BrowserType;

public class LocalWebDriverProperties {

  // Metody zwracają właściwości dla poszczególnych kluczy, analogicznie jak w przypadku AppProperties

  public static String getChromeWebDriverLocation() {
    return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
  }

  public static String getFirefoxWebDriverLocation() {
    return ConfigurationProperties.getProperties().getProperty("firefox.driver.location");
  }

  public static String getInternetExplorerWebDriverLocation() {
    return ConfigurationProperties.getProperties().getProperty("ie.driver.location");
  }
}
