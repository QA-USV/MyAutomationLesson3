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

import java.util.List;

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
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
        driver = null;
    }

//    @Test
//    void negative01NameFieldNotFilled() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("");
//        elements.get(1).sendKeys("+79990000000");
//        driver.findElement(By.className("checkbox__box")).click();
//        driver.findElement(By.className("button__text")).click();
//        String report = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
//    }
//
//    @Test
//    void negative02PhoneFieldNotFilled() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("Смит Джон");
//        elements.get(1).sendKeys("");
//        driver.findElement(By.className("checkbox__box")).click();
//        driver.findElement(By.className("button__text")).click();
//        String report = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
//    }
//
//    @Test
//    void negative03CheckboxNotClicked() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("Смит Джон");
//        elements.get(1).sendKeys("+79990000000");
//        driver.findElement(By.className("button__text")).click();
//        String report = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
//    }
//
//    @Test
//    void negative04SendButtonNotClicked() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("Смит Джон");
//        elements.get(1).sendKeys("+79990000000");
//        driver.findElement(By.className("checkbox__box")).click();
//        String report = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
//    }

    @Test
    void negative05NameFieldOneWordOnly() {
        driver.get("http://localhost:9999");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Джон");
        elements.get(1).sendKeys("+79990000000");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();
        String report = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
    }

    @Test
    void negative06NameFieldHyphensOnly() {
        driver.get("http://localhost:9999");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("----");
        elements.get(1).sendKeys("+79990000000");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();
        String report = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
    }

//    @Test
//    void negative07NameFieldSpacesOnly() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("  ");
//        elements.get(1).sendKeys("+79990000000");
//        driver.findElement(By.className("checkbox__box")).click();
//        driver.findElement(By.className("button__text")).click();
//        String report = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
//    }
//
//    @Test
//    void negative08NameFieldEnglishLang() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("Smith John");
//        elements.get(1).sendKeys("+79990000000");
//        driver.findElement(By.className("checkbox__box")).click();
//        driver.findElement(By.className("button__text")).click();
//        String report = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
//    }
//
//    @Test
//    void negative09NameFieldNameAndFigures() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("Маша999");
//        elements.get(1).sendKeys("+79990000000");
//        driver.findElement(By.className("checkbox__box")).click();
//        driver.findElement(By.className("button__text")).click();
//        String report = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
//    }

    @Test
    void negative10NameFieldWithDoubleHyphen() {
        driver.get("http://localhost:9999");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Смит--Адамс Джон");
        elements.get(1).sendKeys("+79990000000");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();
        String report = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
    }

//    @Test
//    void negative11PhoneFieldNoPlus() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("Смит Джон");
//        elements.get(1).sendKeys("89990000000");
//        driver.findElement(By.className("checkbox__box")).click();
//        driver.findElement(By.className("button__text")).click();
//        String report = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
//    }
//
//    @Test
//    void negative12PhoneFieldTenFigures() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("Смит Джон");
//        elements.get(1).sendKeys("+7987654321");
//        driver.findElement(By.className("checkbox__box")).click();
//        driver.findElement(By.className("button__text")).click();
//        String report = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", report.trim());
//    }
}