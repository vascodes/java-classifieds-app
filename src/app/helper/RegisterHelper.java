package app.helper;

import java.sql.SQLIntegrityConstraintViolationException;

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

		String fullName = txtFullName.getText().trim(), phone = txtPhone.getText().trim(),
				email = txtEmail.getText().trim(), address = txtAddress.getText().trim(),
				username = txtUsername.getText().trim(), password = txtPassword.getText().trim();

		// Check whether all text inputs are provided.
		String allInputs[] = { fullName, phone, email, address, username, password };
		for (String inputStr : allInputs) {
			if (inputStr.equals("")) {
				CommonHelper.showAlert("Please provide all inputs.");
				return;
			}
		}

		UserBO newUser = new UserBO(fullName, phone, email, address, username, password);
		UserBL userBL = new UserBL();

		boolean isUserAdded = false;
		try {
			isUserAdded = userBL.addUser(newUser);
		} catch (SQLIntegrityConstraintViolationException e) {
			CommonHelper.showAlert(e.getMessage());
		}
		
		if (isUserAdded) {
			CommonHelper.showAlert("Registration Successful.");

			// Reset all input text fields.
			txtFullName.setText("");
			txtPhone.setText("");
			txtEmail.setText("");
			txtAddress.setText("");
			txtUsername.setText("");
			txtPassword.setText("");
		} else {
			CommonHelper.showAlert("Registration failed.");
		}
	}

	public void handleLoginButtonClick() {
		LoginWindow login = new LoginWindow();
		login.setVisibility(true);

		registerWindow.dispose();
	}

	public void handleRegisterButtonClick() {
		// TODO Auto-generated method stub

	}
}
