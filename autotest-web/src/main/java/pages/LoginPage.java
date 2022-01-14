package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Login")
public class LoginPage extends WebPage {

    @Name("поле 'Username'")
    private SelenideElement username = $x("//input[contains(@id, 'username')]");

    @Name("поле 'Password'")
    private SelenideElement password = $x("//input[contains(@id, 'password')]");

    @Name("кнопка 'Login'")
    private SelenideElement loginBtn = $x("//input[@value= 'Login']");

}
