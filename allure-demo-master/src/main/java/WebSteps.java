import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class WebSteps {

    @Step("Starting web driver")
    public void startDriver() {
        maybeThrowSeleniumTimeoutException();
    }

    @Step("Stopping web driver")
    public void stopDriver() {
        maybeThrowSeleniumTimeoutException();
    }

    @Step("Open issues page `{owner}/{repo}`")
    public void openIssuesPage(final String owner, final String repo) {
        attachPageSource();
        maybeThrowElementNotFoundException();
    }

    @Step("Open pull requests page `{owner}/{repo}`")
    public void openPullRequestsPage(final String owner, final String repo) {
        attachPageSource();
        maybeThrowElementNotFoundException();
    }

    @Step("Create pull request from branch `{branch}`")
    public void createPullRequestFromBranch(final String branch) {
        maybeThrowElementNotFoundException();
    }

    @Step("Create issue with title `{title}`")
    public void createIssueWithTitle(String title) {
        maybeThrowAssertionException(title);
    }

    @Step("Close pull request for branch `{branch}`")
    public void closePullRequestForBranch(final String branch) {
        maybeThrowAssertionException(branch);
    }

    @Step("Close issue with title `{title}`")
    public void closeIssueWithTitle(final String title) {
        maybeThrowAssertionException(title);
    }

    @Step("Check pull request for branch `{branch}` exists")
    public void shouldSeePullRequestForBranch(final String branch) {
        maybeThrowAssertionException(branch);
    }

    @Step("Check issue with title `{title}` exists")
    public void shouldSeeIssueWithTitle(final String title) {
        maybeThrowAssertionException(title);
    }

    @Step("Check pull request for branch `{branch}` not exists")
    public void shouldNotSeePullRequestForBranch(final String branch) {
        maybeThrowAssertionException(branch);
    }

    @Step("Check issue with title `{title}` not exists")
    public void shouldNotSeeIssueWithTitle(final String title) {
        maybeThrowAssertionException(title);
    }

    @Attachment(value = "Page", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        try {
            final InputStream stream = ClassLoader.getSystemResourceAsStream("index.html");
            return IOUtils.toString(stream, Charset.forName("UTF-8")).getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void maybeThrowSeleniumTimeoutException() {
        if (isTimeToThrowException()) {
            fail(webDriverIsNotReachable("Allure"));
        }
    }

    private void maybeThrowElementNotFoundException() {
        try {
            Thread.sleep(1000);
            if (isTimeToThrowException()) {
                fail(elementNotFoundMessage("[//div[@class='something']]"));
            }
        } catch (InterruptedException e) {
            //do nothing, it's dummy test
        }
    }

    private void maybeThrowAssertionException(String text) {
        if (isTimeToThrowException()) {
            fail(textEqual(text, "another text"));
        }
    }

    private boolean isTimeToThrowException() {
        return new Random().nextBoolean()
                && new Random().nextBoolean()
                && new Random().nextBoolean()
                && new Random().nextBoolean();
    }

    private String webDriverIsNotReachable(final String text) {
        return String.format("WebDriverException: chrome not reachable\n" +
                "Element not found {By.xpath: //a[@href='/eroshenkoam/allure-example']}\n" +
                "Expected: text '%s'\n" +
                "Page source: file:/Users/eroshenkoam/Developer/eroshenkoam/webdriver-coverage-example/build/reports/tests/1603973861960.0.html\n" +
                "Timeout: 4 s.", text);
    }

    private String textEqual(final String expected, final String actual) {
        return String.format("Element should text '%s' {By.xpath: //a[@href='/eroshenkoam/allure-example']}\n" +
                "Element: '<a class=\"v-align-middle\">%s</a>'\n" +
                "Screenshot: file:/Users/eroshenkoam/Developer/eroshenkoam/webdriver-coverage-example/build/reports/tests/1603973703632.0.png\n" +
                "Page source: file:/Users/eroshenkoam/Developer/eroshenkoam/webdriver-coverage-example/build/reports/tests/1603973703632.0.html\n" +
                "Timeout: 4 s.\n", expected, actual);
    }

    private String elementNotFoundMessage(String selector) {
        return String.format("Element not found {By.xpath: %s}\n" +
                "Expected: visible or transparent: visible or have css value opacity=0\n" +
                "Screenshot: file:/Users/eroshenkoam/Developer/eroshenkoam/webdriver-coverage-example/build/reports/tests/1603973516437.0.png\n" +
                "Page source: file:/Users/eroshenkoam/Developer/eroshenkoam/webdriver-coverage-example/build/reports/tests/1603973516437.0.html\n" +
                "Timeout: 4 s.\n", selector);
    }

    public static class ElementsRnumbers {
        @AndroidFindBy(xpath =  "//android.widget.ScrollView/android.widget.TextView[@text=\",\"]")
        MobileElement generateComma;
        @AndroidFindBy(xpath =  "//android.widget.ScrollView/android.widget.TextView[@text=\"1\"]")
        MobileElement generateOne;

        @AndroidFindBy(xpath =  "//android.widget.ScrollView/android.widget.TextView[@text=\"2\"]")
        MobileElement generateTwo;
        @AndroidFindBy(xpath =  "//android.widget.ScrollView/android.widget.TextView[@text=\"3\"]")
        MobileElement generateThree;
        @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]")
        MobileElement numberScreen;

        @AndroidFindBy(id = "ru.uxapps.random:id/f_num_from_et")
        MobileElement numberFrom;

        @AndroidFindBy(id = "ru.uxapps.random:id/f_num_to")
        MobileElement numberTo;

        //custom

        @AndroidFindBy(id = "ru.uxapps.random:id/v_params_quantity_et")
        MobileElement addQuantity;

        @AndroidFindBy(id = "ru.uxapps.random:id/v_params_delay_et")
        MobileElement addDelay;

        @AndroidFindBy(id = "ru.uxapps.random:id/v_param_add_features")
        MobileElement addParam;

        @AndroidFindBy(id = "ru.uxapps.random:id/d_feat_set_no_rep_switch")
        MobileElement noRepeatParam;

        @AndroidFindBy(id = "ru.uxapps.random:id/d_feat_set_quantity_switch")
        MobileElement quantityParam;
        @AndroidFindBy(id = "ru.uxapps.random:id/d_feat_set_delay_switch")
        MobileElement delayParam;

        @AndroidFindBy(id = "android:id/button1")
        MobileElement applyParam;

        @AndroidFindBy(id = "ru.uxapps.random:id/v_trigger_fab")
        MobileElement generate;
    }
}
