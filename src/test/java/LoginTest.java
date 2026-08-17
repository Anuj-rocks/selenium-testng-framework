
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeClass
    public void initializeDriver() {
        Selenium.initializeDriver();
    }

    @Test
    public void testNavigateToAmazon() {
        Selenium.navigateToAmazon();
    }

    @Test(dependsOnMethods = "testNavigateToAmazon")
    public void testSearchProduct() throws InterruptedException {
        Selenium.searchProduct("phone");
    }

    @Test(dependsOnMethods = "testSearchProduct")
    public void testSortProducts() throws InterruptedException {
        Selenium.sortProducts();
    }

    @Test(dependsOnMethods = "testSortProducts")
    public void testLoginToAccount() throws InterruptedException {
       Selenium.loginToAccount();
    }

    @AfterClass
    public void closeDriver() {
        Selenium.closeDriver();
    }
}