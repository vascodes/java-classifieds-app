package business;

import business.businessObjects.LoginBO;
import data.AuthDAL;

public class LoginBL {
	private LoginBO loginBO = null;

	public LoginBL(String username, String password) {
		loginBO = new LoginBO();
		
		loginBO.setUsername(username);
		loginBO.setPassword(password);		
	}

	public void authenticate() {
		AuthDAL auth = new AuthDAL();
		auth.checkLogin(loginBO);
	}
}
