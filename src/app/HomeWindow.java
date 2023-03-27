package app;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import app.helper.HomeHelper;
import business.businessObjects.UserBO;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class HomeWindow {
	private JFrame homeFrame;
	private UserBO user;
	private JTable adsTable;

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWindow window = new HomeWindow();
					window.homeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homeFrame = new JFrame();
		homeFrame.setBounds(200, 100, 1227, 597);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.getContentPane().setLayout(null);
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(128, 128, 255));
		MenuPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		MenuPanel.setBounds(0, 0, 205, 560);
		homeFrame.getContentPane().add(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 25));
		lblNewLabel.setBounds(73, 151, 71, 32);
		MenuPanel.add(lblNewLabel);
		
		JLabel lblMyAds = new JLabel("My Ads");
		lblMyAds.setForeground(new Color(255, 255, 255));
		lblMyAds.setFont(new Font("Ubuntu", Font.PLAIN, 25));
		lblMyAds.setBounds(67, 241, 83, 32);
		MenuPanel.add(lblMyAds);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(8, 215, 202, 2);
		MenuPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(8, 126, 202, 2);
		MenuPanel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(8, 306, 202, 2);
		MenuPanel.add(separator_1_1);
		
		JLabel lblMyAds_1 = new JLabel("My Profile");
		lblMyAds_1.setForeground(new Color(255, 255, 255));
		lblMyAds_1.setFont(new Font("Ubuntu", Font.PLAIN, 25));
		lblMyAds_1.setBounds(49, 343, 120, 32);
		MenuPanel.add(lblMyAds_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(8, 407, 202, 2);
		MenuPanel.add(separator_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(8, 10, 189, 106);
		MenuPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome.");
		lblNewLabel_2.setBounds(54, 43, 80, 19);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		panel.add(lblNewLabel_2);
		
		// Ads Panel.
		JPanel AdsPanel = new JPanel();
		AdsPanel.setBackground(new Color(255, 255, 255));
		AdsPanel.setBounds(202, 0, 1011, 560);
		homeFrame.getContentPane().add(AdsPanel);
		AdsPanel.setLayout(null);
		
		// Ads Table.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 128, 950, 286);
		AdsPanel.add(scrollPane);
			
		adsTable = new JTable();
		adsTable.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		scrollPane.setViewportView(adsTable);
		adsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ad Title", "Description", "Category", "Created By"
			}
		));
		adsTable.setModel(HomeHelper.getInitTableData()); // Init data.
		adsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		adsTable.getColumnModel().getColumn(0).setMinWidth(100);
		adsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		adsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		adsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		JLabel lblNewLabel_1 = new JLabel("All Advertisements");
		lblNewLabel_1.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(23, 44, 268, 36);
		AdsPanel.add(lblNewLabel_1);				
	}
	
	public void setVisibility(boolean isVisible) {
		homeFrame.setVisible(isVisible);
	}
}
