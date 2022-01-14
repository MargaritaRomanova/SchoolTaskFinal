package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Ticket")
public class TicketPage extends WebPage {

    @Name("кнопка 'AttachFile(s)'")
    private SelenideElement attachFilesBtn = $x("//button[contains(text(), 'Attach File(s)')]");

    @Name("выбор image")
    private SelenideElement selectImage = $x("//input[@name='attachment']");

    @Name("текст с названием картинки")
    private SelenideElement textWithFileName = $x("//span[contains(@id, 'selectedfilename')]");

    @Name("кнопка 'Update This Ticket'")
    private SelenideElement updateThisTicketBtn = $x("//button[contains(text(), 'Update This Ticket')]");

    @Name("кнопка 'Delete'")
    private SelenideElement deleteBtn = $x("//button[contains(text(), 'Delete')]");

    @Name("кнопка 'Yes I Understand - Delete It Anyway'")
    private SelenideElement agreeBtn =
            $x("//button[contains(text(), 'Yes I Understand - Delete It Anyway')]");

}
