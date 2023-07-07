package login;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import List_.List;
import Product_.Product;
import Sell_.Sell;
import chat_.Chat;
import home_.Kategorie;
import member_.Member_Info;
import msg_.Msg_Chat;
import msg_.Msg_Chat_Details;
import msg_.Msg_Request;
import msg_.Msg_Request_Details;
import request_.Request;
import server_getchar.MembersVO;
import server_getchar.Msg_chatVo;
import server_getchar.Msg_requestVO;
import server_getchar.PDTVO;
import server_getchar.PVO;
import server_getchar.Protocol;
import server_getchar.RequestVO;
import signup.Auth;
import signup.Signup;

public class Login extends JFrame implements Runnable{
	
	JPanel contentPane;
	public JPanel pg; // 다른 패널들을 담을 패널
	public CardLayout card; // 형식
	private JTextField id_tf;
	private JPasswordField pw_tf;
	private JButton signUp_bt, login_bt, find_bt;
	private JLabel pw_lb, logo_lb, id_lb;
	
	public int idDup = 3;
	public int nickNameDup = 3;
	public int emailAuth = 3;
	public String m_id, m_pw;
	public int point;
	public int loginRes, pdtRes;
	public java.util.List<PDTVO> p_list;
	public java.util.List<Msg_chatVo> c_list;
	public java.util.List<Msg_requestVO> r_list;
	public PVO pvo_vo;
	public int res;
	public RequestVO reqVo;
	
	public ObjectInputStream in;
	public ObjectOutputStream out;
	public Socket s;
	public Signup signup;
	public Auth auth;
	public Find_ID find_id;
	public Find_PW find_pw;
	public Kategorie kate;
	public Sell sell;
	public List list;
	public Product product;
	public Chat chat;
	public Request request;
	public Member_Info member_info;
	public MembersVO mvo;
	public Msg_Chat msg_chat;
	public Msg_Request msg_request;
	public Msg_Chat_Details msg_chat_detail;
	public Msg_Request_Details msg_request_detail;
	
