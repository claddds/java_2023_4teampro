package c_loginout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import movie_server.CustomerVO;
import movie_server.Protocol;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Sign_in extends JFrame implements Runnable{
	private JTextField signin_id_tf;
	private JTextField signin_pw_tf;
	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	
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
		
		// 접속
		connected();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (s != null) {
					Protocol p = new Protocol();
					p.setCmd(0);
					try {
						out.writeObject(p);
						out.flush();
					} catch (Exception e2) {
					}
				} else {
					closed();
				}
			}
		});
		
		signin_login_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_go();
			}
		});
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
	
		// 서버 연결 메서드
		private void connected() {
			try {
				s = new Socket("192.168.0.41", 7780);
				out = new ObjectOutputStream(s.getOutputStream());
				in = new ObjectInputStream(s.getInputStream());

				new Thread(this).start();
			} catch (Exception e) {
			}
		}
		
		// 서버 연결 해제 메서드
		private void closed() {
			try {
				in.close();
				out.close();
				s.close();
				System.out.println("프로그램 종료");
				System.exit(0);
			} catch (Exception e) {
			}
		}
		
		// 초기값 메서드
		private void init() {
			id_tf.setText("");
			pw_tf.setText("");
			id_tf.requestFocus();
		}
		
		@Override
		public void run() {
			esc:while(true) {
				try {
					Object obj = in.readObject();
					if(obj != null) {
						Protocol p = (Protocol)obj;
						switch (p.getCmd()) {
							case 0 : break esc;	// 종료
							case 501:	// 로그인
								CustomerVO vo = p.getVo();
								LogIn(vo, p.getResult());
								break;
								
						}
					}
				} catch (Exception e) {
				}
			}
			 closed();
		}
		
		public void login_go() {
			if(signin_id_tf.getText().trim().length()>0&&signin_pw_tf.getText().trim().length()>0) {
				Protocol p = new Protocol();
				CustomerVO vo = new CustomerVO();
				vo.setCust_id(signin_id_tf.getText().trim());
				vo.setCust_password(signin_pw_tf.getText().trim());
				
				p.setCmd(501);
				p.setVo(vo);
				
				try {
					out.writeObject(p);
					out.flush();
				} catch (IOException e1) {
				}
			}else JOptionPane.showMessageDialog(getParent(), "아이디 / 비밀번호를 입력해주세요.");
		}
		
		public void LogIn(CustomerVO vo, int result) {
			if(result==0) {
				JOptionPane.showMessageDialog(getParent(), "로그인 성공");
				CustomerVO = vo;
				m_id = vo.getMember_id();
				m_pw = vo.getMember_pw();
				init();
				
			} else
				JOptionPane.showMessageDialog(getParent(), "가입 정보 없음");
		}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Sign_in();
			}
		});
	}
}
