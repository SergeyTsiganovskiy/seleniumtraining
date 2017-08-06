package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AddToCartTest extends TestBase {
  @Test
  public void AddToCartTest() throws InterruptedException {
    wd.get(HOME_PAGE);
    type(By.name("email"), "example@gmail.com");
    type(By.name("password"), "12345");
    wd.findElement(By.name("login")).click();

    int initialNumberOfItems = Integer.parseInt(wd.findElement(By.cssSelector("#cart span.quantity")).getText());

    // наполняем корзину товарами
    for (int i = initialNumberOfItems; i < initialNumberOfItems + 4; i++) {
      wd.findElement(By.cssSelector("div#box-most-popular li:nth-of-type(1)")).click();

      // есть товары где нужно перед добавление указать размер
      if (wd.findElements(By.name("options[Size]")).size() > 0){
        new Select(wd.findElement(By.name("options[Size]"))).selectByValue("Small");
      }

      WebElement addToCartButton = wd.findElement(By.name("add_cart_product"));
      addToCartButton.click();
      new WebDriverWait(wd, 3).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#cart span.quantity"), String.format("%d", i)));
      wd.navigate().back();
    }
    wd.findElement(By.linkText("Checkout »")).click();

    // определяем количество товаров в корзине
    List<WebElement> numderOfGoods = wd.findElements(By.cssSelector(".shortcut"));

    // проверяем что название товара, который удаляем исчезло из списка в таблице
    for (int i = 0; i < numderOfGoods.size(); i++) {
      String goodName = wd.findElement(By.xpath(".//*[@id='box-checkout-cart']/div//p/ a")).getText();
      wd.findElement(By.xpath("//*[@name = \"remove_cart_item\"]")).click();
      Assert.assertTrue(isTableChanged(By.cssSelector("#order_confirmation-wrapper td.item"), goodName));
    }
  }

  private void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  // проверятпо названию товара, удалился ли он из таблицы
  private boolean isTableChanged(By productNamelocator, String goodName) throws InterruptedException {
    for (int count = 0; ; count++) {

      if (count >= 30) {
        throw new TimeoutException();
      }

      List<String> goodNames = new ArrayList<>();

      try {
        List<WebElement> goodNameElements = wd.findElements(productNamelocator);

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
}
