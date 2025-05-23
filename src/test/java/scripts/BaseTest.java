package scripts;

import drivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    //public WebDriver driver2;
    static Logger logger = LogManager.getLogger("testBookingFromHomePage");

    @BeforeMethod
    // setup trình duyệt
    @Parameters ({"browser"})
    public void setupTest( String browser){
        logger.info("Setting up Webdriver...");
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.setDriver(browser);
        driver = driverFactory.getDriver();
        driver.get("https://demo1.cybersoft.edu.vn/");
        logger.info("Truy cap web thanh cong roi đó");
        //String browser = "Safari";
//        if (browser == "Chrome")
//        {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }else if{
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//        else{
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        }
//
//        switch (browser){
//            case "Chrome":
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            case "Safari":
//                WebDriverManager.safaridriver().setup();
//                driver = new SafariDriver();
//                break;
//            default:
//                System.out.println("This browser is not support!");
//        }
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();

    }
    public WebDriver getDriver(){return driver;}
    void teardown(){
        driver.quit();
    }
    @AfterMethod
    public void  tearDown (){
        driver.quit();
    }
}
