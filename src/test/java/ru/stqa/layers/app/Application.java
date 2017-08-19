package ru.stqa.layers.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.stqa.layers.pages.CartPage;
import ru.stqa.layers.pages.GoodPage;
import ru.stqa.layers.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class Application {

  public static final String ADMIN_PAGE = "http://localhost/litecart/public_html/admin/";
  public static final String HOME_PAGE = "http://localhost/litecart/public_html";
  private GoodPage goodPage;
  private HomePage homePage;
  private CartPage cartPage;
  private WebDriver wd;


  public void init() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    wd = new ChromeDriver(options);
//    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
//    wd = new InternetExplorerDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    homePage = new HomePage(wd);
    goodPage = new GoodPage(wd);
    cartPage = new CartPage(wd);
  }

  public void stop() {
    wd.quit();
  }

  public void goToHomePage() {
    wd.get(HOME_PAGE);
  }

  public HomePage homePage() {
    return homePage;
  }

  public GoodPage goodPage() {
    return goodPage;
  }

  public CartPage cartPage() {
    return cartPage;
  }

}
