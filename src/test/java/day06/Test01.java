package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// Test01 isimli bir class olusturun
public class Test01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");

        //Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Save";

        if (actualPageTitle.contains(expectedPageTitle)){
            System.out.println("Sayfa başlığında " + expectedPageTitle + "geçiyor PASS");
        }else {
            System.out.println("Sayfa başlığında " + expectedPageTitle + "geçmiyor FAILED");
        }

        //Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expectedPageEqual = "Walmart.com | Save Money.Live Better";

        if (actualPageTitle.equals(expectedPageEqual)){
            System.out.println("Sayfa " + expectedPageEqual + " e eşit. PASS");
        }else {
            System.out.println("Sayfa " + expectedPageEqual + " e eşit değil. FAILED");
            System.out.println("Actual Title : " + actualPageTitle);
            System.out.println("Expecterd Title : " + expectedPageEqual);
        }

        //URL in walmart.com icerdigini control edin
        String actualPageURL = driver.getCurrentUrl();
        String expectedPageURL = "walmart.com";

        if (actualPageURL.contains(expectedPageURL)){
            System.out.println("Sayfa URL si " + expectedPageURL + " içeriyor PASS" );
        }else{
            System.out.println("Sayfa URL si " + expectedPageURL + " içermiyor FAILED" );
        }

        //”Nutella” icin arama yapiniz
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement nutellaSearch = driver.findElement(By.xpath("//input[@class='h_a a8_b header-GlobalSearch-input mweb-Typeahead-input h_b']"));
        String searchWord = "Nutella";
        nutellaSearch.sendKeys(searchWord+ Keys.ENTER);

        //Kac sonuc bulundugunu yaziniz
        WebElement goruntuSayisi = driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println("aramada " + goruntuSayisi.getText() + " kadar sonuç bulundu");

        //Sayfayi kapatin
        driver.quit();
    }
}
