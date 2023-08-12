import annotations.*;
import config.WebSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import screen.Platform;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


@Layer("web")
@Owner("yaroslav")
@Feature("Тесты с опциями")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberTestCustom extends BaseTest{
  /*  private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";
    private static final String BRANCH = "new-feature";
    private final WebSteps steps = new WebSteps();
    private final DriverFactory driverFactory = new DriverFactory();


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
    */

    @Test
    @TM4J("Это где будет писаться? лала")
    @Microservice("Тест на мобильных устройствах с опциями")
    @Story("Тест случайных чисел с опциями")
    @Tags({@Tag("111"), @Tag("222")})
    @JiraIssues({@JiraIssue("Тесттест")})
    @DisplayName("Тест на мобильных устройствах с включенными настройками")

    public void shouldCloseIssue() {
        ElementsNumbers elementsNumbers = new ElementsNumbers(driver);
        //click number
        // Assert.assertFalse(elementsNumbers.getNumberScreen().isSelected());
        elementsNumbers.getNumberScreen().click();
//change from 1
        // Assert.assertTrue(elementsNumbers.getNumberFrom().isDisplayed());
        elementsNumbers.getNumberFrom().clear();
        elementsNumbers.getNumberFrom().sendKeys("1");
//change from 1
        //Assert.assertTrue(elementsNumbers.getNumberTo().isDisplayed());
        elementsNumbers.getNumberTo().clear();
        elementsNumbers.getNumberTo().sendKeys("2");
        System.out.println("Ввели числа");
//add param
        //Assert.assertTrue(elementsNumbers.addParam.isDisplayed());
        elementsNumbers.getAddParam();
        System.out.println("Нажимаем параметры");
//repeat
        //Assert.assertTrue(noRepeatParam.isDisplayed());
        //  System.out.println(noRepeatParam.getAttribute("checked"));
        elementsNumbers.getNoRepeatParam();
        // System.out.println(noRepeatParam.getAttribute("checked"));
//quantity
        // Assert.assertTrue(quantityParam.isDisplayed());
        elementsNumbers.getQuantityParam();
//delay
        //Assert.assertTrue(delayParam.isDisplayed());
        elementsNumbers.getDelayParam();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//apply param
        //Assert.assertTrue(applyParam.isDisplayed());
        elementsNumbers.getApplyParam();
        System.out.println("Подтверждаем параметры");

        System.out.println("Ставим количество на 2");
        elementsNumbers.getAddQuantity().clear();
        elementsNumbers.getAddQuantity().sendKeys("2");

        System.out.println("Ставим задержку на 1");
        elementsNumbers.getAddDelay().clear();
        elementsNumbers.getAddDelay().sendKeys("1");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//generate
        //Assert.assertTrue(generate.isDisplayed());
        System.out.println("Generate first");
        elementsNumbers.getGenerate();
//check generate

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (elementsNumbers.getGenerateOneTwo().isDisplayed()) {
            System.out.println("if 1, 2 generate");
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
        } else if (elementsNumbers.getGenerateOneOne().isDisplayed()) {
            System.out.println("if 1, 1 generate");
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
        } else if (elementsNumbers.getGenerateTwoOne().isDisplayed()) {
            System.out.println("if 2, 1 generate");
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
            elementsNumbers.screenshot();
        }
        else {
            elementsNumbers.screenshot();
            elementsNumbers.getException();
        }
    }
    // @AfterEach
   // public void stopDriver() {
    //    steps.stopDriver();
    //}

}