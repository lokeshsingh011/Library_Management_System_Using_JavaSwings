import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class AddBooks extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks frame = new AddBooks();
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
	public AddBooks() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 695, 566);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOK ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 112, 167, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CATEGORY");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(33, 168, 167, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(33, 230, 167, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AUTHOR");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(33, 291, 167, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("COPIES");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(33, 352, 167, 43);
		contentPane.add(lblNewLabel_4);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1.setBounds(210, 112, 426, 43);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2.setBounds(210, 168, 426, 43);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3.setBounds(210, 230, 426, 43);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4.setBounds(210, 291, 426, 43);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5.setBounds(210, 352, 426, 43);
		contentPane.add(t5);
		t5.setColumns(10);
		
		JButton add = new JButton("ADD");
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(0, 128, 192));
		add.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost/library";
				String mysqluser="root";
				String mysqlpwd="01122003";
				String query="insert into books values(?,?,?,?,?);";
				String id=t1.getText();
				String category=t2.getText();
				String name=t3.getText();
				String author=t4.getText();
				int copies=Integer.parseInt(t5.getText());
				String checkquery="update books set copies=copies+"+copies+" where name='"+name+"' and category='"+category+"' and author='"+author+"';";
				
				try {
					Connection conn=DriverManager.getConnection(url,mysqluser,mysqlpwd);
					Statement stm=conn.createStatement();
					int rows=stm.executeUpdate(checkquery);
					
					if (rows>0) {
						JOptionPane.showMessageDialog(add, "One Record Added Successfully");
					}
					else
					{
						PreparedStatement stmt=conn.prepareCall(query);
						
						stmt.setString(1, id);
						stmt.setString(2, category);
						stmt.setString(3, name);
						stmt.setString(4, author);
						stmt.setInt(5, copies);
						stmt.execute();
						
						JOptionPane.showMessageDialog(add, "One Record Added Successfully");
						
					}
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(add, e1.getMessage());
				}
				
				
			}
		});
		add.setFont(new Font("Tahoma", Font.BOLD, 19));
		add.setBounds(33, 440, 285, 46);
		contentPane.add(add);
		
		JButton cancel = new JButton("CANCEL");
		cancel.setForeground(new Color(255, 255, 255));
		cancel.setBackground(new Color(0, 128, 192));
		cancel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(cancel).dispose();
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 19));
		cancel.setBounds(351, 440, 285, 46);
		contentPane.add(cancel);
		
		JLabel lblNewLabel_5 = new JLabel("   ENTER BOOKS DETAILS");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("STFangsong", Font.BOLD, 29));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(137, 29, 499, 72);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\icons8-book-100.png"));
		lblNewLabel_6.setBounds(69, 11, 110, 112);
		contentPane.add(lblNewLabel_6);
	}
}
