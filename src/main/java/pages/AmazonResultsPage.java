package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonResultsPage extends BasePage {
    private final By sortDropdown = By.xpath("//span[contains(text(), 'Sort by')]//ancestor::div[@class='a-dropdown-container']");
    private final By fallbackSortDropdown = By.xpath("//span[contains(@class, 'a-button-dropdown')]");

    public AmazonResultsPage(WebDriver driver) {
        super(driver);
    }

    public void sortProducts() {
        try {
            waitForVisible(sortDropdown);
            driver.findElement(sortDropdown).click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } catch (Exception e) {
            System.out.println("Sort dropdown not found with primary selector, trying alternative...");
            try {
                waitForVisible(fallbackSortDropdown);
                driver.findElement(fallbackSortDropdown).click();
            } catch (Exception e2) {
                System.out.println("Warning: Could not click sort button. Continuing with test.");
            }
        }
    }
}
