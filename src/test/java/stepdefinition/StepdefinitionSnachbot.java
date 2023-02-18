package stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SnachbotfunctionalPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class StepdefinitionSnachbot {
	
	SnachbotfunctionalPage sb = new SnachbotfunctionalPage();
	
	@Given("Users is in Snachbot page")
	public void users_is_in_snachbot_page() {
		Driver.getDriver().get(ConfigReader.getProperty("url_prod"));
	}

	@When("Users accept cookies and look in to the page")
	public void users_accept_cookies_and_look_in_to_the_page() {
	    BrowserUtils.waitForClickability(sb.cookiesAcceptButton, 5);
	    sb.cookiesAcceptButton.click();
	    sb.acceptButton.click();
	}

	@Then("Users shoould see the Snachbot chat box and it is available to use for the users")
	public void users_shoould_see_the_snachbot_chat_box_and_it_is_available_to_use_for_the_users() {
		Assert.assertEquals(true, sb.snachButton.isDisplayed());
	}

	@When("Users Click on Snachbot at the bottom right corner of the page")
	public void users_click_on_snachbot_at_the_bottom_right_corner_of_the_page() {
		BrowserUtils.waitForClickability(sb.cookiesAcceptButton, 5);
	    sb.cookiesAcceptButton.click();
	    sb.acceptButton.click();
		sb.snachButton.click(); 
	}
   
	@Then("Users should able to see a chat box where users can enter free text for interacting with Snachbot")
	public void users_should_able_to_see_a_chat_box_where_users_can_enter_free_text_for_interacting_with_snachbot() {
		Driver.getDriver().switchTo().frame("sntch_iframe");
		BrowserUtils.waitForVisibility(sb.snachboxMessage, 5);
        String actualText=sb.snachboxMessage.getText();
        String expectedText = "There’s lots I can show you but first please let me know your name.";
        Assert.assertEquals(actualText,expectedText);
        Assert.assertEquals(true, sb.chatBox.isEnabled());
        
        
	}
	
	@When("Users enter his name in the chat box")
	public void users_enter_his_name_in_the_chat_box() {
		BrowserUtils.waitForClickability(sb.cookiesAcceptButton, 5);
		sb.cookiesAcceptButton.click();
	    sb.acceptButton.click();
		sb.snachButton.click();
		Driver.getDriver().switchTo().frame("sntch_iframe");
		sb.chatBox.sendKeys("FirstName");
		sb.sendMessageButton.click();
	}

	@Then("he should get a correct response from Snachbot")
	public void he_should_get_a_correct_response_from_snachbot() {
		String actualText=sb.returnMessage.getText();
        String expectedText = "Hi FirstName! Good to chat to you. Did I get your name right?";
        Assert.assertEquals(actualText,expectedText);
		
	}

	@When("Users click Yes after getting the response by entering their name from the Snachbot")
	public void users_click_yes_after_getting_the_response_by_entering_their_name_from_the_snachbot() {
		BrowserUtils.waitForClickability(sb.cookiesAcceptButton, 5);
		sb.cookiesAcceptButton.click();
	    sb.acceptButton.click();
		sb.snachButton.click();
		Driver.getDriver().switchTo().frame("sntch_iframe");
		sb.chatBox.sendKeys("FirstName");
		sb.sendMessageButton.click();
		BrowserUtils.waitForClickability(sb.yesButton, 5);
		sb.yesButton.click();
	}

	@Then("Users should get information about Snachbot can do for the Users")
	public void users_should_get_information_about_snachbot_can_do_for_the_users() {
		BrowserUtils.waitForVisibility(sb.returnInformationalMessage, 5);
		String actualText=sb.returnInformationalMessage.getText();
        String expectedText = "Great! Here's what I can chat about with you:";
        Assert.assertEquals(actualText,expectedText);
	    
	}

	@When("Users click on close icon in the chat box")
	public void users_click_on_close_icon_in_the_chat_box() {
		BrowserUtils.waitForClickability(sb.cookiesAcceptButton, 5);
		sb.cookiesAcceptButton.click();
	    sb.acceptButton.click();
		sb.snachButton.click();
		BrowserUtils.waitForVisibility(sb.snachBoxClose, 5);
		sb.snachBoxClose.click();
		
	}

	@Then("Users should able to close the chat box successfully")
	public void users_should_able_to_close_the_chat_box_successfully() {
		Assert.assertEquals(true, sb.snachButton.isDisplayed());
		
	}

	
	
	
             
}