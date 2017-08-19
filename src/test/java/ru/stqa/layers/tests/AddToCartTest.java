package ru.stqa.layers.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCartTest extends TestBase {
  @Test
  public void AddToCartTest() throws InterruptedException {
    app.homePage();
    app.getHomePage().login();
    int initialNumberOfItems = app.innerPage().goodQuantity();

    // наполняем корзину товарами
    for (int i = initialNumberOfItems; i < initialNumberOfItems + 4; i++) {
      app.innerPage().addToCart(i);
    }
    app.innerPage().goToCart();

    // определяем количество товаров в корзине
    List<WebElement> numderOfGoods = app.goodsInCart();

    // проверяем что название товара, который удаляем исчезло из списка в таблице
    for (int i = 0; i < numderOfGoods.size(); i++) {
      app.delete();
      Assert.assertTrue(app.isTableChanged(app.goodToDelete()));
    }
  }
}
