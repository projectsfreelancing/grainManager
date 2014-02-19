package com.grainManager.userInterface.forms.homeScreen;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.grainManager.properties.ApplicationsConstants;

public class HomePage {
	JFrame mainFrame;
	JPanel homePageLinkPanel, homePageButtonPanel, homePageImagePanel;

	public HomePage() {
		createMainFrame();
		new HomePageLinkPanel();
		new HomePageButtonPanel();
	}

	private void createMainFrame() {
		mainFrame = ApplicationsConstants._uiUtilReference.getJFrame(
				ApplicationsConstants._HOME_PAGE_WIDTH,
				ApplicationsConstants._HOME_PAGE_HEIGHT, "Grain Manager");

		mainFrame.setLayout(new java.awt.FlowLayout(FlowLayout.LEFT, 10, 10));
		mainFrame.setVisible(true);

		ApplicationsConstants._homePageReference = mainFrame;
	}
}