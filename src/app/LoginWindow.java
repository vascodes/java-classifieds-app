package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import app.helper.LoginHelper;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class LoginWindow {

	private JFrame loginFrame;
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
					window.loginFrame.setVisible(true);
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
	 * Initialize the contents of the loginFrame.
	 */
	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setTitle("LOGIN");
		loginFrame.setBounds(500, 200, 500, 500);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		
		LoginHelper lh = new LoginHelper(loginFrame);
				
		// Title.
		JLabel lblLoginTitle = new JLabel("Swing Classifieds");
		lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginTitle.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.BOLD, 34));
		lblLoginTitle.setBounds(90, 34, 305, 62);
		loginFrame.getContentPane().add(lblLoginTitle);
		
		JPanel UsernamePanel = new JPanel();
		UsernamePanel.setBounds(90, 120, 305, 81);
		loginFrame.getContentPane().add(UsernamePanel);
		UsernamePanel.setLayout(null);
		
		// Username.
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(0, 0, 107, 25);
		UsernamePanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 20));
		
		txtUsername = new JTextField();
		txtUsername.setBounds(0, 33, 305, 48);
		UsernamePanel.add(txtUsername);
		txtUsername.setToolTipText("example: johndoe");
		txtUsername.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBounds(90, 227, 305, 82);
		loginFrame.getContentPane().add(passwordPanel);
		passwordPanel.setLayout(null);
		
		// Password.
		txtPassword = new JTextField();
		txtPassword.setBounds(0, 34, 305, 48);
		passwordPanel.add(txtPassword);
		txtPassword.setToolTipText("your password.");
		txtPassword.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(0, 0, 107, 25);
		passwordPanel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 20));
		
		// LOGIN BUTTON.
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				lh.handleLoginButtonClick(txtUsername, txtPassword);
			}
		});
		btnLogin.setFont(new Font("HelveticaNeueLT Pro 55 Roman", Font.PLAIN, 20));
		btnLogin.setBounds(90, 339, 305, 48);
		loginFrame.getContentPane().add(btnLogin);
		
		JLabel lblRegister = new JLabel("Don't have an account? Register here.");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lh.handleRegisterButtonClick(loginFrame);
			}
		});
		lblRegister.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		lblRegister.setBounds(120, 412, 245, 25);
		loginFrame.getContentPane().add(lblRegister);
	}
	
	public void setVisibility(boolean isVisible) {
		loginFrame.setVisible(isVisible);
	}
}
