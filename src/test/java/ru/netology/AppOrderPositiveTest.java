package ru.netology;

//import.io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppOrderPositiveTest {
    private WebDriver driver;

    //@BeforeAll
    //public static void setupAll() {

        //WebDriverManager.chromedriver().setup();
   // }


    @BeforeEach
    public void beforeEach() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999.");
    }

    @AfterEach
    public void AfterEach() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldBeSuccessfulForm() {
        driver.FindElement(By.cssSelector("[data-test-id=name]input")).sendKeys(...KeysToSend "Михалыч-Михайлов Михаил");
        driver.FindElement(By.cssSelector("[data-test-id=phone]input")).sendKeys(...KeysToSend "+79600010011");
        driver.FindElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.FindElement(By.cssSelector("button.button")).click();
        var actualText = driver.FindElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals(expected:
        "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actualText);

    }

}

