import annotations.*;
import config.WebSteps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import screen.Platform;

import java.net.MalformedURLException;


@Layer("web")
@Owner("yaroslav")
@Feature("Тесты")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CoinTest extends DriverFactory {


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
    @Story("Тест без настроек - Монетка")
    @JiraIssues({@JiraIssue("Тестирование приложения Случайных чисел")})
    @Tags({@Tag("111"), @Tag("222")})
    @DisplayName("Тест приложения Случайных чисел - Монетка")
    public void shouldCreateIssue() {

        ElementsNumbers elementsNumbers = new ElementsNumbers(driver);

//First click DiceList
        elementsNumbers.getCoinList();

//1 case - simple
        elementsNumbers.getCoinSwipe();
        elementsNumbers.getCoinSwipe();
        elementsNumbers.getCoinSwipe();
//back to the list
        System.out.println("Back to the CoinTest");
        elementsNumbers.getBackToList();

        System.out.println("Second click CoinTest");
        elementsNumbers.getCoinList();
        //2 case
        elementsNumbers.getCoinSwipe();
        elementsNumbers.getCoinSwipe();
        elementsNumbers.getCoinSwipe();
//add two

    }}
