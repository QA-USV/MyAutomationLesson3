package ru.netology.MyAutomation3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTestPositive {

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
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldCheckFieldsPositive01() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит Джон");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
    }

    @Test
    void shouldCheckFieldsPositive02() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит-Адамс Джон");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
    }

    @Test
    void shouldCheckFieldsPositive03() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит-Адамс Анна-Мария");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
    }

    @Test
    void shouldCheckFieldsPositive04() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Ю Эн");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
    }
}