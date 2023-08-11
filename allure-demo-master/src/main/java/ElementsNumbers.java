import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class ElementsNumbers extends Screen {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"1\")")
    MobileElement generateOOne;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"2\")")
    MobileElement generateTwo;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"1, 1\")")
    MobileElement generateOneOne;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"2, 1\")")
    MobileElement generateTwoOne;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"1, 2\")")
    MobileElement generateOneTwo;

    @AndroidFindBy(xpath =  "//android.widget.ScrollView/android.widget.TextView[@text=\"1\"]")
    MobileElement generateOne;


/*test spisok*/


    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"СПИСОК\")")
    MobileElement linkList;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"ИГРАЛЬНЫЕ КОСТИ\")")
    MobileElement diceList;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"ЖРЕБИЙ\")")
    MobileElement lotList;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Монетка\")")
    MobileElement coinList;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\",\")")
    MobileElement findComma;



    @AndroidFindBy(id = "ru.uxapps.random:id/i_add_list")
    MobileElement addNewList;

    @AndroidFindBy(id = "ru.uxapps.random:id/d_new_list_et")
    MobileElement newTextList;


    @AndroidFindBy(id = "ru.uxapps.random:id/f_list_et")
    MobileElement newTextListArray;

   // String defaultList = newTextListArray.getText();
   // String[] splitList = defaultList.split("\n");
   // String sym = splitList[0];
    //splitList[0] = item;
    //String resultList = String.join("gyjhgjhgjgh", sym);


    @AndroidFindBy(id = "android:id/button1")
    MobileElement saveTextList;

    @AndroidFindBy(id = "ru.uxapps.random:id/m_list_custom_rename")
    MobileElement renameTextList;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")
    MobileElement backToList;


/*test spisok*/

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]")
    MobileElement numberScreen;

    @AndroidFindBy(id = "ru.uxapps.random:id/f_num_from_et")
    MobileElement numberFrom;

    @AndroidFindBy(id = "ru.uxapps.random:id/f_num_to")
    MobileElement numberTo;


/*Dice*/
@AndroidFindBy(id = "ru.uxapps.random:id/custom_quantity_1")
MobileElement oneDice; //click
    @AndroidFindBy(id = "ru.uxapps.random:id/custom_quantity_2")
    MobileElement TwoDice; //click
@AndroidFindBy(id = "ru.uxapps.random:id/quantity_other_rb")
MobileElement otherDice; //click and otherTextDic s active

@AndroidFindBy(id = "ru.uxapps.random:id/other_quantity_et")
MobileElement otherTextDice; //text

/*Dice*/

    /*Coin*/



//swipe and click
    /*Coin*/

    /*Lot*/
    @AndroidFindBy(id = "ru.uxapps.random:id/f_lots_total_et")
    MobileElement fromLot;

    @AndroidFindBy(id = "ru.uxapps.random:id/f_lots_marked_et")
    MobileElement toLot;
    /*Lot*/


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

    public ElementsNumbers(AppiumDriver<?> driver) {  super(driver);  }


    @Step("Нажимаем 'СПИСОК'")
    public void getLinkList() {
        linkList.click();
    }
    @Step("Нажимаем 'ИГРАЛЬНЫЕ КОСТИ'")
    public void getDiceList() {
        diceList.click();
    }
    @Step("Нажимаем 'Жребий'")
    public void getLotList() {
        lotList.click();
    }
    @Step("Нажимаем 'Монетка'")
    public void getCoinList() {
        coinList.click();
    }

    @Step("Подкидываем 'Монетку'")
    public void getCoinSwipe() {
        swipe(Direction.UP);
    }

    @Step("Нашли запятую, генерируем дальше")
    public MobileElement getFindComma() {
        return findComma; //find Comma
    }
    @Step("Нажимаем 'Создать новый список'")
    public void getAddNewList() {
        addNewList.click();
    }

    @Step("Изменяем название всего списка")
    public MobileElement getNewTextListArray() {
        return newTextListArray; //test1 test2 test3

    }



    @Step("Выбираем первое значение")
    public void getOneDice() {
        oneDice.click();
    }

    @Step("Выбираем второе значение")
    public void getTwoDice() {
        TwoDice.click();
    }

    @Step("Нажимаем ввести другое значение")
    public void getOtherDice() {
        otherDice.click();
    }

    @Step("Вводим другое значение")
    public MobileElement getOtherTextDice() {
        return otherTextDice;
    }

    @Step("Быстрое изменение название списка по иконке 'Редактировать' сверху")
    public void getRenameTextList() {
        renameTextList.click();
    }
    @Step("Нажимаем на пустую область, для след.генерации")
    public void getBackToList() {
        backToList.click();
    }

    //dice
    @Step("Изменяем название списка")
    public MobileElement getNewTextList() {
        return newTextList;
    }
    @Step("Сохраняем введенные изменения")
    public void getSaveTextList() {
        saveTextList.click();
    }

