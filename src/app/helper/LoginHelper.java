package app.helper;

import java.sql.SQLException;

import javax.swing.*;

import app.RegisterWindow;
import business.LoginBL;
import business.businessObjects.LoginBO;

public class LoginHelper {
	public static void handleLoginButtonClick(JTextField txtUsername, JTextField txtPassword) {

		// Check if all inputs are provided.
		JTextField[] JtxtFields = { txtUsername, txtPassword };
		for (JTextField txtField : JtxtFields) {
			if (txtField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please provide all inputs.");
				return;
			}
		}

		LoginBO loginBO = new LoginBO(txtUsername.getText().trim(), txtPassword.getText().trim());
		LoginBL loginBL = new LoginBL();

		boolean isUserExists = false;
		try {
			isUserExists = loginBL.checkLogin(loginBO);
		} catch (SQLException e) {
			System.out.println("Error. Could not login.");
			e.printStackTrace();
		}
		if (isUserExists) {
			JOptionPane.showMessageDialog(null, "Login Successful.");

			// Reset all text fields.
			for (JTextField txtField : JtxtFields) {
				txtField.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Login Failed. Please check username and password.");
		}
	}

	public static void handleRegisterButtonClick(JFrame loginFrame) {
		loginFrame.dispose();

		RegisterWindow register = new RegisterWindow();
		register.setVisibility(true);
	}

	public static void handleRegisterButtonClick() {
		// TODO Auto-generated method stub

	}
}
