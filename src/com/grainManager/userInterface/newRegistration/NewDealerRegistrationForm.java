package com.grainManager.userInterface.newRegistration;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.grainManager.properties.ApplicationsConstants;

public class NewDealerRegistrationForm extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JPanel contentMainPanel;

	JTextField[] textField;
	JButton saveButton, cancelButton;

	JLabel welcomeLabel;

	public NewDealerRegistrationForm() {
		initComponents();
	}

	private void initComponents() {
		mainPanel = ApplicationsConstants._uiUtilReference.getJPanel(
				RegistrationUtil._NEW_CUSTOMER_REGISTRATION_FORM_WIDTH,
				RegistrationUtil._NEW_CUSTOMER_REGISTRATION_FORM_HEIGHT);

		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

		welcomeLabel = ApplicationsConstants._uiUtilReference.getJLabel();
		welcomeLabel.setText("Welcome, Please Enter The New Dealer Detail");

		setContentPanelContent();

		mainPanel.add(welcomeLabel);
		mainPanel.add(contentMainPanel);

		add(mainPanel);
		setTitle("Dealer Registration");
		pack();
		setLocationRelativeTo(NewDealerRegistrationForm.this);
		setVisible(true);
	}

	private void setContentPanelContent() {
		String[] keyStrings = { "First Name", "Tin No.", "Contact No.",
				"Proprieter", "Address" };
		JLabel[] keyLabels;

		saveButton = ApplicationsConstants._uiUtilReference.getJButton();
		saveButton.setText("Save");
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionListner(e);
			}

		});

		cancelButton = ApplicationsConstants._uiUtilReference.getJButton();
		cancelButton.setText("Cancel");

		contentMainPanel = ApplicationsConstants._uiUtilReference
				.getJPanel(
						RegistrationUtil._NEW_CUSTOMER_REGISTRATION_FORM_CONTENT_PANEL_WIDTH,
						RegistrationUtil._NEW_CUSTOMER_REGISTRATION_FORM_CONTENT_PANEL_HEIGHT);

		contentMainPanel.setLayout(new GridLayout(keyStrings.length + 1, 2));

		textField = new JTextField[keyStrings.length];
		keyLabels = new JLabel[keyStrings.length];
		for (int iLoop = 0; iLoop < keyStrings.length; iLoop++) {
			textField[iLoop] = ApplicationsConstants._uiUtilReference
					.getJTextField();
			textField[iLoop].setHorizontalAlignment(SwingConstants.CENTER);

			keyLabels[iLoop] = ApplicationsConstants._uiUtilReference
					.getJLabel();
			keyLabels[iLoop].setText(keyStrings[iLoop]);
			keyLabels[iLoop].setHorizontalAlignment(SwingConstants.RIGHT);

			contentMainPanel.add(keyLabels[iLoop]);
			contentMainPanel.add(textField[iLoop]);
		}
		contentMainPanel.add(saveButton);
		contentMainPanel.add(cancelButton);
	}

	private void actionListner(ActionEvent event) {
		JButton clickedButton = null;
		if (event.getSource() instanceof JButton)
			clickedButton = (JButton) event.getSource();
		else
			return;

		if (clickedButton.getText().equals("Save")) {

		} else if (clickedButton.getText().equals("Cancel")) {
			dispose();
		}
	}

	public static void main(String[] args) {
		new NewCustomerRegistrationForm();
	}
}
