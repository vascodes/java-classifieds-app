package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.helper.HomeHelper;
import business.AdvertisementBL;
import business.businessObjects.CategoryBO;
import business.businessObjects.UserBO;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAdWindow {

	private JFrame frmCreateNewAdvertisement;
	private JTextField txtAdTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAdWindow window = new CreateAdWindow(null);
					window.frmCreateNewAdvertisement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateAdWindow(UserBO user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(UserBO user) {
		frmCreateNewAdvertisement = new JFrame();
		frmCreateNewAdvertisement.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		frmCreateNewAdvertisement.setTitle("Create New Advertisement");
		frmCreateNewAdvertisement.getContentPane().setFont(new Font("Ubuntu", Font.PLAIN, 12));
		frmCreateNewAdvertisement.getContentPane().setLayout(null);

		HomeHelper hh = new HomeHelper();

		JLabel lblCreateAdTitle = new JLabel("Create an Advertisement");
		lblCreateAdTitle.setFont(new Font("Ubuntu", Font.BOLD, 22));
		lblCreateAdTitle.setBounds(12, 13, 268, 26);
		frmCreateNewAdvertisement.getContentPane().add(lblCreateAdTitle);
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 54, 752, 2);
		frmCreateNewAdvertisement.getContentPane().add(separator);

		JPanel AdDetailsInputPanel = new JPanel();
		AdDetailsInputPanel.setBounds(10, 80, 740, 303);
		frmCreateNewAdvertisement.getContentPane().add(AdDetailsInputPanel);
		AdDetailsInputPanel.setLayout(null);

		JLabel lblAdTitle = new JLabel("Title");
		lblAdTitle.setBounds(0, 1, 37, 21);
		AdDetailsInputPanel.add(lblAdTitle);
		lblAdTitle.setFont(new Font("Ubuntu", Font.PLAIN, 18));

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(0, 112, 98, 21);
		AdDetailsInputPanel.add(lblDescription);
		lblDescription.setFont(new Font("Ubuntu", Font.PLAIN, 18));

		// CATEGORY.
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(0, 57, 74, 21);
		AdDetailsInputPanel.add(lblCategory);
		lblCategory.setFont(new Font("Ubuntu", Font.PLAIN, 18));

		txtAdTitle = new JTextField();
		txtAdTitle.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		txtAdTitle.setBounds(135, 3, 605, 28);
		AdDetailsInputPanel.add(txtAdTitle);
		txtAdTitle.setColumns(10);

		// Categories ComboBox.
		JComboBox<String> cbCategory = new JComboBox<String>();
		cbCategory.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		cbCategory.setBounds(135, 60, 605, 28);
		AdDetailsInputPanel.add(cbCategory);
		hh.setCategoryList(cbCategory);

		// DESCRIPTION
		JTextArea textAreaAdDescription = new JTextArea();
		textAreaAdDescription.setBounds(135, 119, 605, 183);
		AdDetailsInputPanel.add(textAreaAdDescription);
		
		// CREATE BUTTON.
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = user.getId();
				String adTitle = txtAdTitle.getText().trim();
				String category = (String) cbCategory.getSelectedItem();
				String description = textAreaAdDescription.getText().trim();
				
				hh.handleCreateButtonClick(userId, adTitle, description, category);
				frmCreateNewAdvertisement.dispose();
				new MyAdsWindow(user).setVisibility(true);
			}
		});
		btnNewButton.setBackground(new Color(124, 252, 0));
		btnNewButton.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		btnNewButton.setBounds(641, 403, 109, 25);
		frmCreateNewAdvertisement.getContentPane().add(btnNewButton);	
				
		frmCreateNewAdvertisement.setBounds(100, 100, 784, 488);
		frmCreateNewAdvertisement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean isVisible) {
		frmCreateNewAdvertisement.setVisible(isVisible);
	}
}
