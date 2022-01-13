package pages;

import elements.MainMenu;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

@Name(value = "Helpdesk Base")
public class HelpdeskBasePage extends WebPage {

    public MainMenu mainMenu() {
        return new MainMenu();
    }
}
