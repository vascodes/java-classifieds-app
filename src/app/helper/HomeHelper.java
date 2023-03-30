package app.helper;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.TableModel;

import app.HomeWindow;
import business.AdvertisementBL;
import business.businessObjects.AdvertisementBO;
import business.businessObjects.CategoryBO;
import business.businessObjects.UserBO;

public class HomeHelper {
	public TableModel getAdsTableData() {
		AdvertisementBL adBL = new AdvertisementBL();
		TableModel tm = null;

		try {
			tm = adBL.getAllAds();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tm;
	}

	public TableModel getMyAdsTableData(int userId) {
		AdvertisementBL adBL = new AdvertisementBL();
		TableModel tm = null;

		try {
			tm = adBL.getAdsByUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tm;
	}

	public void handleMyAdsButtonClick() {

	}

	public void setCategoryList(JComboBox<String> cbCategory) {
		AdvertisementBL adBL = new AdvertisementBL();
		
		try {
			List<CategoryBO> categories = adBL.getCategories();
			
			if (!categories.isEmpty()) {
				// Add each category to cbCategory.
				for (CategoryBO category : categories) {
					String categoryName = category.getCategory().toUpperCase();
					cbCategory.addItem(categoryName);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void handleCreateButtonClick(int userId, String adTitle, String description, String category) {
		AdvertisementBL adBL = new AdvertisementBL();
		boolean success = adBL.addAdvertisement(userId, adTitle, description, category);
		if(!success) {
			Common.showAlert("Could not create Advertisement.");
		}
		else {
			Common.showAlert("Created Advertisement.");
		}
		
	}
}
