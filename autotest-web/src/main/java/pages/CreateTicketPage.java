package pages;

import com.codeborne.selenide.SelenideElement;
import models.Ticket;
import org.openqa.selenium.support.ui.Select;
import ru.lanit.at.web.annotations.Name;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Create Ticket")
public class CreateTicketPage extends HelpdeskBasePage {

    @Name("поле заголовка")
    private SelenideElement problemTitle = $x("//input[@id='id_title']");

    @Name("поле Queue")
    private SelenideElement queue = $x("//select[@id='id_queue']");

    @Name("поле 'Submit Ticket'")
    private SelenideElement submitTicketButton = $x("//button[@class='btn btn-primary btn-lg btn-block']");

    public void createTicket(Ticket ticket) {
        fillProblemTitle(ticket.getTitle());
        fillQueue(ticket.getQueue());
        createTicket();
    }

    public void fillProblemTitle(String text) {
        problemTitle.sendKeys(text);
    }

    public void fillQueue(String value) {
        Select selectObject = new Select(queue);
        selectObject.selectByValue(value);
    }

    private void createTicket() {
        submitTicketButton.click();
    }
}
