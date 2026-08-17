import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonResultsPage;

public class Selenium {

    static WebDriver driver;
    private static AmazonHomePage amazonHomePage;
    private static AmazonResultsPage amazonResultsPage;
    private static AmazonLoginPage amazonLoginPage;

    public static void main(String[] args) throws Exception {
        amazonTest();
    }

    public static void amazonTest() throws Exception {
        initializeDriver();
        navigateToAmazon();
        searchProduct("phone");
        sortProducts();
        loginToAccount();
        closeDriver();
    }
public static void initializeDriver() {

    System.setProperty("webdriver.chrome.driver",
            "C:\\Browser driver\\chromedriver.exe");

    driver = new ChromeDriver();

    amazonHomePage = new AmazonHomePage(driver);
    amazonResultsPage = new AmazonResultsPage(driver);
    amazonLoginPage = new AmazonLoginPage(driver);
}
    
{

        amazonHomePage = new AmazonHomePage(driver);
        amazonResultsPage = new AmazonResultsPage(driver);
        amazonLoginPage = new AmazonLoginPage(driver);
    }

    public static void navigateToAmazon() {
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
    }

    public static void searchProduct(String productName) {
        amazonHomePage.searchProduct(productName);
    }

    public static void sortProducts() {
        amazonResultsPage.sortProducts();
    }

    public static void loginToAccount() {
        amazonLoginPage.loginToAccount();
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}