	public Login() {
		super("getChar");
		
		pg = new JPanel();
		pg.setLayout(card = new CardLayout());	
		
		setResizable(false);
//		setUndecorated(true);
		setBounds(100, 100, 1100, 700);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(null);

		logo_lb = new JLabel("GET CHAR");
		logo_lb.setFont(new Font("HSSaemaul", Font.BOLD, 130));
		logo_lb.setForeground(new Color(153, 204, 255));
		logo_lb.setBounds(82, 213, 444, 203);
		contentPane.add(logo_lb);

		id_tf = new JTextField();
		id_tf.setBounds(670, 282, 222, 28);
		id_tf.setFont(new Font("HS새마을체", Font.PLAIN, 15));
		contentPane.add(id_tf);

		pw_tf = new JPasswordField();
		pw_tf.setBounds(670, 320, 222, 28);
		pw_tf.setFont(new Font("HS새마을체", Font.PLAIN, 15));
		contentPane.add(pw_tf);

		signUp_bt = new JButton("회원가입");
		signUp_bt.setBounds(655, 448, 112, 37);
		signUp_bt.setBorderPainted(false);
		signUp_bt.setFocusPainted(false);
		signUp_bt.setContentAreaFilled(false);
		signUp_bt.setFont(new Font("HSSaemaul", Font.BOLD, 20));
		signUp_bt.setForeground(new Color(217, 171, 246));
		signUp_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(signUp_bt);

		login_bt = new JButton("로그인");
		login_bt.setBounds(909, 287, 107, 49);
		login_bt.setBorderPainted(false);
		login_bt.setFocusPainted(false);
		login_bt.setContentAreaFilled(false);
		login_bt.setFont(new Font("HSSaemaul", Font.BOLD, 30));
		login_bt.setForeground(Color.ORANGE);
		login_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(login_bt);

		id_lb = new JLabel("ID");
		id_lb.setForeground(Color.ORANGE);
		id_lb.setFont(new Font("HSSaemaul", Font.PLAIN, 30));
		id_lb.setBounds(637, 287, 107, 25);
		contentPane.add(id_lb);

		pw_lb = new JLabel("PASSWORD");
		pw_lb.setForeground(Color.ORANGE);
		pw_lb.setFont(new Font("HSSaemaul", Font.PLAIN, 30));
		pw_lb.setBounds(551, 326, 107, 25);
		contentPane.add(pw_lb);

		find_bt = new JButton("아이디/비밀번호 찾기");
		find_bt.setBounds(806, 448, 184, 37);
		find_bt.setBorderPainted(false);
		find_bt.setFocusPainted(false);
		find_bt.setContentAreaFilled(false);
		find_bt.setFont(new Font("HSSaemaul", Font.BOLD, 20));
		find_bt.setForeground(new Color(217, 171, 246));
		find_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(find_bt);

		connected();

		auth = new Auth(this);
		signup = new Signup(this);
		find_id = new Find_ID(this);
		find_pw = new Find_PW(this);
		kate = new Kategorie(this);
		sell = new Sell(this);
		list = new List(this);
		product = new Product(this);
		chat = new Chat(this);
		request = new Request(this);
		member_info = new Member_Info(this);
		msg_chat = new msg_.Msg_Chat(this);
		msg_request = new Msg_Request(this);
		msg_chat_detail = new Msg_Chat_Details(this);
		msg_request_detail = new Msg_Request_Details(this);
		
		pg.add(contentPane, "login");
		pg.add(auth, "auth");
		pg.add(signup, "signup");
		pg.add(find_id, "find_id");
		pg.add(find_pw, "find_pw");
		pg.add(kate, "kate");
		pg.add(sell, "sell");
		pg.add(list, "list");
		pg.add(product, "product");
		pg.add(chat, "chat");
		pg.add(request, "request");
		pg.add(member_info, "member_info");
		pg.add(msg_chat, "msg_chat");
		pg.add(msg_request, "msg_request");
		pg.add(msg_chat_detail, "msg_chat_detail");
		pg.add(msg_request_detail, "msg_request_detail");
		
		setContentPane(pg);
		card.show(pg, "login");
		
		
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
		
		login_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login_go();
			}
		});
		
		signUp_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(pg, "signup");
				init();
			}
		});
		
		find_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(pg, "find_id");
				init();
			}
		});
		
		pw_tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER ){
					login_go();
				}
			}
		});

	}
	
	// 서버 연결 메서드
	private void connected() {
		try {
			s = new Socket("192.168.0.23", 8180);
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
		bk: while (true) {
			try {
				Object obj = in.readObject();
				if(obj != null) {
					Protocol p = (Protocol) obj;
					switch (p.getCmd()) {
					case 0: // 종료
						break bk;

					case 1: // 로그인
						MembersVO vo = p.getVo();
						LogIn(vo, p.getResult());
						break;
						
					case 2: // 요청 세팅
						res = p.getResult();
						reqVo = p.getReqvo();
						request.req();
						break;
						
					case 3: // 회원가입
						loginRes = p.getResult();
						signup.loginRes();
						break;
						
					case 4: // 상품 등록
						pdtRes = p.getResult();
						sell.pdtRes();
						break;
						
					case 5: // 상품 전체보기
						p_list = p.getP_list();
						list.refresh(p_list);
						break;
					case 6: // 상품 상세보기
						pvo_vo = p.getPvo();
						point = p.getResult();
						product.getEx(pvo_vo);
						break;
					
					case 7: // 아이디 중복체크
						idDup = p.getResult();
						signup.dupchk();
						break;

					case 8: // 닉네임 중복체크
						nickNameDup = p.getResult();
						signup.nickchk();
						break;
					
					case 9: // 아이디 찾기
						MembersVO vo9 = p.getVo();
						findId(vo9, p.getResult());
						break;
					
					case 10: // 비밀번호 찾기
						MembersVO vo10 = p.getVo();
						findPw(vo10,p.getResult());
						break;
						
					case 13: // 회원 프로필 수정
						int res13 = p.getResult();
						member_info.showMsg(res13);
						break;
						
					case 14: // 채팅(메시지)전송
						int res14 = p.getResult();
						if(res14 > 0) {
							JOptionPane.showMessageDialog(getParent(), "메시지 전송 성공 !");
							chat.setTextArea(p.getMsg());
						} else JOptionPane.showMessageDialog(getParent(), "메시지 전송 실패");
						break;
						
					case 15: // 메시지함 보기
						c_list = p.getC_list();
						msg_chat.msg_refresh();
						break;
					
					case 16 : // 메시지 읽음
						int res16 = p.getResult();
						Msg_chatVo mcv = p.getMsg_chatvo();
						PVO pvo = p.getPvo();
						if(res16 == 1) {
							msg_chat_detail.stateChange(mcv, pvo);
						}else {
							JOptionPane.showMessageDialog(getParent(), "예기치 못한 오류");
						}
						break;
						
					case 17 : // 요청 전송
						int res17 = p.getResult();
						request.result(res17);

					case 18 : // 요청함 보기
						r_list = p.getR_list();
						msg_request.msg_refresh();
						break;
					
					case 19 : // 요청 읽음
						int res19 = p.getResult();
						Msg_requestVO rcv = p.getMsg_requestvo();
						PVO pvo19 = p.getPvo();
						if(res19 == 1) {
							msg_request_detail.stateChange(rcv, pvo19);
						}else {
							JOptionPane.showMessageDialog(getParent(), "예기치 못한 오류");
						}
						break;
					
					case 20 : // 요청 거절(요청 삭제)
						int res20 = p.getResult();
						
						if(res20 == 1) {
							JOptionPane.showMessageDialog(getParent(), "요청이 거절되었습니다 !");
						} else JOptionPane.showMessageDialog(getParent(), "예기치 못한 오류");
						break;
						
					case 21 : // 채팅(메시지) 답장
						int res21 = p.getResult();
						if(res21>0) {
							JOptionPane.showMessageDialog(getParent(), "답장 성공 !");
							msg_chat_detail.goooooooooooooooooooooooooooooooooooooooooooooooooooooooooo();
						} else JOptionPane.showMessageDialog(getParent(), "전송 오류 ..");
						break;
						
					case 22 : // 상품 검색
						p_list = p.getP_list();
						list.refresh(p_list);
						break;
					
					case 23 : // 요청 수락
						int result23 = p.getResult();
						if(result23 == 1) {
							JOptionPane.showMessageDialog(getParent(), "거래 성공");
						}else JOptionPane.showMessageDialog(getParent(), "거래 오류");
						break;
					
					case 24 : // 해당 회원의 포인트 조회
						int result24 = p.getReqvo().getPDT_ID();
						int result24_2 = p.getReqvo().getPDT_PRICE();
						msg_request_detail.point_res2(result24);
						msg_request_detail.point_res(result24_2);
						break;
						
					case 25 : // 요청 수락
						int result25 = p.getResult();
						if(result25 == 1) {
							JOptionPane.showMessageDialog(getParent(), "++ 포인트 ++");
						}else JOptionPane.showMessageDialog(getParent(), "거래 오류");
						break;
						
					case 26 : // 해당 회원의 새로운 알림 여부
						String result26 = p.getMsg();
						String result26_2 = p.getMsg2();
						System.out.println(result26);
						System.out.println(result26_2);
						if((result26.equals("0") || result26 == null) && result26_2 == null || result26_2.equals("0")) {
							msg_empty();
						} else {
							msg_exist();
						}
						break;
					}
				}
			} catch (Exception e) {
			}
		}
		closed();
	}
	
	public void findId(MembersVO vo, int result) {
		if(result==0) {
			init();
			JOptionPane.showMessageDialog(getParent(), "ID : "+vo.getMember_id());
		}else {
			init();
			JOptionPane.showMessageDialog(getParent(), "잘못된 정보입니다.");
		}
	}
	
	public void findPw(MembersVO vo, int result) {
		if(result==0) {
			init();
			JOptionPane.showMessageDialog(getParent(), "PW : "+vo.getMember_pw());
		}else {
			init();
			JOptionPane.showMessageDialog(getParent(), "잘못된 정보입니다.");
		}
	}
	
	public void LogIn(MembersVO vo, int result) {
		if(result==0) {
			JOptionPane.showMessageDialog(getParent(), "로그인 성공");
			mvo = vo;
			m_id = vo.getMember_id();
			m_pw = vo.getMember_pw();
			init();
			
			exex();
		} else
			JOptionPane.showMessageDialog(getParent(), "가입 정보 없음");
	}
	
	public void exex() {
		Protocol p = new Protocol();
		p.setCmd(26);
		p.setMsg(m_id);
		
		try {
			out.writeObject(p);
			out.flush();
		} catch (Exception e2) {
		}
	}
	
	public void msg_exist() {
		System.out.println("있음");
		kate.my_info.setForeground(new Color(250, 81, 100));
		System.out.println("ewqe");
		card.show(pg, "kate");
	}

	
	public void msg_empty() {
		System.out.println("옶음");
		try {
			kate.my_info.setForeground(Color.ORANGE);
			card.show(pg, "kate");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void login_go() {
		if(id_tf.getText().trim().length()>0&&pw_tf.getText().trim().length()>0) {
			Protocol p = new Protocol();
			MembersVO vo = new MembersVO();
			vo.setMember_id(id_tf.getText().trim());
			vo.setMember_pw(pw_tf.getText().trim());
			
			p.setCmd(1);
			p.setVo(vo);
			
			try {
				out.writeObject(p);
				out.flush();
			} catch (IOException e1) {
			}
		}else JOptionPane.showMessageDialog(getParent(), "아이디 / 비밀번호를 입력해주세요.");
	}
	
//	public static void naverMailSend() {
//        String host = "smtp.naver.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
//        String user = "picasso7889@naver.com"; // 패스워드
//        String password = "h3z9bnkvn0c!";       
//
//        //수신 메일
//        String to = "수신자@이메일";
//        
//        // SMTP 서버 정보를 설정한다.
//        // Get the session object 
//        // java.util.Properties 클래스를 사용하여 STMP 서버와 관련된 정보를 지정 
//        Properties props = new Properties();
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", 587);
//        props.put("mail.smtp.auth", "true");
//        
//        // Properties에 저장되어있는 설정 값을 getDefaultInstance() 메소드로 설정값을 저장하여 세션 생성 
//        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(user, password);
//            }
//        });
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            //발신자 셋팅 
//            message.setFrom(new InternetAddress(user));
//
//            //메일 보내는 사람이 한명일 경우 
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // 메일 제목
//            message.setSubject("테스트 임미다-!");
//
//            // 메일 내용
//            message.setText("메일인증테스트입니다 ");
//
//            // send the message
//            Transport.send(message);
//            System.out.println("Success Message Send");
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
	
	//메인 메서드
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}