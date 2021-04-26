@regression
Feature: Login
  Buy the all inclusive pass
  As a user,
  I want to add the quantities to for the number of required passes
  so that I can place an order from the checkout page

  Background: User is on the home page
    Given I navigate to the Project "Home" page

  @positive
  Scenario Outline: E2E Journey to select the quantity and navigate to checkout
    When the user selects the dropdown option as "2 day pass from $92"
    And press checkout button
    And enters the date and presses Continue button
    And enter email "<email>",
    And enter card details as card number "<card_number>", month "<month>", year "<year>", Code "<code>"
    And enters personal details as name "<name>", last name "<last_name>" and phone "<phone>>"
    And enter billing address "<street>", city "<city>", zip "<zip>", country "<country>", state "<state>"
    And press Confirm Order button
    Then the user should see the "Unable to process the payment. Please verify the Card Details and try again." message
    Examples:

      | email            | card_number        | month | year | code | name | last_name | phone       | street      | city   | zip     | country        | state  |
      | yash.deo@eso.com | 3700 0000 0000 002 | 03    | 2030 | 7373 | Test | Tester    | 07581211416 | Kingsley Rd | London | TW3 1NS | United Kingdom | Barnet |


    # Some of the below scenarios could have been scripted along with the E2E scenario
    # Validation messages by keeping the mandatory fields blank, ex:- blank user name, wrong credit card number etc.
    # The scenarios needs to be improved for the parameterisetion of selecting the number of cards and also the type of offers
    #  The scenario to navigate back to the Review section from the Confirmation page and back to the Confirmation page to check if the records are maintained
    # The "SUCCESSFUL" payment and the the combination of payments for different types, like paypal, visa etc.
    # Multiple browser and devices testing

