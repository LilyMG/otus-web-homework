package mainpage;

import annotations.Path;
import extensions.UIExtensions;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@Path("/")
@ExtendWith(UIExtensions.class)
public class MainPage_Test {

    @Inject
    private WebDriver webDriver;

    @Inject
    private MainPage mainPage;

    @Test
    public void mainPageTest(){}

}
