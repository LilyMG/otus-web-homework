package pages;

import annotations.Template;
import annotations.UrlTemplates;
import org.openqa.selenium.WebDriver;

@UrlTemplates(
        template = @Template(name = "news_templates", template = "/$1/$2")
)
public class NewsPage extends AbsBasePage {
    public NewsPage(WebDriver driver) {
        super(driver);
    }
}
