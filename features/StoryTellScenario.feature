Feature: Landing Page Test

  Scenario:
    Given I open Storytel app
    When I Swipe stories to left and right and verify swiping works correctly
    Then Click on Try it out button
    And I scroll down to find “Iceland” selection
    And I select “Iceland” and click “Done”
    And I select only “English” from languages selections page and click “Done”
    And I scroll down to find “Feelgood” text from Book tips page
    And I Swipe left on “Feelgood” section books and click on the "7" th item from the list
    And I Verify correct book is clicked
    And I Click like button
    And I Fill a valid email and password and click “Continue” button
    And I Click I Accept button Ég samþykki
    And I Click “No thanks” to Marketing Consent popup
    And I Click Back button to close “Welcome to Storytel!” page
    And I Click Like button and verify book is saved to bookshelf
    And I Click ← to go back to Book tips
    And I Open Side Menu
    And I Click Search button
    And I Swipe left to “Series” section
    And I Search for "Harry"
    And I Swipe up on search result to find “Advantures of Harry Stevenson” and click on it
    And I Verify that page is the correct page
    And I Click Filter
    And I Remove Ebook from Filter list and click “Done”
    And I Verify “Oops! It seems you've filtered a bit too much.” text on the screen.



