package project.swing.LJH;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//결제정보창, 결제확인창
public class ticket_before_pay extends JFrame{
	JPanel north,center,south,v_point,con_pay,bt_p, info_p;
	JLabel point,show_point,pay,show_name,show_date,show_room,show_peo,show_seat,show_price;
	JButton pay_bt, back_bt;
	

	
	
	public ticket_before_pay() {
		super("결제확인창");
		 
		/*잔여포인트 & 결제확인창 이름 패널*/
		v_point = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		v_point.setBorder(new EmptyBorder(5,5,5,5));
		con_pay = new JPanel();
		
		point = new JLabel("잔여포인트");
		show_point = new JLabel("10000"); //임의로 넣은것으로 나중에 DB연동하기

		v_point.add(point);
		v_point.add(show_point);
		
		pay = new JLabel("결제 확인창");
		pay.setFont(new Font("굴림",Font.BOLD,25));
		pay.setHorizontalAlignment(SwingConstants.CENTER); 
		pay.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		
		con_pay.add(pay);
		
		north = new JPanel();
		north.setLayout(new BorderLayout());
		
		north.add(v_point,BorderLayout.NORTH);
		north.add(pay,BorderLayout.SOUTH);
		
		
		/*안에 내용물 패널 (여기는 다 DB연동해야함) */
		
		center = new JPanel();
		info_p = new JPanel();
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_name = new JLabel("영화제목:   ");
		JLabel jl1 = new JLabel("뽀로로"); //임시로 나중에 DB연동하기
		
		p1.add(show_name);
		p1.add(jl1);
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_date= new JLabel("영화상영일:   ");
		JLabel jl2 = new JLabel("2023/05/11");//임시로 나중에 DB연동하기
		
		p2.add(show_date);
		p2.add(jl2);
		
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_room= new JLabel("극장이름:   ");
		JLabel jl3 = new JLabel("ICT관");//임시로 나중에 DB연동하기
		
		p3.add(show_room);
		p3.add(jl3);
		
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_peo= new JLabel("인  원:   ");
		JLabel jl4 = new JLabel("2 명");//임시로 나중에 DB연동하기
		
		p4.add(show_peo);
		p4.add(jl4);
		
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_seat= new JLabel("좌석번호:   ");
		JLabel jl5 = new JLabel("K1,K2");//임시로 나중에 DB연동하기
		
		p5.add(show_seat);
		p5.add(jl5);
		
		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_price= new JLabel("결제금액:   ");
		JLabel jl6 = new JLabel("15000 원");//임시로 나중에 DB연동하기
		
		p6.add(show_price);
		p6.add(jl6);
		
		center.setLayout(new GridLayout(6,1));
		
		center.setBorder(new EmptyBorder(40,20,20,20));
		center.add(p1);
		center.add(p2);
		center.add(p3);
		center.add(p4);
		center.add(p5);
		center.add(p6);
		
		
	
	    
		/*버튼*/
		bt_p = new JPanel();
		pay_bt = new JButton("결제하기");
		back_bt = new JButton("돌아가기");
		bt_p.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		bt_p.add(pay_bt);
		bt_p.add(Box.createHorizontalStrut(20));
		bt_p.add(back_bt);
		bt_p.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
		
		
		/*모든 판넬 붙이기*/
		add(north,BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bt_p,BorderLayout.SOUTH);
		
		setSize(350, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
	}
	



	public static void main(String[] args) {
		new ticket_before_pay();
	}  //메인
} //클래스
