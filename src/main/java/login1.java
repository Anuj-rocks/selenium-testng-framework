/*import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login1 {

    public static void performLogin(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Hello, sign in')]")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys("8319079842");
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Anuj@1995");
        driver.findElement(By.id("signInSubmit")).click();
        login1.explicitwait(driver, By.xpath("//span[contains(text(),'Hello, Anuj')]"));
        System.out.println("Login successful");
        System.out.println("you are on login page");
    }

   // public static void login2(WebDriver driver)
   public static void explicitwait(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='searchbox']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}*/