#Author: Salim Souidi

@LoginTest
Feature: User Login

  As a user,
  I want to log in to the application
  So that I can access my account.

  @ValidCredentials
  Scenario Outline: Login with valid credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    And clicks the login button
    Then the user should be redirected to the homepage

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

