package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertEquals;

public class AddItemToCartSteps {
    
    // Locators
    private final By additemButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.cssSelector(".shopping_cart_link");
    private final By itemName = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    
    private String expectedItemName = "Sauce Labs Backpack";
    private String expectedUrl = "https://www.saucedemo.com/inventory.html";
    

    @Given("the user is on the product page")
    public void the_user_is_on_the_product_page() {
    	
        assert Hooks.driver.getCurrentUrl().equals(expectedUrl) : "User is not on the homepage.";
    }
    
    @When("the user adds the item to the cart")
    public void the_user_adds_the_item_to_the_cart() {
        Hooks.driver.findElement(additemButton).click();
    }

    @When("the user views the cart")
    public void the_user_views_the_cart() {
        Hooks.driver.findElement(cartIcon).click();
    }

    @Then("the item should be displayed in the cart with the correct name")
    public void the_item_should_be_displayed_in_the_cart_with_the_correct_name() {
        WebElement itemElement = Hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));
        System.out.println("Actual name " +itemElement.getText());
        //assertEquals(itemElement.getText(), expectedItemName, "Item name does not match!");
        
        assert itemElement.getText().equals(expectedItemName) : "Item name does not match!";
    }
}

