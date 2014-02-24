package com.grainManager.userInterface.forms.homeScreen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.grainManager.properties.ApplicationsConstants;
import com.grainManager.userInterface.UiColor;
import com.grainManager.userInterface.UiFont;
import com.grainManager.userInterface.newRegistration.NewChequeForm;
import com.grainManager.userInterface.newRegistration.NewCropRegistration;
import com.grainManager.userInterface.newRegistration.NewCustomerRegistrationForm;
import com.grainManager.userInterface.newRegistration.NewDealerRegistrationForm;
import com.grainManager.userInterface.newRegistration.UiBorder;

public class HomePageButtonPanel {

	JPanel mainPanel;

	String[] homePageButtonText = { "NewCustomer", "NewDealer", "New Crop",
			"NewBilling", "NewCheque", "NewPayment", "NewPurchase",
			"MandiTaxReport", "V.A.T Report", "CurrentBalance" };

	int homePageButtonWidth = 120;
	int homePageButtonHeight = 35;

	JButton[] homePageButton;

	public HomePageButtonPanel() {
		initComponents();
		ApplicationsConstants._homePageReference.add(mainPanel);
	}

	private void initComponents() {
		mainPanel = ApplicationsConstants._uiUtilReference.getJPanel(
				ApplicationsConstants._HOME_PAGE_BUTTON_PANEL_WIDTH,
				ApplicationsConstants._HOME_PAGE_BUTTON_PANEL_HEIGHT);

		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		homePageButton = new JButton[homePageButtonText.length];
		for (int iLoop = 0; iLoop < homePageButtonText.length; iLoop++) {
			homePageButton[iLoop] = ApplicationsConstants._uiUtilReference
					.getJButton();
			homePageButton[iLoop].setText(homePageButtonText[iLoop]);
			homePageButton[iLoop].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					actionListner(e);
				}
			});

			ApplicationsConstants._uiUtilReference.getCustomButton(
					homePageButton[iLoop], homePageButtonWidth,
					homePageButtonHeight, UiColor.BG_MAIN_MENU_BTN,
					UiColor.COLOR_GRAY, UiFont.FONT_MAIN_MENU_BTN,
					UiBorder.BORDER_RAISED_BEVEL);

			// ApplicationsConstants._uiUtilReference.getCustomButton(homePageButton[iLoop],
			// width, height, bgColor, fgColor, font, border)

			mainPanel.add(homePageButton[iLoop]);
		}
	}

	private void actionListner(ActionEvent event) {
		JButton clickedButton;
		if (event.getSource() instanceof JButton)
			clickedButton = (JButton) event.getSource();
		else
			return;
		System.out.println(clickedButton.getText());
		if (clickedButton.getText().equals(homePageButtonText[0]))
			new NewCustomerRegistrationForm();
		else if (clickedButton.getText().equals(homePageButtonText[1]))
			new NewDealerRegistrationForm();
		else if (clickedButton.getText().equals(homePageButtonText[2])) {
			new NewCropRegistration();
		} else if (clickedButton.getText().equals(homePageButtonText[3])) {

		} else if (clickedButton.getText().equals(homePageButtonText[4])) {
			new NewChequeForm();
		}
	}
}
