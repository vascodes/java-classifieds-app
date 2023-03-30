package app;

import java.awt.*;
import javax.swing.*;

import app.helper.RegisterHelper;

import java.awt.event.*;

public class RegisterWindow {

	private JFrame registrationFrame;
	private JTextField txtFullName;
	private JTextField txtUsername;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow window = new RegisterWindow();
					window.registrationFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		registrationFrame = new JFrame();
		registrationFrame.setResizable(false);
		registrationFrame.setTitle("REGISTRATION");
		registrationFrame.setBounds(400, 100, 800, 658);
		registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registrationFrame.getContentPane().setLayout(null);		

		RegisterHelper rh = new RegisterHelper();
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(299, 29, 231, 44);
		registrationFrame.getContentPane().add(headerPanel);
		headerPanel.setLayout(null);

		// Heading.
		JLabel lblRegistrationHeading = new JLabel("REGISTRATION");
		lblRegistrationHeading.setBounds(0, 0, 231, 44);
		headerPanel.add(lblRegistrationHeading);
		lblRegistrationHeading.setFont(new Font("Ubuntu", Font.BOLD, 30));

		// Full Name.
		JPanel fullNamePanel = new JPanel();
		fullNamePanel.setBounds(33, 103, 306, 80);
		registrationFrame.getContentPane().add(fullNamePanel);
		fullNamePanel.setLayout(null);

		JLabel lblName = new JLabel("Full Name");
		lblName.setBounds(0, 0, 102, 44);
		fullNamePanel.add(lblName);
		lblName.setFont(new Font("Ubuntu", Font.PLAIN, 18));

		txtFullName = new JTextField();
		txtFullName.setToolTipText("example: John Doe");
		txtFullName.setBounds(0, 42, 307, 38);
		fullNamePanel.add(txtFullName);
		txtFullName.setHorizontalAlignment(SwingConstants.LEFT);
		txtFullName.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		txtFullName.setColumns(10);

		// Phone number.
		JPanel PhonePanel = new JPanel();
		PhonePanel.setBounds(406, 101, 340, 82);
		registrationFrame.getContentPane().add(PhonePanel);
		PhonePanel.setLayout(null);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(0, 0, 69, 44);
		PhonePanel.add(lblPhone);
		lblPhone.setFont(new Font("Ubuntu", Font.PLAIN, 18));

		txtPhone = new JTextField();
		txtPhone.setToolTipText("example: 9876543210");
		txtPhone.setBounds(0, 48, 340, 34);
		PhonePanel.add(txtPhone);
		txtPhone.setHorizontalAlignment(SwingConstants.LEFT);
		txtPhone.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txtPhone.setColumns(10);

		// Email.
		JPanel emailPanel = new JPanel();
		emailPanel.setBounds(33, 216, 306, 86);
		registrationFrame.getContentPane().add(emailPanel);
		emailPanel.setLayout(null);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(0, 0, 69, 44);
		emailPanel.add(lblEmail);
		lblEmail.setFont(new Font("Ubuntu", Font.PLAIN, 18));

		txtEmail = new JTextField();
		txtEmail.setToolTipText("example: johndoe@example.com");
		txtEmail.setBounds(0, 48, 306, 38);
		emailPanel.add(txtEmail);
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txtEmail.setColumns(10);

		// Address.
		JPanel addressPanel = new JPanel();
		addressPanel.setBounds(406, 218, 340, 84);
		registrationFrame.getContentPane().add(addressPanel);
		addressPanel.setLayout(null);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(2, 0, 102, 44);
		addressPanel.add(lblAddress);
		lblAddress.setFont(new Font("Ubuntu", Font.PLAIN, 18));

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txtAddress.setBounds(0, 46, 340, 38);
		addressPanel.add(txtAddress);
		txtAddress.setColumns(10);

		// Username.
		JPanel UsernamePanel = new JPanel();
		UsernamePanel.setBounds(33, 339, 306, 84);
		registrationFrame.getContentPane().add(UsernamePanel);
		UsernamePanel.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(0, 0, 102, 44);
		UsernamePanel.add(lblUsername);
		lblUsername.setFont(new Font("Ubuntu", Font.PLAIN, 18));

		txtUsername = new JTextField();
		txtUsername.setToolTipText("example: JohnDoe");
		txtUsername.setBounds(0, 46, 324, 38);
		UsernamePanel.add(txtUsername);
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txtUsername.setColumns(10);

		// Password.
		JPanel PasswordPanel = new JPanel();
		PasswordPanel.setLayout(null);
		PasswordPanel.setBounds(404, 339, 342, 84);
		registrationFrame.getContentPane().add(PasswordPanel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblPassword.setBounds(0, 0, 102, 44);
		PasswordPanel.add(lblPassword);

		txtPassword = new JTextField();
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtPassword.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(0, 46, 342, 38);
		PasswordPanel.add(txtPassword);

		// Register Button.
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName = txtFullName.getText().trim();
				String phone = txtPhone.getText().trim();
				String email = txtEmail.getText().trim();
				String address = txtAddress.getText().trim();
				String username = txtUsername.getText().trim();
				String password = txtPassword.getText().trim();

				rh.handleRegisterButtonClick(fullName, phone, email, address, username, password);

				// Reset all input text fields.
				txtFullName.setText("");
				txtPhone.setText("");
				txtEmail.setText("");
				txtAddress.setText("");
				txtUsername.setText("");
				txtPassword.setText("");
			}
		});
		btnRegister.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnRegister.setBounds(299, 480, 188, 44);
		registrationFrame.getContentPane().add(btnRegister);

		// Login Label.
		JLabel lblLogin = new JLabel("Already have an account? Login");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rh.handleLoginButtonClick();

				registrationFrame.dispose();
			}
		});
		lblLogin.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		lblLogin.setBounds(277, 552, 231, 19);
		registrationFrame.getContentPane().add(lblLogin);
	}

	public void setVisibility(boolean isVisible) {
		registrationFrame.setVisible(isVisible);
	}
}
