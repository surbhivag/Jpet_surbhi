package com.mikeci.jpetstore.test.page;

import java.util.concurrent.TimeUnit;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.Condition;
import com.thoughtworks.selenium.condition.ConditionRunner;
import com.thoughtworks.selenium.condition.Not;
import com.thoughtworks.selenium.condition.Presence;
import com.thoughtworks.selenium.condition.Text;

public abstract class Page {

	protected final Selenium selenium;
	protected final ConditionRunner runner;

	public Page(Selenium selenium, ConditionRunner runner) {
		this.selenium = selenium;
		this.runner = runner;
	}

	protected static void waitFor(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
		}
	}

	public void waitFor(Condition condition) {
		runner.waitFor(condition);
		waitFor(1);
	}
	
	public void waitForPageToLoad(){
		selenium.waitForPageToLoad("30000");
	}

	public void textIsVisible(String text) {
		waitFor(new Text(text));
	}
	
	public void elementIsPresent(Presence prescence) {
		waitFor(prescence);
	}
	
	public void imageIsPresent(String srcAttributeValue){
		String xpath = "//img[@src='"+srcAttributeValue+"']";
		elementIsPresent(new Presence(xpath));
	}

	public void textIsNotVisible(String text) {
		waitFor(new Not(new Text(text)));
	}
	
    public void clickLink(String link) {
        selenium.click("link="+link);
    }
    
	public void open(String url) {
		selenium.open(url);
	}
    
    public void type(String locator, String value){
    	selenium.type(locator, value);
    }
    
    public void clickButton(String buttonLocator){
    	selenium.click(buttonLocator);
    }
    
	public abstract void verifyPage();

}

