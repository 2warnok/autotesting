import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class ScreenTestWatcher implements TestWatcher {

    protected AppiumDriver<?> driver;
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot();
    }
    private void takeScreenshot() {
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        String path = "./build/screenshots/" + screenshot.getName();
        try {
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}