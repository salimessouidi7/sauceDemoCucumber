package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;

    // Ce hook s'exécute toujours en premier pour initialiser WebDriver
    @Before(order = 0)
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    
    // Ce hook s'exécute pour les scénarios @AddToCart pour vérifier la connexion
    @Before(value = "@AddToCart", order = 1)
    public void loginIfNotLoggedIn() {
        if (!driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
            // Si l'utilisateur n'est pas connecté, exécuter le scénario de connexion
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

