package extensions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.PageGuiceModule;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class UIExtensions implements BeforeEachCallback, AfterEachCallback {

    Injector injector = null;

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        injector = Guice.createInjector(new PageGuiceModule());
        injector.injectMembers(extensionContext.getTestInstance());
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        WebDriver webDriver = injector.getProvider(WebDriver.class).get();
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }
}
