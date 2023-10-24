import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 715, 414);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lkmah\\Downloads\\icons8-dashboard-94.png"));
		lblNewLabel.setBounds(55, 11, 604, 82);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton b = new JButton("BOOKS AVAILABLE");
		b.setFont(new Font("Tahoma", Font.BOLD, 15));
		b.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		b.setForeground(new Color(255, 255, 255));
		b.setBounds(50, 117, 282, 41);
		panel.add(b);
		b.setBackground(new Color(0, 128, 192));
		
		JButton ab = new JButton("ADD BOOKS");
		ab.setFont(new Font("Tahoma", Font.BOLD, 15));
		ab.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ab.setForeground(new Color(255, 255, 255));
		ab.setBounds(50, 180, 282, 41);
		panel.add(ab);
		ab.setBackground(new Color(0, 128, 192));
		
		JButton rb = new JButton("REMOVE BOOKS");
		rb.setFont(new Font("Tahoma", Font.BOLD, 15));
		rb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		rb.setForeground(new Color(255, 255, 255));
		rb.setBounds(50, 241, 282, 41);
		panel.add(rb);
		rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveBooks rmbks=new RemoveBooks();
				rmbks.setVisible(true);
			}
		});
		rb.setBackground(new Color(0, 128, 192));
		
		JButton s = new JButton("STAFF DETAILS");
		s.setFont(new Font("Tahoma", Font.BOLD, 15));
		s.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		s.setForeground(new Color(255, 255, 255));
		s.setBounds(372, 117, 282, 41);
		panel.add(s);
		s.setBackground(new Color(0, 128, 192));
		
		JButton as = new JButton("ADD STAFF");
		as.setFont(new Font("Tahoma", Font.BOLD, 15));
		as.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		as.setForeground(new Color(255, 255, 255));
		as.setBounds(372, 180, 282, 41);
		panel.add(as);
		as.setBackground(new Color(0, 128, 192));
		
		JButton rs = new JButton("REMOVE STAFF");
		rs.setFont(new Font("Tahoma", Font.BOLD, 15));
		rs.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		rs.setForeground(new Color(255, 255, 255));
		rs.setBounds(372, 239, 282, 44);
		panel.add(rs);
		rs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveStaff rmsf=new RemoveStaff();
				rmsf.setVisible(true);
			}
		});
		rs.setBackground(new Color(0, 128, 192));
		
		JButton uad = new JButton("UPDATE ADMIN DETAILS");
		uad.setFont(new Font("Tahoma", Font.BOLD, 15));
		uad.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		uad.setForeground(new Color(255, 255, 255));
		uad.setBounds(50, 300, 604, 41);
		panel.add(uad);
		uad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAdmin ua=new UpdateAdmin();
				ua.setVisible(true);
			}
		});
		uad.setBackground(new Color(0, 128, 192));
		as.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaff adsf=new AddStaff();
				adsf.setVisible(true);
			}
		});
		s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff sf=new Staff();
				sf.setVisible(true);
				
			}
		});
		ab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBooks adbks=new AddBooks();
				adbks.setVisible(true);
			}
		});
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BooksAvailable booksavl= new BooksAvailable();
				booksavl.setVisible(true);
				
			}
		});
	}
}
