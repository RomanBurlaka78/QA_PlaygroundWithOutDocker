package playground.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SortableListPage extends BasePage<SortableListPage>{
    public SortableListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "ul[id='draggable-list'] li")
    List<WebElement> sortableList;


    public SortableListPage getElementOfSortedList(String text) {
        sortableList.stream()
                .filter(element -> element.getText().equals(text))
                .findFirst()
                .ifPresentOrElse(element -> element.click(),   () -> { throw new RuntimeException("Элемент с текстом '" + text + "' не найден"); });

        return this;
    }

    public List<String> getTableSortedList() {
        List<String> itemsList = sortableList.stream().map(WebElement::getText).collect(Collectors.toList());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return itemsList;
    }

}
