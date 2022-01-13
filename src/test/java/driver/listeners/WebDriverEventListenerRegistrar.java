package driver.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class WebDriverEventListenerRegistrar {

  public synchronized static WebDriver registerWebDriverEventListener(WebDriver driver) {

    DriverEventListener driverEventListener = new DriverEventListener();

    // Utworzenie obiektu EventFiringDecorator, który to w konstruktorze przymuje stworzoną przez nas klasę DriverEventListener
    EventFiringDecorator eventFiringDecorator = new EventFiringDecorator(driverEventListener);

    // W ramach metody decorate "dekorujemy" stworzony poprzednio przez WebDrivera
    return eventFiringDecorator.decorate(driver);
  }

}