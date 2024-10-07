package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class PageGuiceModule extends AbstractModule {

    @Provides
    public WebDriver getDriver() {
        //todo implement factory
        return null;
    }

    @Provides
    @Singleton
    public MainPage getMainPage() {
        return new MainPage(getDriver());
    }

}
