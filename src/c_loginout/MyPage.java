package c_loginout;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

import movie_server.CustomerVO;
import movie_server.Protocol;

public class MyPage extends JPanel {
	Sign_in sign_in;
	
	// 탈퇴하기, 비밀번호 변경, 핸드폰 번호 변경 버튼
	private JButton cust_delete_bt, mp_pw_ch_bt, mp_phone_ch_bt;
	
	public MyPage(Sign_in signin) {
		this.sign_in = signin;
		
		this.setLayout(null);
		
		setBackground(new Color(255, 255, 255));
		setSize(800, 800);
		
		JLabel mp_mypage_Label = new JLabel("마이페이지");
		mp_mypage_Label.setHorizontalAlignment(SwingConstants.CENTER);
		mp_mypage_Label.setFont(new Font("맑은 고딕", Font.BOLD, 44));
		mp_mypage_Label.setBounds(194, 100, 274, 79);
		
		this.add(mp_mypage_Label);
		
		cust_delete_bt = new JButton("탈퇴하기");
		cust_delete_bt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		cust_delete_bt.setBounds(524, 551, 97, 23);
		this.add(cust_delete_bt);
		
		JLabel mp_name_label = new JLabel("이름");
		mp_name_label.setHorizontalAlignment(SwingConstants.RIGHT);
		mp_name_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		mp_name_label.setBounds(135, 221, 97, 23);
		this.add(mp_name_label);
		
		mp_pw_ch_bt = new JButton("비밀번호 변경");
		mp_pw_ch_bt.setBounds(290, 311, 121, 23);
		this.add(mp_pw_ch_bt);
		
		mp_phone_ch_bt = new JButton("핸드폰 번호 변경");
		mp_phone_ch_bt.setBounds(472, 413, 137, 23);
		this.add(mp_phone_ch_bt);
		
		JLabel mp_an_name_label = new JLabel(signin.p.getC_vo().getCust_name());
		mp_an_name_label.setHorizontalAlignment(SwingConstants.LEFT);
		mp_an_name_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		mp_an_name_label.setBounds(290, 221, 121, 23);
		add(mp_an_name_label);
		
		
		JLabel mp_id_label = new JLabel("아이디");
		mp_id_label.setHorizontalAlignment(SwingConstants.RIGHT);
		mp_id_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		mp_id_label.setBounds(135, 264, 97, 23);
		this.add(mp_id_label);
		
		JLabel mp_pw_label = new JLabel("비밀번호");
		mp_pw_label.setHorizontalAlignment(SwingConstants.RIGHT);
		mp_pw_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		mp_pw_label.setBounds(135, 307, 97, 23);
		this.add(mp_pw_label);
		
		JLabel mp_birth_label = new JLabel("생년월일");
		mp_birth_label.setHorizontalAlignment(SwingConstants.RIGHT);
		mp_birth_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		mp_birth_label.setBounds(135, 356, 97, 23);
		this.add(mp_birth_label);
		
		JLabel mp_phone_label = new JLabel("핸드폰 번호");
		mp_phone_label.setHorizontalAlignment(SwingConstants.RIGHT);
		mp_phone_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		mp_phone_label.setBounds(135, 409, 97, 23);
		this.add(mp_phone_label);
		
		// 마이페이지에서는 현재 로그인 되어있는 사람의 정보를 볼 수 있다.
		JLabel mp_an_id_label = new JLabel(signin.p.getC_vo().getCust_id());
		mp_an_id_label.setHorizontalAlignment(SwingConstants.LEFT);
		mp_an_id_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		mp_an_id_label.setBounds(290, 264, 131, 23);
		this.add(mp_an_id_label);
		
		JLabel mp_an_birth_label = new JLabel(signin.p.getC_vo().getCust_birth());
		mp_an_birth_label.setHorizontalAlignment(SwingConstants.LEFT);
		mp_an_birth_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		mp_an_birth_label.setBounds(290, 356, 121, 23);
		this.add(mp_an_birth_label);
		
		JLabel mp_an_phone_label = new JLabel(signin.p.getC_vo().getCust_phone());
		mp_an_phone_label.setHorizontalAlignment(SwingConstants.LEFT);
		mp_an_phone_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		mp_an_phone_label.setBounds(290, 413, 121, 23);
		this.add(mp_an_phone_label);
		
		mp_pw_ch_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ch_pw = JOptionPane.showInputDialog("변경할 비밀번호를 입력해주세요");
				System.out.println("마이페이지 입장 비밀번호 입력"+ ch_pw);
				try {
					CustomerVO vo = new CustomerVO();
					
					// vo.setCust_password(ch_pw)
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		mp_phone_ch_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		cust_delete_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
