package tests.uiTests;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

@Story("UI tests")
@Tag("ui")
public class UiTests extends BaseTest{
    @Test
    @Step
    void submitWebFormTest() throws InterruptedException {
        driver.get(UI_BASE_URL);
        driver.findElement(By.linkText("Web form")).click();
        driver.findElement(By.id("my-text-id")).sendKeys("Text");
        longWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type = 'submit']")));
        WebElement submit = driver.findElement(By.xpath("//button[@type = 'submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        Thread.sleep(500);
        submit.click();
        WebElement title = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", title.getText());
    }

    @Test
    @Step
    void loadingImagesImplicitWaitTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebElement compass = driver.findElement(By.id("compass"));
        WebElement calendar = driver.findElement(By.id("calendar"));
        WebElement award = driver.findElement(By.id("award"));
        WebElement landscape = driver.findElement(By.id("landscape"));

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(compass.getDomAttribute("src")).containsIgnoringCase("compass");
        softly.assertThat(calendar.getDomAttribute("src")).containsIgnoringCase("calendar");
        softly.assertThat(award.getDomAttribute("src")).containsIgnoringCase("award");
        softly.assertThat(landscape.getDomAttribute("src")).containsIgnoringCase("landscape");
        softly.assertAll();
    }

    @Test
    @Step
    void loadingImagesExplicitWaitTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        WebElement landscape = longWait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        assertThat(landscape.getDomAttribute("src")).containsIgnoringCase("landscape");
    }
}
