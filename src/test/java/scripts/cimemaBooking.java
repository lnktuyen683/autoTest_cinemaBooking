package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PurchasePage;

import javax.swing.*;
import java.time.Duration;

public class cimemaBooking extends BaseTest{
    @Test
    public void verifylogin(){
        LoginPage loginPage = new LoginPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);
        loginPage.login("susan", "susansu");


//        Actions actions = new Actions(driver);
//        // cuon toi home tool thanh ngang
//        WebElement hometool = driver.findElement(By.xpath("//div[@id='homeTool']"));
//        //hanh dong cuon
//        actions.scrollToElement(hometool);
//        //hover vao bo phim
//        WebElement filmbutton = driver.findElement(By.xpath("//div[contains(@style, 'moana')]"));
//        actions.moveToElement(filmbutton).perform();
//        //Di click button mua ve
//        WebElement bookticket = driver.findElement(By.xpath("//a[(@href ='/detail/11585') and text()='MUA VÉ']"));
//        bookticket.click();
//        //Chon thoi gian
//        WebElement booktime = driver.findElement(By.xpath("//a[(@href ='/purchase/46703')]"));
//        booktime.click();
//        //goi purchase page
//        purchasePage.purchaseSlot("65");

    }

    @Test
    public void verifybooking(){
        LoginPage loginPage = new LoginPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);
        logger.info("Star logging..");
        loginPage.login("susan", "susansu");
        logger.info("login successfully.");
        logger.info("wait.");
        //Thread.sleep(1000);
        logger.info("done wait.");

        Actions actions = new Actions(driver);
        // cuon toi home tool thanh ngang
        WebElement hometool = driver.findElement(By.xpath("//div[@id='homeTool']"));
        //hanh dong cuon
        actions.scrollToElement(hometool);
        //hover vao bo phim
        WebElement filmbutton = driver.findElement(By.xpath("//div[contains(@style, 'moana')]"));
        actions.moveToElement(filmbutton).perform();
        //Di click button mua ve
        WebElement bookticket = driver.findElement(By.xpath("//a[(@href ='/detail/11585') and text()='MUA VÉ']"));
        bookticket.click();
        logger.info("da click mua ve thanh cong");
        //Chon thoi gian
        WebElement booktime = driver.findElement(By.xpath("//a[(@href ='/purchase/46703')]"));
        booktime.click();
        //goi purchase page
        purchasePage.purchaseSlot("65");

    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

}
