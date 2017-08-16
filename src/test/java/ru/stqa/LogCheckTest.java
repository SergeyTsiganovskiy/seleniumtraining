package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LogCheckTest extends TestBase{

  @Test
  public void logCheckTest(){
    goToAdminPage();
    wd.findElement(By.linkText("Catalog")).click();
    List<WebElement> toyLinks =
            wd.findElements(By.cssSelector("tr > td:nth-of-type(3) > a[href *=\"edit_product&category_id=0\"]"));

    List<String> linkNames = new ArrayList<>();

    for (WebElement linkName: toyLinks ){
      linkNames.add(linkName.getText());
    }

    for (String linkName: linkNames){
      wd.findElement(By.linkText(linkName)).click();


      Assert.assertFalse(wd.manage().logs().get("browser").iterator().hasNext() ||
              wd.manage().logs().get("client").iterator().hasNext()||
              wd.manage().logs().get("driver").iterator().hasNext());
      wd.navigate().back();
    }
  }
}

