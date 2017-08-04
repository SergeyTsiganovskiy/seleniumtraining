package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class AddNewCustomerTest extends TestBase{
    @Test
    public void AddNewCustomerTest() {
        wd.get(HOME_PAGE);
        wd.findElement(By.linkText("New customers click here")).click();
        type(By.name("firstname"), "MyName");
        type(By.name("lastname"), "MyLastName");
        type(By.name("address1"), "GreenStreet");
        type(By.name("city"), "NY");
        type(By.name("postcode"), "44444");

        wd.findElement(By.cssSelector(".select2-selection.select2-selection--single")).click();

        wd.findElement(By.cssSelector(".select2-search__field")).sendKeys("United States", Keys.ENTER);

        Select select = new Select(wd.findElement(By.xpath("//select[@name = \"zone_code\"]")));
        select.selectByValue("NY");


        String email = String.format("test" + new Random().nextInt(999) + "@gmail.com");
        type(By.name("email"), email);
        type(By.name("phone"), "+1234567898" );
        type(By.name("password"), "pass");
        type(By.name("confirmed_password"), "pass" );

        wd.findElement(By.name("create_account")).click();
        wd.findElement(By.linkText("Logout")).click();

        type(By.name("email"), email);
        type(By.name("password"), "pass");

        wd.findElement(By.name("login")).click();
        wd.findElement(By.linkText("Logout")).click();
    }

    private void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }
}
