package app.helper;

import javax.swing.*;

import app.LoginWindow;
import business.UserBL;
import business.businessObjects.UserBO;

public class RegisterHelper {
	public static void handleRegisterButtonClick(JTextField[] JtxtFields) {

		// Check if all inputs are provided.
		for (JTextField txtField : JtxtFields) {
			if (txtField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please provide all inputs.");
				return;
			}
		}

		// Create user object.
		UserBL userBL = new UserBL();
		UserBO user = new UserBO(JtxtFields[0].getText().trim(), JtxtFields[1].getText().trim(),
				JtxtFields[2].getText().trim(), JtxtFields[3].getText().trim());

		boolean isUserAdded = false;
		isUserAdded = userBL.addUser(user, JtxtFields[4].getText().trim(), JtxtFields[5].getText().trim());
		if (isUserAdded) {
			JOptionPane.showMessageDialog(null, "Registration Successful.");

			// Reset text fields.
			for (JTextField txtField : JtxtFields) {
				txtField.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Registration failed.");
		}
	}

	public static void handleLoginButtonClick(JFrame registrationFrame) {
		registrationFrame.dispose();

		LoginWindow login = new LoginWindow();
		login.setVisibility(true);
	}

	public static void handleRegisterButtonClick() {
		// TODO Auto-generated method stub

	}
}
