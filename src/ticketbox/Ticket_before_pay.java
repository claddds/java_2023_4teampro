package ticketbox;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import c_loginout.Sign_in;
//이걸로 합치기!
//결제정보창, 결제확인창
public class Ticket_before_pay extends JPanel{
	Sign_in sign_in;
	
	
	JLabel pay,lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6,lblNewLabel_7,
	lblNewLabel_8,lblNewLabel_9,lblNewLabel_10,lblNewLabel_11,lblNewLabel_12,lblNewLabel_13,lblNewLabel_14,
	lblNewLabel_15,lblNewLabel_16;
	
	JButton btnNewButton, btnNewButton_1;
	 
	public Ticket_before_pay(Sign_in signin) {
		this.sign_in = signin;
	
		 
		this.setLayout(null);
		
		 pay = new JLabel("결제 확인창");
		pay.setBounds(279, 167, 200, 40);
		this.add(pay);
		pay.setFont(new Font("굴림",Font.BOLD,25));
		pay.setHorizontalAlignment(SwingConstants.CENTER); 

		
		 lblNewLabel = new JLabel("영화 제목:");
		lblNewLabel.setBounds(310, 273, 57, 15);
		this.add(lblNewLabel);
		
		 lblNewLabel_1 = new JLabel("상영일:");
		lblNewLabel_1.setBounds(310, 333, 68, 15);
		this.add(lblNewLabel_1);
		
		 lblNewLabel_2 = new JLabel("상영관:");
		lblNewLabel_2.setBounds(310, 393, 57, 15);
		this.add(lblNewLabel_2);
		
		 lblNewLabel_3 = new JLabel("인원");
		lblNewLabel_3.setBounds(310, 453, 30, 15);
		this.add(lblNewLabel_3);
		
		 lblNewLabel_4 = new JLabel("성인:");
		lblNewLabel_4.setBounds(346, 453, 34, 15);
		this.add(lblNewLabel_4);
		
		 lblNewLabel_5 = new JLabel("아동:");
		lblNewLabel_5.setBounds(424, 453, 34, 15);
		this.add(lblNewLabel_5);
		
		 lblNewLabel_6 = new JLabel("0명");
		lblNewLabel_6.setBounds(388, 453, 34, 15);
		this.add(lblNewLabel_6);
		
		 lblNewLabel_7 = new JLabel("0명");
		lblNewLabel_7.setBounds(466, 453, 34, 15);
		this.add(lblNewLabel_7);
		
		 lblNewLabel_8 = new JLabel("좌석 번호:");
		lblNewLabel_8.setBounds(310, 513, 57, 15);
		this.add(lblNewLabel_8);
		
		 lblNewLabel_9 = new JLabel("결제 금액:");
		lblNewLabel_9.setBounds(310, 573, 57, 15);
		this.add(lblNewLabel_9);
		
		 lblNewLabel_10 = new JLabel("영화이름");
		lblNewLabel_10.setBounds(388, 273, 57, 15);
		this.add(lblNewLabel_10);
		
		 lblNewLabel_11 = new JLabel("날짜");
		lblNewLabel_11.setBounds(388, 333, 57, 15);
		this.add(lblNewLabel_11);
		
		 lblNewLabel_12 = new JLabel("상영관이름");
		lblNewLabel_12.setBounds(388, 393, 70, 15);
		this.add(lblNewLabel_12);
		
		 lblNewLabel_13 = new JLabel("선택좌석");
		lblNewLabel_13.setBounds(388, 513, 57, 15);
		this.add(lblNewLabel_13);
		
		 lblNewLabel_14 = new JLabel("총금액");
		lblNewLabel_14.setBounds(388, 573, 57, 15);
		this.add(lblNewLabel_14);
		
	/*	 lblNewLabel_15 = new JLabel("잔여포인트:");
		lblNewLabel_15.setBounds(501, 77, 80, 15);
		this.add(lblNewLabel_15);
		
		 lblNewLabel_16 = new JLabel("00000");
		lblNewLabel_16.setBounds(576, 77, 57, 15);
		this.add(lblNewLabel_16);*/
		
		btnNewButton = new JButton("취소하기");
		btnNewButton.setBounds(235, 714, 115, 35);
		this.add(btnNewButton);
		
		btnNewButton_1 = new JButton("결제하기");
		btnNewButton_1.setBounds(450, 714, 115, 35);
		this.add(btnNewButton_1);
		
	/*	btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog payDialog = new JDialog(signin, "결제하기", true);
				payDialog.setSize(350, 250);
				payDialog.setLocationRelativeTo(signin);
				
				JLabel jl1 = new JLabel("  잔여 포인트 :");
				
				payDialog.add(jl1);
				
				payDialog.add(jl1);
			}
		});*/
		
		
		//돌아가기 버튼을 눌렀을 경우에 다시 좌석확인창으로 넘어가진다. 
		//결제확인창은 숨어진다.
//		back_bt.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ticket_seat con_seat = new Ticket_seat();
//				con_seat.setVisible(true);
//				setVisible(false);
//				
//			}
//		});
//		
//		
//	}
	



	



//
//	public static void main(String[] args) {
//		new Ticket_before_pay();
	}  //메인
}   //클래스