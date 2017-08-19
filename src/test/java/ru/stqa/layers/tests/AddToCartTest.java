package ru.stqa.layers.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCartTest extends TestBase {
  @Test
  public void AddToCartTest() throws InterruptedException {
    app.goToHomePage();
    app.homePage().login();
    int initialNumberOfItems = app.goodPage().goodQuantity();

    // наполняем корзину товарами
    for (int i = initialNumberOfItems; i < initialNumberOfItems + 4; i++) {
      app.goodPage().addToCart(i);
    }
    app.goodPage().goToCart();

    // определяем количество товаров в корзине
    List<WebElement> numderOfGoods = app.cartPage().goodsInCart();

    // проверяем что название товара, который удаляем исчезло из списка в таблице
    for (int i = 0; i < numderOfGoods.size(); i++) {
      app.cartPage().delete();
      Assert.assertTrue(app.cartPage().isTableChanged(app.cartPage().goodToDelete()));
    }
  }
}
