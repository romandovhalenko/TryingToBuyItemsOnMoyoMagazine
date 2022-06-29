import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TryingToBuyItemsOnMoyoMagazine {
    //for sleeping
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWebsiteMoyo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //open the site and maximize window
        driver.get("https://www.moyo.ua/");
        driver.manage().window().maximize();
        //open main menu
        driver.findElement(By.xpath("//div[@class='header_catalog_btn_text']")).click();
        sleep(1);
        //open smart gadgets
        driver.findElement(By.xpath("//a[@class='menu_link item-2915']")).click();
        sleep(1);

        //add 1st item to trash
        driver.findElements(By.xpath("//button[@class='buy-btn btn btn--green js-product-modal-close js-buy']")).get(0).sendKeys(Keys.ENTER);
            //increase to 5 items
            for (int i = 0; i < 4; i++) {
                sleep(1);
                //pressing "plus" btn
                driver.findElements(By.xpath("//div[@class='cart-item__price-wrapper']//button[@class='qty-btn plus ']")).get(0).sendKeys(Keys.ENTER);
            }

        //close trash for add next item
        driver.findElement(By.xpath("//div[@class='cart-footer__continue']")).click();

        //add 2nd item to trash
        driver.findElements(By.xpath("//button[@class='buy-btn btn btn--green js-product-modal-close js-buy']")).get(1).sendKeys(Keys.ENTER);
        //increase to 5 items
        for (int i = 0; i < 4; i++) {
            sleep(1);
            //pressing "plus" btn
            driver.findElements(By.xpath("//div[@class='cart-item__price-wrapper']//button[@class='qty-btn plus ']")).get(1).sendKeys(Keys.ENTER);
        }

        //pressing button "buy"
        driver.findElement(By.xpath("//button[@class='rds-btn']")).click();
        sleep(1);
        //enter firstname of buyer
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Імя\n");
        //enter middlename of buyer
        driver.findElement(By.xpath("//input[@name='middlename']")).sendKeys("Побатькові\n");
        //enter lastname of buyer
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Фамілія\n");
        //enter phone number of buyer
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("670123456\n");
        //enter email of buyer
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testmail@gmail.com\n");
        //press "next" btn
        driver.findElements(By.xpath("//button[@class='rds-btn']")).get(0).sendKeys(Keys.ENTER);
        sleep(1);
        //press btn for change city
        driver.findElement(By.xpath("//span[@class='form-change__link']")).click();
        sleep(1);
        //find city
        driver.findElement(By.xpath("//input[@name='searchTAQueryString']")).sendKeys("Винница\n");
        sleep(1);
        //select city
        driver.findElement(By.xpath("//ul[@class='autocomplete-list sc-hmzhuo hpgiGL']")).click();
        sleep(1);
        //change method delivery
        driver.findElement(By.xpath("//input[@id='toShop']")).click();
        //press "next" btn
        driver.findElements(By.xpath("//button[@class='rds-btn']")).get(0).sendKeys(Keys.ENTER);

        //the END
    }
}
