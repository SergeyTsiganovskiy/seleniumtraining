package ru.stqa;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

public class TestBase {
  public static WebDriver wd;
  public static final String ADMIN_PAGE = "http://localhost/litecart/public_html/admin/";
  public static final String HOME_PAGE = "http://localhost/litecart/public_html";


  @AfterClass
  public static void tearDown() {
    wd.quit();
  }
}
