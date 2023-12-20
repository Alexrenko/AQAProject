package ru.aston.aqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://mts.by");

        try {
            WebElement cookieAcceptButton = driver.findElement(By.id("cookie-agree"));
            if (cookieAcceptButton.isDisplayed()) {
                cookieAcceptButton.click();
            }
        } catch (Exception e) {
            System.out.println("Всплывающее окно согласия на cookie не найдено или уже закрыто.");
        }
    }

    @Test
    void testTitle() {
        WebElement titleElement = driver.findElement(By.cssSelector(".pay__wrapper h2"));
        String expectedTitle = "Онлайн пополнение\nбез комиссии"; // Добавлен символ переноса строки

        assertEquals(expectedTitle, titleElement.getText(), "Название блока не соответствует ожидаемому");
    }

    @Test
    void testPaymentLogos() {
        String[] logosAltText = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт", "МИР"};
        for (String altText : logosAltText) {
            WebElement logo = driver.findElement(
                    By.xpath("//div[@class='pay__partners']//img[@alt='" + altText + "']"));

            assertTrue(logo.isDisplayed(), "Логотип платежной системы с alt='" + altText + "' не отображается");
        }
    }

    @Test
    void testServiceDetailsLink() {
        WebElement serviceDetailsLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        serviceDetailsLink.click();
        String expectedUrlContains = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        assertTrue(driver.getCurrentUrl().contains(expectedUrlContains), "URL не соответствует ожидаемому");
    }

    @Test
    void testFillFormAndContinueOpensPaymentWindow() {
        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        WebElement emailField = driver.findElement(By.id("connection-email"));
        phoneField.sendKeys("297777777");
        sumField.sendKeys("100");
        emailField.sendKeys("test@mail.ru");

        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));

        WebElement paymentInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header__payment-info")));
        assertTrue(paymentInfo.isDisplayed(), "Окно оплаты не появилось после нажатия на кнопку 'Продолжить'");

        driver.switchTo().defaultContent();
    }


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
