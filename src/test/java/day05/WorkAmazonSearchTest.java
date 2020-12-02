package day05;
/*







 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//Class Work Amazon Search Test
public class WorkAmazonSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

    //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

    //2- arama kutusunu locate edelim
    //3- “Samsung headphones” ile arama yapalim
    //4- Bulunan sonuc sayisini yazdiralim
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchTextBox.sendKeys("Samsung headphones");
        searchTextBox.submit();
        Thread.sleep(2000);
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());


    //5- Ilk urunu tiklayalim
         driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
         Thread.sleep(3000);
         driver.navigate().back();

    //6- Sayfadaki tum basliklari yazdiralim
        List<WebElement> baslikListesi = driver.findElements(By.xpath("(//span[@dir='auto'])"));
        for (WebElement w : baslikListesi
        ) {
            System.out.println(w.getText());
        }
        driver.close();






    }
}
