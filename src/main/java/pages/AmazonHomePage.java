package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage extends BasePage {
    private final By searchBox = By.xpath("//input[@role='searchbox']");
    private final By searchButton = By.xpath("//input[@id='nav-search-submit-button']");

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        waitForVisible(searchBox);
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }
}
