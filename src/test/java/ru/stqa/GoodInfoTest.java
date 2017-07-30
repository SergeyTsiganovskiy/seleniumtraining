package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class GoodInfoTest extends TestBase{

  @Test
  public void testGoodInfo(){
    wd.get(HOME_PAGE);
    String nameMainPage = wd.findElement(By.cssSelector("#box-campaigns .name")).getText();
    String regularPriceMainPage = wd.findElement(By.cssSelector("#box-campaigns .regular-price")).getText();
    String campaignPriceMainPage = wd.findElement(By.cssSelector("#box-campaigns .campaign-price")).getText();
    Good mainPageGood = new Good(nameMainPage, regularPriceMainPage, campaignPriceMainPage);

    wd.findElement(By.cssSelector("#box-campaigns li a:nth-of-type(1)")).click();
    String nameInnerPage = wd.findElement(By.cssSelector("h1")).getText();
    String regularPriceInnerPage = wd.findElement(By.cssSelector(".regular-price")).getText();
    String campaignPriceInnerPage = wd.findElement(By.cssSelector(".campaign-price")).getText();
    Good innerPageGood = new Good(nameInnerPage, regularPriceInnerPage, campaignPriceInnerPage);

    Assert.assertEquals(mainPageGood, innerPageGood);
  }
}
