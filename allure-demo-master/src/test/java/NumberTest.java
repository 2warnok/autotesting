import annotations.*;
import config.WebSteps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Description;
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
@Feature("Тесты")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberTest extends DriverFactory {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";
    private static final String ISSUE_TITLE = "Some issue title here";

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

    @BeforeEach
    public void startDriver() {
        steps.startDriver();
    }

    @Test
    @TM4J("Это у нас отметка где?")
    @Microservice("Тест")
    @Story("Тест без настроек")
    @JiraIssues({@JiraIssue("Тестирование приложения Случайных чисел")})
    @Tags({@Tag("111"), @Tag("222")})
    @DisplayName("Тест приложения Случайных чисел - без настроек")
    @Description("Описание для теста Случайных чисел - без настроек")
    public void shouldCreateIssue() {

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
        elementsNumbers.getNumberTo().sendKeys("1");
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

//apply param
        //Assert.assertTrue(applyParam.isDisplayed());
        elementsNumbers.getApplyParam();
        System.out.println("Подтверждаем параметры");
//generate
        //Assert.assertTrue(generate.isDisplayed());
        System.out.println("Generate first");
        elementsNumbers.getGenerate();

       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//check generate
        System.out.println(elementsNumbers.generateOne);
        System.out.println(elementsNumbers.getGenerateOOne());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (elementsNumbers.getGenerateOOne().isDisplayed()) {
            System.out.println("if 1 generate");
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
        } else if (elementsNumbers.getGenerateTwo().isDisplayed()) {
            System.out.println("if 2 generate");
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();

        } else {
            elementsNumbers.getException();
        }
        // Assert.assertTrue(generateOne.isDisplayed() || generateTwo.isDisplayed());
    }
   /* @AfterEach
    public void stopDriver() {
        steps.stopDriver();
    }*/

}
