package playground.pages;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MouseHoverPage extends BasePage<MouseHoverPage>{
    private static final Logger log = LoggerFactory.getLogger(MouseHoverPage.class);

    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    @Step("hover mouse and get price")
    public String getPrice() {
        int price = 0;
        getActions().moveToElement(getDriver().findElement(By.xpath("//img[@class = 'poster']"))).perform();

        String prices =  getDriver().findElement(By.xpath("//p[@class='current-price']")).getText();


        return  prices.replaceAll("^0-9","");
    }


}
