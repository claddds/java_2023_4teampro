package project.swing.LJH;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ticket_seat extends JFrame{
	JPanel bt_p, v_point,seat_p,con_seat;
	JLabel point,show_point;
	JButton re_bt, pay_bt;
	
	public ticket_seat() {
		super("좌석선택창");
		
		
		
		/*잔여포인트 패널*/
		v_point = new JPanel();
		v_point.setLayout(new FlowLayout(FlowLayout.RIGHT)); 
		v_point.setBorder(new EmptyBorder(10,10,10,10)); 
		/*각 패널별로 공간띄어주기함 */
		point = new JLabel("잔여포인트:       ");		
		show_point = new JLabel("10000"); //임의숫자	
		
		v_point.add(point);
		v_point.add(show_point);
		 
		
		/*좌석패널*/
		seat_p = new JPanel();
		seat_p.setLayout(new BorderLayout());
		seat_p.add(new JLabel(" [좌석선택] "),BorderLayout.NORTH);
		
		
		
		/*좌석확인페널*/
		con_seat = new JPanel();
		con_seat.setLayout(new BorderLayout());
		con_seat.add(new JLabel(" [좌석확인] "),BorderLayout.NORTH);
		
		
		
		/* 마지막 버튼 패널 */
		bt_p = new JPanel();
		pay_bt = new JButton("예매하기");
		re_bt = new JButton("다시선택");
		bt_p.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		bt_p.add(re_bt);
		bt_p.add(Box.createHorizontalStrut(20));
		bt_p.add(pay_bt);
		bt_p.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
		
		
		
		
		
		JPanel pack = new JPanel(new BorderLayout());
		pack.setBorder(new EmptyBorder(20,20,20,20));
		
		pack.add(v_point,BorderLayout.NORTH);
		pack.add(bt_p, BorderLayout.SOUTH);
		pack.add(seat_p, BorderLayout.CENTER);
		pack.add(con_seat, BorderLayout.EAST);
		
		add(pack);
		
		
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
	}
	
	
	
	public static void main(String[] args) {
		new ticket_seat();
	}
}
