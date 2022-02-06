package com.model;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.*;

public class RegisterPageElements {
    //поле ввода имени
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='name']")
    public SelenideElement registrationPageName;
    //поле ввода email
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]/div/div/input")
    public SelenideElement registrationPageEmail;
    //поле ввода пароля
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='Пароль']")
    public SelenideElement registrationPagePassword;
    //кнопка Зарегистрироваться
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement registrationPageButton;
    //Ссылка на переход страницы авторизации
    @FindBy(xpath = "//a[@href='/login']")
    public SelenideElement linkToLoginPage;
    //неккоректный пароль
    @FindBy(xpath = "//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']")
    public SelenideElement incorrectPasswordWarn;
    //поля заполнены
    public void registrationFormFilled(String name, String email, String password){
        registrationPageName.setValue(name);
        registrationPageEmail.setValue(email);
        registrationPagePassword.setValue(password);
    }
}
