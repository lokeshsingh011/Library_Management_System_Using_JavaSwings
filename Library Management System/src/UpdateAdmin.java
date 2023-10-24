import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class UpdateAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAdmin frame = new UpdateAdmin();
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
	public UpdateAdmin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 252);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 128, 192));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"User_id", "Name", "Password", "Contact"}));
		comboBox.setBounds(154, 91, 114, 34);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("SELECT AND ENTER THE DETAILS ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("STFangsong", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 30, 489, 34);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(300, 91, 199, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/library";
				String user="root";
				String pwd="01122003";
				String column=comboBox.getSelectedItem().toString();
				String input=textField.getText();
				String query="update admin set "+column+" ='"+input+"';";
				
				try {
					Connection c=DriverManager.getConnection(url,user,pwd);
					Statement stm=c.createStatement();
					int r=stm.executeUpdate(query);
					if(r>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Credentials Updated Successfully!");
					}

				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(btnNewButton, e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(154, 145, 170, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBackground(new Color(0, 128, 192));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(334, 145, 165, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\icons8-admin-100.png"));
		lblNewLabel_1.setBounds(10, 75, 114, 111);
		contentPane.add(lblNewLabel_1);
	}
}
