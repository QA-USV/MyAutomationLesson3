package ru.netology.MyAutomation3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTestNegative {

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
    void negative01NameFieldNotFilled() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(1) > span > span > span.input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", report.trim());
    }

    @Test
    void negative02PhoneFieldNotFilled() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит Джон");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(2) > span > span > span.input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", report.trim());
    }

    @Test
    void negative03CheckboxNotClicked() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит Джон");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(3) > label > span.checkbox__text")).getText();
        assertEquals("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй", report.trim());
    }

    @Test
    void negative04NameFieldOneWordOnly() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(1) > span > span > span.input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", report.trim());
    }

    @Test
    void negative05NameFieldHyphensOnly() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("---");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(1) > span > span > span.input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", report.trim());
    }

    @Test
    void negative06NameFieldSpacesOnly() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("   ");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(1) > span > span > span.input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", report.trim());
    }

    @Test
    void negative07NameFieldEnglishLang() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Smith John");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(1) > span > span > span.input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", report.trim());
    }

    @Test
    void negative08NameFieldNameAndFigures() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит 007");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(1) > span > span > span.input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", report.trim());
    }

    @Test
    void negative09NameFieldWithDoubleHyphen() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит--Адамс Джон");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(1) > span > span > span.input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", report.trim());
    }

    @Test
    void negative10PhoneFieldNoPlus() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит Джон");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("89990000000");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(2) > span > span > span.input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", report.trim());
    }

    @Test
    void negative11PhoneFieldTenFigures() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Смит Джон");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+798765432");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("[class='button button_view_extra button_size_m button_theme_alfa-on-white']")).click();
        String report = driver.findElement(By.cssSelector("#root > div > form > div:nth-child(2) > span > span > span.input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", report.trim());
    }
}