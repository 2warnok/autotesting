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
public class LotTest extends DriverFactory {


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
    @Story("Тест без настроек - Жребий")
    @JiraIssues({@JiraIssue("Тестирование приложения Случайных чисел")})
    @Tags({@Tag("111"), @Tag("222")})
    @DisplayName("Тест приложения Случайных чисел - Жребий")
    public void shouldCreateIssue() {

        ElementsNumbers elementsNumbers = new ElementsNumbers(driver);

//First click DiceList
        elementsNumbers.getLotList();


//1 case - simple
        System.out.println("Generate first - without parameter");
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
//back to the list
        System.out.println("Back to the LotList");
        elementsNumbers.getBackToList();
//2 case
        System.out.println("Second click LotList - check other number");
        elementsNumbers.getLotList();
//add two
        elementsNumbers.getFromLot().sendKeys("5");
        elementsNumbers.getToLot().sendKeys("3");
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
//back to the list
        System.out.println("Back to the list");
        elementsNumbers.getBackToList();
//3 case

        System.out.println("Third click LotList - check other number");
        elementsNumbers.getLotList();
        elementsNumbers.getFromLot().sendKeys("15");
        elementsNumbers.getToLot().sendKeys("13");
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
    }}
