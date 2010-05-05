package com.mikeci.jpetstore.test.page;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class StoreLoginPage extends Page {

	public StoreLoginPage(Selenium selenium, ConditionRunner runner) {
		super(selenium, runner);
	}
	
	@Override
	public void verifyPage() {
		textIsVisible("Please enter your username and password.");
	}
	
	public void verifyPresenceOfInvalidCredentialsErrorMessage(){
		textIsVisible("Invalid username or password. Signon failed.");
	}
	
	public void typeUsername(String username){
		type("//input[@name='username']", username);
	}
	
	public void typePassword(String password){
		type("//input[@name='password']", password);
	}
	
	public StoreFrontPage clickLoginButton(){
		clickButton("//input[@value='Login']");
		waitForPageToLoad();
		return new StoreFrontPage(selenium, runner);
	}
	


}
