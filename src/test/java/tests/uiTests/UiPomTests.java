package tests.uiTests;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

@Story("UI POM tests")
@Tag("ui")
public class UiPomTests extends BaseTest{
    @Test
    @Step
    void loginPomTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, longWait);
        loginPage.login();
        loginPage.successMessage("Login successful");
        assertThat(driver.getCurrentUrl()).contains("login-sucess");
    }
}
