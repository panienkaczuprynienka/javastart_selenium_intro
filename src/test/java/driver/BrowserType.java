package driver;

public enum BrowserType {
  FIREFOX("firefox"),
  CHROME("chrome"),
  IE("InternetExplorer");

  private final String browserType;


  BrowserType(String browserType) {
    this.browserType = browserType;
  }
}
