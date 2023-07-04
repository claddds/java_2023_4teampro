package Pay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.Protocol;
import common.Session;

public class Pay extends JFrame implements Runnable{
	JPanel northPanel, centerPanel, remainingPanel, payPanel, ButtonPanel;
	JButton pay, cancel;
	JLabel jl2;
	
	int chargepoint;
	Pay_VO pay_vo;
	
	// 이 부분은 나중에 다른곳에 해야함. 로그인 후 메인화면에 해야할 듯.
	public static String currentUserId; // 현재 로그인한 회원아이디 static 변수로 선언

	// 접속하기 위해 필요한 것들
	public ObjectInputStream in;
	public ObjectOutputStream out;
	public Socket s;
	
	public Pay() {
		super("결제");
				
		getContentPane().setBackground(Color.WHITE);

		// 잔여포인트
		remainingPanel = new JPanel();
		remainingPanel.setLayout(new BoxLayout(remainingPanel, BoxLayout.Y_AXIS));

		JPanel remainingPanel_1 = new JPanel();
		remainingPanel_1.setPreferredSize(new Dimension(180, 50)); // remainingPanel_1 패널의 너비,높이
		// remainingPanel_1.setBackground(Color.WHITE);

		JPanel remainingPanel_2 = new JPanel();
		remainingPanel_2.setLayout(new BoxLayout(remainingPanel_2, BoxLayout.X_AXIS));
		JLabel jl1 = new JLabel("   잔여 포인트 :"); // 라벨 생성
		jl1.setFont(jl1.getFont().deriveFont(Font.BOLD, 15)); // 큰 글꼴 크기(16)로 설정
		
		jl2 = new JLabel(); //POINT DB의 REMAINING_POINT 
		jl2.setText(" " + Integer.toString(chargepoint) + "원"); // Pay_VO 객체에서 point를 가져와 JLabel에 설정
		jl2.setFont(jl1.getFont().deriveFont(Font.BOLD, 15));
		jl2.setBorder(BorderFactory.createEmptyBorder()); // 테두리 설정
		
		remainingPanel_2.add(jl1);
		remainingPanel_2.add(jl2);
		remainingPanel_2.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // 검은색 테두리
		remainingPanel_2.setMaximumSize(new Dimension(remainingPanel_1.getPreferredSize()));
		// 이거 없으면 테두리가 양옆으로 길어짐

		remainingPanel.add(remainingPanel_1);
		remainingPanel.add(remainingPanel_2);
		// remainingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		// 패널의 내부 여백 (상, 좌, 하, 우)

		// 결제포인트
		payPanel = new JPanel();
		payPanel.setLayout(new BoxLayout(payPanel, BoxLayout.Y_AXIS));
		JPanel payPanel_1 = new JPanel();
		payPanel_1.setPreferredSize(new Dimension(180, 0));

		JPanel payPanel_2 = new JPanel();
		payPanel_2.setLayout(new BoxLayout(payPanel_2, BoxLayout.X_AXIS));
		JLabel jl3 = new JLabel("   결제 포인트 :");
		jl3.setFont(jl3.getFont().deriveFont(Font.BOLD, 15));
		JLabel jl4 = new JLabel("  30,000 ");
		jl4.setFont(jl1.getFont().deriveFont(Font.BOLD, 15));
		jl4.setBorder(BorderFactory.createEmptyBorder());
		payPanel_2.add(jl3);
		payPanel_2.add(jl4);
		payPanel_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		payPanel_2.setMaximumSize(new Dimension(payPanel_1.getPreferredSize()));

		payPanel.add(payPanel_1);
		payPanel.add(payPanel_2);

		// 결제, 취소 버튼
		ButtonPanel = new JPanel();
		pay = new JButton("결제하기"); // 버튼클릭->티켓테이블INSERT, 포인트테이블INSERT
		cancel = new JButton("취소하기");
		ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		ButtonPanel.add(pay);
		ButtonPanel.add(Box.createHorizontalStrut(20));
		ButtonPanel.add(cancel);
		ButtonPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
		// ButtonPanel의 테두리에 빈 여백 추가 상, 좌, 하, 우

		setLayout(new BorderLayout());
		add(remainingPanel, BorderLayout.NORTH);
		add(payPanel, BorderLayout.CENTER);
		add(ButtonPanel, BorderLayout.SOUTH);
		add(Box.createVerticalStrut(20), BorderLayout.WEST);
		add(Box.createVerticalStrut(20), BorderLayout.EAST);

		setSize(350, 250);
		setLocationRelativeTo(null); // 현재 화면의 중앙에 표시
		setVisible(true); // 닫힐 때 프로그램이 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); // 크기 조절 비활성화
	
		
		// 결제하기 버튼 -> TICKET DB에 INSERT (O)
		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("===결제하기 버튼 클릭!===");
					System.out.println("currentUserId:" + currentUserId);
					
					Pay_VO pay_vo = new Pay_VO();
					
					// pay_vo.setTicket_num(); //시퀀스로 들어감.
					pay_vo.setMovie_id("2");
					pay_vo.setCust_id(currentUserId);
					pay_vo.setMovie_name("케로로");
					pay_vo.setTheater_id("미나리");
					String dateString = "2023-07-02"; // 날짜 문자열
					LocalDate localDate = LocalDate.parse(dateString); // 문자열을 LocalDate로 파싱
					Date sqlDate = Date.valueOf(localDate); // LocalDate를 java.sql.Date로 변환
					pay_vo.setMovie_date(sqlDate); // java.sql.Date 객체를 설정
					pay_vo.setStart_time("13:30");
					pay_vo.setEnd_time("15:50");
					pay_vo.setTheater_seat("E열1");
					
					// 프로토콜 사용 안할 때
					// int result = Pay_DAO.getInsert(pay_vo);
					
					// 프로토콜 사용
					Protocol p = new Protocol();
					p.setCmd(103); 
					p.setPay_vo(pay_vo); // 프로토콜에 VO 객체를 설정
					
					out.writeObject(p); // objectOutputStream을 통해 Protocol 객체를 서버로 전송
					out.flush(); // 출력 스트림을 비우는 역할
					
					System.out.println("영화 정보가 입력되었습니다.");
				} catch (Exception e2) {
				}
				
//				// 예매 완료창으로 전환
//				Reservation_completed reservationCompleted = new Reservation_completed();
//		        setVisible(false); // 현재 Pay 창 숨기기
			}
		});
		
		// 접속
		connected();
		
		// 결제하기창 닫기 버튼 누르면 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (s != null) {
					try {
						Protocol p = new Protocol();
						p.setCmd(100);
						out.writeObject(p);
						out.flush();
					} catch (Exception e2) {
					}
				} else {
					closed();
				}
			}
		});
	}
	
	// 접속 메서드
	public void connected() {
		try {
						// 집: 192.168.0.11
			s = new Socket("192.168.0.11", 7789);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			new Thread(this).start();
			loadRemainingPoint(); // 접속하면서 잔여포인트 가져옴
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 끝내기 메서드
	public void closed() {
		try {
			out.close();
			in.close();
			System.exit(0);
		} catch (Exception e) {
		}
	}
	
	// 현재 로그인한 회원정보를 불러와서 잔여포인트를 불러오는 메서드
	private void loadRemainingPoint() {
	    try {
	    	System.out.println("===loadRemainingPoint 실행===");
	    	
	    	// Session에서 currentUserId 호출
	    	Pay_VO pay_vo = new Pay_VO();
        	currentUserId = Session.getCurrentUserId();
	    	pay_vo.setCust_id(currentUserId);
	    	
	    	//잔여 포인트 가져오기
	        System.out.println("===잔여포인트 가져오기 실행===");
	        
	        Protocol p = new Protocol();
	        p.setCmd(102);
	        p.setPay_vo(pay_vo);
	        out.writeObject(p);
	        out.flush();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
		
	@Override
	public void run() {
		esc: while (true) {
			try {
				Object obj = in.readObject();
				if (obj != null) {
					Protocol p = (Protocol) obj;
					switch (p.getCmd()) {
					case 100:
						break esc;
					case 102:
						System.out.println("===Pay.java의 case1===");
					    chargepoint = p.getResult(); // 프로토콜에서 잔여 포인트 가져오기
					    jl2.setText(" " + Integer.toString(chargepoint) + "원"); // JLabel에 잔여포인터 업데이트
						break;
					case 103:
						// 예매 완료창으로 전환
						Reservation_completed reservationCompleted = new Reservation_completed();
				        setVisible(false); // 현재 Pay 창 숨기기
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		closed();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            
			@Override
			public void run() {
	            new Pay();
            }
        });
    }
}