package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class RightClickMenuPage extends BasePage<RightClickMenuPage> {
    public RightClickMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li[class = 'menu-item']")
    List<WebElement> contextList;

    @FindBy(xpath = "//body")
    WebElement body;

    @FindBy(css = "p[id = 'msg']")
    WebElement msg;

    @Step("click right mouse button")
    public RightClickMenuPage clickContextMenu() {
        Actions actions = new Actions(getDriver());
        actions.contextClick(body).perform();
        return this;
    }

    @Step("get list of context menu")

    public String getListOfContextMenu() {

        return contextList.stream()
                .map(e -> e.getText())
                .collect(Collectors.toList())
                .toString();
    }

    @Step("menu item clicked should be : {item}")
    public String menuItemClickedShouldBeAs(String item, int number) {
        String itemText = contextList.get(number).getText();
        contextList.get(number).click();

        Assert.assertEquals(itemText, item);
        Assert.assertEquals(msg.getText(), String.format("Menu item %s clicked", itemText));
        return itemText + " Element clicked : " +  String.format("Menu item %s clicked", itemText);
    }

}
