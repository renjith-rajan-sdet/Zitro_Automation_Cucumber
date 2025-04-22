@GameTwist
Feature: Sanity Tests

  @SanityTests @TC_001 @severity=High
  Scenario: TC001_GameTwist_register_new_user
    Given Web Application launched - Application - "GameTwist"
    When GameTwist home screen is loaded
    Then Register a new user and record the user credentials

  @SanityTests @TC_002 @severity=High
  Scenario: TC002_GameTwist_login_update_SecurityQuestion
    Given Web Application launched - Application - "GameTwist"
    When GameTwist home screen is loaded
    Then login using the created credentials
    And navigate to personal data -> security question
    Then update the security question and answer -> save the changes
    And validate that the security question change is successful

  @SanityTests @TC_003 @severity=High
  Scenario: TC003_GameTwist_login_update_NewsletterConsent
    Given Web Application launched - Application - "GameTwist"
    When GameTwist home screen is loaded
    Then login using the created credentials
    And navigate to personal data -> newsletter consent
    Then update the newsletter consent and answer -> save the changes
    And validate that the newsletter consent change is successful
