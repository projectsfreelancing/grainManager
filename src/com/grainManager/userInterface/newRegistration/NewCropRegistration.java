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

import com.grainManager.properties.ApplicationsConstants;

public class NewCropRegistration extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel mainPanel, contentPanel;

	JTextField[] textFields;
	JButton saveButton, cancelButton;

	public NewCropRegistration() {
		initComponents();
	}

	private void initComponents() {
		JLabel welcomeLabel;

		mainPanel = ApplicationsConstants._uiUtilReference.getJPanel(
				RegistrationUtil._NEW_CROP_REGISTRATION_FORM_WIDTH,
				RegistrationUtil._NEW_CROP_REGISTRATION_FORM_HEIGHT);
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

		welcomeLabel = ApplicationsConstants._uiUtilReference.getJLabel();
		welcomeLabel.setText("Add New Crop");

		initContentPanel();

		mainPanel.add(welcomeLabel);
		mainPanel.add(contentPanel);

		add(mainPanel);
		pack();
		setVisible(true);
	}

	private void initContentPanel() {
		String[] keyCaptions = { "Crop Name", "Vyapar Mandal Tax", "Aadat",
				"Mandi Tax", "Majoori", "VAT", "Weight Per Quantity" };

		JLabel[] keyLabels;
		contentPanel = ApplicationsConstants._uiUtilReference
				.getJPanel(
						RegistrationUtil._NEW_CROP_REGISTRATION_FORM_CONTENT_PANEL_WIDTH,
						RegistrationUtil._NEW_CROP_REGISTRATION_FORM_CONTENT_PANEL_HEIGHT);

		contentPanel.setLayout(new GridLayout(8, 2));

		keyLabels = new JLabel[keyCaptions.length];
		textFields = new JTextField[keyCaptions.length];
		for (int iLoop = 0; iLoop < keyCaptions.length; iLoop++) {
			keyLabels[iLoop] = ApplicationsConstants._uiUtilReference
					.getJLabel();

			keyLabels[iLoop].setText(keyCaptions[iLoop]);

			textFields[iLoop] = ApplicationsConstants._uiUtilReference
					.getJTextField();

			contentPanel.add(keyLabels[iLoop]);
			contentPanel.add(textFields[iLoop]);
		}
		saveButton = ApplicationsConstants._uiUtilReference.getJButton();
		saveButton.setText("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionListner(e);
			}
		});

		cancelButton = ApplicationsConstants._uiUtilReference.getJButton();
		cancelButton.setText("cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionListner(e);
			}
		});

		contentPanel.add(saveButton);
		contentPanel.add(cancelButton);
	}

	private void actionListner(ActionEvent event) {

	}

	public static void main(String[] args) {
		new NewCropRegistration();
	}
}
