package ru.stqa;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MenuItemsTests {
    public static WebDriver wd;
    
    @BeforeClass
    public static void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        wd = new ChromeDriver(options);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get("http://localhost/litecart/public_html/admin/login.php?redirect_url=%2Flitecart%2Fpublic_html%2Fadmin%2F");
        wd.findElement(By.name("username")).clear();
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();
    }


    @Test
    public void AppearanceItemTest(){
        // CSS - #app- > a[href *= "appearance"]
        // XPATH -  .//*[@id='app-']/a[contains(@href, 'appearance')]
        wd.findElement(By.linkText("Appearence")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void TemplateItemTest(){
        wd.findElement(By.linkText("Appearence")).click();
        // XPATH - //*[@id='doc-template']
        // CSS - #doc-template
        wd.findElement(By.linkText("Appearence")).click();
        wd.findElement(By.linkText("Template")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void LogotypeItemTest(){
        wd.findElement(By.linkText("Appearence")).click();
        // XPATH - //*[@id='doc-logotype']
        // CSS - #doc-logotype
        wd.findElement(By.linkText("Logotype")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void CatalogItemTest(){
        // XPATH - .//*[@id='app-']/a[contains(@href, 'catalog')]
        // CSS - #app- > a[href *= "catalog"]
        wd.findElement(By.linkText("Catalog")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void CatalogSubItemTest(){
        wd.findElement(By.linkText("Catalog")).click();
        // XPATH - .//*[@id='doc-catalog']/a
        wd.findElement(By.cssSelector("#doc-catalog")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void ProductGroupsItemTest(){
        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.cssSelector("#doc-product_groups")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void OptionGroupsItemTest(){
        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Option Groups")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void ManufacturersItemTest(){
        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Manufacturers")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void SuppliersItemTest(){
        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Suppliers")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void DeliveryStatusesItemTest(){
        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Delivery Statuses")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void SoldOutStatusesItemTest(){
        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Sold Out Statuses")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void QuantityUnitsItemTest(){
        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Quantity Units")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void CSVImportExportItemTest(){
        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("CSV Import/Export")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void CountriesItemTest(){
        wd.findElement(By.linkText("Countries")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void CurrenciesItemTest(){
        wd.findElement(By.linkText("Currencies")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void CustomersItemTest(){
        wd.findElement(By.linkText("Customers")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void CustomersCSVImportExportItemTest(){
        wd.findElement(By.linkText("Customers")).click();
        wd.findElement(By.linkText("CSV Import/Export")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void NewsletterItemTest(){
        wd.findElement(By.linkText("Customers")).click();
        wd.findElement(By.linkText("Newsletter")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void GeoZonesItemTest(){
        wd.findElement(By.linkText("Geo Zones")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void LanguagesItemTest(){
        wd.findElement(By.linkText("Languages")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void StorageEncodingItemTest(){
        wd.findElement(By.linkText("Languages")).click();
        wd.findElement(By.linkText("Storage Encoding")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void ModulesItemTest(){
        wd.findElement(By.linkText("Modules")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void CustomerItemTest(){
        wd.findElement(By.linkText("Modules")).click();
        wd.findElement(By.linkText("Customer")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void ShippingItemTest(){
        wd.findElement(By.linkText("Modules")).click();
        wd.findElement(By.linkText("Shipping")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void PaymentItemTest(){
        wd.findElement(By.linkText("Modules")).click();
        wd.findElement(By.linkText("Payment")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void OrderTotalItemTest(){
        wd.findElement(By.linkText("Modules")).click();
        wd.findElement(By.linkText("Order Total")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void OrderSuccessItemTest(){
        wd.findElement(By.linkText("Modules")).click();
        wd.findElement(By.linkText("Order Success")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void OrderActionItemTest(){
        wd.findElement(By.linkText("Modules")).click();
        wd.findElement(By.linkText("Order Action")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void OrdersItemTest(){
        wd.findElement(By.linkText("Orders")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void OrderStatusesItemTest(){
        wd.findElement(By.linkText("Orders")).click();
        wd.findElement(By.linkText("Order Statuses")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void PagesItemTest(){
        wd.findElement(By.linkText("Pages")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void ReportsItemTest(){
        wd.findElement(By.linkText("Reports")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void MostSoldProductsItemTest(){
        wd.findElement(By.linkText("Reports")).click();
        wd.findElement(By.linkText("Most Sold Products")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void MostShoppingCustomersItemTest(){
        wd.findElement(By.linkText("Reports")).click();
        wd.findElement(By.linkText("Most Shopping Customers")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void SettingsItemTest(){
        wd.findElement(By.linkText("Settings")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void DefaultsSettingsItemTest(){
        wd.findElement(By.linkText("Settings")).click();
        wd.findElement(By.linkText("Defaults")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void GeneralItemTest(){
        wd.findElement(By.linkText("Settings")).click();
        wd.findElement(By.linkText("General")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void ListingsItemTest(){
        wd.findElement(By.linkText("Settings")).click();
        wd.findElement(By.linkText("Listings")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void ImagesItemTest(){
        wd.findElement(By.linkText("Settings")).click();
        wd.findElement(By.linkText("Images")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void CheckoutItemTest(){
        wd.findElement(By.linkText("Settings")).click();
        wd.findElement(By.linkText("Checkout")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void AdvancedItemTest(){
        wd.findElement(By.linkText("Settings")).click();
        wd.findElement(By.linkText("Advanced")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void SecurityItemTest(){
        wd.findElement(By.linkText("Settings")).click();
        wd.findElement(By.linkText("Security")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }


    @Test
    public void SlidesItemTest(){
        wd.findElement(By.linkText("Slides")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void TaxItemTest(){
        wd.findElement(By.linkText("Tax")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void TaxClassesItemTest(){
        wd.findElement(By.linkText("Tax")).click();
        wd.findElement(By.linkText("Tax Classes")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void TaxRatesItemTest(){
        wd.findElement(By.linkText("Tax")).click();
        wd.findElement(By.linkText("Tax Rates")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void TranslationsItemTest(){
        wd.findElement(By.linkText("Translations")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void SearchTranslationsItemTest(){
        wd.findElement(By.linkText("Translations")).click();
        wd.findElement(By.linkText("Search Translations")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void ScanFilesItemTest(){
        wd.findElement(By.linkText("Translations")).click();
        wd.findElement(By.linkText("Scan Files")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void TranslationCSVImportExportItemTest(){
        wd.findElement(By.linkText("Translations")).click();
        wd.findElement(By.linkText("CSV Import/Export")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void UsersItemTest(){
        wd.findElement(By.linkText("Users")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void vQmodsItemTest(){
        wd.findElement(By.linkText("vQmods")).click();
        Assert.assertTrue(wd.findElement(By.xpath(".//*[@id='content']/h1")) != null);
        Assert.assertTrue(wd.findElements(By.xpath(".//*[@id='content']/h1")).size() == 1);
    }

    @Test
    public void MenuItemsTest() {
        wd.findElement(By.linkText("vQmods")).click();
        wd.findElement(By.xpath("//li[@id='doc-vqmods']/a")).click();
    }
    
    @AfterClass
    public static void tearDown() {
        wd.quit();
    }
    
}
