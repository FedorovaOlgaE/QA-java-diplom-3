package ChromeTest;

import com.codeborne.selenide.Configuration;
import com.model.MainPageElements;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class JumpBetweenSectionsTest {
    @Before
    public void beforeTest() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

    }
    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void jumpToBunsSection(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        mainPage.saucesSection.click();
        mainPage.bunsSection.click();
        Assert.assertEquals(mainPage.bunsSection.getText(), "Булки");
    }
    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void jumpToSaucesSection(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        mainPage.saucesSection.click();
        Assert.assertEquals(mainPage.saucesSection.getText(), "Соусы");
    }
    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void jumpToFillingsSection(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        mainPage.fillingsSection.click();
        Assert.assertEquals(mainPage.fillingsSection.getText(), "Начинки");
    }
}
