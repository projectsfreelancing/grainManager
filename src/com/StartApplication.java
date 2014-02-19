package com;

import com.properties.ApplicationsConstants;
import com.userInterface.UiUtil;
import com.userInterface.forms.homeScreen.HomePage;

public class StartApplication {

	public static void main(String[] args) {
		ApplicationsConstants._uiUtilReference = new UiUtil();
		new HomePage();
	}
}