package app.helper;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.*;

import app.LoginWindow;
import business.UserBL;
import business.businessObjects.UserBO;

public class RegisterHelper {
	public void handleRegisterButtonClick(String fullName, String phone, String email, String address, String username,
			String password) {

		// Check whether all text inputs are provided.
		String allInputs[] = { fullName, phone, email, address, username, password };
		for (String inputStr : allInputs) {
			if (inputStr.equals("")) {
				Common.showAlert("Please provide all inputs.");
				return;
			}
		}

		UserBO newUser = new UserBO(fullName, phone, email, address, username, password);
		UserBL userBL = new UserBL();

		boolean isUserAdded = false;
		try {
			isUserAdded = userBL.addUser(newUser);
		} catch (SQLIntegrityConstraintViolationException e) {
			Common.showAlert(e.getMessage());
		}

		if (isUserAdded) {
			Common.showAlert("Registration Successful.");
		} else {
			Common.showAlert("Registration failed.");
		}
	}

	public void handleLoginButtonClick() {
		LoginWindow login = new LoginWindow();
		login.setVisibility(true);
	}
}
