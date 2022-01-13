package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage extends BasePage{

  @FindBy(css = "#Content a")
  private WebElement enterStoreLink;

  public TopMenuPage clickOnEnterStoreLink() {
    WaitForElement.waitUntilElementIsClickable(enterStoreLink);
    enterStoreLink.click();
    log().info("Clicked on Enter Store link");
    return new TopMenuPage();
  }

}