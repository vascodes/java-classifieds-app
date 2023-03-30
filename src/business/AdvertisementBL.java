package business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

import business.businessObjects.CategoryBO;
import data.AdvertisementDAL;
import net.proteanit.sql.DbUtils;

public class AdvertisementBL {

	public TableModel getAllAds() throws SQLException {
		ResultSet rs = null;
		TableModel tm = null;

		AdvertisementDAL adDAL = new AdvertisementDAL();
		rs = adDAL.getAllAds();

		if (rs.next()) {
			tm = DbUtils.resultSetToTableModel(rs);
		}

		return tm;
	}

	public TableModel getAdsByUserId(int userId) throws SQLException {
		ResultSet rs = null;
		TableModel tm = null;

		AdvertisementDAL adDAL = new AdvertisementDAL();
		rs = adDAL.getAdsByUserId(userId);
		tm = DbUtils.resultSetToTableModel(rs);

		return tm;
	}

	public List<CategoryBO> getCategories() throws SQLException {
		List<CategoryBO> categories = new ArrayList<CategoryBO>();

		AdvertisementDAL adDAL = new AdvertisementDAL();
		ResultSet rs = adDAL.getCategories();

		while (rs.next()) {
			int categoryId = rs.getInt(1);
			String categoryName = rs.getString(2);

			CategoryBO category = new CategoryBO();
			category.setId(categoryId);
			category.setCategory(categoryName);

			categories.add(category);
		}

		return categories;
	}

	public boolean addAdvertisement(int userId, String adTitle, String description, String category) {
		AdvertisementDAL adDAL = new AdvertisementDAL();
		int categoryId = adDAL.getCategoryIdFromName(category.toLowerCase());
		boolean success = false;
		success = adDAL.addAdvertisement(userId, adTitle, description, categoryId);

		return success;
	}

}