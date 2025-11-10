package playground.pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class MultiLevelDropDownPage extends BasePage<MultiLevelDropDownPage>{
    public MultiLevelDropDownPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(getDriver());

    @FindBy(css = "a[class='icon-button']")
    List<WebElement> listIcons;

    @FindBy(css = "a[class='menu-item']")
    List<WebElement> menuInnerList;

    @FindBy(css = "div[class='dropdown'] div a span")
    List<WebElement> settingsList;


    @Step("click dropdown menu and choose item : {name}")
    public MultiLevelDropDownPage clickDropDownAndChooseItem(String name) throws ElementClickInterceptedException {
       try {
           actions.click(listIcons.get(3)).perform();
           String finalName = name;
           menuInnerList.stream()
                   .filter(e -> e.getText().contains(finalName))
                   .findFirst().ifPresent(actions->actions.click());
           actions.perform();
       }
       catch (ElementClickInterceptedException e) {
           name = "Not found: " + e;
           Allure.addAttachment("Error", name);
       }

        return this;
    }
    @Step("get dropdown list")
    public String getDropdownList(){
       return settingsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()).toString();

    }
    @Step("get dropdown list contains")
    public String dropdownListContains(String name){
        return settingsList.stream()
                .filter(element -> element.getText().equals(name))
                .findFirst()
                .map(WebElement::getText)
                .orElseThrow(() -> new RuntimeException("Element '" + name + "' not found"));
    }

}
