import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class RemoveBooks extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveBooks frame = new RemoveBooks();
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
	public RemoveBooks() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 569, 205);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER BOOK ID OR BOOK NAME TO REMOVE ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("STFangsong", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 533, 45);
		contentPane.add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t1.setBounds(112, 61, 414, 45);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("REMOVE");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/library";
				String user="root";
				String pwd="01122003";
				String input=t1.getText();
				String query="delete from books where book_id='"+input+"' or name='"+input+"';";
				
				try {
					Connection c=DriverManager.getConnection(url,user,pwd);
					Statement stm=c.createStatement();
					int r=stm.executeUpdate(query);
					if(r>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Book Successfully removed from Library");
					}
					else
						JOptionPane.showMessageDialog(btnNewButton,"No such Book found in the Library");
					
					stm.close();
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(btnNewButton, e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(112, 126, 199, 29);
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(327, 126, 199, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\icons8-remove-book-48.png"));
		lblNewLabel_1.setBounds(10, 61, 71, 70);
		contentPane.add(lblNewLabel_1);
	}
}
