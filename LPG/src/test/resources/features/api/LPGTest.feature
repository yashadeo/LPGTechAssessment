@api
Feature: Test the LPG API's

  Scenario: Get all the cities
    When user sends the get request to fetch all the cities
    Then user should see all the cities as below present in the responses
      | New York    |
      | London      |
      | Los Angeles |
      | Sydney      |
      | Paris       |

  Scenario: Get all the attractions for the city
    When user sends the get request to fetch all the attractions for the city "New York" and id "1"
    Then user should see all the all the attractions for the city and the file should match with the "NYCityAttractions.json"

  Scenario Outline: Get all the attractions for a city , attraction type, and order
    When user sends the request to fetch the resources for the the city "<city>", id "<id>", type as "<attraction_type>", field to sort ad "<sort_field>"  and order "<order>"
    Then user should see all the all the attractions for the city and the file should match with the "NYMuseumRatingDesc.json"
    Examples:
      | attraction_type | sort_field | order | city     | id |
      | MUSEUM          | rating     | desc  | New York | 1  |


    # Some below scenarios can be covered
    # At the moment, the browser window opens while executing the text which I need to fix. But the tests runs fine.
    # Negative scenarios like keep the mandatory fields blank and send the request, wrong id or text instead of number. Ex:- id field
    # Give wrong endpoint
    # Also different sets of the data, ex:- different city, sorting order combination etc.
    # Report is not generating at the moment, it should be, but I need to check the listener class and need to spend more time.
    
