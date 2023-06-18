@parameterizing
Feature: search_feature
  Background: user goes to google
    Given user navigates to "https://google.com"

  Scenario: TC01_iphone_search
    And user search for "iPhone"
    Then verify the page title contains "iPhone"
    Then close the application