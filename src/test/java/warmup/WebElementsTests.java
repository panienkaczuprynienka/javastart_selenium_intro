package warmup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class WebElementsTests {

  private WebDriver driver;

  @BeforeMethod
  public void beforeTest() {
    System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
  }

  @Test(enabled = false)
  public void typingIntoWebElementTest() {

    WebElement userNameField = driver.findElement(By.id("username"));
    userNameField.sendKeys("Selenium Start");

    String typeUserNameValue = userNameField.getAttribute("value");
    sleep();
    assertEquals(typeUserNameValue, "Selenium Start");
  }

  @Test(enabled = false)
  public void filePickingTest(){

    sleep();

    WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
    uploadFilePicker.sendKeys("C:\\test.txt");

    sleep();
  }

  @Test(enabled = false)
  public void checkRadioButtonTest() {

    WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
    WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

    sleep();
    maleRadioButton.click();
    sleep();
    assertTrue(maleRadioButton.isSelected());

    femaleRadioButton.click();
    sleep();
    assertTrue(femaleRadioButton.isSelected());
    assertFalse(maleRadioButton.isSelected());
  }

  @Test(enabled = false)
  public void checkboxButtonTest() {

    WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
    WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti']"));
    WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger']"));

    assertFalse(pizzaCheckbox.isSelected());
    assertFalse(spaghettiCheckbox.isSelected());
    assertFalse(hamburgerCheckbox.isSelected());

    sleep();

    pizzaCheckbox.click();
    spaghettiCheckbox.click();
    hamburgerCheckbox.click();

    assertTrue(pizzaCheckbox.isSelected());
    assertTrue(spaghettiCheckbox.isSelected());
    assertTrue(hamburgerCheckbox.isSelected());

    sleep();

    pizzaCheckbox.click();
    spaghettiCheckbox.click();
    hamburgerCheckbox.click();

    sleep();

    assertFalse(pizzaCheckbox.isSelected());
    assertFalse(spaghettiCheckbox.isSelected());
    assertFalse(hamburgerCheckbox.isSelected());
  }

  @Test(enabled = false)
  public void dropDownListingTest() {

    sleep();

    WebElement countryWebElement = driver.findElement(By.id("country"));

    Select countryDropDown = new Select(countryWebElement);

    List<WebElement> options = countryDropDown.getOptions();

    List<String> namesOfOptions = new ArrayList<>();

    for (WebElement option : options) {

      namesOfOptions.add(option.getText());

      System.out.println(option.getText());
    }
    List<String> expectedNamesOfOptions = new ArrayList<>();
    expectedNamesOfOptions.add("Germany");
    expectedNamesOfOptions.add("Poland");
    expectedNamesOfOptions.add("UK");

    sleep();

    assertEquals(namesOfOptions, expectedNamesOfOptions);
  }

  @Test(enabled = false)
  public void hoverOverAndClickAndHoldTest() {
    driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");

    WebElement smileyIcon = driver.findElement(By.id("smiley"));

    Actions action = new Actions(driver);

    action.moveToElement(smileyIcon).click().build().perform();

    sleep();

    Actions secondAction = new Actions(driver);
    WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));

    secondAction.clickAndHold(smileyIcon2).build().perform();

    sleep();
  }

  @AfterMethod
  public void afterTest() {
    driver.close();
    driver.quit();
  }

  private void sleep() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}