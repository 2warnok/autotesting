import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


@Layer("web")
@Owner("yaroslav")
@Feature("Тесты с опциями")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PullRequestsWebTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private static final String BRANCH = "new-feature";

    private final WebSteps steps = new WebSteps();

    private final DriverFactory driverFactory = new DriverFactory();



    //number
    // @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\" ЧИСЛО \")")
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
    @BeforeAll
    public void setDriver() throws MalformedURLException {
        driver = driverFactory.setUp(Platform.ANDROID);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AfterAll
    public void tearDown() {
        driver.quit();
    }
    AppiumDriver<?> driver;


    @BeforeEach
    public void startDriver() {
        steps.startDriver();
    }


    @Test
    @TM4J("Это где будет писаться? лала")
    @Microservice("Тест на мобильных устройствах с опциями")
    @Story("Тест случайных чисел с опциями")
    @Tags({@Tag("111"), @Tag("222")})
    @JiraIssues({@JiraIssue("Тесттест")})
    @DisplayName("Тест на мобильных устройствах с включенными настройками")

    public void shouldCloseIssue() {


        //click number
        Assert.assertFalse(numberScreen.isSelected());
        numberScreen.click();
//change from 1
        Assert.assertTrue(numberFrom.isDisplayed());
      numberFrom.clear();
      numberFrom.sendKeys("1");


//change from 1
        Assert.assertTrue(numberTo.isDisplayed());
        numberTo.clear();
        numberTo.sendKeys("1");

        //String key2 = "2";
//add param
        Assert.assertTrue(addParam.isDisplayed());
        addParam.click();
//repeat
        Assert.assertTrue(noRepeatParam.isDisplayed());
        //noRepeatParam.getAttribute("checked");

        // Assert.assertEquals(true, noRepeatParam.isSelected());

        noRepeatParam.click();

//quantity
        Assert.assertTrue(quantityParam.isDisplayed());
       quantityParam.click();
//delay
        Assert.assertTrue(delayParam.isDisplayed());
        delayParam.click();

//apply param
        Assert.assertTrue(applyParam.isDisplayed());
        applyParam.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//apply two option
        Assert.assertTrue(addQuantity.isDisplayed());
        addQuantity.clear();
        addQuantity.sendKeys("2");

        Assert.assertTrue(addDelay.isDisplayed());
        addQuantity.clear();
        addQuantity.sendKeys("1");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//generate
        Assert.assertTrue(generate.isDisplayed());

        generate.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//check generate
        if (generateOne.isDisplayed()==true || generateTwo.isDisplayed()==true) {
            generate.click();
            generate.click();
            generate.click();
        } else if (generateComma.isDisplayed()==true) {
            System.out.println("oops comma");
            throw new NullPointerException("Exception: oops!");
        }
    }

    @AfterEach
    public void stopDriver() {
        steps.stopDriver();
    }

}