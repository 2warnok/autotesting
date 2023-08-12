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
public class ListTest extends BaseTest {


  /*  private final WebSteps steps = new WebSteps();
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
*/
    @Test
    @TM4J("Это у нас отметка где?")
    @Microservice("Тест")
    @Story("Тест без настроек - Список")
    @JiraIssues({@JiraIssue("Тестирование приложения Случайных чисел")})
    @Tags({@Tag("111"), @Tag("222")})
    @DisplayName("Тест приложения Случайных чисел - Список")
    public void shouldCreateIssue() {

        ElementsNumbers elementsNumbers = new ElementsNumbers(driver);

//First click List
        elementsNumbers.getLinkList();



        System.out.println("We are here");
//TEST this
        String defaultList = elementsNumbers.getNewTextListArray().getText();
        String[] splitList = defaultList.split("\n");
        String sym = splitList[0];
        System.out.println(sym);
        String resultList = String.join("\n", splitList);
        elementsNumbers.getNewTextListArray().sendKeys( "sym");
        elementsNumbers.getNewTextListArray().sendKeys(sym);
//TEST this

//1 case - simple
        System.out.println("Generate first - without parametr");
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
//back to the list
        System.out.println("Back to the list");
        elementsNumbers.getBackToList();
//2 case
        System.out.println("Second click List - check repeat");
        elementsNumbers.getLinkList();
//add param
        elementsNumbers.getAddParam();
        System.out.println("Click parametrs");
//repeat enable
        elementsNumbers.getNoRepeatParam();
//apply param
        elementsNumbers.getApplyParam();
        System.out.println("Apply param");
        System.out.println("check repeat - 5 click");
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
//back to the list
        System.out.println("Back to the list");
        elementsNumbers.getBackToList();
//3 case
        System.out.println("Third click List - check quantity");
        elementsNumbers.getLinkList();
//add param
        elementsNumbers.getAddParam();
        System.out.println("Click parametrs");
//repeat disable
        System.out.println("repeat disable");
        elementsNumbers.getNoRepeatParam();
//quantity enable
        System.out.println("quantity enable");
        elementsNumbers.getQuantityParam();
//apply param
        elementsNumbers.getApplyParam();
        System.out.println("Apply param");
        elementsNumbers.getAddQuantity().sendKeys("2");
        System.out.println("check quantity - 5 click");
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
//back to the list
        System.out.println("Back to the list");
        elementsNumbers.getBackToList();
//4 case
        System.out.println("For click List - check delay");
        elementsNumbers.getLinkList();
//add param
        elementsNumbers.getAddParam();
        System.out.println("Click parametrs");
//quantity disable
        System.out.println("quantity disable");
        elementsNumbers.getQuantityParam();
//delay enable
        System.out.println("delay enable");
        elementsNumbers.getDelayParam();
//apply param
        elementsNumbers.getApplyParam();
        System.out.println("Apply param");
        elementsNumbers.getAddDelay().sendKeys("2");
        System.out.println("check quantity - 5 click");
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
//back to the list
        System.out.println("Back to the list");
        elementsNumbers.getBackToList();
//5 case
        System.out.println("Five click List - check all param");
        elementsNumbers.getLinkList();
//add param
        elementsNumbers.getAddParam();
        System.out.println("Click parametrs");
//repeat enable
        System.out.println("repeat enable");
        elementsNumbers.getNoRepeatParam();
//quantity enable
        System.out.println("quantity enable");
        elementsNumbers.getQuantityParam();
//delay enable
        System.out.println("delay enable");
//apply param
        elementsNumbers.getApplyParam();
        System.out.println("Apply param");
        elementsNumbers.getAddQuantity().sendKeys("2");
        elementsNumbers.getAddDelay().sendKeys("2");
        System.out.println("check all");
        elementsNumbers.getGenerate();
        if (elementsNumbers.getFindComma().isDisplayed()) {
            System.out.println("find 1 comma");
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
            elementsNumbers.getGenerate();
        } else {

            elementsNumbers.getException();
        }
//back to the list
        System.out.println("Back to the list");
        elementsNumbers.getBackToList();
//click new List +
        elementsNumbers.getAddNewList();
//rename List
        elementsNumbers.getNewTextList().sendKeys("Testlist");
//save change
        elementsNumbers.getSaveTextList();
//quick rename
        elementsNumbers.getRenameTextList();
//rename List
        elementsNumbers.getNewTextList().sendKeys("testtest");
//save change
        elementsNumbers.getSaveTextList();


        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();
        elementsNumbers.getGenerate();

        System.out.println("We have congratulations");

///////////////////////////////////////////////////////////////////////
        /* System.out.println(elementsNumbers.generateOne);
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
        }*/
        // Assert.assertTrue(generateOne.isDisplayed() || generateTwo.isDisplayed());
    }
   /* @AfterEach
    public void stopDriver() {
        steps.stopDriver();
    }*/

}
