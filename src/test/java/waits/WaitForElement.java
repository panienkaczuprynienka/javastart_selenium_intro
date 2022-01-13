package waits;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.manager.DriverManager;

import java.time.Duration;

public class WaitForElement {

  private static WebDriverWait getWebDriverWait(){
    return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
  }

  public static void waitUntilElementIsVisible(WebElement element){
    getWebDriverWait().until(ExpectedConditions.visibilityOf(element));

  }

  public static void waitUntilElementIsClickable(WebElement element){
    getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
  }
}
