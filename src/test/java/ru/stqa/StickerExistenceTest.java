package ru.stqa;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StickerExistenceTest extends TestBase {


  @BeforeClass
  public static void setUp() throws Exception {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    wd = new ChromeDriver(options);
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    wd.get(HOME_PAGE);
  }

  @Test
  public void testStickerExistence() {
    List<WebElement> listOfGoods = wd.findElements(By.cssSelector(".product.column.shadow.hover-light"));
    for (WebElement good : listOfGoods) {
      List<WebElement> listOfStickers = good.findElements(By.cssSelector(".sticker"));
      String nameOfGood = good.findElement(By.cssSelector(".name")).getText();
      if (listOfStickers.size() == 0) {
        System.out.println("У товара " + nameOfGood + " нет стикера");
      } else if (listOfStickers.size() > 1) {
        System.out.println("У товара " + nameOfGood + " больше чем 1 стикер");
      }
    }
  }
}

