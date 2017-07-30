package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class PriceSizeTest extends TestBase {

  @Test
  public void testPriceSizeOnHomePage(){
    wd.get(HOME_PAGE);
    Dimension regularPriceDimension = wd.findElement(By.cssSelector("#box-campaigns .regular-price")).getSize();
    Dimension campaignPriceDimension = wd.findElement(By.cssSelector("#box-campaigns .campaign-price")).getSize();
    int reqularPriceSize = regularPriceDimension.getHeight() * regularPriceDimension.getWidth();
    int campaignPriceSize = campaignPriceDimension.getHeight() * campaignPriceDimension.getWidth();

    Assert.assertTrue(campaignPriceSize > reqularPriceSize);
  }

  @Test
  public void testPriceSizeOnInnerPage(){
    wd.get(HOME_PAGE);
    wd.findElement(By.cssSelector("#box-campaigns li a:nth-of-type(1)")).click();
    Dimension regularPriceDimension = wd.findElement(By.cssSelector(".regular-price")).getSize();
    Dimension campaignPriceDimension = wd.findElement(By.cssSelector(".campaign-price")).getSize();
    int reqularPriceSize = regularPriceDimension.getHeight() * regularPriceDimension.getWidth();
    int campaignPriceSize = campaignPriceDimension.getHeight() * campaignPriceDimension.getWidth();

    Assert.assertTrue(campaignPriceSize > reqularPriceSize);
  }
}
