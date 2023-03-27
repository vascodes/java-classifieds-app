package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdvertisementDAL {
	DB db = null;

	public AdvertisementDAL() {
		db = new DB();
	}

	public ResultSet getAllAds() {
		ResultSet rs = null;
		Connection con = db.getConnection();

		try {
			/*
			 * SELECT ad.title, ad.content, ac.category, l.username FROM tbl_advertisement
			 * ad JOIN tbl_advertisement_category ac ON ad.ad_category_id = ac.id JOIN
			 * tbl_user_advertisement ua ON ua.ad_id = ad.id JOIN tbl_login l ON l.user_id =
			 * ua.user_id;
			 */
			
			String sql = "SELECT\r\n"
					+ "    ad.title,\r\n"
					+ "    ad.content,\r\n"
					+ "    ac.category,\r\n"
					+ "    l.username\r\n"
					+ "FROM\r\n"
					+ "    tbl_advertisement ad\r\n"
					+ "    JOIN tbl_advertisement_category ac ON ad.ad_category_id = ac.id\r\n"
					+ "    JOIN tbl_user_advertisement     ua ON ua.ad_id = ad.id\r\n"
					+ "    JOIN tbl_login                  l ON l.user_id = ua.user_id";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
}
