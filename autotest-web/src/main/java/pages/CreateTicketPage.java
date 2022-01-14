package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Create Ticket")
public class CreateTicketPage extends WebPage {

    @Name("поле 'problem'")
    private SelenideElement problemTitle = $x("//input[@id='id_title']");

    @Name("поле 'Queue'")
    private SelenideElement queue = $x("//select[@id='id_queue']");

    @Name("поле 'Submit Ticket'")
    private SelenideElement submitTicketButton = $x("//button[@class='btn btn-primary btn-lg btn-block']");

}
