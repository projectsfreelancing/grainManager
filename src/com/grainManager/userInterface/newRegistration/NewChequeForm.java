package com.grainManager.userInterface.newRegistration;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.grainManager.properties.ApplicationsConstants;

public class NewChequeForm extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mainPanel;

	JLabel welcomeLabel;

	public NewChequeForm() {
		initComponents();
	}

	private void initComponents() {
		mainPanel = ApplicationsConstants._uiUtilReference.getJPanel(
				RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_WIDTH,
				RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_HEIGHT);
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

		welcomeLabel = ApplicationsConstants._uiUtilReference.getJLabel();
	}

	public static void main(String[] args) {

	}
}
