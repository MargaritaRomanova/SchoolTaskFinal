package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Login")
public class LoginPage extends HelpdeskBasePage {

    @Name("поле 'Username'")
    private SelenideElement username = $x("//input[contains(@id, 'username')]");

    @Name("поле 'Password'")
    private SelenideElement password = $x("//input[contains(@id, 'password')]");

    @Name("поле запомнить данные")
    private SelenideElement rememberPasswordCheckbox = $x("//input[@value='remember-me']");

    @Name("кнопка 'Login'")
    private SelenideElement loginBtn = $x("//input[@value= 'Login']");

    public void login(String user, String password) {
        username.sendKeys(user);
        this.password.sendKeys(password);
        rememberPasswordCheckbox.click();
        loginBtn.click();
    }
}
