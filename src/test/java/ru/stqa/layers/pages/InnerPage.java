package ru.stqa.layers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InnerPage {
  protected WebDriver wd;

  public InnerPage(WebDriver wd) {
    this.wd = wd;
  }

  public void goToCart() {
    wd.findElement(By.linkText("Checkout »")).click();
  }

  public void addToCart(int i) {
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

  public int goodQuantity() {
    return Integer.parseInt(wd.findElement(By.cssSelector("#cart span.quantity")).getText());
  }
}
