package c_loginout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
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
	
	JPanel contentPane;
	public JPanel pg; // 다른 패널들을 담을 패널
	public CardLayout card; // 형식
	
	private JTextField signin_id_tf;
	private JTextField signin_pw_tf;
	private JButton signin_login_bt, signin_signup_bt;
	private JLabel signin_logo_label, signin_id_label, signin_pw_label;
	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	public CustomerVO cvo;
	public String c_id, c_pw;
	
	public Sign_in() {
		super("로그인");
		
		pg = new JPanel();
		pg.setLayout(card = new CardLayout());	
		
		setResizable(false);
		setBounds(100, 100, 800, 800);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		signin_logo_label = new JLabel("4딸라-필름");
		signin_logo_label.setFont(new Font("맑은 고딕", Font.BOLD, 78));
		signin_logo_label.setBounds(217, 79, 400, 203);
		contentPane.add(signin_logo_label);
		
		signin_id_tf = new JTextField();
		signin_id_tf.setBounds(395, 277, 222, 28);
		signin_id_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		contentPane.add(signin_id_tf);
		
		signin_pw_tf = new JPasswordField();
		signin_pw_tf.setBounds(395, 315, 222, 28);
		signin_pw_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		contentPane.add(signin_pw_tf);
		
		signin_id_label = new JLabel("ID");
		signin_id_label.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		signin_id_label.setBounds(199, 277, 107, 25);
		contentPane.add(signin_id_label);

		signin_pw_label = new JLabel("PASSWORD");
		signin_pw_label.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		signin_pw_label.setBounds(199, 323, 171, 25);
		contentPane.add(signin_pw_label);
		
		signin_signup_bt = new JButton("회원가입");
		signin_signup_bt.setBounds(425, 385, 134, 37);
		signin_signup_bt.setBorderPainted(false);
		signin_signup_bt.setFocusPainted(false);
		signin_signup_bt.setContentAreaFilled(false);
		signin_signup_bt.setFont(new Font("맑은고딕", Font.BOLD, 20));
		signin_signup_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(signin_signup_bt);
		
		signin_login_bt = new JButton("로그인");
		signin_login_bt.setBounds(269, 378, 144, 50);
		signin_login_bt.setBorderPainted(false);
		signin_login_bt.setFocusPainted(false);
		signin_login_bt.setContentAreaFilled(false);
		signin_login_bt.setFont(new Font("Dialog", Font.BOLD, 20));
		signin_login_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(signin_login_bt);
		
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
			signin_id_tf.setText("");
			signin_pw_tf.setText("");
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
				cvo = vo;
				c_id = vo.getCust_id();
				c_pw = vo.getCust_password();
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
