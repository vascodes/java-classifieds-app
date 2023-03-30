package app.helper;

import java.sql.SQLException;

import javax.swing.*;

import app.HomeWindow;
import app.RegisterWindow;
import business.UserBL;
import business.businessObjects.UserBO;

public class LoginHelper {
	public void handleLoginButtonClick(String username, String password) {
		// Check whether all text inputs are provided.
		String allInputs[] = { username, password };
		for (String inputStr : allInputs) {
			if (inputStr.equals("")) {
				Common.showAlert("Please provide all inputs.");
				return;
			}
		}

		UserBO user = null;
		UserBL userBL = new UserBL();

		try {
			user = userBL.getUserByUsernameAndPassword(username, password);
		} catch (SQLException e) {
			System.out.println("Error. Could not login.");
			e.printStackTrace();
		}

		if (user == null) {
			Common.showAlert("Login Failed. Please check username and password.");
		} else {
			Common.showAlert("Login Successful.");

			// Show home window.
			HomeWindow hw = new HomeWindow(user);
			hw.setVisibility(true);
		}
	}

	public void handleRegisterButtonClick() {
		RegisterWindow register = new RegisterWindow();
		register.setVisibility(true);
	}
}
