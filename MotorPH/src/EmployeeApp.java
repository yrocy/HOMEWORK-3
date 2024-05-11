import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nextPage.EmployeeApp1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JButton btnLogin;
	private JPasswordField passwordPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeApp frame = new EmployeeApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * author @ Cyrone Alvarez
	 */
	public EmployeeApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(64, 176, 93, 33);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(64, 217, 95, 33);
		contentPane.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(231, 180, 175, 28);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblLogo = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/MotorPH logo.png"));
		lblLogo.setIcon(img);
		lblLogo.setBounds(154, 31, 125, 110);
		contentPane.add(lblLogo);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = passwordPassword.getText();
				String username = textUsername.getText();
				
				if (password.contains("123") && username.contains("employee")){
					passwordPassword.setText(null);
					textUsername.setText(null);	
					
					EmployeeApp1 info = new EmployeeApp1();
					//EmployeeApp1.main(null);
					info.main(null);
					
			
		}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Login Details!","Login Error",JOptionPane.ERROR_MESSAGE);
					passwordPassword.setText(null);
					textUsername.setText(null);	
				}
				
			}
			
			
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(158, 309, 133, 33);
		contentPane.add(btnLogin);
		
		passwordPassword = new JPasswordField();
		passwordPassword.setBounds(231, 221, 175, 28);
		contentPane.add(passwordPassword);
		
		JCheckBox chckbxRememberMe = new JCheckBox("Remember Me");
		chckbxRememberMe.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxRememberMe.setBackground(new Color(192, 192, 192));
		chckbxRememberMe.setBounds(64, 257, 125, 23);
		contentPane.add(chckbxRememberMe);
	}
}
