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





#  1. Open Storytel app
#  2. Swipe stories to left and right and verify swiping works correctly
#  3. Click on “Try it out” button
#  4. Scroll down to find “Iceland” selection
#  5. Select “Iceland” and click “Done”
#  6. Select only “English” from languages selections page and click “Done”
#  7. Scroll down to find “Feelgood” text from Book tips page
#  8. Swipe left on “Feelgood” section books and click on the 7th item from the list
#  9. Verify correct book is clicked
#  10. Click like button
#  11. Fill a valid email and password and click “Continue” button
#  12. Click I Accept button (Ég samþykki)
#  13. Click “No thanks” to Marketing Consent popup
#  14. Click Back button to close “Welcome to Storytel!” page
#  15. Click Like button and verify book is saved to bookshelf
#  16. Click ← to go back to Book tips
#  17. Open Side Menu
#  18. Click Search button
#  19. Swipe left to “Series” section
#  20. Search for “Harry”
#  21. Swipe up on search result to find “Advantures of Harry Stevenson” and click on it
#  22. Verify that page is the correct page
#  23. Click Filter
#  24. Remove Ebook from Filter list and click “Done”
#  25. Verify “Oops! It seems you've filtered a bit too much.” text on the screen.