package com.mikeci.jpetstore.test.page;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class HomePage extends Page {

	public HomePage(Selenium selenium, ConditionRunner runner) {
		super(selenium, runner);
	}
	
	@Override
	public void verifyPage() {
		textIsVisible("Welcome to JPetStore 5");
		textIsVisible("Copyright Apache Software Foundation");
	}
	
	public StoreFrontPage clickEnterStoreLink(){
		clickLink("Enter the Store");
		waitForPageToLoad();
		return new StoreFrontPage(selenium, runner);
	}

}
