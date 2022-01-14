package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Tickets")
public class TicketsPage extends WebPage {

    @Name("поле 'Status'")
    private ElementsCollection statuses = $$x("//select[@id='id_statuses']/option");

    @Name("кнопка 'delete Status'")
     private SelenideElement deleteStatusBtn =
            $x("//li[@id='filterBoxStatus']//button[contains(@class, 'filterBuilderRemove')]");

    @Name("список Drop-Down 'Add Filter'")
    private SelenideElement addFilter =
            $x("//select[@id='filterBuilderSelect']");

    @Name("кнопка 'Apply Filters'")
    private SelenideElement applyFiltersBtn = $x("//input[@value='Apply Filters']");

    @Name("кнопка 'Save Query' more information")
    private SelenideElement saveQueryBtnMoreInformation =
            $x("//button[contains(@class, 'collapsed btn')]//i[@class='fas fa-save']");

    @Name("поле 'Query Name'")
    private SelenideElement queryName =
            $x("//form[@action='/save_query/']//input[@type='text']");

    @Name("кнопка 'Save Query'")
    private SelenideElement saveQueryBtn =
            $x("//input[@value='Save Query']");

    @Name("текст с 'Query Name'")
    private SelenideElement textWithName =
            $x("//li[contains(text(), 'You are currently viewing saved query')]");

    @Name("кнопка 'Delete Save Query'")
    private SelenideElement deleteSaveQueryBtn =
            $x("//a[contains(text(),'Delete Saved Query')]");

    @Name("кнопка 'Yes I Understand - Delete It Anyway'")
    private SelenideElement agreeBtn =
            $x("//button[contains(text(), 'Yes I Understand - Delete It Anyway')]");
}
