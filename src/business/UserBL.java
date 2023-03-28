package business;

import java.sql.*;

import business.businessObjects.UserBO;
import data.UserDAL;

public class UserBL {
	public boolean addUser(UserBO user) throws SQLIntegrityConstraintViolationException {
		boolean isUserAdded = false;

		UserDAL userDAL = new UserDAL();
		try {
			isUserAdded = userDAL.addUser(user.getName(), user.getPhone(), user.getEmail(), user.getAddress(),
					user.getUsername(), user.getPassword());
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new SQLIntegrityConstraintViolationException("Sorry, account with username " + user.getUsername() + " already exists.");
		}

		return isUserAdded;
	}

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

	public UserBO getUserByUsername(String username) {
		UserDAL userDAL = new UserDAL();
		UserBO user = null;
		ResultSet rs = userDAL.getUserByUsername(username);

		try {
			if (rs.next()) {
				user = new UserBO(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"),
						rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}