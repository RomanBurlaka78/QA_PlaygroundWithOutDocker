package playground.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class BaseTest {
    protected WebDriver driver;
    private String browser;


    protected WebDriver getDriver() {
        return driver;
    }
    List<String> optionalBrowser = List.of("firefox", "chrome", "edge");
    Random random = new Random();
    String optionalItem = optionalBrowser.get(random.nextInt(optionalBrowser.size()));


    @BeforeClass
    @Parameters("browser")
    protected void beforeClass(@Optional("chrome") String browserParam) {
        this.browser = browserParam;
        Arrays.stream(this.getClass().getMethods())
                .filter(m -> m.getAnnotation(Test.class) != null && m.getAnnotation(Ignore.class) == null)
                .collect(Collectors.toList());

    }

    @BeforeMethod
    public WebDriver setUp() {

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1920,1080");
//                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--window-size=1920,1080");
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }


        driver.get("https://qaplayground.dev/");
        return driver;
    }


    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            driver.quit();
        } else {
            System.out.println("Failed: " + testResult.getTestClass());
        }
    }
}
