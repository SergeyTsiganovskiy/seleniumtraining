package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StickerExistenceTest extends TestBase {

  @Test
  public void testStickerExistence() {
    wd.get(HOME_PAGE);
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

