package ru.stqa.layers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodPage {
  protected WebDriver wd;
  private By cartLink = By.linkText("Checkout »");
  private By goodLink = By.cssSelector("div#box-most-popular li:nth-of-type(1)");
  private By goodParameter = By.name("options[Size]");
  private By addToCartButton = By.name("add_cart_product");
  private By numberOfGoods = By.cssSelector("#cart span.quantity") ;

  public GoodPage(WebDriver wd) {
    this.wd = wd;
  }

  public void goToCart() {
    wd.findElement(cartLink).click();
  }

  public void addToCart(int i) {
    wd.findElement(goodLink).click();

    // есть товары где нужно перед добавление указать размер
    if (wd.findElements(goodParameter).size() > 0) {
      new Select(wd.findElement(goodParameter)).selectByValue("Small");
    }

    wd.findElement(addToCartButton).click();
    new WebDriverWait(wd, 3).until(ExpectedConditions.textToBePresentInElementLocated(numberOfGoods, String.format("%d", i)));
    wd.navigate().back();
  }

  public int goodQuantity() {
    return Integer.parseInt(wd.findElement(numberOfGoods).getText());
  }
}
