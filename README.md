StoryTellAppAutomationTemplate
--------------------------------------------------------------------

Framwork Demo 
--------------------------------------------------------------------
![Demo](https://eywasoft.s3.amazonaws.com/AndroidAutomationVideoGifV1.gif)


### What do I need?

This should download everything for you, but the following may be useful anyway:

- Appium Desktop - https://github.com/appium/appium-desktop/releases/latest 
- Android Studio (Allows you to install SDK and Emulators) - https://developer.android.com/studio/index.html
- XCode - https://developer.apple.com/xcode/

### How do I get a device ID?

## Android

Assuming you have downloaded the Android SDK, type ```adb devices``` in your console

## IOS

Not implemented

--------------------------------------------------------------------

### Tools & libraries

- Cucumber-JVM:- BDD Framework
- Custom Page Object Pattern and utility functions
- Appium: - Mobile Native app, Hybrid App, Web app
- JAVA: - Programming language
- JUnit: - JUnit Java testing framework
- Maven: - Build tool

--------------------------------------------------------------------

### Compile Build or Run Tests

Command Line

cd to root ot automationFramework project directory

--------------------------------------------------------------------

Getting Started
--------------------------------------------------------------------

Feature Files
-------------------------------------------------------------------

These files contains the acceptance criteria which are written in Gherkin Language and contains various scenarios.  
The feature files are tagged with "@tagname" to group common feature files 

File Extension:  *.feature    
Location: "/features"      
Directory:  Separate directories for GUI and API tests, Group common features files in a 
single directory    
File Conventions:Meaning full name "LandingPage.feature"
Example:   
Feature: Landing Page Test

  Scenario:
    Given I open Storytel app
    When I Swipe stories to left and right and verify swiping works correctly
    Then Click on Try it out button
    And I scroll down to find “Iceland” selection
    And I select “Iceland” and click “Done”
    ......


Page Objects
-------------------------------------------------------------------
PageObjects are used to store the AndroidElements for a Mobile Page.
A good practice is to have a separate class for every single Mobile Page.
To avoid duplication for multiple pages which have common web page elements a Parent class can be created 
and the child class can then inherit.  
Every Page  class extends "BasePage.class" to make use of the WebDriver Object and utility functions.  
In case of Parent and Child Class, Parent class extends PageObject class and child class extends Parent class  

public class Welcome_Page extends BasePage {

    public Welcome_Page(WebDriver driver) {
        super(driver);
    }

    public void goBack() {
        goBackBtn();
    }

}

Step Definitions
--------------------------------------------------------------------
Every steps defined in Feature file needs to be implemented in Step Definitions Class

Location: src/test/java/steps

Example:  

public class WelcomePage_Steps {

    final Welcome_Page welcome_page = new Welcome_Page(Driver.current());

    /**
     * Click Back button to close “Welcome to Storytel!” page
     */
    @Then("I Click Back button to close “Welcome to Storytel!” page")
    public void i_click_back_button_to_close_welcome_to_storytel_page() {
        welcome_page.goBack();

    }

}


Compile Build or Run Tests
==========================

Command Line

cd to root ot StoryTellAppAutomationTemplate project directory


To run all tests
------------------------
mvn clean install  


Run Test Suite
--------------------------------------------------------------------
Test Suites are used to run a group of Tests which are tagged and represented in form of Feature files & Scenarios

Location: src/test/java/testRunner/TestRunner.java
File Conventions:Every Class file ends with Suite.class @RunWith(Cucumber.class) 


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        plugin = {"pretty", "json:Report"},
        monochrome = true
)
public class TestRunner {
}

  
