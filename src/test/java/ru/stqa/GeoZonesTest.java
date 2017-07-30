package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeoZonesTest extends TestBase {
  @Test
  public void testGeoZones() {
    goToAdminPage();
    wd.findElement(By.linkText("Geo Zones")).click();
    List<WebElement> countryList = wd.findElements(By.cssSelector(".row>td:nth-of-type(3)>a"));
    List<String> countryNames = new ArrayList<>();
    for (WebElement country:countryList) {
      countryNames.add(country.getText());
    }

    for (String countryName : countryNames) {
      wd.findElement(By.linkText(countryName)).click();
      List<WebElement> zones = wd.findElements(By.cssSelector("select[name $=\"[zone_code]\"] option[selected = \"selected\"]"));
      List<String> zoneNamesBefore = new ArrayList<>();
      for (WebElement zone: zones) {
        zoneNamesBefore.add(zone.getText());
      }
      List<String> zoneNamesAfter = new ArrayList<>(zoneNamesBefore);
      Collections.sort(zoneNamesAfter);
      Assert.assertEquals(zoneNamesBefore,zoneNamesAfter);
      wd.findElement(By.linkText("Geo Zones")).click();
    }
  }
}
