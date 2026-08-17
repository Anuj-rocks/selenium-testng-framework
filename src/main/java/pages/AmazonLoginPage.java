package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonLoginPage extends BasePage {
    private final By signInLink = By.xpath("//span[contains(text(),'Hello, sign in')]");
    private final By emailField = By.xpath("//input[@id='ap_email_login']");
    private final By continueButton = By.xpath("//input[@class='a-button-input']");
    private final By passwordField = By.xpath("//input[@id='ap_password']");
    private final By signInSubmit = By.id("signInSubmit");
    private final By loginSuccess = By.xpath("//span[contains(text(),'Hello, Anuj')]");

    public AmazonLoginPage(WebDriver driver) {
        super(driver);
    }

   public void loginToAccount() {
    waitForVisible(signInLink);
    driver.findElement(signInLink).click();

    waitForVisible(emailField);

    String username = System.getProperty("USERNAME");
    String password = System.getProperty("Password");

    driver.findElement(emailField).sendKeys(username);
    driver.findElement(continueButton).click();

    waitForVisible(passwordField);
    driver.findElement(passwordField).sendKeys(password);

    driver.findElement(signInSubmit).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("login-page");
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Page URL: " + driver.getCurrentUrl());
        try {
            waitForVisible(loginSuccess);
            System.out.println("Login successful");
            System.out.println("you are on login page");
        } catch (Exception e) {
            System.out.println("Login success element not found!");
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }
}
