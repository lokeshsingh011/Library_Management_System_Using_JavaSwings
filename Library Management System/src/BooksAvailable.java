import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
public class BooksAvailable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooksAvailable frame = new BooksAvailable();
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
	public BooksAvailable() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1143, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBackground(new Color(0, 128, 192));
		scrollPane.setBounds(10, 84, 1107, 593);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
				"BOOK ID", "CATEGORY", "NAME", "AUTHOR", "COPIES"
			}
		));
		
		JButton fetch = new JButton("FETCH");
		fetch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fetch.setBackground(new Color(0, 128, 192));
		fetch.setForeground(new Color(255, 255, 255));
		fetch.setFont(new Font("Tahoma", Font.BOLD, 14));
		fetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel)table.getModel();
				
				String url="jdbc:mysql://localhost/library";
				String user="root";
				String pwd="01122003";
				String query="select*from books;";
				
				try{
					Connection conn=DriverManager.getConnection(url,user,pwd);
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(query);
					while(rs.next()) {
						String bookid=rs.getString("BOOK_ID");
						String category=rs.getString("CATEGORY");
						String name=rs.getString("NAME");
						String author=rs.getString("AUTHOR");
						String copies=rs.getString("COPIES");
						
						model.addRow(new Object[] {bookid,category,name,author,copies});
						
					}
					rs.close();
					stm.close();
					
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(fetch, e1.getMessage());
				}
				
			}
		});
		fetch.setBounds(10, 690, 549, 40);
		contentPane.add(fetch);
		
		JButton back = new JButton("BACK");
		back.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		back.setBackground(new Color(0, 128, 192));
		back.setForeground(new Color(255, 255, 255));
		back.setFont(new Font("Tahoma", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.windowForComponent(back).dispose();
			}
		});
		back.setBounds(570, 690, 549, 40);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("BOOKS AVAILABLE IN THE LIBRARY");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\icons8-books-64.png"));
		lblNewLabel.setFont(new Font("STFangsong", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1107, 64);
		contentPane.add(lblNewLabel);
	}
}
