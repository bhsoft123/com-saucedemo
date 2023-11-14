package browsertesting;
/*Project-4 - ProjectName : com-saucedemo
BaseUrl = https://www.saucedemo.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Enter the email to email field.
7. Enter the password to password field.
8. Click on Login Button.
9. Print the current url.
10. Navigate to baseUrl
11. Refresh the page.
12. Close the browser.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTesting {

    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1. Setup browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //2. Open url
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //3. Print the title of the page.
        System.out.println("Title of Page: "+ driver.getTitle());
        //4. Print the current url.
        System.out.println("Current Url: " + driver.getCurrentUrl());
        // 5. Print the page source.
        System.out.println("Page Source: " + driver.getPageSource());
        //6. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("Abc@gmail.com");
        //7. Enter the password to password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");
        //8. Click on Login Button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(5000);

        //9. Print the current url
        System.out.println("Current Url: " +driver.getCurrentUrl());
        //10. Navigate to baseUrl
        driver.navigate().to(baseUrl);
        //11. Refresh the page
        driver.navigate().refresh();
        //12. Close the browser
        driver.quit();
    }
}
