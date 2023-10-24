import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;


public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setBackground(new Color(1, 163, 209));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 342);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(29, 48, 594, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\icons8-user-24.png"));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("STFangsong", Font.BOLD, 20));
		lblNewLabel_1.setBounds(240, 113, 24, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\icons8-password-key-24.png"));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("STFangsong", Font.BOLD, 20));
		lblNewLabel_2.setBounds(240, 163, 24, 27);
		contentPane.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setForeground(new Color(0, 0, 0));
		username.setBackground(new Color(255, 255, 255));
		username.setBounds(274, 113, 312, 27);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setForeground(new Color(0, 0, 0));
		password.setBackground(new Color(255, 255, 255));
		password.setBounds(274, 163, 312, 27);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/library?useSSL=false";
				String mysqluser="root";
				String mysqlpwd="01122003";
				String pswrd=new String(password.getPassword());
				String uname=username.getText();
				String query=("select PASSWORD from ADMIN where USER_ID='"+uname+"';");
				
				try {
					Connection conn=DriverManager.getConnection(url,mysqluser,mysqlpwd);
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(query);
					if(rs.next()) {
						String realpswrd=rs.getString("PASSWORD");
						if(realpswrd.equals(pswrd)) {
							Dashboard dsh=new Dashboard();
							dsh.setVisible(true);
						
							
						}
						else
							JOptionPane.showMessageDialog(btnNewButton,"username or password entered is incorrect");
					}
					else
						JOptionPane.showMessageDialog(btnNewButton,"Wrong Username");
					
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(btnNewButton, e1.getMessage());
				}
				username.setText(null);
				password.setText(null);
				
			}

			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(240, 213, 346, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\Icondesigner.net-Hyperion-Sidebar-Library.128.png"));
		lblNewLabel_3.setBounds(29, 86, 152, 162);
		contentPane.add(lblNewLabel_3);
	}

}
