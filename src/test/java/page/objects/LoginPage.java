package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage extends BasePage {

  @FindBy(name = "username")
  private WebElement usernameField;

  @FindBy(name = "password")
  private WebElement passwordField;

  @FindBy(name = "signon")
  private WebElement signOnButton;

  @FindBy(css = "#Content ul[class='messages'] li")
  private WebElement messageLabel;

  @Step("Type {username}")
  public LoginPage typeIntoUserNameField(String username) {
    WaitForElement.waitUntilElementIsVisible(usernameField);
    usernameField.sendKeys(username);
    log().info("Typed into User Name Field {}", username);
    return this;
  }

  @Step("Type {password}")
  public LoginPage typeIntoPasswordField(String password) {
    passwordField.clear();
    passwordField.sendKeys(password);
    log().info("Typed into Password Field {}", password);
    return this;
  }

  public FooterPage clickOnLoginButton() {
    signOnButton.click();
    log().info("Clicked on Login Button");
    return new FooterPage();
  }

  public String getWarningMessage() {
    WaitForElement.waitUntilElementIsVisible(messageLabel);
    String warningText = messageLabel.getText();
    log().info("Returned warning message was: {}", warningText);
    return warningText;
  }
  @Step("Assert that warning message {warningMessage} is displayed")
  public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
    log().info("Checking if warning message {} is displayed", warningMessage);
    WaitForElement.waitUntilElementIsVisible(messageLabel);
    AssertWebElement.assertThat(messageLabel).isNotDisplayed().hasText(warningMessage);
    return this;
  }

}