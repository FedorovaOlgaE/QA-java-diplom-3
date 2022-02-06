package com.model;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class MainPageElements {
    //кнопка ЛК в шапке
    @FindBy(xpath = "//a[@href='/account']")
    public SelenideElement loginButton;

    //переход на страницу логина
    public LoginPageElements login(){
        return page(LoginPageElements.class);
    }
    //кнопка Войти в акк
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']")
    public SelenideElement loginInAccountButton;

    // Кнопка перехода в конструктор
    @FindBy(xpath = "//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']")
    public SelenideElement constructorMenuButton;

    // Лого
    @FindBy(className = "AppHeader_header__logo__2D0X2")
    public SelenideElement logo;

    //Вкладка "Булки"
    @FindBy(xpath = ".//div[span[text()='Булки']]")
    public SelenideElement bunsSection;

    //Вкладка "Соусы"
    @FindBy(xpath = ".//div[span[text()='Соусы']]")
    public SelenideElement saucesSection;

    //Вкладка "Начинки"
    @FindBy(xpath = ".//div[span[text()='Начинки']]")
    public SelenideElement fillingsSection;

}
