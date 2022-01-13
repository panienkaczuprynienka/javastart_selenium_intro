package driver.manager;

import configuration.LocalWebDriverProperties;
import configuration.TestRunProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import driver.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;
import static driver.BrowserType.FIREFOX;

public class DriverManager {

  //Dwie zmiennej instancj klasy ThreadLocal przechowujące kolejno instancję obiektu WebDriver oraz BrowserType dla danego wątku
  private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
  private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

  //prywatny konstruktor
  private DriverManager() {
  }

  //Metoda służy od ustawiania typu przeglądarki dla danego wątku
  public static void setWebDriver(BrowserType browserType) {

    //Obiekt typu WebDriver, który w kolejnych liniach zostanie zainicjalizowany wywołaniem metody getBrowser() z klasy BrowserFactory
    WebDriver browser = null;

    //Jeśli obiekt browserType będzie nullem, wtedy dla danego wątku zostanie wybrana przeglądarka zdefiniowana
    // w pliku configuration.properties
    if (browserType == null) {

      //Utworzenie instancji WebDrivera dla opcji gdy browserType jest nullem
      //Zostanie wtedy wybrana przeglądarka zdefiniowana w pliku configuration.properties
      browserType = getBrowserToRun();
      browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
    } else {
      //Utworzenie instancji WebDrivera dla opcji gdy browserType nie jest nullem
      //To znaczy, że został on zdefiniowany w pliku TestNG XML i możemy go używać
      browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
    }

    //Rejestracja obiektu WebDrivera
    browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);


    //Dodanie do puli instancji ThreadLocal za pomocą metody set() instancji klasy BrowserType
    browserTypeThreadLocal.set(browserType);

    //Dodanie do puli instancji ThreadLocal za pomocą metody set() instancji klasy WebDriver
    webDriverThreadLocal.set(browser);
  }

  public static WebDriver getWebDriver() {

    if (webDriverThreadLocal.get() == null) {
      //Rzucenie wyjątku IllegalStateException w sytuacji gdy dla danego wątku instancja przeglądarki nie została
      // poprawnie zainicializowana metodą setWebDriver
      throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
    }
    return webDriverThreadLocal.get();
  }

  //zamkniecie okna przegladarki, ubicie instancji drivera i przypisanie mu nulla, tak jakby nie był zainicjalizowany
  public static void disposeDriver() {
    webDriverThreadLocal.get().close();

    if (!browserTypeThreadLocal.get().equals(FIREFOX)) {
      webDriverThreadLocal.get().quit();
    }

    webDriverThreadLocal.remove();
    browserTypeThreadLocal.remove();
  }
}
