package com.mikeci.jpetstore.test.scenario;

import org.jbehave.scenario.Scenario;

public class LoginScenarios extends Scenario{

	public LoginScenarios(){
		super(new LoginSteps());
	}
}
