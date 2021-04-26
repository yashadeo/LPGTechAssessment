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
    When user sends the get request to fetch all the attaractions for the city "New York" and id "1"
    Then user should see all the all the attractions for the city and the file should match with the "NYCityAttractions.json"

  Scenario Outline: Get all the attractions for a city , attraction type, and order
    When user sends the request to fetch the resources for the the city "<city>", id "<id>", type as "<attraction_type>", field to sort ad "<sort_field>"  and order "<order>"
    Then user should see all the all the attractions for the city and the file should match with the "NYMuseumRatingDesc.json"
    Examples:
      | attraction_type | sort_field | order      | city     | id |
      | MUSEUM          | rating     | desc | New York | 1  |
