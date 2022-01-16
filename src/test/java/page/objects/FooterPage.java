package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScreenShotMaker;
import waits.WaitForElement;

import java.util.List;


public class FooterPage extends BasePage {

  @FindBy(css = "#Banner img[src*='dog']")
  private List<WebElement> bannerAfterLoginLogo;

  public boolean isBannerAfterLoginDisplayed() {
    WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo.get(0));
    boolean isDisplayed = bannerAfterLoginLogo.size() == 1 ? true : false;
    log().info("Returning status of banner after login: {}", isDisplayed);
    return isDisplayed;
  }

  @Step("Assert that element dog banner is displayed")
  public FooterPage assertThatDogBannerIsDisplayed() {
    log().info("Checking if dog banner is displayed");
    WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo.get(0));
    AssertWebElement.assertThat(bannerAfterLoginLogo.get(0)).isDisplayed();
    return this;
  }

}