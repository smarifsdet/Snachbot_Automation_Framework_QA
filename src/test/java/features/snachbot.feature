@Test
Feature: Verify the Snachbot functionality for the users

		Background: Users should get in to the Snachbot page
		   Given Users is in Snachbot page

    Scenario: Validating the availability of the Snachbot chat box for the users

       When Users accept cookies and look in to the page

       Then Users shoould see the Snachbot chat box and it is available to use for the users
       
    Scenario: Verify that Users can see a box to enter text to interact with Snachbot

       When Users Click on Snachbot at the bottom right corner of the page

       Then Users should able to see a chat box where users can enter free text for interacting with Snachbot 
         
    Scenario: Verify the first specific conversation of the Users

       When Users enter his name in the chat box

       Then he should get a correct response from Snachbot
         
    Scenario: Verify the second specific conversation of the Users

       When Users click Yes after getting the response by entering their name from the Snachbot

       Then Users should get information about Snachbot can do for the Users
          
    Scenario: Verify that Users can close the Snachbot chat box

       When Users click on close icon in the chat box
       
       Then Users should able to close the chat box successfully

