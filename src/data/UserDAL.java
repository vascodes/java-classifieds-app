package data;

import java.sql.*;

public class UserDAL {
	DB db = null;

	public UserDAL() {
		db = new DB();
	}

	public ResultSet getUserById(int id) {		
		ResultSet rs = null;

		try {
			Connection con = db.getConnection();

			String sql = "SELECT * FROM tbl_user WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();	
			rs.next();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
}
