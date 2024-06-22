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
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeApp1 extends JFrame {

	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDispute;
	private JPanel panelAttendance;
	private JLayeredPane layeredPane;
	private JPanel panelSchedule;
	private JTextField txtLname;
	private JTextField txtFname;
	private JTextField txtBday;
	private JTextField txtPos;
	private JTextField txtUname;
	private JTextField txtPword;
	private JTextField txtEmployeeNo;
	private JTable table;

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
	
		
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:/motorph","root","");
			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(EmployeeApp1.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeApp1.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
	 
	
	 }	
	
	public void switchPanels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}	
	

	/**
	 * author @ Cyrone Alvarez (ALTER TABLE users_tbl AUTO_INCREMENT = 1)
	 */
	public EmployeeApp1() {
		Connect();

		
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
		lblNewLabel_5_1.setBounds(228, 75, 61, 14);
		panelSchedule.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Wednesday");
		lblNewLabel_5_2.setBounds(322, 75, 82, 14);
		panelSchedule.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Thursday");
		lblNewLabel_5_3.setBounds(436, 75, 59, 14);
		panelSchedule.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Friday");
		lblNewLabel_5_4.setBounds(544, 75, 46, 14);
		panelSchedule.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Saturday");
		lblNewLabel_5_5.setBounds(638, 75, 63, 14);
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
		
		JPanel panelRegistration = new JPanel();
		layeredPane.add(panelRegistration, "name_2104085139400");
		panelRegistration.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Registration");
		lblNewLabel_4_1.setBounds(373, 11, 149, 30);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panelRegistration.add(lblNewLabel_4_1);
		
		JLabel lblEmployeeNoRgst = new JLabel("Search Employee ID:");
		lblEmployeeNoRgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeNoRgst.setBounds(57, 407, 206, 17);
		panelRegistration.add(lblEmployeeNoRgst);
		
		JLabel lblLastNameRgst = new JLabel("Last Name:");
		lblLastNameRgst.setBounds(310, 443, 72, 14);
		panelRegistration.add(lblLastNameRgst);
		
		JLabel lblFirstNameRgst = new JLabel("First Name:");
		lblFirstNameRgst.setBounds(42, 443, 72, 14);
		panelRegistration.add(lblFirstNameRgst);
		
		JLabel lblPositionRgst = new JLabel("Position:");
		lblPositionRgst.setBounds(321, 476, 62, 14);
		panelRegistration.add(lblPositionRgst);
		
		JLabel lblBirthdayRgst = new JLabel("Birthday:");
		lblBirthdayRgst.setBounds(50, 476, 66, 14);
		panelRegistration.add(lblBirthdayRgst);
		
		txtLname = new JTextField();
		txtLname.setColumns(10);
		txtLname.setBounds(380, 440, 182, 20);
		panelRegistration.add(txtLname);
		
		txtFname = new JTextField();
		txtFname.setColumns(10);
		txtFname.setBounds(110, 440, 182, 20);
		panelRegistration.add(txtFname);
		
		txtBday = new JTextField();
		txtBday.setColumns(10);
		txtBday.setBounds(110, 473, 182, 20);
		panelRegistration.add(txtBday);
		
		txtPos = new JTextField();
		txtPos.setColumns(10);
		txtPos.setBounds(380, 473, 182, 20);
		panelRegistration.add(txtPos);
		
		JButton btnAddRgst = new JButton("Add");
		btnAddRgst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lname,fname,bday,pos,uname,pword;
				
				lname = txtLname.getText();
				fname = txtFname.getText();
				bday = txtBday.getText();
				pos = txtPos.getText();
				uname = txtUname.getText();
				pword = txtPword.getText();
				
				try {	
														
					pst = con.prepareStatement("INSERT INTO users_tbl (lname,fname,bday,pos,uname,pword)VALUES(?,?,?,?,?,?)");
					pst.setString(1, lname);
					pst.setString(2, fname);
					pst.setString(3, bday);
					pst.setString(4, pos);
					pst.setString(5, uname);
					pst.setString(6, pword);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "A new user has been added successfully!");
					txtLname.setText("");
					txtFname.setText("");
					txtBday.setText("");
					txtPos.setText("");
					txtUname.setText("");
					txtPword.setText("");
					txtLname.requestFocus();
								
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
		     	}
			}
		});
		btnAddRgst.setBounds(651, 420, 89, 23);
		panelRegistration.add(btnAddRgst);
		
		JButton btnUpdateRgst = new JButton("Update");
		btnUpdateRgst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
                String lname,fname,bday,pos,uname,pword,employeeid;
				
				lname = txtLname.getText();
				fname = txtFname.getText();
				bday = txtBday.getText();
				pos = txtPos.getText();
				uname = txtUname.getText();
				pword = txtPword.getText();
				employeeid = txtEmployeeNo.getText();
				
				try {	
														
					pst = con.prepareStatement("update users_tbl set lname=?,fname=?,bday=?,pos=?,uname=?,pword=? where employeeid=?");
					pst.setString(1, lname);
					pst.setString(2, fname);
					pst.setString(3, bday);
					pst.setString(4, pos);
					pst.setString(5, uname);
					pst.setString(6, pword);
					pst.setString(7, employeeid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Information has been updated!");
					txtLname.setText("");
					txtFname.setText("");
					txtBday.setText("");
					txtPos.setText("");
					txtUname.setText("");
					txtPword.setText("");
					txtLname.requestFocus();
								
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
		     	}
				
			}

		});
		btnUpdateRgst.setBounds(651, 453, 89, 23);
		panelRegistration.add(btnUpdateRgst);
		
		JButton btnDeleteRgst = new JButton("Delete");
		btnDeleteRgst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String employeeid;
				employeeid = txtEmployeeNo.getText();
				
				try {	
														
					pst = con.prepareStatement("delete from users_tbl where employeeid=?");
					
					pst.setString(1, employeeid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Information has been deleted!");
					txtLname.setText("");
					txtFname.setText("");
					txtBday.setText("");
					txtPos.setText("");
					txtUname.setText("");
					txtPword.setText("");
					txtLname.requestFocus();
								
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
		     	}
			}
		});
		btnDeleteRgst.setBounds(651, 486, 89, 23);
		panelRegistration.add(btnDeleteRgst);
		
		JLabel lblUsernameRgst = new JLabel("Username:");
		lblUsernameRgst.setBounds(44, 509, 79, 14);
		panelRegistration.add(lblUsernameRgst);
		
		txtUname = new JTextField();
		txtUname.setColumns(10);
		txtUname.setBounds(110, 506, 182, 20);
		panelRegistration.add(txtUname);
		
		txtPword = new JTextField();
		txtPword.setColumns(10);
		txtPword.setBounds(380, 506, 182, 20);
		panelRegistration.add(txtPword);
		
		JLabel lblPasswordRgst = new JLabel("Password:");
		lblPasswordRgst.setBounds(315, 509, 79, 14);
		panelRegistration.add(lblPasswordRgst);
		
		JButton btnSearchRgst = new JButton("Search");
		btnSearchRgst.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {	
				
				String id = txtEmployeeNo.getText();	
							
				try {
					pst = con.prepareStatement("SELECT lname,fname,bday,pos,uname,pword from users_tbl where employeeid=?");
					pst.setString(1, id);
					
					ResultSet rs1 = pst.executeQuery();
					
					if(rs1.next()==false)
					{
						JOptionPane.showMessageDialog(null, "User not found!");
						txtLname.setText("");
						txtFname.setText("");
						txtBday.setText("");
						txtPos.setText("");
						txtUname.setText("");
						txtPword.setText("");
						txtEmployeeNo.requestFocus();
					
					}
					else
					{
					String lname = rs1.getString(1);
					String fname = rs1.getString(2);
					String bday = rs1.getString(3);
					String pos = rs1.getString(4);
					String uname = rs1.getString(5);
					String pword = rs1.getString(6);	
					
					txtLname.setText(lname);
					txtFname.setText(fname);
					txtBday.setText(bday);
					txtPos.setText(pos);
					txtUname.setText(uname);
					txtPword.setText(pword);
					
				     } 
			     	} catch (SQLException e) {
					e.printStackTrace();
				    }
				
				}
									                   					                        					                        		                     				                        
		});
		btnSearchRgst.setBounds(476, 406, 89, 23);
		panelRegistration.add(btnSearchRgst);
		
		txtEmployeeNo = new JTextField();
		txtEmployeeNo.setColumns(10);
		txtEmployeeNo.setBounds(258, 407, 182, 20);
		panelRegistration.add(txtEmployeeNo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 845, 320);
		panelRegistration.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRefreshRgst = new JButton("Refresh");
		btnRefreshRgst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:/motorph","root","");
					
					Statement stmt=con.createStatement();
					
					ResultSet rs=stmt.executeQuery("select * from users_tbl");
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				
				}
				
				    catch (Exception ex) 
				    {
				    	
				    	JOptionPane.showMessageDialog(rootPane, ex.getMessage());
				    }
										
			}
			
		});
		btnRefreshRgst.setBounds(766, 370, 89, 23);
		panelRegistration.add(btnRefreshRgst);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelSchedule);
			}
		});
		btnSchedule.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSchedule.setBounds(592, 141, 89, 23);
		contentPane.add(btnSchedule);
		
		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAttendance);
			}
		});
		btnAttendance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAttendance.setBounds(690, 141, 107, 23);
		contentPane.add(btnAttendance);
		
		JButton btnDispute = new JButton("Dispute");
		btnDispute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelDispute);
			}
		});
		btnDispute.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDispute.setBounds(807, 141, 89, 23);
		contentPane.add(btnDispute);
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelRegistration);
			}
		});
		btnRegistration.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistration.setBounds(475, 141, 107, 23);
		contentPane.add(btnRegistration);
	}

	private void lblProfilePicture(ImageIcon img1) {
		// TODO Auto-generated method stub
		
	}
}
