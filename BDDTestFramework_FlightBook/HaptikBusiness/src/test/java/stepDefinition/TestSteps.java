package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BotPage;
import managers.WebDriverManager;

public class TestSteps {
	WebDriver driver;
	BotPage botPage;
	WebDriverManager webDriverManager;
	TestContext testContext;
	
	public TestSteps(TestContext context){		
		 testContext = context;
		 botPage = testContext.getPageObjectManager().getBotPage();
	}
	 	 	
	@Given("I am on Haptik HomePage")
	public void i_am_on_Haptik_HomePage() {		
		System.out.println(botPage.getHomePageTitle());
		//Assert.assertEquals(botPage.getHomePageTitle(), "Welcome to the world’s largest Conversational AI Platform\r\n" + 
				//"Build lasting customer relationships, one conversation at a time.");
	}

	@When("I click on chat bubble")
	public void i_click_on_chat_bubble() {
		botPage.clickOnChatBubble();
		botPage.switchToChatFrame();
	}

	@Then("I validate the menu")
	public void i_validate_the_menu() {
		botPage.validateTaskBar();
	}

	@When("I select \"([^\"]*)\" from TaskBar")
	public void i_select_from_taskbar(String option) {
		botPage.selectMenuOption(option);
	}

	@Then("I get various bots")
	public void i_got_various_bots() {
		botPage.postProductText();
	}
	
	@When("I choose \"([^\"]*)\"")
	public void i_choose_Concierge_Bot(String botName) throws InterruptedException {
		botPage.selectBot(botName);
	}
	
	@Then("I receive three options")
	public void i_receive_three_options() {
	    botPage.postBotText();
	}
	
	@When("I click on \"([^\"]*)\"")
	public void i_click_on_choice(String option) {
		botPage.selectedBotChoice(option);
	}
	
	@Then("I get two options to choose from")
	public void i_got_two_options_to_choose_from() {
	   botPage.validateOption();
	}
	
	@Then("I get few instruction")
	public void i_got_few_instruction() {
	    botPage.postChoiceInstruction();
	}
	
	@When("I click Menu")
	public void i_again_chose_Menu_option() throws InterruptedException {
		botPage.clickOnMenu();
	}
	
	@Then("I recieve AboutBot instruction")
	public void i_recieve_registration_instruction() {
		botPage.aboutBotText();
	}

	@Then("I verify bot title")
	public void verify_bot_title() {
		WebElement botTitle = botPage.getBotTitle();
		botPage.highLightText(botTitle);
	}

	@Then("I verify bot tag")
	public void verify_bot_tag() {
		WebElement botTitleTag = botPage.getBotTitleTag();
		botPage.highLightText(botTitleTag);
	}

	@Then("I verify AboutBot message")
	public void aboutbot_message() {	
		WebElement aboutBotText = botPage.getAboutBotText();;
		botPage.highLightText(aboutBotText);
	}

	@Then("I close chat bubble")
	public void i_close_chat_bubble() {
	    botPage.closeBot();
	}
	
}