//lot
    @Step("Изменяем количество отображаемых элементов '2'")
    public MobileElement getToLot() {
    return toLot;
}

    @Step("Изменяем количество отображаемых элементов '2'")
    public MobileElement getFromLot() {
        return fromLot;
    }

    @Step("Изменяем количество отображаемых элементов '2'")
    public MobileElement getAddQuantity() {
       return addQuantity;
    }
    @Step("Изменяем задержку времени '1'")
    public MobileElement getAddDelay() {
      return  addDelay;
    }

    @Step("Если найдено '1' нажимаем далее")
    public MobileElement getGenerateOne() {
       return generateOne;
    }
    @Step("Если найдено '1' нажимаем далее")
    public MobileElement getGenerateOOne() {
        return generateOOne;
    }
    @Step("Если найдено '2' нажимаем далее")
    public MobileElement getGenerateTwo() {
        return generateTwo;
    }
    @Step("Если найдено '1, 2' нажимаем далее")
    public MobileElement getGenerateOneTwo() {
        return generateOneTwo;
    }
    @Step("Если найдено '1, 1' нажимаем далее")
    public MobileElement getGenerateOneOne() {
        return generateOneOne;
    }
    @Step("Если найдено '2, 1' нажимаем далее")
    public MobileElement getGenerateTwoOne() {
        return generateTwoOne;
    }
    @Step("Ошибка, не верные значения")
    public void getException() {
        screenshot();
        throw new NullPointerException("Exception: oops!");
    }
    @Step("Заходим в приложение и нажимаем на экран 'Числа'")
    public MobileElement getNumberScreen() {
        return numberScreen;
    }
    @Step("Вводим число 'от'")
    public MobileElement getNumberFrom() {
        return numberFrom;
    }
    @Step("Вводим число 'до'")
    public MobileElement getNumberTo() {
        return numberTo;
    }
    @Step("Заходим в параметры или настройки")
    public void getAddParam() {
        addParam.click();
    }
    @Step("Нажимаем 'Отключить повторение'")
    public void getNoRepeatParam() {
        noRepeatParam.click();
    }
    @Step("Нажимаем 'Отключить количество'")
    public void getQuantityParam() {
        quantityParam.click();
    }
    @Step("Нажимаем 'Отключить задержку времени'")
    public void getDelayParam() {
        delayParam.click();
    }
    @Step("Нажимаем 'Подтвердить отключение параметров'")
    public void getApplyParam() {
        applyParam.click();
    }
    @Step("Нажимаем кнопку 'Генерировать'")
    public void getGenerate() {
        generate.click();
    }


    @Step("Скриншот последнего рабочего состояния")
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



    private enum Direction{
        RIGHT,
        LEFT,
        UP,
        DOWN
    }

    @Step("Проводим пальцем {direction}")
    private void swipe(Direction direction) {
        int edge = 5;
        int press = 300;
        Dimension dims = driver.manage().window().getSize();
        PointOption<?> pointOptionStart = PointOption.point(dims.width / 2,dims.height / 2);
        PointOption<?> pointOptionEnd;
        switch (direction) {
            case RIGHT:
                pointOptionEnd = PointOption.point(dims.width - edge, dims.height / 2);
                break;
            case LEFT:
                pointOptionEnd = PointOption.point(edge, dims.height / 2);
                break;
            case UP:
                pointOptionEnd = PointOption.point(dims.width / 2, edge);
                break;
            case DOWN:
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edge);
                break;
            default:
                throw new IllegalArgumentException("Swipe is not supported");
        }

        new TouchAction<>(driver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(press)))
                .moveTo(pointOptionEnd)
                .release()
                .perform();
    }
}
