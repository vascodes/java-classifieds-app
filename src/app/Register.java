package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register {

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
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		registrationFrame = new JFrame();
		registrationFrame.setBounds(400, 100, 800, 700);
		registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registrationFrame.getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(299, 29, 231, 44);
		registrationFrame.getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblRegistrationHeading = new JLabel("REGISTRATION");
		lblRegistrationHeading.setBounds(0, 0, 231, 44);
		headerPanel.add(lblRegistrationHeading);
		lblRegistrationHeading.setFont(new Font("Ubuntu", Font.BOLD, 30));
		
		JPanel fullNamePanel = new JPanel();
		fullNamePanel.setBounds(33, 85, 710, 80);
		registrationFrame.getContentPane().add(fullNamePanel);
		fullNamePanel.setLayout(null);
		
		JLabel lblName = new JLabel("Full Name");
		lblName.setBounds(0, 0, 102, 44);
		fullNamePanel.add(lblName);
		lblName.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		
		txtFullName = new JTextField();
		txtFullName.setToolTipText("example: John Doe");
		txtFullName.setBounds(0, 42, 710, 38);
		fullNamePanel.add(txtFullName);
		txtFullName.setHorizontalAlignment(SwingConstants.LEFT);
		txtFullName.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		txtFullName.setColumns(10);
		
		JPanel PhonePanel = new JPanel();
		PhonePanel.setBounds(33, 186, 306, 86);
		registrationFrame.getContentPane().add(PhonePanel);
		PhonePanel.setLayout(null);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(0, 0, 69, 44);
		PhonePanel.add(lblPhone);
		lblPhone.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		
		txtPhone = new JTextField();
		txtPhone.setToolTipText("example: 9876543210");
		txtPhone.setBounds(0, 48, 306, 38);
		PhonePanel.add(txtPhone);
		txtPhone.setHorizontalAlignment(SwingConstants.LEFT);
		txtPhone.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txtPhone.setColumns(10);
		
		JPanel emailPanel = new JPanel();
		emailPanel.setBounds(406, 186, 342, 86);
		registrationFrame.getContentPane().add(emailPanel);
		emailPanel.setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(0, 0, 69, 44);
		emailPanel.add(lblEmail);
		lblEmail.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText(" example: johndoe@example.com");
		txtEmail.setBounds(0, 48, 342, 38);
		emailPanel.add(txtEmail);
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		
		JPanel addressPanel = new JPanel();
		addressPanel.setBounds(406, 305, 342, 84);
		registrationFrame.getContentPane().add(addressPanel);
		addressPanel.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(2, 0, 102, 44);
		addressPanel.add(lblAddress);
		lblAddress.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		
		txtAddress = new JTextField();
		txtAddress.setBounds(0, 46, 342, 38);
		addressPanel.add(txtAddress);
		txtAddress.setColumns(10);
		
		JPanel DOBPanel = new JPanel();
		DOBPanel.setBounds(33, 305, 306, 80);
		registrationFrame.getContentPane().add(DOBPanel);
		DOBPanel.setLayout(null);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setBounds(0, 0, 130, 44);
		DOBPanel.add(lblDateOfBirth);
		lblDateOfBirth.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		Date today = new Date();
		JSpinner spinnerDOB = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
		spinnerDOB.setBounds(0, 42, 302, 37);
		DOBPanel.add(spinnerDOB);
		spinnerDOB.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		JSpinner.DateEditor de_spinnerDOB = new JSpinner.DateEditor(spinnerDOB, "dd-MMM-yy");
		spinnerDOB.setEditor(de_spinnerDOB);
		
		JPanel UsernamePanel = new JPanel();
		UsernamePanel.setBounds(33, 419, 306, 84);
		registrationFrame.getContentPane().add(UsernamePanel);
		UsernamePanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(0, 0, 102, 44);
		UsernamePanel.add(lblUsername);
		lblUsername.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText(" example: JohnDoe");
		txtUsername.setBounds(0, 46, 324, 38);
		UsernamePanel.add(txtUsername);
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		
		JPanel PasswordPanel = new JPanel();
		PasswordPanel.setLayout(null);
		PasswordPanel.setBounds(406, 419, 342, 84);
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
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked Register.");
			}
		});
		btnRegister.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnRegister.setBounds(299, 549, 188, 44);
		registrationFrame.getContentPane().add(btnRegister);
		
		JLabel lblLogin = new JLabel("Already have an account? Login");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicked login.");
			}
		});
		lblLogin.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		lblLogin.setBounds(277, 613, 231, 19);
		registrationFrame.getContentPane().add(lblLogin);
	}
}
