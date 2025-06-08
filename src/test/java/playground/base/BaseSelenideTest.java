package playground.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;

public class BaseSelenideTest {

    public  void createDriver()  {
//        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = "https://qaplayground.dev";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.webdriverLogsEnabled = true;
        Configuration.headless = false;
        Configuration.timeout = 10000;

    }
    @BeforeMethod
    public void setUp(){
        Selenide.closeWebDriver();
    }
}
