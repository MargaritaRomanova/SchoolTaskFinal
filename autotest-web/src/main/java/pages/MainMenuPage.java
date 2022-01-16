package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Main Menu")
public class MainMenuPage extends WebPage {

    @Name("кнопка 'New Ticket'")
    private SelenideElement newTicketBtn = $x("//*[contains(text(), 'New Ticket')]/parent::*");

    @Name("кнопка 'Login'")
    private SelenideElement logInBtn = $x("//*[contains(text(), 'Log In')]/parent::*");

    @Name("кнопка 'All Tickets'")
    private SelenideElement allTicketsBtn = $x("//*[contains(text(), 'All Tickets')]/parent::*");

    @Name("кнопка 'Saved Queries'")
    private SelenideElement savedQueriesBtn = $x("//*[contains(text(), 'Saved Queries')]/parent::*");

    @Name("поле 'Search'")
    private SelenideElement searchTicket = $x("//input[@id='search_query']");

    @Name("кнопка 'Search'")
    private SelenideElement searchBtn = $x("//*[@class='fas fa-search']/parent::*");

    @Name("elements Saved Query")
    private ElementsCollection elementsSavedQuery = $$x("//a[@class='dropdown-item small']");
}
