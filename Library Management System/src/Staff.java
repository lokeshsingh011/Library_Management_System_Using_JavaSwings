import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Staff extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff frame = new Staff();
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
	public Staff() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 788, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		table.setSelectionForeground(new Color(0, 128, 192));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setForeground(new Color(255, 255, 255));
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(new Color(0, 128, 192));
		table.setRowMargin(0);
		table.setRowHeight(25);
		table.setIntercellSpacing(new Dimension(0, 0));
		scrollPane.setViewportView(table);
		table.getTableHeader().setFont(new Font ("Segoe UI", Font.BOLD, 25));
		table.getTableHeader().setOpaque(false);
	    table.getTableHeader().setBackground(new Color (32, 136, 203));
		table.getTableHeader().setForeground(new Color (255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STAFF ID", "NAME", "CONTACT"
			}
		));
		
		JButton btnNewButton = new JButton("FETCH");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				
				String url="jdbc:mysql://localhost/library";
				String user="root";
				String pwd="01122003";
				String query="select*from staff;";
				
				try{
					Connection conn=DriverManager.getConnection(url,user,pwd);
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(query);
					while(rs.next()) {
						String sid=rs.getString("STAFF_ID");
						String name=rs.getString("NAME");
						String contact=rs.getString("CONTACT");
						
						model.addRow(new Object[] {sid,name,contact});
					}
					rs.close();
					stm.close();
				
					
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(btnNewButton, e1.getMessage());
					
				}
			}
		});
		btnNewButton.setBounds(22, 515, 366, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 128, 192));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_1.setBounds(420, 515, 366, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("STAFF DETAILS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("STFangsong", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(93, 11, 618, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\icons8-staff-48.png"));
		lblNewLabel_1.setBounds(224, 11, 69, 55);
		contentPane.add(lblNewLabel_1);
	}

}
