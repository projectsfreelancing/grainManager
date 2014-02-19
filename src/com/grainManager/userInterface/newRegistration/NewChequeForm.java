package com.grainManager.userInterface.newRegistration;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
	JPanel topPanel, bottomPanel;

	JLabel welcomeLabel;

	JComboBox dealerComboBox, customerComboBox;
	List<String> dealerList, customerList;

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
		customerComboBox.setPreferredSize(new Dimension(120, 100));
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
	}

	private void actionListner(ActionEvent event) {

	}

	private void setBottomPanelContent() {

	}

	public static void main(String[] args) {

	}
}
