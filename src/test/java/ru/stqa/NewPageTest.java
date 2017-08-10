package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class NewPageTest extends TestBase{
    @Test
    public void NewPageTest() {
        goToAdminPage();

        wd.findElement(By.linkText("Countries")).click();
        wd.findElement(By.linkText("Add New Country")).click();

        List<WebElement> links = wd.findElements(By.cssSelector(".fa.fa-external-link"));

        for (WebElement link: links){
            goToOuterPage(link);
        }
    }

    private void goToOuterPage(WebElement link) {
        String originalWindow = wd.getWindowHandle();
        Set<String> existingWindows = wd.getWindowHandles();
        link.click();
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
