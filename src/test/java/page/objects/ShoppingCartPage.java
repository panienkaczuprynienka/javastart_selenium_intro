package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

  @FindBy(css = "a[href$='newOrderForm=']")
  private WebElement proceedToCheckoutButton;

  private WebDriver driver;

  public ShoppingCartPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickOnProceedToCheckout() {
    proceedToCheckoutButton.click();
  }
}