package com.grainManager.userInterface.newRegistration;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	JComboBox selectDealerComboBox, selectCustomerComboBox;
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
	}

	private void setTopPanelContent() {
		JPanel leftPanel, rightPanel;
		String[] KeyStrings = { "Select Dealer", "Select Customer" };

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

		selectDealerComboBox = ApplicationsConstants._uiUtilReference
				.getJComboBox();
		selectDealerComboBox.setModel(new DefaultComboBoxModel(dealerList
				.toArray()));
		selectDealerComboBox.setSelectedIndex(0);
		selectDealerComboBox.setPreferredSize(new Dimension(120, 30));
		selectDealerComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionListner(e);
			}
		});

		selectCustomerComboBox = ApplicationsConstants._uiUtilReference
				.getJComboBox();
		selectCustomerComboBox.setModel(new DefaultComboBoxModel(customerList
				.toArray()));
		selectCustomerComboBox.setSelectedIndex(0);
		selectCustomerComboBox.setPreferredSize(new Dimension(120, 100));
		selectCustomerComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionListner(e);
			}
		});

	}

	private void actionListner(ActionEvent event) {

	}

	private void setBottomPanelContent() {

	}

	public static void main(String[] args) {

	}
}
