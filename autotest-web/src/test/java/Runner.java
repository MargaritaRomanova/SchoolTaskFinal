import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import models.Ticket;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WindowSteps;

import java.io.IOException;
import java.nio.file.Paths;

@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        features = "classpath:features",
        glue = {"steps", "hooks"},
        tags = "@google"
)
public class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Test
    public void changeCreatedTicket() throws Exception {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("resources.properties"));
        PageManager pageManager = new PageManager();
        WindowSteps windowSteps = new WindowSteps(pageManager);
        try {
            // step 1 : Заполнть объект класс Ticket необходимыми тестовыми данными
            Ticket ticket = new Ticket();
            Ticket createNewTicket = ticket.buildNewTicket();
            windowSteps.open(System.getProperty("site.url"));
            new MainPage();
            HelpdeskBasePage helpdeskBasePage = new HelpdeskBasePage();

            // step 2 : Перейти к странице авторизации и выполнить вход
            helpdeskBasePage.mainMenu().logIn();
            LoginPage loginPage = new LoginPage();
            loginPage.login(System.getProperty("user"), System.getProperty("password"));
            HelpdeskBasePage helpdeskBasePageAfterLogin = new HelpdeskBasePage();

            // step 3 : Создать новый тикет
            helpdeskBasePageAfterLogin.mainMenu().newTicket();
            CreateTicketPage createTicketPage = new CreateTicketPage();
            createTicketPage.createTicket(createNewTicket);

            // step 4 : Добавить файл в созданный тикет и убедиться, что файл добавлен
            helpdeskBasePageAfterLogin.mainMenu().allTickets();
            TicketsPage ticketsPage = new TicketsPage();
            helpdeskBasePageAfterLogin.mainMenu().searchTicket(createNewTicket);
            ticketsPage.openTicket(createNewTicket);
            TicketPage ticketPage = new TicketPage();
            ticketPage.addFile(Paths.get(Paths.get("").toAbsolutePath().getParent().toString(),
                    "Images", System.getProperty("fileName")).toString());
            ticketPage.verifyTheFileWasAdded("fileName");

            // step 5 : Сохранить внесенные изменения
            ticketPage.clickUpdateTicket();
        } finally {
            new TicketPage().deleteTicket();
            windowSteps.closeDriver();
        }
    }

    @Test
    public void saveASearchQuery() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("resources.properties"));
        PageManager pageManager = new PageManager();
        WindowSteps windowSteps = new WindowSteps(pageManager);

        String status = "Closed";
        String nameQuery = "nameQuery";

        windowSteps.open(System.getProperty("site.url"));
        try {
            new MainPage();
            HelpdeskBasePage helpdeskBasePage = new HelpdeskBasePage();

            // step 1 : Перейти к странице авторизации и выполнить вход
            helpdeskBasePage.mainMenu().logIn();
            LoginPage loginPage = new LoginPage();
            loginPage.login(System.getProperty("user"), System.getProperty("password"));
            HelpdeskBasePage helpdeskBasePageAfterLogin = new HelpdeskBasePage();

            // step 2 : Во вкладке 'All Tickets' применить фильтры, заполнить имя запроса и сохранить
            helpdeskBasePageAfterLogin.mainMenu().allTickets();
            TicketsPage ticketsPage = new TicketsPage();
            ticketsPage.fillAndSaveFilter(status, nameQuery);

            // step 3 : Убедиться, что запрос сохранен и фильтры применены
            helpdeskBasePageAfterLogin.mainMenu().savedQuery();
            helpdeskBasePageAfterLogin.mainMenu().searchAndClickSavedQuery(nameQuery);
            new TicketsPage().verifyFiltersWereAdded(status, nameQuery);
        } finally {
            new TicketsPage().clickDeleteSaveQueryBtn();
            windowSteps.closeDriver();
        }
    }
}
