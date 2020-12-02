package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        // 2. Username kutusuna “standard_user” yazdirin
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement userNameBox = driver.findElement(By.id("user-name"));
        userNameBox.sendKeys("standard_user");

        // 3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("secret_sauce");

        // 4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firsrProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String firstProductName = firsrProduct.getText();
        Thread.sleep(3000);
        firsrProduct.click();

        //6. Add to Cart butonuna basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])")).click();

        //7. Alisveris sepetine tiklayin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement boxToProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String boxToProductName = boxToProduct.getText();
        if (firstProductName.equals(boxToProductName)){
            System.out.println("alışveriş sepeti testi PASS");
        }else {
            System.out.println("alışveriş sepeti testi FAILED");
            System.out.println("Sepetteki ürün ile seçtiğim ürün aynı değil");
        }
        // 9. Sayfayi kapatin
        driver.close();



    }
}
