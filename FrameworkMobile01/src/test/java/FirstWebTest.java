import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstWebTest {

    WebDriver driver = null;

    @Test
    public void testWiki() {
        //String driverPath = "C:\\Users\\ajruiz\\IdeaProjects\\EjSelenium01\\drivers\\chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();

        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
        //driver.navigate().to("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        WebElement searchInput = (WebElement) driver.findElement(By.cssSelector(".cdx-text-input__input"));
        searchInput.sendKeys("Selenium");

    }

}
