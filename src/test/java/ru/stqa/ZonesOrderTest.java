package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZonesOrderTest extends TestBase {

  @Test
  public void testZonesOrder() {
    goToAdminPage();
    wd.findElement(By.linkText("Countries")).click();

    List<WebElement> tableRows = wd.findElements(By.cssSelector(".row"));
    List<Country> countries = new ArrayList<>();
    // заполняем коллекцию объектов типа Countries
    for (WebElement element : tableRows) {
      String countryName = element.findElement(By.cssSelector("td:nth-of-type(5)>a")).getText();
      int zones = Integer.parseInt(element.findElement(By.cssSelector("td:nth-of-type(6)")).getText());
      countries.add(new Country(zones, countryName));
    }

    // ищем страну у которой указано, что количество Zones > 0
    // если да, то кликаем и формируем коллекцию из названий зон
    // потом сортируем её и проверяем с исходной

    for (Country country : countries) {
      List<String> namesOfZoneBefore = new ArrayList<>();
      if (country.getZones() > 0) {
        wd.findElement(By.linkText(country.getName())).click();
        List<WebElement> listOfZones = wd.findElements(By.cssSelector("#table-zones>tbody>tr>td:nth-of-type(3)"));
        listOfZones.remove(listOfZones.size() - 1); // последний элемент не зона, поэтому его удалим из коллекции
        for (WebElement zone : listOfZones) {
          namesOfZoneBefore.add(zone.getText());
        }
        List<String> namesOfZoneAfter = new ArrayList<>(namesOfZoneBefore);
        Collections.sort(namesOfZoneAfter);
        // если коллекци названий после сортировки совпадает с исходной коллекцией, то исходная тоже была отсортирована
        Assert.assertEquals(namesOfZoneBefore, namesOfZoneAfter);
      }
      wd.findElement(By.linkText("Countries")).click();
    }
  }

}
