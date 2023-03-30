package data;

import java.sql.*;

public class AdvertisementDAL {
	DB db = null;

	public AdvertisementDAL() {
		db = new DB();
	}

	public ResultSet getAllAds() throws SQLException {
		ResultSet rs = null;
		Connection con = db.getConnection();

		/*
		 * SELECT ad.title, ad.content, c.category, u.username, ad.create_date as
		 * "CREATE DATE" FROM tbl_advertisement ad JOIN tbl_category c ON ad.category_id
		 * = c.id JOIN tbl_user_advertisement ua ON ua.ad_id = ad.id JOIN tbl_user u ON
		 * u.id = ua.user_id
		 */

		String sql = "SELECT ad.title, ad.content, c.category, u.username, ad.create_date as\r\n"
				+ "\"CREATE DATE\" FROM tbl_advertisement ad JOIN tbl_category c ON\r\n"
				+ "ad.category_id = c.id JOIN tbl_user_advertisement ua ON ua.ad_id = ad.id\r\n"
				+ "JOIN tbl_user u ON u.id = ua.user_id";

		PreparedStatement stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();

		return rs;
	}

	public ResultSet getAdsByUserId(int userId) throws SQLException {
		ResultSet rs = null;
		Connection con = db.getConnection();

		/*
		 * SELECT ad.title, ad.content, c.category, u.username, ad.create_date AS
		 * "CREATE DATE" FROM tbl_advertisement ad JOIN tbl_category c ON ad.category_id
		 * = c.id JOIN tbl_user_advertisement ua ON ua.ad_id = ad.id JOIN tbl_user u ON
		 * u.id = ua.user_id WHERE u.id = ?
		 */

		String sql = "SELECT ad.title, ad.content, c.category, u.username, ad.create_date AS\r\n"
				+ "\"CREATE DATE\" FROM tbl_advertisement ad JOIN tbl_category c ON\r\n"
				+ "ad.category_id = c.id JOIN tbl_user_advertisement ua ON ua.ad_id = ad.id\r\n"
				+ "JOIN tbl_user u ON u.id = ua.user_id WHERE u.id = ?";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, userId);
		rs = stmt.executeQuery();

		return rs;
	}

	public int getCategoryIdFromName(String categoryName) {
		int categoryId = 0;
		ResultSet rs = null;
		Connection con = db.getConnection();

		String sql = "select id from tbl_category where category = ?";

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, categoryName);

			rs = ps.executeQuery();
			if (rs.next())
				categoryId = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categoryId;
	}

	public ResultSet getCategories() throws SQLException {
		ResultSet rs = null;
		Connection con = db.getConnection();

		String sql = "select * from tbl_category order by category";

		PreparedStatement stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();

		return rs;
	}

	public boolean addAdvertisement(int userId, String title, String description, int categoryId) {
		boolean success = false;
		Connection con = db.getConnection();
		String sql = null;
		PreparedStatement ps = null;
		int lastInsertedAdId = 0;

		try {
			sql = "INSERT INTO tbl_advertisement (title, content, category_id) VALUES (?, ?, ?)";
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, title);
			ps.setString(2, description);
			ps.setInt(3, categoryId);

			ps.executeUpdate();
			ps.close();

			PreparedStatement ps2 = con.prepareStatement("SELECT TBL_ADVERTISEMENT_ID_SEQ.CURRVAL FROM DUAL");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				lastInsertedAdId = rs.getInt(1);

				if (lastInsertedAdId > 0) {
					sql = "INSERT INTO tbl_user_advertisement (user_id, ad_id) VALUES (?, ?)";
					PreparedStatement ps3 = con.prepareStatement(sql);

					ps3.setInt(1, userId);
					ps3.setInt(2, lastInsertedAdId);

					ps3.executeUpdate();
					ps3.close();
					success = true;
				}

				return success;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;
	}
}
