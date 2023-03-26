package business;

import java.sql.*;

import business.businessObjects.UserBO;
import data.UserDAL;

public class UserBL {
	public UserBO getUserById(int id) {
		UserDAL userDAL = new UserDAL();
		UserBO user = null;

		try {
			ResultSet rs = userDAL.getUserById(id);
			if (rs.next()) {
				user = new UserBO(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"),
						rs.getString("address"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public boolean addUser(UserBO user, String username, String password) {
		boolean isUserAdded = false;
		UserDAL userDAL = new UserDAL();

		isUserAdded = userDAL.addUser(user.getName(), user.getPhone(), user.getEmail(), user.getAddress(), username,
				password);

		return isUserAdded;
	}
}