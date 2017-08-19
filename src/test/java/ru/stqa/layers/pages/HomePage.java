package ru.stqa.layers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
  protected WebDriver wd;

  public HomePage(WebDriver wd) {
    this.wd = wd;
  }

  public void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void login() {
    type(By.name("email"), "example@gmail.com");
    type(By.name("password"), "12345");
    wd.findElement(By.name("login")).click();
  }
}
