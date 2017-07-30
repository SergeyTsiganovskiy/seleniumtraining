package ru.stqa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
  public static WebDriver wd;
  public static final String ADMIN_PAGE = "http://localhost/litecart/public_html/admin/";
  public static final String HOME_PAGE = "http://localhost/litecart/public_html";

  @BeforeClass
  public static void setUp() throws Exception {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    wd = new ChromeDriver(options);
//    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
//    wd = new InternetExplorerDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }

  @AfterClass
  public static void tearDown() {
    wd.quit();
  }

  protected void goToAdminPage() {
    wd.get(ADMIN_PAGE);
    wd.findElement(By.name("username")).clear();
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();
  }
}
