package pageObjects;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BotPage {
	WebDriver driver = null;
	WebDriverWait wait = null;
	public BotPage(WebDriver driver) {
		this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	
	 @FindBy(id = "haptik-js-sdk") 	 
	 private WebElement botBuuble;
	 
	 @FindBy(className = "navbar-brand") 	 
	 private WebElement brandText;	 
	 
	 
	 @FindBy(className = "taskbox-tasks") 	 
	 private WebElement taskBox;
	 	 
	 @FindBy(className = "task-title") 	 
	 private List<WebElement> dropDownTitle;
	 
	 @FindBy(xpath = "//span[@class='pre-line-span' and contains(text(),'Tell me about Haptik')]") 	 
	 private WebElement haptikProductText;
	 
	 @FindBy(css = ".slick-slide.slick-active") 	 
	 private WebElement activeBotName;
	 
	 @FindBy(css = ".slick-arrow.slick-next") 	 
	 private WebElement nextArrow;
	 
	 @FindBy(xpath = "//div[@class='slick-slide slick-active']//div[text()='Know More']") 	 
	 private WebElement knowMore;
	 
	 @FindBy(xpath = "//span[@class='pre-line-span' and contains(text(),'Concierge Bot.')]") 	 
	 private WebElement postBotText1;
	 
	 @FindBy(xpath = "//span[@class='pre-line-span' and contains(text(),'Our')]") 	 
	 private WebElement postBotText2;
	 
	 @FindBy(xpath = "//div[@class='image-smart-action-text' and contains(text(),'In fact, our clients have seen:')]") 	 
	 private WebElement postBotText3;
	 
	 @FindBy(xpath = "//div[@class='qr-item' and contains(text(),'See another Bot')]") 	 
	 private WebElement loadConceirgeBotOption;
	 
	 @FindBy(className = "qr-item") 	 
	 private List<WebElement> ConceirgeBotOption;
	 
	 @FindBy(xpath = "//div[@class='qr-item' and contains(text(),'Not my problem')]") 	 
	 private WebElement loadConceirgeBotChoice;
	 
	 @FindBy(xpath = "//span[@class='pre-line-span' and contains(text(),'your name')]") 	 
	 private WebElement postBotDecisionText;
	 
	 @FindBy(id = "icon/arrow/up") 	 
	 private WebElement menuButton;
	 
	 @FindBy(css = ".minimized-view-cross-icon.open") 	 
	 private WebElement closeButton;
	  
	 @FindBy(xpath = "//span[@class='pre-line-span' and contains(text(),' Teach me about bots')]") 	 
	 private WebElement aboutBot;
	 
	 @FindBy(className = "powered-by-logo-text") 	 
	 private WebElement botLogoText;
	 
	 @FindBy(className = "header-top-left-text-title") 	 
	 private WebElement botTitleText;;
	 
	 @FindBy(className = "header-top-left-text-credentials") 	 
	 private WebElement botTitleTagText;
	 
	 public void click(WebElement element)
	 {
	     element.click();
	 }
	 
	 public void WaitForElementToAppear(WebDriver driver, WebElement element)
     {
		 wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOf(element));
     }
	 
	 public String getHomePageTitle(){
			return brandText.getText();
		}
	 	
	public void switchToFrame(WebElement element) {
			driver.switchTo().frame(element);		
	}
	

	public void switchToChatFrame() {
		switchToFrame(botBuuble);
		
	}
		
	 public WebElement getBotTitle(){
		 return botTitleText;
	 }
	 
	 public WebElement refreshActiveBot(){
		 return activeBotName;
	 }

	 public WebElement getBotTitleTag(){
		 return botTitleTagText;
	 }
	 
	 public WebElement getBotLogo(){
		 return botLogoText;
	 }
	 
	 public WebElement getAboutBotText(){
		 return aboutBot;
	 }
	 
	 
	 public void clickOnChatBubble() {
		 WaitForElementToAppear(driver, botBuuble);
		 click(botBuuble);
	 }
	 
	 
	 public void validateTaskBar() {
		 WaitForElementToAppear(driver, taskBox);
	 }
	 
	 public void selectMenuOption(String choice) {
		 WaitForElementToAppear(driver, taskBox);
		 for(WebElement option : dropDownTitle) {
			 System.out.println(option.getText());
			 System.out.println(choice);
			    if(option.getText().equals(choice) ){
			    	click(option);
			    	break;
			    }
			  }
	 }
	 
	 public void postProductText() {
		 WaitForElementToAppear(driver, haptikProductText);
	 }
	 	 
	 public void selectBot(String botName) throws InterruptedException {
		 WaitForElementToAppear(driver, activeBotName);
		 while(!activeBotName.getText().contains(botName)) { 
			  click(nextArrow);
			  Thread.sleep(1000);
			  activeBotName = refreshActiveBot();  			  
			  }
		 click(knowMore);
	 }
	 
	 public void postBotText() {
		 WaitForElementToAppear(driver, postBotText1);
		 WaitForElementToAppear(driver, postBotText2);
		 WaitForElementToAppear(driver, postBotText3);
		 WaitForElementToAppear(driver, loadConceirgeBotOption);
	 }	 
	 
	 public void selectedBotChoice(String choice) {
		  for(WebElement option : ConceirgeBotOption) {
			    if(option.getText().equals(choice) ){
			    	click(option);
			    	break;
			    }
			  }
	 }
	 
	 public void validateOption() {
		 WaitForElementToAppear(driver, loadConceirgeBotChoice);
	 }
	 
	 
	 public void postChoiceInstruction() {
		 WaitForElementToAppear(driver, postBotDecisionText);
	 }
	 
	 public void clickOnMenu() {
		 click(menuButton);
	 }
	 
	 public void aboutBotText() {
		 WaitForElementToAppear(driver, aboutBot);
	 }
	 
	 	 
	 public void highLightText(WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 }
	 
	 public void closeBot(){
		 click(closeButton);
	 }

}
