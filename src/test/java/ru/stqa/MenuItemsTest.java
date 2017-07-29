package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MenuItemsTest extends TestBase {

  @Test
  public void testMenuItems() {
    goToAdminPage();

    List<WebElement> menuItemLinks = wd.findElements(By.xpath("//li[@id='app-']/a"));
    List<String> itemNames = new ArrayList<>();
    // запоминаем имена пунктов меню
    for (WebElement link : menuItemLinks) {
      itemNames.add(link.getText());
    }
    // прокликиваем пункты меню по имена
    for (String linkName : itemNames) {
      wd.findElement(By.linkText(linkName)).click();

      isCaptionCorrect(linkName, "#content>h1");

      int numberOfSubItems = wd.findElements(By.xpath(".//li/ul//a")).size();

      // если у пункта меню есть подпункты, то запоминаем их имена и прокликиваем их

      if (numberOfSubItems > 1) {
        List<WebElement> subItems = wd.findElements(By.xpath(".//li/ul//a"));
        List<String> subItemNames = new ArrayList<>();
        for (WebElement subItem : subItems) {
          subItemNames.add(subItem.getText());
        }

        for (String subLinkNames : subItemNames) {
          wd.findElement(By.linkText(subLinkNames)).click();
          isCaptionCorrect(subLinkNames, "#content>h1");
        }
      }
    }
  }

  private void isCaptionCorrect(String linkName, String locator) {
    if (wd.findElement(By.cssSelector(locator)) == null && (wd.findElements(By.cssSelector(locator)).size() > 1)) {
      System.out.println("У пункта меню " + linkName + "заголовок или отсутствует либо не один");
    }
  }

}
