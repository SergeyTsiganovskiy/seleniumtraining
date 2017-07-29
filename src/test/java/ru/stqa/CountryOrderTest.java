package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryOrderTest extends TestBase {

  @Test
  public void testCountryOrder(){
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

    List<String> countryNamesBefore = new ArrayList<>();
    for (Country country: countries) {
      countryNamesBefore.add(country.getName());
    }
    List<String> countryNamesAfter = new ArrayList<>(countryNamesBefore);;

    Collections.sort(countryNamesAfter);
    // если коллекци названий после сортировки совпадает с исходной коллекцией, то исходная тоже была отсортирована
    Assert.assertEquals(countryNamesBefore , countryNamesAfter);
  }
}
