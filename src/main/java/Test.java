import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class Test {

    //public static final String URL = "https://www.google.com";

    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\bmulovanyi\\IdeaProjects\\JavaAutoTest\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        WebElement NavigateToLaptops = driver.findElement(By.linkText("Ноутбуки и компьютеры"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        NavigateToLaptops.click();
        WebElement Laptops = driver.findElement(By.linkText("Ноутбуки"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Laptops.click();
        //WebElement Sort = driver.findElement( By.xpath("/html/body/app-root/div/div[1]/rz-category/div/main/ctg-catalog/div[1]/div/ctg-sort/select"));
        //Sort.click();
        Select SortExpensiveHigher = new Select(driver.findElement(By.xpath(".//select[@class='select-css ng-untouched ng-pristine ng-valid']")));
        SortExpensiveHigher.selectByVisibleText("От дорогих к дешевым");

        //WebElement SortExpensiveHigher = driver.findElement(By.tagName( "От дорогих к дешевым"));
        //SortExpensiveHigher.click();



        driver.quit();
    }
}