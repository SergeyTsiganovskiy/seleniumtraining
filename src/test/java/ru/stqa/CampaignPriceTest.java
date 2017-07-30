package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CampaignPriceTest extends TestBase{

  @Test
  public void testCampaignPriceColorOnHomePage(){
    wd.get(HOME_PAGE);
    String campaignPriceRGBColor = wd.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("Color");
    Assert.assertTrue(isElementRed(campaignPriceRGBColor));
  }

  @Test
  public void testCampaignPriceFontOnHomePage(){
    wd.get(HOME_PAGE);
    String tagName = wd.findElement(By.cssSelector("#box-campaigns .campaign-price")).getTagName();
    Assert.assertEquals("strong" , tagName);
  }

  @Test
  public void testCampaignPriceColorOnInnerPage(){
    wd.get(HOME_PAGE);
    wd.findElement(By.cssSelector("#box-campaigns li a:nth-of-type(1)")).click();
    String campaignPriceRGBColor = wd.findElement(By.cssSelector(".campaign-price")).getCssValue("Color");
    Assert.assertTrue(isElementRed(campaignPriceRGBColor));
  }

  @Test
  public void testCampaignPriceFontOnInnerPage(){
    wd.get(HOME_PAGE);
    wd.findElement(By.cssSelector("#box-campaigns li a:nth-of-type(1)")).click();
    String tagName = wd.findElement(By.cssSelector(".campaign-price")).getTagName();
    Assert.assertEquals("strong" , tagName);
  }

  private boolean isElementRed(String rgb) {
    List<String> colorSet = new ArrayList<>();
    String str = rgb.substring(4, rgb.length() - 1);
    StringTokenizer st = new StringTokenizer(str, ",");
    while (st.hasMoreTokens()) {
      colorSet.add(st.nextToken().trim());
    }
    if (colorSet.get(1).equals("0") && colorSet.get(2).equals("0")) return true;

    return false;
  }
}
