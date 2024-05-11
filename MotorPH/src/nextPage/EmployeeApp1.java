package nextPage;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class EmployeeApp1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDispute;
	private JPanel panelAttendance;
	private JLayeredPane layeredPane;
	private JPanel panelSchedule;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeApp1 frame = new EmployeeApp1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * author @ Cyrone Alvarez
	 */
	public EmployeeApp1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1377, 813);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/MotorPH logo.png"));
		lblLogo.setIcon(img);
		lblLogo.setBounds(164, 22, 125, 110);
		contentPane.add(lblLogo);
		
		JLabel lblProfilePicture = new JLabel("");
		lblProfilePicture.setBackground(new Color(192, 192, 192));
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/profilepic.jpg"));
		lblProfilePicture.setIcon(img1);
		lblProfilePicture.setBounds(118, 188, 200, 182);
		contentPane.add(lblProfilePicture);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmployee.setBounds(164, 381, 98, 25);
		contentPane.add(lblEmployee);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(176, 468, 64, 25);
		contentPane.add(lblFullName);
		
		JLabel lblFullName1 = new JLabel("LastName, FirstName MiddleInitial");
		lblFullName1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFullName1.setBounds(51, 440, 328, 31);
		contentPane.add(lblFullName1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(176, 534, 64, 25);
		contentPane.add(lblAddress);
		
		JLabel lblAddress1 = new JLabel("HouseNo.,Street,Brgy.,City,Country,ZipCode");
		lblAddress1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress1.setBounds(20, 505, 408, 29);
		contentPane.add(lblAddress1);
		
		JLabel lblTenurity = new JLabel("Tenurity");
		lblTenurity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenurity.setBounds(176, 666, 64, 25);
		contentPane.add(lblTenurity);
		
		JLabel lblTenurity1 = new JLabel("NumberofMonths,Days,Years");
		lblTenurity1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenurity1.setBounds(89, 637, 272, 29);
		contentPane.add(lblTenurity1);
		
		JLabel lblNewLabel = new JLabel("Hired Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(176, 601, 64, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Month,Day,Year");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(136, 573, 155, 29);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 175, 408, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 702, 408, 2);
		contentPane.add(separator_1);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(475, 175, 865, 530);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelSchedule = new JPanel();
		layeredPane.add(panelSchedule, "name_25653561535000");
		panelSchedule.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Schedule");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(380, 10, 115, 30);
		panelSchedule.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Monday");
		lblNewLabel_5.setBounds(134, 75, 46, 14);
		panelSchedule.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tuesday");
		lblNewLabel_5_1.setBounds(228, 75, 46, 14);
		panelSchedule.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Wednesday");
		lblNewLabel_5_2.setBounds(322, 75, 66, 14);
		panelSchedule.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Thursday");
		lblNewLabel_5_3.setBounds(436, 75, 46, 14);
		panelSchedule.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Friday");
		lblNewLabel_5_4.setBounds(544, 75, 46, 14);
		panelSchedule.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Saturday");
		lblNewLabel_5_5.setBounds(638, 75, 46, 14);
		panelSchedule.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_5_6 = new JLabel("Sunday");
		lblNewLabel_5_6.setBounds(745, 75, 46, 14);
		panelSchedule.add(lblNewLabel_5_6);
		
		JLabel lblNewLabel_6 = new JLabel("MM/DD/YYYY");
		lblNewLabel_6.setBounds(119, 63, 71, 14);
		panelSchedule.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("MM/DD/YYYY");
		lblNewLabel_6_1.setBounds(218, 63, 71, 14);
		panelSchedule.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("MM/DD/YYYY");
		lblNewLabel_6_2.setBounds(320, 63, 71, 14);
		panelSchedule.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("MM/DD/YYYY");
		lblNewLabel_6_3.setBounds(430, 63, 71, 14);
		panelSchedule.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("MM/DD/YYYY");
		lblNewLabel_6_4.setBounds(528, 63, 71, 14);
		panelSchedule.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("MM/DD/YYYY");
		lblNewLabel_6_5.setBounds(630, 63, 71, 14);
		panelSchedule.add(lblNewLabel_6_5);
		
		JLabel lblNewLabel_6_6 = new JLabel("MM/DD/YYYY");
		lblNewLabel_6_6.setBounds(732, 63, 71, 14);
		panelSchedule.add(lblNewLabel_6_6);
		
		JLabel lblNewLabel_7 = new JLabel("Time");
		lblNewLabel_7.setBounds(27, 107, 46, 14);
		panelSchedule.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Time");
		lblNewLabel_7_1.setBounds(27, 143, 46, 14);
		panelSchedule.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Time");
		lblNewLabel_7_1_1.setBounds(27, 181, 46, 14);
		panelSchedule.add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("Time");
		lblNewLabel_7_1_1_1.setBounds(27, 223, 46, 14);
		panelSchedule.add(lblNewLabel_7_1_1_1);
		
		JLabel lblNewLabel_7_1_1_2 = new JLabel("Time");
		lblNewLabel_7_1_1_2.setBounds(27, 266, 46, 14);
		panelSchedule.add(lblNewLabel_7_1_1_2);
		
		JLabel lblNewLabel_7_1_1_3 = new JLabel("Time");
		lblNewLabel_7_1_1_3.setBounds(27, 309, 46, 14);
		panelSchedule.add(lblNewLabel_7_1_1_3);
		
		JLabel lblNewLabel_7_1_1_4 = new JLabel("Time");
		lblNewLabel_7_1_1_4.setBounds(27, 356, 46, 14);
		panelSchedule.add(lblNewLabel_7_1_1_4);
		
		JLabel lblNewLabel_7_1_1_5 = new JLabel("Time");
		lblNewLabel_7_1_1_5.setBounds(27, 400, 46, 14);
		panelSchedule.add(lblNewLabel_7_1_1_5);
		
		JLabel lblNewLabel_7_1_1_5_1 = new JLabel("Time");
		lblNewLabel_7_1_1_5_1.setBounds(27, 441, 46, 14);
		panelSchedule.add(lblNewLabel_7_1_1_5_1);
		
		JLabel lblNewLabel_7_1_1_5_2 = new JLabel("Time");
		lblNewLabel_7_1_1_5_2.setBounds(27, 481, 46, 14);
		panelSchedule.add(lblNewLabel_7_1_1_5_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(27, 129, 793, 2);
		panelSchedule.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(27, 168, 793, 2);
		panelSchedule.add(separator_2_1);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(27, 210, 793, 2);
		panelSchedule.add(separator_2_2);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setBounds(27, 253, 793, 2);
		panelSchedule.add(separator_2_3);
		
		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setBounds(27, 296, 793, 2);
		panelSchedule.add(separator_2_4);
		
		JSeparator separator_2_5 = new JSeparator();
		separator_2_5.setBounds(27, 343, 793, 2);
		panelSchedule.add(separator_2_5);
		
		JSeparator separator_2_6 = new JSeparator();
		separator_2_6.setBounds(27, 387, 793, 2);
		panelSchedule.add(separator_2_6);
		
		JSeparator separator_2_7 = new JSeparator();
		separator_2_7.setBounds(27, 425, 793, 2);
		panelSchedule.add(separator_2_7);
		
		JSeparator separator_2_8 = new JSeparator();
		separator_2_8.setBounds(27, 468, 793, 2);
		panelSchedule.add(separator_2_8);
		
		JSeparator separator_2_9 = new JSeparator();
		separator_2_9.setBounds(27, 100, 793, 2);
		panelSchedule.add(separator_2_9);
		
		panelAttendance = new JPanel();
		layeredPane.add(panelAttendance, "name_25660225309200");
		panelAttendance.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Attendance");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(380, 10, 134, 30);
		panelAttendance.add(lblNewLabel_3);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(27, 142, 374, 270);
		panelAttendance.add(calendar);
		
		JLabel lblNewLabel_8 = new JLabel("Clock in:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(466, 212, 58, 14);
		panelAttendance.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Clock out:");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_1.setBounds(456, 237, 71, 14);
		panelAttendance.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("Schedule:");
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_2.setBounds(456, 187, 73, 14);
		panelAttendance.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("8:00 AM to 5:00 PM");
		lblNewLabel_8_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_2_1.setBounds(557, 187, 134, 14);
		panelAttendance.add(lblNewLabel_8_2_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Discrepancy:");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_1_1.setBounds(437, 255, 90, 30);
		panelAttendance.add(lblNewLabel_8_1_1);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Total time:");
		lblNewLabel_8_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_1_1_1.setBounds(456, 287, 71, 14);
		panelAttendance.add(lblNewLabel_8_1_1_1);
		
		panelDispute = new JPanel();
		layeredPane.add(panelDispute, "name_25669960795600");
		panelDispute.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Dispute");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setBounds(380, 10, 115, 30);
		panelDispute.add(lblNewLabel_4);
		
		JCalendar calendar_1 = new JCalendar();
		calendar_1.setBounds(27, 142, 374, 270);
		panelDispute.add(calendar_1);
		
		JLabel lblNewLabel_9 = new JLabel("Type:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(456, 171, 73, 30);
		panelDispute.add(lblNewLabel_9);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Type of Dispute", "Payroll", "Attendance", "Leaves"}));
		comboBox.setBounds(527, 171, 154, 22);
		panelDispute.add(comboBox);
		
		JLabel lblNewLabel_9_1 = new JLabel("Reason:");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_1.setBounds(456, 214, 57, 30);
		panelDispute.add(lblNewLabel_9_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(530, 214, 310, 50);
		panelDispute.add(textPane);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Your dispute has been submitted!","Dispute", EXIT_ON_CLOSE);
				
			}
		});
		btnNewButton.setBounds(562, 283, 89, 23);
		panelDispute.add(btnNewButton);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelSchedule);
			}
		});
		btnSchedule.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSchedule.setBounds(475, 141, 89, 23);
		contentPane.add(btnSchedule);
		
		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAttendance);
			}
		});
		btnAttendance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAttendance.setBounds(574, 141, 107, 23);
		contentPane.add(btnAttendance);
		
		JButton btnDispute = new JButton("Dispute");
		btnDispute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelDispute);
			}
		});
		btnDispute.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDispute.setBounds(691, 141, 89, 23);
		contentPane.add(btnDispute);
	}

	private void lblProfilePicture(ImageIcon img1) {
		// TODO Auto-generated method stub
		
	}
}
