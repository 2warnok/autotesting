import config.WebSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.PageFactory;
import screen.Platform;

import java.net.MalformedURLException;

public class BaseTest extends DriverFactory{
    private final WebSteps steps = new WebSteps();
    private final DriverFactory driverFactory = new DriverFactory();
    protected AppiumDriver<?> driver;

    @ExtendWith(ScreenTestWatcher.class)

    @BeforeAll
    public void setDriver() throws MalformedURLException {
        driver = driverFactory.setUp(Platform.ANDROID);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    @BeforeEach
    public void startDriver() {
        steps.startDriver();
    }
}
