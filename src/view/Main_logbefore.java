package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;

public class Main_logbefore {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_logbefore window = new Main_logbefore();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_logbefore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[10px][152px][624px,grow]", "[43px][57.00px][][][][10px][][][][][][][][][][][][][][][][grow]"));
		
		JPanel topbutton_panel = new JPanel();
		frame.getContentPane().add(topbutton_panel, "cell 0 0 3 1,alignx left,aligny top");
		
		JButton mticket_button = new JButton("모바일티켓");
		mticket_button.setFont(new Font("돋움", Font.BOLD, 20));
		mticket_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton login_button = new JButton("로그인");
		login_button.setFont(new Font("돋움", Font.BOLD, 20));
		
		JButton join_button = new JButton("회원가입");
		join_button.setFont(new Font("돋움", Font.BOLD, 20));
		GroupLayout gl_topbutton_panel = new GroupLayout(topbutton_panel);
		gl_topbutton_panel.setHorizontalGroup(
			gl_topbutton_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topbutton_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(mticket_button, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(330)
					.addComponent(login_button, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(join_button, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_topbutton_panel.setVerticalGroup(
			gl_topbutton_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_topbutton_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(mticket_button))
				.addGroup(Alignment.TRAILING, gl_topbutton_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_topbutton_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(join_button)
						.addComponent(login_button)))
		);
		topbutton_panel.setLayout(gl_topbutton_panel);
		
		JPanel logo_panel = new JPanel();
		frame.getContentPane().add(logo_panel, "cell 1 1 2 1,alignx right,aligny top");
		GridBagLayout gbl_logo_panel = new GridBagLayout();
		gbl_logo_panel.columnWidths = new int[]{437, 0};
		gbl_logo_panel.rowHeights = new int[]{79, 0};
		gbl_logo_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_logo_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		logo_panel.setLayout(gbl_logo_panel);
		
		JButton logo_button = new JButton("4딸라- 시네마");
		frame.getContentPane().add(logo_button, "cell 2 2");
		logo_button.setFont(new Font("돋움", Font.BOLD, 60));
		
		JPanel book_snack_panel = new JPanel();
		frame.getContentPane().add(book_snack_panel, "cell 1 21 2 1,grow");
		book_snack_panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton book_button = new JButton("예매");
		book_button.setFont(new Font("돋움", Font.BOLD, 20));
		book_snack_panel.add(book_button);
		
		JButton snackbar_button = new JButton("매점");
		snackbar_button.setFont(new Font("돋움", Font.BOLD, 20));
		book_snack_panel.add(snackbar_button);
	}

}
