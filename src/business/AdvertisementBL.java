package business;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.TableModel;

import data.AdvertisementDAL;
import net.proteanit.sql.DbUtils;

public class AdvertisementBL {
	
	public TableModel getAllAds() {
		ResultSet rs = null;
		TableModel tm = null;

		AdvertisementDAL adDAL = new AdvertisementDAL();
		rs = adDAL.getAllAds();
		try {
			if(rs.next())
				tm = DbUtils.resultSetToTableModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tm;
	}
}
