package project.swing.LJH;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//결제정보창, 결제확인창
public class ticket_info_pay extends JFrame{
	JPanel v_point, bt_p,info_p;
	JLabel point,show_point,show_name,show_date,show_room,show_peo,show_seat,show_price;
	JButton pay_bt, back_bt;
	
	
	
	
	public ticket_info_pay() {
		super("결제확인창");
		
		v_point = new JPanel();
		v_point.setLayout(new FlowLayout(FlowLayout.RIGHT)); 
		v_point.setBorder(new EmptyBorder(5,0,30,0)); 
		/*각 패널별로 공간띄어주기함 */
		point = new JLabel("잔여포인트:       ");	
		show_point = new JLabel("10000"); //임의숫자	
		
		v_point.add(point);
		v_point.add(show_point);
		
		/*내용*/
		info_p = new JPanel();
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_name = new JLabel("영화제목:   ");
		JLabel jl1 = new JLabel("뽀로로");
		
		p1.add(show_name);
		p1.add(jl1);
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_date= new JLabel("영화상영일:   ");
		JLabel jl2 = new JLabel("2023/05/11");
		
		p2.add(show_date);
		p2.add(jl2);
		
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_room= new JLabel("극장이름:   ");
		JLabel jl3 = new JLabel("ICT관");
		
		p3.add(show_room);
		p3.add(jl3);
		
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_peo= new JLabel("인  원:   ");
		JLabel jl4 = new JLabel("2 명");
		
		p4.add(show_peo);
		p4.add(jl4);
		
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_seat= new JLabel("좌석번호:   ");
		JLabel jl5 = new JLabel("K1,K2");
		
		p5.add(show_seat);
		p5.add(jl5);
		
		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		show_price= new JLabel("결제금액:   ");
		JLabel jl6 = new JLabel("15000 원");
		
		p6.add(show_price);
		p6.add(jl6);
		
		
		/*그리드로 만들게 한패널에 붙이기*/
		JPanel pack = new JPanel();
		pack.setLayout(new GridLayout(6,1));
		
		pack.add(p1);
		pack.add(p2);
		pack.add(p3);
		pack.add(p4);
		pack.add(p5);
		pack.add(p6);
		
		pack.setBorder(new EmptyBorder(30,30,30,30));
		pack.setBorder(BorderFactory.createTitledBorder("결제 확인창"));
		/*다시*/
		
		
		/*버튼*/
		bt_p = new JPanel();
		pay_bt = new JButton("결제하기");
		back_bt = new JButton("돌아가기");
		bt_p.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		bt_p.add(pay_bt);
		bt_p.add(Box.createHorizontalStrut(20));
		bt_p.add(back_bt);
		bt_p.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
	                  // ButtonPanel의 테두리에 빈 여백 추가      상, 좌, 하, 우
		
		
		//setBorder(BorderFactorty.createTitleBorder("내용"))
		
		
		/*각 패널을 프레임에 붙이기*/
		add(v_point,BorderLayout.NORTH);
		add(bt_p, BorderLayout.SOUTH);
		add(pack,BorderLayout.CENTER);
		
		
		setSize(350, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new ticket_info_pay();
	}  //메인
} //클래스
