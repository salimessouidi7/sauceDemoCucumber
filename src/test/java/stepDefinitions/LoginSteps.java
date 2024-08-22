package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class LoginSteps {

    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Hooks.driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        Hooks.driver.findElement(usernameField).sendKeys(username);
        Hooks.driver.findElement(passwordField).sendKeys(password);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        Hooks.driver.findElement(loginButton).click();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        assert Hooks.driver.getCurrentUrl().equals(expectedUrl) : "User is not on the homepage.";
    }
}


