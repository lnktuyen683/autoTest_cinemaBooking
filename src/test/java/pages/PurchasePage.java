package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchasePage {
    WebDriver driver;
    public PurchasePage(WebDriver driver){this.driver =driver;}
    public void purchaseSlot(String number){
        //chon ghe
        WebElement selectChair = driver.findElement(By.xpath("//span[contains(text(),'"+number+"')]"));
        selectChair.click();
        //Chon dat ve
        WebElement bookSelectChairTicket = driver.findElement(By.xpath("//span[contains(text(),'ĐẶT VÉ')]"));
         bookSelectChairTicket.click();
    }
}
