package business;

import java.sql.*;

import data.UserDAL;

public class UserBLL {

	public static void main(String[] args) {
		UserBO user = new UserBO();

		UserDAL userDAL = new UserDAL();
		ResultSet rs = userDAL.getUserById(1);
		try {
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPhone(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setAddress(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(user);
	}
}