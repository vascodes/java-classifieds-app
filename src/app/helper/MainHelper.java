package app.helper;

import javax.swing.JFrame;

import app.LoginWindow;
import app.RegisterWindow;

public class MainHelper {
	public static void handleLoginButtonClick(JFrame currentFrame) {
		currentFrame.dispose();
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.setVisibility(true);
	}
	
	public static void handleRegisterButtonClick(JFrame currentFrame) {
		currentFrame.dispose();
		RegisterWindow registerWindow = new RegisterWindow();
		registerWindow.setVisibility(true);
	}
}