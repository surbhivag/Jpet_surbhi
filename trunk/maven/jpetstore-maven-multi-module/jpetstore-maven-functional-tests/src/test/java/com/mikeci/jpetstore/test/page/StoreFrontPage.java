package com.mikeci.jpetstore.test.page;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class StoreFrontPage extends Page {

	public StoreFrontPage(Selenium selenium, ConditionRunner runner) {
		super(selenium, runner);
	}

	@Override
	public void verifyPage() {
		String imagePrefix = "../images/";
		imageIsPresent(imagePrefix+"splash.gif");
	}
	
	public StoreLoginPage clickSignInLink(){
		clickLink("Sign In");
		waitForPageToLoad();
		return new StoreLoginPage(selenium, runner);
	}
	
	public void verifyPresenceOfUserWelcomeMessage(String user){
		textIsVisible("Welcome "+user+"!");
	}

}
