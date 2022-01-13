package driver.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.List;

public class DriverEventListener implements WebDriverListener {

  private static Logger logger = LogManager.getLogger(DriverEventListener.class);

  @Override
  public void beforeFindElement(WebDriver driver, By locator) {
    WebDriverListener.super.beforeFindElement(driver, locator);
    logger.info("Trying to find WebElement with locator " + locator.toString());
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    WebDriverListener.super.afterFindElement(driver, locator, result);
    logger.info("Found WebElement with locator " + locator.toString());
  }

  @Override
  public void beforeFindElements(WebDriver driver, By locator) {
    WebDriverListener.super.beforeFindElements(driver, locator);
    logger.info("Trying to find WebElement list with locator " + locator.toString());
  }

  @Override
  public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
    WebDriverListener.super.afterFindElements(driver, locator, result);
    logger.info("Found WebElements list with locator " + locator.toString());
  }

  @Override
  public void beforeFindElement(WebElement element, By locator) {
    WebDriverListener.super.beforeFindElement(element, locator);
    logger.info("Trying to find WebElement with locator " + locator.toString());
  }

  @Override
  public void afterFindElement(WebElement element, By locator, WebElement result) {
    WebDriverListener.super.afterFindElement(element, locator, result);
    logger.info("Found WebElement with locator " + locator.toString());
  }

  @Override
  public void beforeFindElements(WebElement element, By locator) {
    WebDriverListener.super.beforeFindElements(element, locator);
    logger.info("Trying to find WebElement list with locator " + locator.toString());
  }

  @Override
  public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
    WebDriverListener.super.afterFindElements(element, locator, result);
    logger.info("Found WebElements list with locator " + locator.toString());
  }

  @Override
  public void beforeClear(WebElement element) {
    WebDriverListener.super.beforeClear(element);
    logger.info("Trying to clear WebElement");
  }

  @Override
  public void afterClear(WebElement element) {
    WebDriverListener.super.afterClear(element);
    logger.info("Cleared WebElement " + element);
  }

  @Override
  public void beforeClick(WebElement element) {
    WebDriverListener.super.beforeClick(element);
    logger.info("Trying to click WebElement");
  }

  @Override
  public void afterClick(WebElement element) {
    WebDriverListener.super.afterClick(element);
    logger.info("Clicked WebElement");
  }

  @Override
  public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
    WebDriverListener.super.beforeSendKeys(element, keysToSend);
    if (keysToSend == null) {
      logger.info("Trying to clear field with location " + element.getLocation());
    } else {
      logger.info("Trying to type text " + Arrays.toString(keysToSend));
    }
  }

  @Override
  public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    WebDriverListener.super.afterSendKeys(element, keysToSend);
    if (keysToSend == null) {
      logger.info("Cleared field with location " + element.getLocation());
    } else {
      logger.info("Typed text " + Arrays.toString(keysToSend));
    }
  }
}