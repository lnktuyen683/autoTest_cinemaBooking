package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class demo2new {
        static WebDriver driver;
        @BeforeClass
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://tiki.vn");

        }
        @BeforeMethod
        public void navigatehomepage(){
            driver.get("https://tiki.vn");
        }


        @Test
        public void search1() {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            // đóng popup
            driver.findElement(By.xpath("//img[@alt='close-icon']")).click();
            //click vao o search
            driver.findElement(By.xpath("//div[@class='sc-dec0a11d-1 cfhkdd']")).click();
            //input text adidas vao o search
            WebElement searchBox = driver.findElement(By.xpath("//input[@data-view-id=\"main_search_form_input\"]"));
            searchBox.sendKeys("adidas");
            //nhan enter
            searchBox.sendKeys(Keys.ENTER);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //lay danh sach tieu de san pham
            List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 'sc-2d0320b9-0 gHqeOl')]//h3"));

            //List<WebElement> items = driver.findElements(By.cssSelector("div[data-view-id^='product_list_item'] a h3"));

            int count = Math.min(8, items.size());
            for (int i = 0; i<count; i++) {
                //lay tieu de va chuyen ve chu thuong
                String title = items.get(i).getText().toLowerCase();
                System.out.println("Item"+(i+1)+":"+title);
                Assert.assertTrue(title.contains("adidas"), "Item"+(i+1)+"khong chua chu adidas");

            }

        }
    @Test
    public void search2() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // đóng popup
        driver.findElement(By.xpath("//img[@alt='close-icon']")).click();
        //click vao o search
        driver.findElement(By.xpath("//div[@class='sc-dec0a11d-1 cfhkdd']")).click();
        //input text adidas vao o search
        WebElement searchBox = driver.findElement(By.xpath("//input[@data-view-id=\"main_search_form_input\"]"));
        searchBox.sendKeys("samsung");
        //nhan enter
        searchBox.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //lay danh sach tieu de san pham
        List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 'sc-2d0320b9-0 gHqeOl')]//h3"));

        //List<WebElement> items = driver.findElements(By.cssSelector("div[data-view-id^='product_list_item'] a h3"));

        int count = Math.min(8, items.size());
        for (int i = 0; i<count; i++) {
            //lay tieu de va chuyen ve chu thuong
            String title = items.get(i).getText().toLowerCase();
            System.out.println("Item"+(i+1)+":"+title);
            Assert.assertTrue(title.contains("samsung"), "Item"+(i+1)+"khong chua chu samsung");
        }

    }
        @AfterClass
        public void teardown()
        {
            driver.quit();
        }

    }

