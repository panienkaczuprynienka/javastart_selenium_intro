package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import utils.testng.listeners.RetryAnalyzer;

import static navigation.ApplicationURLs.LOGIN_URL;

public class PositiveLoginTests extends TestBase {

  @Issue("DEFECT-2")
  @TmsLink("ID-2")
  @Severity(SeverityLevel.BLOCKER)
  @Test(retryAnalyzer = RetryAnalyzer.class)
  @Description("The goal of this test is to log in using proper username and password" +
          " and check if Dog Banner is displayed after")
  public void asUserLoginUsingValidLoginAndPassword() {
    DriverUtils.navigateToPage(LOGIN_URL);

    LoginPage loginPage = new LoginPage();
    loginPage
            .typeIntoUserNameField("j2ee")
            .typeIntoPasswordField("j2ee")
            .clickOnLoginButton()
            .assertThatDogBannerIsDisplayed();
  }
}
