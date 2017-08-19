package ru.stqa.layers.pages;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

  protected WebDriver wd;

  public CartPage(WebDriver wd) {
    this.wd = wd;
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
}
