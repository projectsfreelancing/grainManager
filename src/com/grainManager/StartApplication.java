package com.grainManager;

import com.grainManager.properties.ApplicationsConstants;
import com.grainManager.userInterface.UiUtil;
import com.grainManager.userInterface.forms.homeScreen.HomePage;

public class StartApplication {

	public static void main(String[] args) {
		ApplicationsConstants._uiUtilReference = new UiUtil();
		
		new HomePage();
	}
}