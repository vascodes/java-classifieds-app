package app.helper;

import javax.swing.*;

import app.LoginWindow;
import business.UserBL;
import business.businessObjects.UserBO;

public class RegisterHelper {
	private JFrame registerWindow;

	public RegisterHelper(JFrame registerWindow) {
		this.registerWindow = registerWindow;
	}

	public void handleRegisterButtonClick(JTextField txtFullName, JTextField txtPhone, JTextField txtEmail,
			JTextField txtAddress, JTextField txtUsername, JTextField txtPassword) {

		JTextField[] JtxtFields = { txtFullName, txtPhone, txtPassword, txtEmail, txtAddress, txtUsername,
				txtPassword };

		// Check if all inputs are provided.
		for (JTextField txtField : JtxtFields) {
			if (txtField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please provide all inputs.");
				return;
			}
		}

		// Create user object.
		UserBL userBL = new UserBL();
		UserBO user = new UserBO(txtFullName.getText(), txtPhone.getText(), txtEmail.getText(), txtAddress.getText());

		boolean isUserAdded = false;
		isUserAdded = userBL.addUser(user, txtUsername.getText().trim(), txtPassword.getText().trim());
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

	public void handleLoginButtonClick() {
		registerWindow.dispose();

		LoginWindow login = new LoginWindow();
		login.setVisibility(true);
	}

	public void handleRegisterButtonClick() {
		// TODO Auto-generated method stub

	}
}
