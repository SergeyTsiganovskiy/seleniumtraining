package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class RegularPriceTest extends TestBase{

  @Test
  public void testRegularPriceColorOnHomePage(){
    wd.get(HOME_PAGE);
    String regularPriceRGBColor = wd.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("Color");
    Assert.assertTrue(isElementGrey(regularPriceRGBColor));
  }

  @Test
  public void testRegularPriceCrossingOnHomePage(){
    wd.get(HOME_PAGE);
    String tagName = wd.findElement(By.cssSelector("#box-campaigns .regular-price")).getTagName();
    Assert.assertEquals("s",tagName);
  }

  @Test
  public void testRegularPriceColorOnInnerPage(){
    wd.get(HOME_PAGE);
    wd.findElement(By.cssSelector("#box-campaigns li a:nth-of-type(1)")).click();
    String regularPriceRGBColor = wd.findElement(By.cssSelector(".regular-price")).getCssValue("Color");
    Assert.assertTrue(isElementGrey(regularPriceRGBColor));
  }

  @Test
  public void testRegularPriceCrossingOnInnerPage(){
    wd.get(HOME_PAGE);
    wd.findElement(By.cssSelector("#box-campaigns li a:nth-of-type(1)")).click();
    String tagName = wd.findElement(By.cssSelector(".regular-price")).getTagName();
    Assert.assertEquals("s",tagName);
  }


  private boolean isElementGrey(String rgb) {
    Set<String> colorSet = new HashSet<>();
    String str = rgb.substring(4, rgb.length() - 1);
    StringTokenizer st = new StringTokenizer(str, ",");
    while (st.hasMoreTokens()) {
      colorSet.add(st.nextToken().trim());
    }
    if (colorSet.size() == 1) return true;

    return false;
  }
}
