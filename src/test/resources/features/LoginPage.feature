# new feature
# Tags: optional

Feature: Login to Square Application

  Background:
    Given User is on SquareLogin page "http://192.168.1.192:3000"

  @ValidCredentials
  Scenario: Login with valid credentials

    When User enters email as "hamza.ramy.ing@gmail.com" and password as "Aziz@123"
    Then User should be able to login successfully and new page open

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials

    When User enters email as "<email>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"

    Examples:
      | email                    | password  | errorMessage                                |
      | hamza.ramy.ing@gmail.com | Aziz@1234 | les informations d'identification invalides |
      | hamza.ramy@gmail.com     | Aziz@123  | les informations d'identification invalides |
      | hamza.ramy@gmail.com     | aziZ@123  | les informations d'identification invalides |


