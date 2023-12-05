import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;
import pages.WelcomeScreen;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTestApk {
    //SoftAssert softAssert = new SoftAssert();
    public static AndroidDriver<AndroidElement> driver;

    //WebDriver driver = null;

    Dotenv dotenv = Dotenv.load();

    public Logger Log = Logger.getLogger(BaseTestApk.class);

    @BeforeTest
    public void beforeTest(){
        DesiredCapabilities capabilities = this.environmentSetup();
        try{
            driver = new AndroidDriver<>(new URL(" http://127.0.0.1:4723/"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.info(driver);
    }

    private DesiredCapabilities environmentSetup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, dotenv.get("APP_PATH"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, dotenv.get("PLATFORM"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, dotenv.get("PLATFORM_VERSION"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dotenv.get("DEVICE_NAME"));
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.wdiodemoapp");
        capabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
        return capabilities;

    }

    public WelcomeScreen getWelcomeScreen(){
        return new WelcomeScreen(driver);
    }

    @AfterTest
    public void afterTest() {
        //driver.quit();
    }

}
