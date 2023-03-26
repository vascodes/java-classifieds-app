package app.helper;

import javax.swing.*;

import business.UserBL;
import business.businessObjects.UserBO;

public class AppHelper {
	public static void handleRegisterButtonClick(String fullname, String phone, String email, String address,
			String username, String password) {

		UserBL userBL = new UserBL();
		UserBO user = new UserBO(fullname, phone, email, address);

		boolean isUserAdded = false;
		isUserAdded = userBL.addUser(user, username, password);
		if (isUserAdded) {
			JOptionPane.showMessageDialog(null, "Registration Successful.");
		} else {
			JOptionPane.showMessageDialog(null, "Registration failed.");
		}
	}

	public static void handleLoginButtonClick() {
		System.out.println("LOGIN CLICKED");
	}
}
