package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import business.LoginBL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("example: johndoe");
		txtUsername.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 15));
		txtUsername.setBounds(90, 155, 305, 48);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Swing Classifieds");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.BOLD, 34));
		lblNewLabel.setBounds(90, 48, 305, 62);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(90, 127, 107, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("your password.");
		txtPassword.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(90, 262, 305, 48);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(90, 233, 107, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userNameText = txtUsername.getText();
				String passwordText = txtPassword.getText();
				
				LoginBL loginBL = new LoginBL(userNameText, passwordText);
//				boolean isAuth = loginBL.authenticate();
			}
		});
		btnNewButton.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(90, 340, 305, 48);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void setVisibility(boolean isVisible) {
		frame.setVisible(isVisible);
	}
}
