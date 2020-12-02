package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // 3. Login alanina “username” yazdirin
        WebElement userName = driver.findElement(By.xpath("//input[@id='user_login']"));
        userName.sendKeys("username");

        // 4. Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // 6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();

        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement amountMoney = driver.findElement(By.id("sp_amount"));
        amountMoney.sendKeys("250");

        // 8. tarih kismina “2020-09-10”
        WebElement dateBox = driver.findElement(By.id("sp_date"));
        dateBox.sendKeys("2020-09-10");

        // 9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        // 10. “The payment was successfully submitted.” mesajinin ciktigini control edin

        WebElement pageMessage = driver.findElement(By.id("alert_content"));
        if (pageMessage.isDisplayed()){
            System.out.println("The payment was successfully submitted yazısı testi PASS");
        }else {
            System.out.println("The payment was successfully submitted yazısı testi FAILED");
        }

        driver.close();


    }
}
