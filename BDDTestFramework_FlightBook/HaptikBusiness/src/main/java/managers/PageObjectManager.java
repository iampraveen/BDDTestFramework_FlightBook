package managers;
import org.openqa.selenium.WebDriver;

import pageObjects.BotPage;

public class PageObjectManager {
	private WebDriver driver;	 
	private BotPage botPage;
	 	 
	 public PageObjectManager(WebDriver driver) {	 
	 this.driver = driver;
	 }
	 	 
	 public BotPage getBotPage(){	 
	 return (botPage == null) ? botPage = new BotPage(driver) : botPage;	 
	 }
}
