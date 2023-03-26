package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;

import app.helper.MainHelper;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("SWING CLASSIFIEDS");
		mainFrame.getContentPane().setFont(new Font("Ubuntu", Font.PLAIN, 16));
		mainFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("SWING CLASSIFIEDS");
		lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 40));
		lblNewLabel.setBounds(57, 51, 372, 68);
		mainFrame.getContentPane().add(lblNewLabel);

		// Register Button.
		JButton btnNewButton = new JButton("Create An Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainHelper.handleRegisterButtonClick(mainFrame);
			}
		});
		btnNewButton.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnNewButton.setBounds(131, 200, 225, 68);
		mainFrame.getContentPane().add(btnNewButton);

		// Login Button.
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainHelper.handleLoginButtonClick(mainFrame);
			}
		});
		btnLogin.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnLogin.setBounds(131, 301, 225, 68);
		mainFrame.getContentPane().add(btnLogin);
		mainFrame.setBounds(400, 150, 501, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
