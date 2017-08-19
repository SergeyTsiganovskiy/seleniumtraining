package ru.stqa.layers.app;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.layers.pages.HomePage;
import ru.stqa.layers.pages.InnerPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Application {

  public static final String ADMIN_PAGE = "http://localhost/litecart/public_html/admin/";
  public static final String HOME_PAGE = "http://localhost/litecart/public_html";
  private  InnerPage innerPage;
  private  HomePage homePage;
  private WebDriver wd;


  public  void init() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    wd = new ChromeDriver(options);
//    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
//    wd = new InternetExplorerDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    homePage = new HomePage(wd);
    innerPage = new InnerPage(wd);
  }

  public void stop() {
    wd.quit();
  }

  public void goToAdminPage() {
    wd.get(ADMIN_PAGE);
    wd.findElement(By.name("username")).clear();
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();
  }

  // проверятпо названию товара, удалился ли он из таблицы
  public boolean isTableChanged(String goodName) throws InterruptedException {
    for (int count = 0; ; count++) {

      if (count >= 30) {
        throw new TimeoutException();
      }

      List<String> goodNames = new ArrayList<>();

      try {
        List<WebElement> goodNameElements = wd.findElements(By.cssSelector("#order_confirmation-wrapper td.item"));

        for (WebElement goodNameElement : goodNameElements) {
          goodNames.add(goodNameElement.getText());
        }
        if (!goodNames.contains(goodName)) {
          break;
        }

      } catch (StaleElementReferenceException e) {
      }

      Thread.sleep(1000);
    }
    return true;
  }

  public void delete() {
    wd.findElement(By.xpath("//*[@name = \"remove_cart_item\"]")).click();
  }

  public String goodToDelete() {
    return wd.findElement(By.xpath(".//*[@id='box-checkout-cart']/div//p/ a")).getText();
  }

  public List<WebElement> goodsInCart() {
    return wd.findElements(By.cssSelector(".shortcut"));
  }

  public void homePage() {
    wd.get(HOME_PAGE);
  }

  public HomePage getHomePage() {
    return homePage;
  }

  public InnerPage innerPage() {
    return innerPage;
  }
}
