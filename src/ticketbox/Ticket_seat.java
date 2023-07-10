package ticketbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import c_loginout.Sign_in;

//이걸로 합치기!
public class Ticket_seat extends JPanel {
	Sign_in sign_in;
	
	Ticket_seat_map map;
	
	JLabel lblNewLabel, lblNewLabel_1,lblNewLabel_2_1_1_1,lblNewLabel_6,lblNewLabel_7,
	lblNewLabel_7_1,lblNewLabel_7_1_1,lblNewLabel_7_1_1_1,lblNewLabel_8,lblNewLabel_8_1,
	lblNewLabel_8_2,lblNewLabel_8_2_1,lblNewLabel_9,lblNewLabel_10,lblNewLabel_11,lblNewLabel_10_1,
	lblNewLabel_10_2,lblNewLabel_10_3,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5;
	
	JButton btnNewButton ,btnNewButton_1,btnNewButton_1_1;
	
	ArrayList<String> selectedSeats = new ArrayList<>();
	
	//Icon  ;
    String theater, adultCount,childCount, date, time, amount ,room;
    //좌석선택창 정보 > 결제확인창으로 값 보내기 위한 변수선언
	
	JComboBox comboBox;
	public Ticket_seat(Sign_in signin) {
		this.sign_in = signin;
		
		map = new Ticket_seat_map(signin);
		
		this.setLayout(null);

		/*lblNewLabel = new JLabel("잔여포인트");
		lblNewLabel.setBounds(610, 22, 69, 15);
		this.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("00000");
		lblNewLabel_1.setBounds(681, 22, 57, 15);
		this.add(lblNewLabel_1);*/

		lblNewLabel_2_1_1_1 = new JLabel("[선택한 정보]");
		lblNewLabel_2_1_1_1.setBounds(610, 56, 82, 15);
		this.add(lblNewLabel_2_1_1_1);

		lblNewLabel_6 = new JLabel();  //앞에서 선택한 정보 여기로 끌어오기/영화포스터
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(610, 81, 161, 460);
		this.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("극장 :");
		lblNewLabel_7.setBounds(610, 573, 57, 15);
		this.add(lblNewLabel_7);

		lblNewLabel_7_1 = new JLabel("날짜 :");
		lblNewLabel_7_1.setBounds(610, 623, 57, 15);
		this.add(lblNewLabel_7_1);

		lblNewLabel_7_1_1 = new JLabel("시간 :");
		lblNewLabel_7_1_1.setBounds(610, 648, 57, 15);
		this.add(lblNewLabel_7_1_1);

		lblNewLabel_7_1_1_1 = new JLabel("인원");
		lblNewLabel_7_1_1_1.setBounds(610, 673, 34, 15);
		this.add(lblNewLabel_7_1_1_1);

		lblNewLabel_8 = new JLabel("성인:");
		lblNewLabel_8.setBounds(642, 673, 34, 15);
		this.add(lblNewLabel_8);

		lblNewLabel_8_1 = new JLabel("아동:");
		lblNewLabel_8_1.setBounds(706, 673, 34, 15);
		this.add(lblNewLabel_8_1);

		lblNewLabel_8_2 = new JLabel();  //앞에서 선택한 정보 여기로 끌어오기/성인인원
		lblNewLabel_8_2.setBounds(681, 673, 32, 15);
		this.add(lblNewLabel_8_2);

		lblNewLabel_8_2_1 = new JLabel(); //앞에서 선택한 정보 여기로 끌어오기/아동인원
		lblNewLabel_8_2_1.setBounds(749, 673, 32, 15);
		this.add(lblNewLabel_8_2_1);

		lblNewLabel_9 = new JLabel("금액:");
		lblNewLabel_9.setBounds(610, 698, 57, 15);
		this.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel();   //ict 이름이라는 극장이름뜨게하기 
		lblNewLabel_10.setBounds(656, 573, 100, 15);
		this.add(lblNewLabel_10);
		//db정보로 넣기

		lblNewLabel_11 = new JLabel(); //관선택시 라벨 동적으로 
		lblNewLabel_11.setBounds(656, 598, 57, 15);
		this.add(lblNewLabel_11);
		
		lblNewLabel_10_1 = new JLabel();  //앞에서 선택한 정보 여기로 끌어오기/날짜
		lblNewLabel_10_1.setBounds(656, 623, 57, 15);
		this.add(lblNewLabel_10_1);
		//db정보로 넣기

		lblNewLabel_10_2 = new JLabel(); //앞에서 선택한 정보 여기로 끌어오기/시간
		lblNewLabel_10_2.setBounds(656, 648, 100, 15);
		this.add(lblNewLabel_10_2);
		//db정보로 넣기

		lblNewLabel_10_3 = new JLabel();  //앞에서 선택한 정보 여기로 끌어오기/금액
		lblNewLabel_10_3.setBounds(656, 698, 57, 15);
		this.add(lblNewLabel_10_3);

		
		
		lblNewLabel_2 = new JLabel("[상영관 목록]");
		lblNewLabel_2.setBounds(57, 56, 82, 15);
		this.add(lblNewLabel_2);
		
		
		String[] thearter_name = {"미나리","개나리","빛나리" };
		comboBox = new JComboBox(thearter_name);
		comboBox.setBounds(151, 52, 69, 23);
		this.add(comboBox);

		btnNewButton = new JButton("SCREEN");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(32, 138, 297, 83);
		this.add(btnNewButton);


		lblNewLabel_3 = new JLabel("[좌석 확인]");
		lblNewLabel_3.setBounds(411, 56, 82, 15);
		this.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("선택한 좌석뜨는곳");
		lblNewLabel_4.setBounds(411, 105, 134, 436);
		this.add(lblNewLabel_4);

		btnNewButton_1 = new JButton("뒤로 가기");
		btnNewButton_1.setBounds(235, 714, 115, 35);
		this.add(btnNewButton_1);

		btnNewButton_1_1 = new JButton("예매 하기");
		btnNewButton_1_1.setBounds(450, 714, 115, 35);
		this.add(btnNewButton_1_1);


		lblNewLabel_5 = new JLabel("상영관:");
		lblNewLabel_5.setBounds(610, 598, 57, 15);
		this.add(lblNewLabel_5);


		
		map.setBounds(32,250,300,300);
		this.add(map);
		
		
		
		//db정보로 넣기

		
		
		//뒤로가기 버튼을 눌렀을 경우 
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sign_in.card.show(sign_in.pg, "to_main");
				
				
			}
		});
		
		
		// 결제하기 버튼을 눌렀을 경우, 결제확인창으로 넘어가도록 액션리스너 만듦.
		// 결제하기 버튼을누름과 동시에 매표소 화면은 숨겨진다.
		// 그리고, 결제확인 창이 객체 생성되면서 화면에 보여진다.
		btnNewButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//영화포스터 눌렀을때 이름 값 받기		
				
				
				adultCount = lblNewLabel_8_2.getText();
				childCount = lblNewLabel_8_2_1.getText();
				date = lblNewLabel_10_1.getText();
				time = lblNewLabel_10_2.getText();
				theater = lblNewLabel_11.getText();
				amount = lblNewLabel_10_3.getText();	
				
				
				sign_in.card.show(sign_in.pg,"tb_pay" );
				
				//영화이름 값넣어야함.
				
				
				sign_in.tb_pay.lblNewLabel_6.setText(adultCount);
				sign_in.tb_pay.lblNewLabel_7.setText(childCount);
				sign_in.tb_pay.lblNewLabel_11.setText(date);
				sign_in.tb_pay.lblNewLabel_12.setText(theater);
				sign_in.tb_pay.lblNewLabel_14.setText(amount);
				
				
				
			}
		});

		// 각 극장관에서 좌석선택후 극장을 바꾸고자할때, 선택된 체크박스의 체크가 초기화되게.
		// resetSeatSelection()은 seat_test 안에 메서드로 구현하였음.
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 콤보박스가 변경되었을 때 체크박스 초기화
				map.resetSeatSelection(); // seat_test 클래스에 resetSeatSelection() 메서드
			
			}
		});

		// 콤보박스 상영관을 누르면, 상영관 라벨에 동적으로 입력
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String selectedOption = (String) combo.getSelectedItem();
				lblNewLabel_11.setText(selectedOption);
				if (selectedOption.equals("개나리")) {
					map.setBounds(32,250,300,300);
		            btnNewButton.setBounds(32, 560, 297, 83); // 개나리 선택 시 버튼 위치 설정
		        } else if (selectedOption.equals("빛나리")) {
		        	btnNewButton.setVerticalTextPosition(SwingConstants.CENTER);
		        	map.setBounds(130, 200, 230, 230);
		            btnNewButton.setBounds(32, 180, 83, 297); // 빛나리 선택 시 버튼 위치 설정
		        } else if (selectedOption.equals("미나리")) {		  
		    		btnNewButton.setEnabled(false);
		    		btnNewButton.setBounds(32, 138, 297, 83);
		        	map.setBounds(32,250,300,300);
		        } 

		        // 화면 갱신
		        revalidate();
		        repaint();
			}
		});

		
		
				
	} // 마지막괄호



	

	
	
}
