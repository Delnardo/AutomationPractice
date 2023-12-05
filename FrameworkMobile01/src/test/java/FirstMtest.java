import org.testng.annotations.Test;
import pages.WelcomeScreen;

public class FirstMtest extends BaseTestApk {

    //@Test(groups = "mobile")
    //public void testMobile() {log.info("First Test"); }

    @Test
    public void test(){
        System.out.println("Holaaa");
        WelcomeScreen welcomeScreen = getWelcomeScreen();
        welcomeScreen.clickOnForm();
    }

}
