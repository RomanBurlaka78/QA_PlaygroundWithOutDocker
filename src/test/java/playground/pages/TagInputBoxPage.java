package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagInputBoxPage extends BasePage<TagInputBoxPage>{
    public TagInputBoxPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input[type = 'text']")
    WebElement addTag;
    @FindBy(css = "div[class = 'details'] p ")
    WebElement tags;

    @Step("add tag with name : {title}")
    public TagInputBoxPage addTag(String title) {
        addTag.sendKeys(title, Keys.ENTER);

        return this;
    }

    @Step("add several tags")
    public TagInputBoxPage addSeveralTags(String names) {
        List<String> splitNames = Arrays.stream(names.split(",")).toList();
        for (int i = 0; i < splitNames.size(); i++) {
            addTag.sendKeys(splitNames.get(i), Keys.ENTER);
        }


        return  this;
    }
    @Step("{number} tags are remaining")
    public int tagsRemaining() {
        int number = Integer.parseInt(tags.getText().replaceAll("[^0-9]", ""));

        return number ;
    }
}
