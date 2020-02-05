package com.RozetkaTests;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class TestRozetka {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\bmulovanyi\\IdeaProjects\\JavaAutoTest\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        driver.findElement(By.className("menu-toggler")).click();
        WebElement LaptopNavigation = driver.findElement(By.linkText("Ноутбуки и компьютеры"));
        Actions builder = new Actions(driver);
        Actions hoverClick = builder.moveToElement(LaptopNavigation).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Ноутбуки') and @class='menu__hidden-title'])")).click();
        /*driver.get("https://rozetka.com.ua/");
       driver.findElement(By.className("menu-toggler")).click();
        driver.findElement(By.linkText("Ноутбуки и компьютеры")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Ноутбуки') and @class='menu__hidden-title'])")).click();
       driver.findElement(By.xpath("//select")).click();
        new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("От дешевых к дорогим");
       driver.findElement(By.xpath("//select")).click();*/
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
