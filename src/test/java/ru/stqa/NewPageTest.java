package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class NewPageTest extends TestBase{
    @Test
    public void NewPageTest() {
        goToAdminPage();

        wd.findElement(By.linkText("Countries")).click();
        wd.findElement(By.linkText("Add New Country")).click();

        goToOuterPage(By.cssSelector("[href $=\"alpha-2\"]"));
        goToOuterPage(By.cssSelector("[href $=\"alpha-3\"]"));
        goToOuterPage(By.cssSelector("[href $=\"Regular_expression\"]"));
        goToOuterPage(By.cssSelector("[href $=\"address-formats.html\"]"));
        goToOuterPage(By.cssSelector("[href $=\"Regular_expression\"]"));
        goToOuterPage(By.cssSelector("[href $=\"currency_and_language\"]"));
        goToOuterPage(By.cssSelector("[href $=\"List_of_country_calling_codes\"]"));
    }

    private void goToOuterPage(By locator) {
        String originalWindow = wd.getWindowHandle();
        Set<String> existingWindows = wd.getWindowHandles();
        wd.findElement(locator).click();
        new WebDriverWait(wd, 5)
                .until(ExpectedConditions.numberOfWindowsToBe(existingWindows.size() + 1));
        Set<String> newExistingWindows = wd.getWindowHandles();
        newExistingWindows.removeAll(existingWindows);
        wd.switchTo().window(newExistingWindows.iterator().next());
        wd.close();
        wd.switchTo().window(originalWindow);
        Assert.assertEquals(originalWindow, wd.getWindowHandle());
    }
}
