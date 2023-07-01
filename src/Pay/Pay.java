package Pay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 마이바티스 test
public class Pay extends JFrame {
	JPanel northPanel, centerPanel, remainingPanel, payPanel, ButtonPanel;
	JButton pay, cancel;
	Pay_VO pay_vo;
	

	public Pay() {
		super("결제");
		
		// Pay_VO 객체를 생성하고 로그인한 회원의 ID
		pay_vo = new Pay_VO();
		String cust_id = Pay_DAO.getMemberLogin(pay_vo);
		pay_vo.setCust_id(cust_id);  //로그인한 사용자 아이디. 나중엔 변수에 담아서 해야함.
		System.out.println("현재 로그인한 회원은 " + cust_id); //현재 로그인한 회원 아이디 콘솔에서 확인해보기.
		
		// DB에서 해당 회원의 잔여포인트(point) 가져와 Pay_VO 객체에 설정
		int point = Pay_DAO.getRemainingPoints(pay_vo);
		pay_vo.setPoint(point);

		getContentPane().setBackground(Color.WHITE);

		// 잔여포인트
		remainingPanel = new JPanel();
		remainingPanel.setLayout(new BoxLayout(remainingPanel, BoxLayout.Y_AXIS));

		JPanel remainingPanel_1 = new JPanel();
		remainingPanel_1.setPreferredSize(new Dimension(180, 50)); // remainingPanel_1 패널의 너비,높이
		// remainingPanel_1.setBackground(Color.WHITE);

		JPanel remainingPanel_2 = new JPanel();
		remainingPanel_2.setLayout(new BoxLayout(remainingPanel_2, BoxLayout.X_AXIS));
		JLabel jl1 = new JLabel("   잔여 포인트  :"); // 라벨 생성
		jl1.setFont(jl1.getFont().deriveFont(Font.BOLD, 15)); // 큰 글꼴 크기(16)로 설정
		
		JLabel jl2 = new JLabel( ); //POINT DB의 REMAINING_POINT 
		jl2.setText(Integer.toString(pay_vo.getPoint())); // Pay_VO 객체에서 point를 가져와 JLabel에 설정
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
		JLabel jl3 = new JLabel("   결제 포인트  :");
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
				Pay_VO pay_vo = new Pay_VO();
				String dateString = "2023-06-29"; // 날짜 문자열
				LocalDate localDate = LocalDate.parse(dateString); // 문자열을 LocalDate로 파싱
				Date sqlDate = Date.valueOf(localDate); // LocalDate를 java.sql.Date로 변환

				pay_vo.setTicket_num(1);
				pay_vo.setMovie_id("2");
				pay_vo.setCust_id("TEST123");
				pay_vo.setMovie_name("스파이더맨");
				pay_vo.setMovie_date(sqlDate); // java.sql.Date 객체를 설정
				pay_vo.setTheater_id("미나리");
				pay_vo.setStart_time("13:30");
				pay_vo.setEnd_time("15:50");
				pay_vo.setTheater_seat("G열18");
				int result = Pay_DAO.getInsert(pay_vo);
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            
			@Override
			public void run() {
                Pay pay3 = new Pay();
                pay3.pay_vo = new Pay_VO(); // Pay_VO 객체 초기화
                // pay_vo의 필드에 값을 설정해야 한다면 여기서 설정
            }
        });
    }
}