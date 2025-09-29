package playground.tests;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import playground.base.BaseSelenideTest;

import static com.codeborne.selenide.Selenide.$;
@Ignore
public class DynamicSelenideTest  extends BaseSelenideTest {

    @Test
    public void testDynamic() {
        Selenide.open("https://qaplayground.dev/apps/dynamic-table/");
        Selenide table = (Selenide) $(By.xpath("tbody[@id= 'tbody']//td"));

        //
    }

}
