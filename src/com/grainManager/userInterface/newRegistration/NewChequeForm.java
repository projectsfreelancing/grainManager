package com.grainManager.userInterface.newRegistration;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.grainManager.properties.ApplicationsConstants;

public class NewChequeForm extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JPanel topPanel, bottomPanel;

	JLabel welcomeLabel;

	JComboBox dealerComboBox, customerComboBox;
	List<String> dealerList, customerList;

	String[] keyString = { "Bank Name*", "Cheque Id*", "Cheque Amount*",
			"Cheque Date*", "Discription" };
	JTextField[] textField;

	JButton saveButton, cancelButton;

	public NewChequeForm() {
		initComponents();
	}

	private void initComponents() {
		mainPanel = ApplicationsConstants._uiUtilReference.getJPanel(
				RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_WIDTH,
				RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_HEIGHT);
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

		welcomeLabel = ApplicationsConstants._uiUtilReference.getJLabel();
		welcomeLabel.setText("Add New Cheque");

		topPanel = ApplicationsConstants._uiUtilReference
				.getJPanel(
						RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_TOP_PANEL_WIDTH,
						RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_TOP_PANEL_HEIGHT);

		bottomPanel = ApplicationsConstants._uiUtilReference
				.getJPanel(
						RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_BOTTOM_PANEL_WIDTH,
						RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_BOTTOM_PANEL_HEIGHT);

		setTopPanelContent();
		setBottomPanelContent();

		mainPanel.add(welcomeLabel);
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);

		add(mainPanel);
		pack();
		setVisible(true);
	}

	private void setTopPanelContent() {
		JPanel leftPanel, rightPanel;
		String[] KeyStrings = { "Select Dealer:", "Select Customer:" };
		JLabel[] keyStringLabels;

		topPanel.setLayout(new BorderLayout(20, 0));

		leftPanel = ApplicationsConstants._uiUtilReference
				.getJPanel(
						RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_TOP_PANEL_WIDTH / 2 - 10,
						RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_TOP_PANEL_HEIGHT);
		leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		rightPanel = ApplicationsConstants._uiUtilReference
				.getJPanel(
						RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_TOP_PANEL_WIDTH / 2 - 10,
						RegistrationUtil._NEW_CHEQUE_REGISTRATION_FORM_TOP_PANEL_HEIGHT);
		rightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		setDealerNameList();
		setCustomerNameList();

		dealerComboBox = ApplicationsConstants._uiUtilReference.getJComboBox();
		dealerComboBox.setModel(new DefaultComboBoxModel(dealerList.toArray()));
		dealerComboBox.setSelectedIndex(0);
		dealerComboBox.setPreferredSize(new Dimension(120, 30));
		dealerComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionListner(e);
			}
		});

		customerComboBox = ApplicationsConstants._uiUtilReference
				.getJComboBox();
		customerComboBox.setModel(new DefaultComboBoxModel(customerList
				.toArray()));
		customerComboBox.setSelectedIndex(0);
		customerComboBox.setPreferredSize(new Dimension(120, 30));
		customerComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionListner(e);
			}
		});

		keyStringLabels = new JLabel[KeyStrings.length];
		for (int iLoop = 0; iLoop < KeyStrings.length; iLoop++) {
			keyStringLabels[iLoop] = ApplicationsConstants._uiUtilReference
					.getJLabel();
			keyStringLabels[iLoop].setText(KeyStrings[iLoop]);
			if (iLoop == 0) {
				leftPanel.add(keyStringLabels[iLoop], BorderLayout.WEST);
				leftPanel.add(dealerComboBox);
			} else {
				rightPanel.add(keyStringLabels[iLoop], BorderLayout.EAST);
				rightPanel.add(customerComboBox);
			}
		}

		// topPanel.add(leftPanel);
		topPanel.add(rightPanel);
	}

	private void setBottomPanelContent() {

		JLabel[] keyLabels;

		bottomPanel.setLayout(new GridLayout(keyString.length + 1, 2));

		keyLabels = new JLabel[keyString.length];
		textField = new JTextField[keyString.length];
		for (int iLoop = 0; iLoop < keyString.length; iLoop++) {
			keyLabels[iLoop] = ApplicationsConstants._uiUtilReference
					.getJLabel();
			keyLabels[iLoop].setText(keyString[iLoop]);

			textField[iLoop] = ApplicationsConstants._uiUtilReference
					.getJTextField();

			bottomPanel.add(keyLabels[iLoop]);
			bottomPanel.add(textField[iLoop]);
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
		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionListner(e);
			}
		});

		bottomPanel.add(saveButton);
		bottomPanel.add(cancelButton);
	}

	private void actionListner(ActionEvent event) {
		JButton clickedButton = null;
		JComboBox clickedComboBox = null;

		if (event.getSource() instanceof JButton)
			clickedButton = (JButton) event.getSource();
		else
			clickedComboBox = (JComboBox) event.getSource();

		if (clickedButton != null) {
			if (clickedButton.getText().equals("Save")) {
				for (int iLoop = 0; iLoop < keyString.length - 1; iLoop++) {
					if (textField[iLoop].getText().length() == 0) {
						JOptionPane.showMessageDialog(this,
								"Please Enter * Marked Fields");
						return;
					}
				}
			} else if (clickedButton.getText().equals("Cancel")) {

			}
		} else if (clickedComboBox != null) {

		}
	}

	private boolean setDealerNameList() {
		boolean isSuccess = false;

		dealerList = new ArrayList<String>();
		dealerList.add("Dealer 1");
		dealerList.add("Dealer 2");

		return isSuccess;
	}

	private boolean setCustomerNameList() {
		boolean isSuccess = false;

		customerList = new ArrayList<String>();
		customerList.add("Customer 1");
		customerList.add("Customer 2");
		return isSuccess;
	}

	public static void main(String[] args) {

	}
}
