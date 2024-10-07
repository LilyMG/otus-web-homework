package pages;

import annotations.Path;
import annotations.Template;
import annotations.UrlTemplates;
import commons.AbsCommonObject;
import exceptions.IncorrectNavigationException;
import org.openqa.selenium.WebDriver;

import java.util.*;

public abstract class AbsBasePage<T> extends AbsCommonObject<T> {
    private final String baseUrl = System.getProperty("base.url");

    private String getPath() {
        Class clazz = getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            Path path = (Path) clazz.getDeclaredAnnotation(Path.class);
            return path.value();
        } else
            throw new IncorrectNavigationException("path parameter was not set via annotation");
    }

    private String getTemplatePath(String templateName, String[] data) {
        Class clazz = getClass();
        if (clazz.isAnnotationPresent(UrlTemplates.class)) {
            UrlTemplates urlTemplates = (UrlTemplates) clazz.getDeclaredAnnotation(UrlTemplates.class);
            Template[] templates = urlTemplates.template();
            String templateStr = Arrays.stream(templates)
                    .filter((Template template) -> template.name().equals(templateName))
                    .findFirst().get().template();
            for (int i = 0; i < data.length; i++) {
                int num = i + 1;
                templateStr = templateStr.replace("$" + num, data[i]);
            }
            return templateStr;
        }
        throw new IncorrectNavigationException("path parameter was not set via annotation");
    }

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public T open() {
        driver.get(baseUrl + getPath());
        return (T) this;
    }

    public T open(String nameTemplate, String[] data) {
        driver.get(baseUrl + getTemplatePath(nameTemplate, data));
        return (T) this;
    }

}
