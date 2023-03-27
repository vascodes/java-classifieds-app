package app.helper;

import java.sql.SQLException;

import javax.swing.*;

import app.HomeWindow;
import app.RegisterWindow;
import business.LoginBL;
import business.UserBL;
import business.businessObjects.LoginBO;
import business.businessObjects.UserBO;

public class LoginHelper {
	private JFrame loginWindow;
	
	public LoginHelper(JFrame loginWindow) {
		this.loginWindow = loginWindow;
	}
	
	public void handleLoginButtonClick(JTextField txtUsername, JTextField txtPassword) {
		String username = txtUsername.getText().trim();
		String password = txtPassword.getText().trim();
		
		// Check if all inputs are provided.
		JTextField[] JtxtFields = { txtUsername, txtPassword };
		for (JTextField txtField : JtxtFields) {
			if (txtField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please provide all inputs.");
				return;
			}
		}

		LoginBO loginBO = new LoginBO(username, password);
		LoginBL loginBL = new LoginBL();

		boolean isUserExists = false;
		UserBL userBL = new UserBL();
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
			
			UserBO user = userBL.getUserByUsername(username);
			System.out.println(user);
			
			// Show home window.
			HomeWindow hw = new HomeWindow();
			hw.setUser(user);
			hw.setVisibility(true);
			loginWindow.setVisible(false);			
			
		} else {
			JOptionPane.showMessageDialog(null, "Login Failed. Please check username and password.");
		}
	}

	public void handleRegisterButtonClick(JFrame loginFrame) {
		loginFrame.dispose();

		RegisterWindow register = new RegisterWindow();
		register.setVisibility(true);
	}

	public void handleRegisterButtonClick() {
		// TODO Auto-generated method stub

	}
}
