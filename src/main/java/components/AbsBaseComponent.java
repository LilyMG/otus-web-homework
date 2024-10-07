package components;

import commons.AbsCommonObject;
import org.openqa.selenium.WebDriver;

public class AbsBaseComponent<T> extends AbsCommonObject<T> {

    public AbsBaseComponent(WebDriver webDriver) {
        super(webDriver);
    }
}
