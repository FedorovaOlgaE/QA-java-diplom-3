package com.pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class MainPageElements {
    //кнопка ЛК в шапке
    @FindBy(xpath = "//a[@href='/account']")
    private SelenideElement loginButton;

    //кнопка Войти в личный кабинет
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']")
    private SelenideElement loginInAccountButton;

    // Кнопка перехода в конструктор
    @FindBy(xpath = "//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']")
    private SelenideElement constructorMenuButton;

    // Лого
    @FindBy(className = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    //Вкладка "Булки"
    @FindBy(xpath = ".//div[span[text()='Булки']]")
    private SelenideElement bunsSection;

    //Вкладка "Соусы"
    @FindBy(xpath = ".//div[span[text()='Соусы']]")
    private SelenideElement saucesSection;

    //Вкладка "Начинки"
    @FindBy(xpath = ".//div[span[text()='Начинки']]")
    private SelenideElement fillingsSection;

    @Step("Пользователь переходит на страницу авторизации")
    public LoginPageElements login() {

        return page(LoginPageElements.class);
    }

    @Step("Пользователь кликает на кнопку авторизации в шапке сайта")
    public void clickLoginButton(){
        loginButton.click();
    }
    @Step("Пользователь кликает на кнопку Войти в аккаунт")
    public void clickLoginInAccountButton(){
        loginInAccountButton.click();
    }
    @Step("Пользователь кликает на владку Булки")
    public void clickBunsSection(){
        bunsSection.click();
    }
    @Step("Пользователь кликает на владку Соусы")
    public void clickSaucesSection(){
        saucesSection.click();
    }
    @Step("Пользователь кликает на владку Начинки")
    public void clickFillingsSection(){
        fillingsSection.click();
    }
    @Step("Пользователь кликает по лого")
    public void clickLogo(){
        logo.click();
    }
    @Step("Пользователь кликает Конструктору")
    public void clickConstructorMenuButton(){
        constructorMenuButton.click();
    }
    @Step("Получение название раздела Булки")
    public String bunsSectionGetText(){
        return bunsSection.getText();
    }
    @Step("Получение название раздела Соусы")
    public String saucesSectionGetText(){
        return saucesSection.getText();
    }
    @Step("Получение название раздела Начинки")
    public String fillingsSectionGetText(){
        return fillingsSection.getText();
    }

}
