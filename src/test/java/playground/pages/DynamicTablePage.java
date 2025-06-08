package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DynamicTablePage extends BasePage<DynamicTablePage> {
    public DynamicTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='text-sm font-medium text-white-900']")
    List<WebElement> tableList;

    @FindBy(xpath = "//span[@class='text-sm font-medium text-white-900']")
    List<WebElement> realName;


    public List<String> getTableList() {
        List<String> itemsList = tableList.stream()
                .map(e -> e.getText())
                .toList();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return itemsList;
    }

    @Step("superhero on list should be : [{text}] ")
    public DynamicTablePage superHeroShouldBeAs(String text) {
        List<WebElement> e = wait5().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='text-sm font-medium text-white-900']")));
        e.stream()
                .filter(element -> element.getText().equals(text))
                .findFirst()
                .ifPresentOrElse(element -> element.click(), () -> {
                    throw new RuntimeException("Element  '" + text + "' not found");
                });

        return this;
    }


    @Step("real name on list should be : [{text}] ")
    public String realNameShouldBeAs(String text) {
        List<WebElement> e = wait5().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='text-sm font-medium text-white-900']")));
        return e.stream()
                .filter(element -> element.getText().equals(text))
                .findFirst()
                .map(WebElement::getText)
                .orElseThrow(() -> new RuntimeException("Element '" + text + "' not found"));
    }


}
