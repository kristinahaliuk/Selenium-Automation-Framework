Feature: Add to cart functionality

  @t1
  Scenario: As a user I need to be able to search for items and add to cart
    Given I land on WebstaurantStore Page
    When I search for "stainless work table"
    Then I Check the search result ensuring every product has the word 'Table' in its title
    When I Add the last of found items to Cart
    Then I am able to Empty Cart
