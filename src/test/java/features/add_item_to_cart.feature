#Author: Salim Souidi

@AddToCart
Feature: Add item to cart

  Scenario: User adds an item to the cart and verifies it is added successfully
    Given the user is on the product page
    When the user adds the item to the cart
    And the user views the cart
    Then the item should be displayed in the cart with the correct name

    
#Feature: User actions on the product page
#
#  Scenario: User logs in and adds an item to the cart
#    Given the user is on the login page
#    When the user enters "<username>" and "<password>"
#    Then the user should be logged in successfully
#    And the user navigates to the product page
#    When the user adds the item to the cart
#    And the user views the cart
#    Then the item should be displayed in the cart with the correct name
#    Examples:
#      | username      | password     |
#      | standard_user | secret_sauce |