package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.BrowserType;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import navigation.ApplicationURLs;
import org.testng.annotations.*;
import utils.ScreenShotMaker;

import java.util.Properties;

public class TestBase {

  @BeforeClass
  public void beforeClass(){
    PropertiesLoader propertiesLoader = new PropertiesLoader();
    Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
    ConfigurationProperties.setProperties(propertiesFromFile);
  }

  @Parameters("browser")
  @BeforeMethod
  public void beforeTest(@Optional BrowserType browserType) {
    DriverManager.setWebDriver(browserType);
    DriverManager.getWebDriver();
    DriverUtils.setInitialConfiguration();
    DriverUtils.navigateToPage(ApplicationURLs.APPLICATION_URL);
  }


  @AfterMethod
  public void afterTest() {
    ScreenShotMaker.makeScreenShot();
    //Zamknięcie okna przeglądarki
    DriverManager.disposeDriver();
  }
}