
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;


public class BaseTest {

    SoftAssert softAssert = new SoftAssert();

    WebDriver driver = null;

    Dotenv dotenv = Dotenv.load();

    public Logger Log = Logger.getLogger(BaseTestApk.class);

    @BeforeTest
    public void beforeTest() {
        Log.info(dotenv.get(""));
                String driverPath = "";
                System.setProperty("webdiver.chrome.driver", driverPath);
                driver = new ChromeDriver();

    }
}
