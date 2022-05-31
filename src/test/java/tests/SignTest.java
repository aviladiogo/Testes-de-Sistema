package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignTest {
    //input yours driver repository location in this variable
    String repository = "C:/Users/Diogo/drivers/chromedriver.exe" ;

    @Test
    public void testPesquisaReddit() {
        System.setProperty("webdriver.chrome.driver", repository);
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //configure this timer in relation to your connection,
                                                                                // give the page enough time to load

        navegador.get("https://www.reddit.com");

        navegador.findElement(By.name("q")).sendKeys("nba"); //use the search bar
        navegador.findElement(By.name("q")).submit(); //press enter

        String url = navegador.getCurrentUrl();
        Assert.assertEquals("https://www.reddit.com/search/?q=nba", url); // we expect be at nba page in reddit
        Assert.assertNotEquals("https://www.reddit.com/search/?q=nfl", url); // we not expect be at nfl page in reddit

        navegador.close();
    }

    @Test
    public void testHomeReddit(){
        System.setProperty("webdriver.chrome.driver", repository);
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//configure this timer in relation to your connection,
                                                                             // give the page enough time to load

        navegador.get("https://www.reddit.com");

        navegador.findElement(By.name("q")).sendKeys("nba");
        navegador.findElement(By.name("q")).submit(); //press enter

        //_30BbATRhFv3V83DHNDjJAO (class of home button in reddit)
        navegador.findElement(By.className("_30BbATRhFv3V83DHNDjJAO")).click();


        String url = navegador.getCurrentUrl();
        Assert.assertEquals("https://www.reddit.com/", url); // we expect be at home page in reddit
        navegador.close();
    }

    @Test
    public void testCoinsButtonReddit(){
        System.setProperty("webdriver.chrome.driver", repository);
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//configure this timer in relation to your connection,
        // give the page enough time to load

        navegador.get("https://www.reddit.com/");


        navegador.findElement(By.id("USER_DROPDOWN_ID")).click(); // click in user
        navegador.findElement(By.className("f8nXLisWxOYzMMl1uIAP3")).click(); // going to coin page
        String url = navegador.getCurrentUrl();

        Assert.assertEquals("https://www.reddit.com/coins", url);
        navegador.close();

    }
}
