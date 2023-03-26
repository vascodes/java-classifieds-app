package business;

import java.sql.*;

import data.UserDAL;

public class UserBL {
	public UserBO getUserById(int id) {
		UserDAL userDAL = new UserDAL();
		UserBO user = new UserBO();

		try {
			ResultSet rs = userDAL.getUserById(id);
			
			user.map(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("phone"), 
						rs.getString("email"),
						rs.getString("address"));			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}	
}