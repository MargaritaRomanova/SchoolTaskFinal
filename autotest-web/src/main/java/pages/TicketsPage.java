package pages;

import com.codeborne.selenide.SelenideElement;
import models.Ticket;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.lanit.at.web.annotations.Name;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Tickets")
public class TicketsPage extends HelpdeskBasePage {

    @Name("поле все статусы")
    private SelenideElement allStatuses = $x("//select[@id='id_statuses']");

    @Name("кнопка 'Apply Filters'")
    private SelenideElement applyFiltersBtn = $x("//input[@value='Apply Filters']");

    @Name("кнопка 'Save Query'")
    private SelenideElement saveQueryBtnMoreInformation =
            $x("//button[contains(@class, 'collapsed btn')]//i[@class='fas fa-save']");

    @Name("поле 'Query Name'")
    private SelenideElement queryName =
            $x("//form[@action='/save_query/']//input[@type='text']");

    @Name("кнопка 'Save Query'")
    private SelenideElement saveQueryBtn =
            $x("//input[@value='Save Query']");

    @Name("кнопка 'Delete Save Query'")
    private SelenideElement deleteSaveQueryBtn =
            $x("//a[contains(text(),'Delete Saved Query')]");

    @Name("кнопка 'Yes I Understand - Delete It Anyway'")
    private SelenideElement agreeBtn =
            $x("//button[contains(text(), 'Yes I Understand - Delete It Anyway')]");

    public void openTicket(Ticket ticket) {
        SelenideElement findTicket = $x("//a[contains(text(),'" + ticket.getTitle() + "')]");
        findTicket.click();
    }

    public void fillAndSaveFilter(String textStatus, String textName){
        Select selectObject = new Select(allStatuses);
        selectObject.deselectAll();
        selectObject.selectByVisibleText(textStatus);
        applyFiltersBtn.click();
        saveQueryBtnMoreInformation.click();
        queryName.sendKeys(textName);
        saveQueryBtn.click();
    }
    public void verifyFiltersWereAdded(String statusText, String nameText){
        SelenideElement statusIsSelect =
                $x("//select[@id='id_statuses']//option[@selected='selected']");
        SelenideElement textWithName =
                $x("//li[@class='list-group-item']/strong");
        Assert.assertEquals(statusIsSelect.getText(),
                statusText,
                "Фильтры не применены");
        Assert.assertTrue(textWithName.getText().contains(nameText),
                "Название поискового запроса не совпадает");
    }

    public void clickDeleteSaveQueryBtn(){
        deleteSaveQueryBtn.click();
        agreeBtn.click();
    }
}
