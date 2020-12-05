package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertion {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void pozitifTest(){
        //Sayfa başlığının TECHPROED içerdiğini doğrulayın
        String searchWord = "TECHPROED";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(searchWord));
    }

    @Test
    public void negatifTest(){
        //sayfa başlığının Mehmet kelimesi içermediğini doğrulayın
        String searchWord = "Mehmet";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(searchWord));
    }
    @Test
    public void equalTest(){
        //sayfa başlığının TECHPROED | SDET | Java Developer | Web Developer | DevOps Engineer olduğunu test ediniz
        String actualTitle = driver.getTitle();
        String expectedTitle = "TECHPROED | SDET | Java Developer | Web Developer | DevOps Engineer";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
