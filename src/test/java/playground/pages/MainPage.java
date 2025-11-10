package playground.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends BasePage<MainPage> {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    protected WebDriver driver;
    String name;


    @Override
    public WebDriver getDriver() {
        return super.getDriver();
    }

    public <T> T goToPage(String name, T page) {
        getDriver().findElement(By.xpath(String.format("//a[@class='card card-course']//h3[text() ='%s']", name))).click();
        return page;
    }

    public MainPage getMainPage() {
        return new MainPage(getDriver());
    }

    public WebElement showPage(String name) {
        return getDriver().findElement(By.xpath(String.format("//a[@class='card card-course']//h3[text() ='%s']", name)));

    }


}
