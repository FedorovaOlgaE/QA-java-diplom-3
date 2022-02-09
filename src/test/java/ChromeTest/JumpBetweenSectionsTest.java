package ChromeTest;

import Pages.MainPageElements;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class JumpBetweenSectionsTest {
    @Before
    public void beforeTest() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void jumpToBunsSection() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        mainPage.clickSaucesSection();
        sleep(300);
        mainPage.clickBunsSection();
        String actualText = mainPage.bunsSectionGetText();
        Assert.assertEquals("Текст раздела не совпадает с ожидаемым", "Булки", actualText);
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void jumpToSaucesSection() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        mainPage.clickSaucesSection();
        String actualText = mainPage.saucesSectionGetText();
        Assert.assertEquals("Текст раздела не совпадает с ожидаемым", "Соусы", actualText);
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void jumpToFillingsSection() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        mainPage.fillingsSectionGetText();
        String actualText = mainPage.fillingsSectionGetText();
        Assert.assertEquals("Текст раздела не совпадает с ожидаемым", "Начинки", actualText);
    }
}
