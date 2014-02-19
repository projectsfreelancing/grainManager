package com.grainManager.userInterface.forms.homeScreen;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.grainManager.properties.ApplicationsConstants;

public class HomePageLinkPanel {
	JPanel mainPanel;

	String[] homePageLinkLabelName = { "Customer", "Billing", "Balance",
			"Crop Data", "Banking", "Accounts", "Monthly Reports", "Entry's",
			"Print Report", "Modify Database" };

	int homePageLinkLabelWidth = 30;
	int homePageLinkLabelHeight = 90;

	JLabel[] homePageLinkLabel;

	public HomePageLinkPanel() {
		initComponents();
		ApplicationsConstants._homePageReference.add(mainPanel);
	}

	private void initComponents() {
		mainPanel = ApplicationsConstants._uiUtilReference.getJPanel(
				ApplicationsConstants._HOME_PAGE_LINK_PANEL_WIDTH,
				ApplicationsConstants._HOME_PAGE_LINK_PANEL_HEIGHT);

		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		homePageLinkLabel = new JLabel[homePageLinkLabelName.length];
		for (int iLoop = 0; iLoop < homePageLinkLabelName.length; iLoop++) {
			homePageLinkLabel[iLoop] = ApplicationsConstants._uiUtilReference
					.getJLabel();
			homePageLinkLabel[iLoop].setSize(new java.awt.Dimension(
					homePageLinkLabelWidth, homePageLinkLabelHeight));
			homePageLinkLabel[iLoop].setText(homePageLinkLabelName[iLoop]);
			mainPanel.add(homePageLinkLabel[iLoop]);
		}
	}
}