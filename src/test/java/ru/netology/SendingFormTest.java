package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.List;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.cssSelector;

public class SendingFormTest {
    private WebDriver driver;


    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldSendform() {
        By driver = null;
        List<WebElement> inputs = driver.findElements((SearchContext) cssSelector("input"));
        inputs.get(0).sendKeys("Юлия");
        inputs.get(1).sendKeys("+79272230350");
        driver.findElement((SearchContext) cssSelector("[data-test-id='#root > div > form > div:nth-child(1) > span']")).click();
        driver.findElement((SearchContext) cssSelector("[data-test-id='#root > div > form > div:nth-child(2) > span']")).click();
        String text = driver.findElement((SearchContext) cssSelector("[data-test-id='#root > div > form > div:nth-child(3) > label']")).getText().trim();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с Вами в ближайшее время.", text);
    }
}