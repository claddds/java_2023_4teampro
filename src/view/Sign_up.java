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

public class Sign_up extends JFrame{
	private JTextField signup_id_tf;
	private JTextField signup_pw_tf;
	private JTextField signup_name_tf;
	private JTextField signup_birth_tf;
	private JTextField signup_phone_tf;
	public Sign_up() {
		super("회원가입");
		
		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel signup_signup_panel = new JPanel();
		signup_signup_panel.setBounds(0, 0, 784, 112);
		getContentPane().add(signup_signup_panel);
		signup_signup_panel.setLayout(null);
		
		JLabel signup_label = new JLabel("회원가입");
		signup_label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		signup_label.setHorizontalAlignment(SwingConstants.CENTER);
		signup_label.setBounds(298, 38, 165, 44);
		signup_signup_panel.add(signup_label);
		
		JPanel signup_signup_w_panel = new JPanel();
		signup_signup_w_panel.setBounds(0, 111, 784, 253);
		getContentPane().add(signup_signup_w_panel);
		signup_signup_w_panel.setLayout(null);
		
		JLabel signup_id_label = new JLabel("아이디");
		signup_id_label.setHorizontalAlignment(SwingConstants.CENTER);
		signup_id_label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		signup_id_label.setBounds(200, 21, 90, 30);
		signup_signup_w_panel.add(signup_id_label);
		
		JLabel signup_pw_label = new JLabel("비밀번호");
		signup_pw_label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		signup_pw_label.setHorizontalAlignment(SwingConstants.CENTER);
		signup_pw_label.setBounds(200, 60, 90, 30);
		signup_signup_w_panel.add(signup_pw_label);
		
		signup_id_tf = new JTextField();
		signup_id_tf.setBounds(286, 29, 220, 21);
		signup_signup_w_panel.add(signup_id_tf);
		signup_id_tf.setColumns(10);
		
		signup_pw_tf = new JTextField();
		signup_pw_tf.setBounds(289, 68, 220, 21);
		signup_signup_w_panel.add(signup_pw_tf);
		signup_pw_tf.setColumns(10);
		
		JLabel signup_name_label = new JLabel("이름");
		signup_name_label.setHorizontalAlignment(SwingConstants.CENTER);
		signup_name_label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		signup_name_label.setBounds(202, 100, 90, 30);
		signup_signup_w_panel.add(signup_name_label);
		
		JLabel signup_birth_label = new JLabel("생년월일");
		signup_birth_label.setHorizontalAlignment(SwingConstants.CENTER);
		signup_birth_label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		signup_birth_label.setBounds(205, 143, 90, 30);
		signup_signup_w_panel.add(signup_birth_label);
		
		JLabel signup_phone_label = new JLabel("핸드폰 번호");
		signup_phone_label.setHorizontalAlignment(SwingConstants.CENTER);
		signup_phone_label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		signup_phone_label.setBounds(189, 183, 90, 30);
		signup_signup_w_panel.add(signup_phone_label);
		
		signup_name_tf = new JTextField();
		signup_name_tf.setBounds(289, 105, 220, 21);
		signup_signup_w_panel.add(signup_name_tf);
		signup_name_tf.setColumns(10);
		
		signup_birth_tf = new JTextField();
		signup_birth_tf.setColumns(10);
		signup_birth_tf.setBounds(289, 151, 220, 21);
		signup_signup_w_panel.add(signup_birth_tf);
		
		signup_phone_tf = new JTextField();
		signup_phone_tf.setColumns(10);
		signup_phone_tf.setBounds(289, 191, 220, 21);
		signup_signup_w_panel.add(signup_phone_tf);
		
		JButton signup_idcheck_bt = new JButton("중복확인");
		signup_idcheck_bt.setBounds(552, 28, 97, 23);
		signup_signup_w_panel.add(signup_idcheck_bt);
		
		JPanel signup_bt_panel = new JPanel();
		signup_bt_panel.setBounds(0, 364, 784, 82);
		getContentPane().add(signup_bt_panel);
		signup_bt_panel.setLayout(null);
		
		JButton signup_signup_bt = new JButton("회원가입");
		signup_signup_bt.setBounds(252, 22, 97, 23);
		signup_bt_panel.add(signup_signup_bt);
		
		JButton signup_cancel_bt = new JButton("취소");
		signup_cancel_bt.setBounds(406, 23, 97, 23);
		signup_bt_panel.add(signup_cancel_bt);
		
		signup_cancel_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main_logout();
				setVisible(false);
			}
		});
	}
	public static void main(String[] args) {
		new Sign_up();
	}
}
