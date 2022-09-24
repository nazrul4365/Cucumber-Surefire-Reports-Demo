@Test
Feature: I want to verify that the Login functionality is working properly

  @Test-001
  Scenario: Login with valid userName and password
    Given Landing page is present
    When I hit login button
    And Enter valid email and password
    When I click LogIn button
    Then I should see HomePage title is "Rahul Shetty Academy"


  @Test-002
  Scenario Outline: Login with invalid uerName and valid password
    Given Landing page is present
    And I hit login button
    And I enter  <userName> and <passWord>
    When I click LogIn button
    Then login should fail with an error "<err>"
    Examples:
      | userName         | passWord | err|
      | test88@gmail.com | 123456   | Your email or password is incorrect. |


  @Test-003
  Scenario Outline: Login with valid uerName and invalid password
    Given Landing page is present
    And I hit login button
    And I enter  <userName> and <passWord>
    When I click LogIn button
    Then login should fail with an error "<err>"
    Examples:
      | userName         | passWord | err                                  |
      | test99@gmail.com | 456935   | Your email or password is incorrect.(Intentionally Result Failing Text)|


