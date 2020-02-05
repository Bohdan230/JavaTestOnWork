import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ISelect;

import javax.swing.*;
import java.util.concurrent.TimeUnit;


public class Test {

    //public static final String URL = "https://www.google.com";

    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\bmulovanyi\\IdeaProjects\\JavaAutoTest\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();

        driver.findElement(By.className("menu-toggler")).click();

        WebElement LaptopNavigation = driver.findElement(By.linkText("Ноутбуки и компьютеры"));
        Actions builder = new Actions(driver);
        Actions hoverClick = builder.moveToElement(LaptopNavigation).click();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement Laptop = driver.findElement(By.xpath("(//a[contains(text(),'Ноутбуки') and @class='menu__hidden-title'])"));
        Laptop.click();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Select SortExpensiveHigher = new Select(driver.findElement(By.xpath(".//select[@class='select-css ng-untouched ng-pristine ng-valid']")));
        SortExpensiveHigher.selectByVisibleText("От дорогих к дешевым");
       // WebElement FirstElement = driver.findElement(By.id("104964564"));
       // FirstElement.click();
        //WebElement BuyButton =


        driver.quit();
    }
}