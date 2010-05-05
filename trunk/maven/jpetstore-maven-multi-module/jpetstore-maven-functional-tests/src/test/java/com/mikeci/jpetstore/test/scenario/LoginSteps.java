package com.mikeci.jpetstore.test.scenario;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.web.selenium.SeleniumSteps;

import com.mikeci.jpetstore.test.page.HomePage;
import com.mikeci.jpetstore.test.page.StoreFrontPage;
import com.mikeci.jpetstore.test.page.StoreLoginPage;

public class LoginSteps extends SeleniumSteps {
	
	private HomePage homePage;
	private StoreFrontPage storeFrontPage;
	private StoreLoginPage storeLoginPage;
	
	@Given("the user opens the home page")
	public void theUserOpensTheHomePage(){
		homePage = new HomePage(selenium, runner);
		homePage.open("http://localhost:8080/jpetstore");
	}
	
	@When("the user clicks the enter store link")
	public void theUserClicksTheEnterStoreLink(){
		storeFrontPage = homePage.clickEnterStoreLink();
	}
	
	@Then("the store front page should be displayed")
	public void theStoreFrontPageShouldBeDisplayed(){
		storeFrontPage.verifyPage();
	}
	
	@When("the user clicks the sign in link")
	public void theUserClicksTheSignInLink(){
		storeLoginPage = storeFrontPage.clickSignInLink();
	}
	
	@Then("the store login page should be displayed")
	public void theStoreLoginPageShouldBeDisplayed(){
		storeLoginPage.verifyPage();
	}
	
	@When("the user enters username $username")
	public void theUserEntersUsername(String username){
		storeLoginPage.typeUsername(username);
	}
	
	@When("the user enters password $password")
	public void theUserEntersPassword(String password){
		storeLoginPage.typePassword(password);
	}
	
	@When("the user clicks the login button")
	public void theUserClicksTheLoginButton(){
		storeFrontPage = storeLoginPage.clickLoginButton();
	}
	
	@Then("the store front page should be displayed for user $user")
	public void theStoreFrontPageShouldBeDisplayedForUser(String user){
		storeFrontPage.verifyPage();
		storeFrontPage.verifyPresenceOfUserWelcomeMessage(user);
	}
	
	@Then("the invalid login error message should be displayed")
	public void theInvalidLoginErrorMessageShouldBeDisplayed(){
		storeLoginPage.verifyPresenceOfInvalidCredentialsErrorMessage();
	}

}
