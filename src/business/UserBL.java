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
			throw new SQLIntegrityConstraintViolationException(
					"Sorry, account with username " + user.getUsername() + " already exists.");
		}

		return isUserAdded;
	}

	public UserBO getUserById(int id) throws SQLException {
		UserBO user = null;

		UserDAL userDAL = new UserDAL();
		ResultSet rs = userDAL.getUserById(id);
		if (rs.next()) {
			user = new UserBO(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"),
					rs.getString("address"), rs.getString("username"), rs.getString("password"));
		}

		return user;
	}

	public UserBO getUserByUsername(String username) throws SQLException {
		UserDAL userDAL = new UserDAL();
		UserBO user = null;
		ResultSet rs = userDAL.getUserByUsername(username);

		if (rs.next()) {
			user = new UserBO(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"),
					rs.getString("address"), rs.getString("username"), rs.getString("password"));
		}

		return user;
	}
	
	public UserBO getUserByUsernameAndPassword(String username, String password) throws SQLException {
		UserDAL userDAL = new UserDAL();
		UserBO user = null;
		ResultSet rs = userDAL.getUserByUsernameAndPassword(username, password);

		if (rs.next()) {
			user = new UserBO(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"),
					rs.getString("address"), rs.getString("username"), rs.getString("password"));
		}

		return user;
	}
}