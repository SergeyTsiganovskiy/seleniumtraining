package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class AddNewGoodTest extends TestBase{

    @Test
    public void AddNewGoodTest() {
        wd.get(ADMIN_PAGE);
        loginAdminPage("admin", "admin");

        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Add New Product")).click();

        wd.findElement(By.xpath("//input[@value = '1']")).click();

        type(By.name("name[en]"), "Toy duck NEW555");
        type(By.name("code"), "12345");

        wd.findElement(By.xpath("//input[@value = '1']")).click();
        wd.findElement(By.cssSelector("tbody>tr:nth-of-type(4)>td>input")).click();

        File file = new File(".\\src\\test\\resources\\testduck.jpg");

        wd.findElement(By.name("new_images[]")).sendKeys(file.getAbsolutePath());

        typeDate(By.name("date_valid_from"), "03-08-2017" );
        typeDate(By.name("date_valid_to"), "05-11-2017" );


        wd.findElement(By.linkText("Information")).click();

        new Select(wd.findElement(By.xpath("//select[@name='manufacturer_id']"))).selectByValue("1");

        type(By.name("keywords"), "for child, toy, cheap toy");
        type(By.name("short_description[en]"), "toy to play in bath");

        wd.findElement(By.cssSelector("div.trumbowyg-editor")).click();
        wd.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys("Description of the toy!");

        type(By.name("head_title[en]"),"toy duck" );

        wd.findElement(By.linkText("Prices")).click();

        type(By.name("purchase_price"),"3");
        new Select(wd.findElement(By.xpath("//select[@name='purchase_price_currency_code']"))).selectByValue("EUR");

        wd.findElement(By.xpath("//input[@name='gross_prices[USD]']")).sendKeys("50");

        wd.findElement(By.name("save")).click();

    }

    private void loginAdminPage(String userName, String password) {
        wd.findElement(By.name("username")).click();
        wd.findElement(By.name("username")).clear();
        wd.findElement(By.name("username")).sendKeys(userName);
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys(password);
        wd.findElement(By.name("login")).click();
    }

    private void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void typeDate(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).sendKeys(text);
    }
}
