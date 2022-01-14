package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.utils.Sleep;
import ru.lanit.at.web.pagecontext.PageManager;

import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$;


public class WebActionSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebActionSteps.class);

    public WebActionSteps(PageManager manager) {
        this.pageManager = manager;
    }

    /**
     * нажимает на элемент по тексту
     *
     * @param text текст элемента
     */
    @Когда("кликнуть на элемент по тексту {string}")
    public void clickElementWithText(String text) {
        $(Selectors.byText(text))
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент по тексту '{}'", text);
    }

    @Если("кликнуть на элемент {string}")
    public void clickOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент '{}'", elementName);
    }

    /**
     * нажимает на элемент по тексту из списка
     *
     * @param text текст элемента
     * @param elem элемент
     */

    @Если("кликнуть на элемент {string} в списке Drop-Down {string}")
    public void clickOnElementDropDown(String text, String elem) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elem);
        Select selectObject = new Select(element);
        selectObject.selectByVisibleText(text);
        LOGGER.info("клик на элемент '{}' в списке Drop-Down '{}'", text, elem);
    }

    @Если("кликнуть на элемент с текстом {string} из списка {string}")
    public void clickOnElementFromList(String text, String xpathExpression) {
        ElementsCollection elements = pageManager
                .getCurrentPage()
                .getElementsCollection(xpathExpression);
        for (SelenideElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                break;
            }
        }
        LOGGER.info("клик на элемент с текстом '{}' из списка '{}'", text, xpathExpression);
    }

    /**
     * скролл до элемента
     *
     * @param elementName наименование элемента
     */
    @Когда("проскроллить страницу до элемента {string}")
    public void scrollToElement(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до элемента '{}'", elementName);
    }

    /**
     * скролл до текста
     *
     * @param text текст
     */
    @Когда("проскроллить страницу до текста {string}")
    public void scrollToText(String text) {
        SelenideElement element = $(Selectors.byText(text));
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до текста '{}'", text);
    }

    @И("подождать {int} сек")
    public void waitSeconds(int timeout) {
        Sleep.pauseSec(timeout);
    }

    /**
     * Ввод значения в элемент
     *
     * @param field - наименование элемента
     * @param value - значение
     */
    @Когда("ввести в поле {string} значение {string}")
    public void fillTheField(String field, String value) {
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        fieldElement
                .shouldBe(Condition.visible)
                .setValue(value);
        LOGGER.info("в поле '{}' введено значение '{}'", field, value);
    }

    /**
     * Очистка поля
     *
     * @param elementName наименование элемента
     */
    @Если("очистить поле {string}")
    public void clearFiled(String elementName) {
        pageManager
                .getCurrentPage()
                .getElement(elementName)
                .shouldBe(Condition.visible)
                .clear();
    }

    /**
     * Добавление файла
     *
     * @param fileName имя файла
     */
    @И("добавление файла {string} из пути")
    public void addFile(String fileName) {
        pageManager
                .getCurrentPage()
                .getElement("кнопка 'AttachFile(s)'").click();
        pageManager
                .getCurrentPage()
                .getElement("выбор image")
                .sendKeys(Paths.get(Paths.get("").toAbsolutePath().getParent().toString(),
                        "Images", fileName).toString());
        LOGGER.info("добавление файла '{}' из пути", fileName);
    }
}
