package project.swing.LJH;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ticket_seat extends JFrame{
	JPanel bt_p, v_point,seat_p,con_seat,info_movie;
	JLabel point,show_point,show_price,show_peo,show_date,show_room;
	JButton re_bt, pay_bt;
	ticket_Seat_Map seat = new ticket_Seat_Map();
	JComboBox<String> room;
	
	JButton seat_bt = new JButton("SCREEN");
	JPanel seat_p3 ;
	JPanel seat_p4 ;
	
	
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
		
		
		String[] room_name = {"미나리","개나리","빛나리"};
		
		room = new JComboBox<>(room_name);
		
		JPanel seat_p2 = new JPanel();
		seat_p2.add(seat_p);
		seat_p2.add(room);
		
		
		
		JPanel seat_pg= new JPanel();
		seat_pg.setLayout(new BorderLayout());
		seat_pg.add(seat_p2,BorderLayout.NORTH);
		
		
		seat_bt = new JButton("SCREEN");

		seat_p3 = new JPanel();
		seat_p3.setLayout(new BorderLayout());
		seat_bt.setEnabled(false);
		

		seat_p3.add(seat_bt,BorderLayout.NORTH);
		seat_bt.add(Box.createVerticalStrut(100));
		seat_p3.add(seat,BorderLayout.CENTER);
		seat_pg.add(seat_p3,BorderLayout.CENTER); //좌석표
		
	
		
		
		
		
		/*좌석확인페널*/
		con_seat = new JPanel();
		con_seat.setLayout(new BorderLayout());

		con_seat.setPreferredSize(new Dimension(150,80));		
		con_seat.setBorder(BorderFactory.createTitledBorder(" [좌석확인] "));
		
		

		
		/*매표소에 있는 선택되어진 영화정보 표시하는 패널*/
		info_movie = new JPanel();
		info_movie.setLayout(new BorderLayout());		
		info_movie.setPreferredSize(new Dimension(200,350));
		/*이것이 이 선택한 영화패널만의 크기이므로, 이 안으로 보일수있게 하자.*/ 
		info_movie.add(new JLabel(" [선택한 영화]"), BorderLayout.NORTH);
		/* **** JScrollPane를 넣어서 보이게할지 textarea 을 붙여야할지 고민해야햠! ***** */
		
		JTextArea s_movie = new JTextArea(200,210); 
		/* 선택된대로 영화 이미지 가 보일 공간*/
		
		/* 포스터 보이는 영화칸 밑에 그리드 레이아웃 위해 만듦.*/
		 
		show_room = new JLabel("ICT관");
		show_date = new JLabel("2023/06/20");
		show_peo = new JLabel("2 명");
		show_price = new JLabel("15000");
		
		JLabel j1 = new JLabel("극       장:    ");
		JLabel j2 = new JLabel("날       짜:    ");
		JLabel j3 = new JLabel("인       원:    ");
		JLabel j4 = new JLabel("금       액:    ");
		
		JPanel pg1 = new JPanel();
		pg1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pg1.add(j1);
		pg1.add(show_room);
		
		JPanel pg2 = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		pg2.add(j2);
		pg2.add(show_date);
		
		JPanel pg3 = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		pg3.add(j3);
		pg3.add(show_peo);
		
		JPanel pg4 = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		pg4.add(j4);
		pg4.add(show_price);
		
		JPanel i_pack = new JPanel(new GridLayout(4,1));
		i_pack.add(pg1);
		i_pack.add(pg2);
		i_pack.add(pg3);
		i_pack.add(pg4);
		


		info_movie.add(s_movie, BorderLayout.CENTER);
		info_movie.add(i_pack,BorderLayout.SOUTH);
		
		JPanel pg5 = new JPanel();
		pg5.setLayout(new BorderLayout());
		
		pg5.add(con_seat,BorderLayout.CENTER);
		pg5.add(info_movie,BorderLayout.EAST);
		
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
		pack.setBorder(new EmptyBorder(10,10,10,10));
		
		pack.add(v_point,BorderLayout.NORTH);
		pack.add(bt_p, BorderLayout.SOUTH);
		//pack.add(seat_pg, BorderLayout.CENTER);
		pack.add(seat_pg, BorderLayout.CENTER);
		pack.add(pg5, BorderLayout.EAST);
		
		
		add(pack);
		
		
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		room.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 updateSeatButtonPosition();
				
			}
		});
	}
		
	
	private void updateSeatButtonPosition() {
	    String selectedRoom = (String) room.getSelectedItem();
	    if (selectedRoom.equals("개나리")) {
	        seat_p3.setLayout(new BorderLayout());
	        seat_p3.add(seat, BorderLayout.EAST);
	        seat_p3.add(seat_bt, BorderLayout.CENTER);

	    } else if (selectedRoom.equals("빛나리")) {
	        seat_p3.setLayout(new BorderLayout());
	        seat_p3.add(seat_bt, BorderLayout.CENTER);
	        seat_p3.add(seat, BorderLayout.WEST);
	    } else if(selectedRoom.equals("미나리")) {
	        seat_p3.setLayout(new BorderLayout());
	        seat_p3.add(seat_bt, BorderLayout.NORTH);
	        seat_p3.add(seat, BorderLayout.CENTER);
	    }
	    seat_p3.revalidate();
	    seat_p3.repaint();
	}
	
	public static void main(String[] args) {
		new ticket_seat();
		
	}
}
