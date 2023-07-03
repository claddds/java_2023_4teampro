package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Sign_in extends JFrame{
	private JTextField signin_id_tf;
	private JTextField signin_pw_tf;
	public Sign_in() {
		super("로그인");
		
		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel signin_login_panel = new JPanel();
		signin_login_panel.setBounds(0, 0, 784, 112);
		getContentPane().add(signin_login_panel);
		signin_login_panel.setLayout(null);
		
		JLabel signin_login_label = new JLabel("로그인");
		signin_login_label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		signin_login_label.setHorizontalAlignment(SwingConstants.CENTER);
		signin_login_label.setBounds(298, 38, 165, 44);
		signin_login_panel.add(signin_login_label);
		
		JPanel signin_id_pw_panel = new JPanel();
		signin_id_pw_panel.setBounds(0, 111, 784, 112);
		getContentPane().add(signin_id_pw_panel);
		signin_id_pw_panel.setLayout(null);
		
		JLabel signin_id_label = new JLabel("아이디");
		signin_id_label.setHorizontalAlignment(SwingConstants.CENTER);
		signin_id_label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		signin_id_label.setBounds(200, 21, 90, 30);
		signin_id_pw_panel.add(signin_id_label);
		
		JLabel signin_pw_label = new JLabel("비밀번호");
		signin_pw_label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		signin_pw_label.setHorizontalAlignment(SwingConstants.CENTER);
		signin_pw_label.setBounds(200, 60, 90, 30);
		signin_id_pw_panel.add(signin_pw_label);
		
		signin_id_tf = new JTextField();
		signin_id_tf.setBounds(283, 27, 220, 21);
		signin_id_pw_panel.add(signin_id_tf);
		signin_id_tf.setColumns(10);
		
		signin_pw_tf = new JTextField();
		signin_pw_tf.setBounds(286, 65, 220, 21);
		signin_id_pw_panel.add(signin_pw_tf);
		signin_pw_tf.setColumns(10);
		
		JPanel signin_login_bt_panel = new JPanel();
		signin_login_bt_panel.setBounds(0, 221, 784, 82);
		getContentPane().add(signin_login_bt_panel);
		signin_login_bt_panel.setLayout(null);
		
		JButton signin_login_bt = new JButton("로그인");
		signin_login_bt.setBounds(252, 22, 97, 23);
		signin_login_bt_panel.add(signin_login_bt);
		
		JButton signin_cancel_bt = new JButton("취소");
		signin_cancel_bt.setBounds(406, 23, 97, 23);
		signin_login_bt_panel.add(signin_cancel_bt);
		
		JButton signin_signup_bt = new JButton("회원가입");
		signin_signup_bt.setBounds(334, 55, 97, 23);
		signin_login_bt_panel.add(signin_signup_bt);
		
		signin_cancel_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main_logout();
				setVisible(false);
			}
		});
		
		signin_signup_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sign_up();
				setVisible(false);	// 창 안보이게 하기
			}
		});
	}
	public static void main(String[] args) {
		new Sign_in();
	}
}
