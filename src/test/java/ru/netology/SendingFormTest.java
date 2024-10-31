
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

public class SendingFormTest {
    private WebDriver driver;
}

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
    List<WebElement> inputs = driver.findElements(By.cssSelector("input"));
    inputs.get(0).sendKeys("Юлия");
    inputs.get(1).sendKeys("+79272230350");
    driver.findElement((SearchContext) By.cssSelector("[data-test-id='argument']")).click();
    driver.findElement((SearchContext) By.cssSelector("[data-test-id='submit']")).click();
    String text = driver.findElement(By.cssSelector("[data-test-id='callbask-success']").getText().trim();
    assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с Вами в ближайшее время.", text);
}
}

public void main() {
}