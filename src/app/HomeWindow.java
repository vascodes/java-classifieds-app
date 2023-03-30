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
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

public class HomeWindow {
	private JFrame homeWindow;
	private JTable adsTable;

	private UserBO user;

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
					HomeWindow window = new HomeWindow(null);
					window.homeWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeWindow(UserBO user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(UserBO currentUser) {
		setUser(currentUser);
		HomeHelper hh = new HomeHelper();

		homeWindow = new JFrame();
		homeWindow.setBounds(200, 100, 1280, 720);
		homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeWindow.getContentPane().setLayout(null);

		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(128, 128, 255));
		MenuPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		MenuPanel.setBounds(0, 0, 205, 663);
		homeWindow.getContentPane().add(MenuPanel);
		MenuPanel.setLayout(null);

		// Welcome Panel.
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBorder(null);
		panel.setBounds(8, 10, 189, 106);
		MenuPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblWelcome = new JLabel("Welcome, " + user.getUsername());
		panel.add(lblWelcome, BorderLayout.CENTER);
		lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Ubuntu", Font.PLAIN, 16));

		// Home Label.
		JLabel lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homeWindow.dispose();
				new HomeWindow(currentUser).setVisibility(true);
			}
		});
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		lblHome.setBounds(71, 142, 62, 32);
		MenuPanel.add(lblHome);

		// My Ads Label.
		JLabel lblMyAds = new JLabel("My Ads");
		lblMyAds.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homeWindow.dispose();				
				new MyAdsWindow(user).setVisibility(true);
			}
		});
		lblMyAds.setForeground(new Color(255, 255, 255));
		lblMyAds.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		lblMyAds.setBounds(69, 209, 66, 32);
		MenuPanel.add(lblMyAds);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 188, 202, 2);
		MenuPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-1, 126, 202, 2);
		MenuPanel.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(-1, 254, 202, 2);
		MenuPanel.add(separator_1_1);

		// Ads Panel.
		JPanel AdsPanel = new JPanel();
		AdsPanel.setBackground(new Color(255, 255, 255));
		AdsPanel.setBounds(213, 0, 1028, 663);
		homeWindow.getContentPane().add(AdsPanel);
		AdsPanel.setLayout(null);

		// Ads Panel title.
		JLabel lblNewLabel_1 = new JLabel("All Advertisements");
		lblNewLabel_1.setFont(new Font("Ubuntu", Font.BOLD, 25));
		lblNewLabel_1.setBounds(23, 15, 235, 36);
		AdsPanel.add(lblNewLabel_1);

		// Ads Table.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 67, 980, 223);
		AdsPanel.add(scrollPane);

		adsTable = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};

		adsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		adsTable.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		adsTable.setRowHeight(50);
		scrollPane.setViewportView(adsTable);

		// Set Table data.
		adsTable.setModel(hh.getAdsTableData());

		// Ads Panel.
		JPanel selectedAdsPanel = new JPanel();
		selectedAdsPanel.setBackground(new Color(255, 255, 255));
		selectedAdsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		selectedAdsPanel.setBounds(23, 314, 980, 283);
		AdsPanel.add(selectedAdsPanel);
		selectedAdsPanel.setLayout(null);

		JLabel lblSelectedAd = new JLabel("Selected Ad");
		lblSelectedAd.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		lblSelectedAd.setBounds(16, 10, 122, 24);
		selectedAdsPanel.add(lblSelectedAd);

		JLabel lblAdTitle = new JLabel("Ad Title");
		lblAdTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdTitle.setVerticalAlignment(SwingConstants.TOP);
		lblAdTitle.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblAdTitle.setBounds(16, 54, 437, 24);
		selectedAdsPanel.add(lblAdTitle);

		JTextPane txtpnAdDescription = new JTextPane();
		txtpnAdDescription.setBackground(new Color(255, 255, 255));
		txtpnAdDescription.setText("Ad description");
		txtpnAdDescription.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		txtpnAdDescription.setBounds(12, 88, 441, 187);
		selectedAdsPanel.add(txtpnAdDescription);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(1, 39, 979, 2);
		selectedAdsPanel.add(separator_2);
		selectedAdsPanel.setVisible(false);

		// AdsTable select row.
		adsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedAdsPanel.setVisible(true);

				int row = adsTable.getSelectedRow();
				String adTitle = adsTable.getModel().getValueAt(row, 0).toString();
				String adContent = adsTable.getModel().getValueAt(row, 1).toString();

				lblAdTitle.setText(adTitle);
				txtpnAdDescription.setText(adContent);
			}
		});
	}

	public void setVisibility(boolean isVisible) {
		homeWindow.setVisible(isVisible);
	}
}
