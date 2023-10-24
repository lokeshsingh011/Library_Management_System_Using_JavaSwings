import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class AddStaff extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaff frame = new AddStaff();
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
	public AddStaff() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STAFF ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(42, 112, 128, 33);
		contentPane.add(lblNewLabel);
		
		JTextField t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t1.setBounds(180, 113, 246, 33);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(42, 172, 128, 33);
		contentPane.add(lblNewLabel_1);
		
		JTextField t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t2.setBounds(180, 173, 246, 33);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CONTACT");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(42, 230, 128, 33);
		contentPane.add(lblNewLabel_2);
		
		JTextField t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t3.setBounds(180, 231, 246, 32);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/library";
				String user="root";
				String pwd="01122003";
				
				String id=t1.getText();
				String name=t2.getText();
				
				String contact=t3.getText();

				String query="insert into STAFF values(?,?,?)";
				try
				{
					Connection conn=DriverManager.getConnection(url,user,pwd);
					
						PreparedStatement stmt = conn.prepareCall(query);
						stmt.setString(1, id);
						stmt.setString(2, name);
						stmt.setString(3, contact);
						stmt.execute();
						JOptionPane.showMessageDialog(btnNewButton, "Added Successfully!");
						
					
					
					
						
					
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(btnNewButton, e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(42, 296, 176, 33);
		contentPane.add(btnNewButton);
		
		JButton cancel = new JButton("CANCEL");
		cancel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cancel.setBackground(new Color(0, 128, 192));
		cancel.setForeground(new Color(255, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(cancel).dispose();
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancel.setBounds(246, 296, 176, 33);
		contentPane.add(cancel);
		
		JLabel lblNewLabel_3 = new JLabel("ENTER STAFF DETAILS");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\icons8-management-48.png"));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("STFangsong", Font.BOLD, 30));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 11, 454, 56);
		contentPane.add(lblNewLabel_3);
	}
}
