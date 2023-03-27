package app.helper;

import javax.swing.JFrame;
import javax.swing.table.TableModel;

import business.AdvertisementBL;

public class HomeHelper {
	private JFrame homeWindow;
	
	public HomeHelper(JFrame homeWindow) {
		this.homeWindow = homeWindow;
	}
	
	public static TableModel getInitTableData() {
		AdvertisementBL adBL = new AdvertisementBL();
		TableModel tm = adBL.getAllAds();		
		
		return tm;
	}
}
