package elements;

import com.codeborne.selenide.SelenideElement;
import models.Ticket;
import ru.lanit.at.web.annotations.Name;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Элемент главного меню
 */
public class MainMenu {

    @Name("кнопка 'New Ticket'")
    private SelenideElement newTicketBtn = $x("//*[contains(text(), 'New Ticket')]/parent::*");

    @Name("кнопка 'Login'")
    private SelenideElement logInBtn = $x("//*[contains(text(), 'Log In')]/parent::*");

    @Name("кнопка 'All Tickets'")
    private SelenideElement allTicketsBtn = $x("//*[contains(text(), 'All Tickets')]/parent::*");

    @Name("кнопка 'Saved Queries'")
    private SelenideElement savedQueriesBtn = $x("//*[contains(text(), 'Saved Queries')]/parent::*");

//    @Name("поле с сохраненным запросом")
//    private SelenideElement fieldWithSaveQuery = $x("//a[@class='dropdown-item small']");

    @Name("поле 'Search'")
    private SelenideElement searchTicket = $x("//input[@id='search_query']");

    @Name("кнопка 'Search'")
    private SelenideElement searchBtn = $x("//*[@class='fas fa-search']/parent::*");

    public void newTicket() {
        newTicketBtn.click();
    }

    public void logIn() {
        logInBtn.click();
    }

    public void allTickets() {
        allTicketsBtn.click();
    }

    public void savedQuery() {
        savedQueriesBtn.click();
    }

    public void searchTicket(Ticket ticket) {
        setSearch(ticket.getTitle())
                .clickSearch();
    }

    private MainMenu setSearch(String text) {
        searchTicket.sendKeys(text);
        return this;
    }

    private void clickSearch() {
        searchBtn.click();
    }

    public void searchAndClickSavedQuery(String text) {
        SelenideElement fieldWithSaveQuery =
                $x(" //div[@class='dropdown-menu show']//a[contains(text(),'" + text + "')]");
        fieldWithSaveQuery.click();
    }
}
