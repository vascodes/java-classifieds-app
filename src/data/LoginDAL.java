package data;

import java.sql.*;

public class LoginDAL {
	DB db = null;

	public LoginDAL() {
		db = new DB();
	}

	public ResultSet getLoginUserDetails(String username, String password) {
		ResultSet rs = null;

		try {
			Connection con = db.getConnection();

			String sql = "SELECT l.* FROM tbl_login l \r\n" + 
							"JOIN tbl_user u ON\r\n" + 
							"u.id = l.user_id\r\n"+ 
							"WHERE l.username = ? AND l.password = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();			
		} catch (SQLException e) {
			System.out.println("User does not exist.");
			e.printStackTrace();
		}

		return rs;
	}
}
