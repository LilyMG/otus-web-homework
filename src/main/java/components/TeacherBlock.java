package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TeacherBlock extends AbsBaseComponent<TeacherBlock>{

    public static void main(String[] args) {
        System.out.println("hello");
    }
    @FindBy(xpath = "")
    //todo add xpath
    private List<WebElement> teacherTiles;

    public TeacherBlock(WebDriver webDriver) {
        super(webDriver);
    }
}
