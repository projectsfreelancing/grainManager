package com.grainManager.userInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.Beans;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class UiUtil {
	public JFrame getJFrame(int width, int height, String title) {
		JFrame frame = null;
		try {
			frame = (JFrame) Beans.instantiate(getClass().getClassLoader(),
					JFrame.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame.setSize(new Dimension(width, height));
		frame.setTitle(title);
		return frame;
	}

	public JLabel getJLabel() {
		JLabel label = null;
		try {
			label = (JLabel) Beans.instantiate(getClass().getClassLoader(),
					JLabel.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// label.setSize(new Dimension(width, height));
		return label;
	}

	public JButton getJButton() {
		JButton button = null;
		try {
			button = (JButton) Beans.instantiate(getClass().getClassLoader(),
					JButton.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// label.setSize(new Dimension(width, height));
		return button;
	}

	public JPanel getJPanel(int width, int height) {
		JPanel panel = null;
		try {
			panel = (JPanel) Beans.instantiate(getClass().getClassLoader(),
					JPanel.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		panel.setSize(new Dimension(width, height));
		return panel;
	}

	public JTextField getJTextField() {
		JTextField textField = null;
		try {
			textField = (JTextField) Beans.instantiate(getClass()
					.getClassLoader(), JTextField.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textField;
	}

	public JComboBox getJComboBox() {
		JComboBox comboBox = null;
		try {
			comboBox = (JComboBox) Beans.instantiate(getClass()
					.getClassLoader(), JComboBox.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comboBox;
	}

	public static void getCustomButton(final JButton btn, final int width,
			final int height, final Color bgColor, final Color fgColor,
			final Font font, final Border border) {
		btn.setFocusPainted(false);
		btn.setPreferredSize(new java.awt.Dimension(width, height));
		btn.setBackground(bgColor);
		btn.setForeground(fgColor);
		btn.setBorder(border);
		btn.setFont(font);
	}

	public static void setButtonImageAndString(final JButton btn,
			final String str, final ImageIcon icon, final java.awt.Color color) {
		btn.setText(str);
		btn.setIcon(icon);
		btn.setBackground(color);
		btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
	}
}
