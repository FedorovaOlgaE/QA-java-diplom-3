package Pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.*;

public class RegisterPageElements {
    //поле ввода имени
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='name']")
    private SelenideElement registrationPageName;

    //поле ввода email
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]/div/div/input")
    private SelenideElement registrationPageEmail;

    //поле ввода пароля
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='Пароль']")
    private SelenideElement registrationPagePassword;

    //кнопка Зарегистрироваться
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registrationPageButton;

    //неккоректный пароль
    @FindBy(xpath = "//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordWarn;

    //Кнопка войти
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement registrationPageButtonLogin;

    @Step("Пользователь заполняет поле Имя")
    public void setName(String name){
        registrationPageName.setValue(name);
    }

    @Step("Пользователь заполняет поле Email")
    public void setEmail(String email){
        registrationPageEmail.setValue(email);
    }
    @Step("Пользователь заполняет поле пароль")
    public void setPassword(String password){
        registrationPagePassword.setValue(password);
    }
    @Step("Пользователь кликает по кнопке регистрации")
    public void clickRegistrationPageButton(){
        registrationPageButton.click();
    }

    @Step("Пользователь кликает по кнопке войти")
    public void clickRegistrationPageButtonLogin(){
        registrationPageButtonLogin.click();
    }

    @Step("Пользователь получает предупреждение о некорректном пароле")
    public String getRegisterErrorText() {
        return incorrectPasswordWarn.getText();
    }

    //поля заполнены
    @Step("Пользователь заполнил форму регистрации")
    public void registrationFormFilled(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationPageButton();
    }
}
