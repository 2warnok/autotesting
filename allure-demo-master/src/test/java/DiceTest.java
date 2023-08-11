import annotations.*;
import config.WebSteps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import screen.Platform;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


@Layer("web")
@Owner("yaroslav")
@Feature("Тесты")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DiceTest extends DriverFactory {


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
    @Story("Тест без настроек - Игральные кости")
    @JiraIssues({@JiraIssue("Тестирование приложения Случайных чисел")})
    @Tags({@Tag("111"), @Tag("222")})
    @DisplayName("Тест приложения Случайных чисел - Игральные кости")
    public void shouldCreateIssue() {

        ElementsNumbers elementsNumbers = new ElementsNumbers(driver);

//First click DiceList
        elementsNumbers.getDiceList();


//1 case - simple




        System.out.println("Generate first - without parameter");
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();

//back to the list
        System.out.println("Back to the DiceList");
        elementsNumbers.getBackToList();
//2 case
        System.out.println("Second click DiceList - check other number");
        elementsNumbers.getDiceList();
//add two
        elementsNumbers.getTwoDice();
        System.out.println("Click two");

        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();

//back to the list
        System.out.println("Back to the list");
        elementsNumbers.getBackToList();
//3 case..custom
        System.out.println("Third click List - check other number");
        elementsNumbers.getDiceList();
        elementsNumbers.getOtherDice();
        elementsNumbers.getOtherTextDice().sendKeys("8");
        driver.hideKeyboard();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();


}}
