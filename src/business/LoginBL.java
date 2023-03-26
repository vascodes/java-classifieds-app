package business;

import java.sql.ResultSet;
import java.sql.SQLException;

import business.businessObjects.LoginBO;
import data.LoginDAL;

public class LoginBL {
	public boolean checkLogin(LoginBO loginBO) throws SQLException {
		LoginDAL loginDAL = new LoginDAL();
		boolean isUserExists = false;

		ResultSet rs = loginDAL.getLoginUserDetails(loginBO.getUsername(), loginBO.getPassword());

		if (rs.next()) {
			isUserExists = true;
		}

		return isUserExists;
	}
}
