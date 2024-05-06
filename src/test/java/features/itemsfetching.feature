Feature: Get all product items from the Item Info API fo for whichever the Price needs to be changed and sent to outlet.

  Scenario: Verify the get api fetches all for the products For which the Price needs to be Changed.
    Given The url of get item info api endpoint to Fetch all the Items For which the selling Price needs to be Changed.
    When I hit the url of an Item Info API to Fetch all the Items
    Then I should Receive all the Items as a Result of the Response
    And I receive the response code as 200 and the Response Message as Success
