package project.swing.LJH;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

//매표소 만들기 
public class ticket_office_main extends JFrame {
	// 필요한 것들 선언하자
	//DBService dbService = new DBService();

	JPanel v_point, c_movie, c_room, c_date, c_time,  c_people, info_movie;
	JButton ticket_bt;
	JComboBox<String> adult , child;
//	JTextField point, show_room,show_peo, show_price,show_date;
	JLabel point,show_point, show_room,show_peo, show_price,show_date;
	JTextArea show_movie;	JScrollPane jsp1,jsp2, jsp3;
	String[] movies = {};
	//String[] rooms = {"임시극장","이 리스트는","나중에","DB연동하기"};
	//String[] dates = {"임시상영표","이 리스트는","나중에","DB연동하기"};
	JCalendar cal = new JCalendar();

 
	
	public ticket_office_main() {
		super("매표소");
		
		
		/*제일 위의 잔여포인트 패널 
		*잔여포인트는 라벨명이고, 포인트칸은 텍스트필드로, 나중에 DB연동시
		*이 텍스트 필드 point에 붙여서 보일수 있도록 하자. 
		*/
		v_point = new JPanel();
		v_point.setLayout(new FlowLayout(FlowLayout.RIGHT)); 
		v_point.setBorder(new EmptyBorder(10,10,10,10)); 
		/*각 패널별로 공간띄어주기함 */
		point = new JLabel("잔여포인트:       ");		
		show_point = new JLabel("10000"); //임의숫자	
		
		v_point.add(point);
		v_point.add(show_point);
		 
		
		/*선택한 영화정보가 보이는 패널
		 *JList안에 있는 DB연동이 되어 보이는 것을 선택한대로
		 *이 곳에는 동적으로 변할 수 있도록
		 *나중에 DB연결하면 보일 수 있도록 하자. 
		 */
		info_movie = new JPanel();
		info_movie.setLayout(new BorderLayout());		
		info_movie.setPreferredSize(new Dimension(200,350));
		/*이것이 이 선택한 영화패널만의 크기이므로, 이 안으로 보일수있게 하자.*/ 
		info_movie.add(new JLabel(" [선택한 영화]"), BorderLayout.NORTH);
		/* **** JScrollPane를 넣어서 보이게할지 textarea 을 붙여야할지 고민해야햠! ***** */
		
		show_movie = new JTextArea(200,210); 
		/* 선택된대로 영화 이미지 가 보일 공간*/

	
		
		/* 포스터 보이는 영화칸 밑에 그리드 레이아웃 위해 만듦.*/
		 
		show_room = new JLabel();
		show_date = new JLabel();
		show_peo = new JLabel();
		show_price = new JLabel();
		
		JLabel j1 = new JLabel("극       장:    ");
		JLabel j2 = new JLabel("날       짜:    ");
		JLabel j3 = new JLabel("인       원:    ");
		JLabel j4 = new JLabel("금       액:    ");
		
		JPanel pg4 = new JPanel();
		pg4.setLayout(new FlowLayout(FlowLayout.LEFT));
		pg4.add(j1);
		pg4.add(show_room);
		
		JPanel pg5 = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		pg5.add(j2);
		pg5.add(show_date);
		
		JPanel pg6 = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		pg6.add(j3);
		pg6.add(show_peo);
		
		JPanel pg7 = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		pg7.add(j4);
		pg7.add(show_price);
		
		JPanel pg8 = new JPanel(new GridLayout(4,1));
		pg8.add(pg4);
		pg8.add(pg5);
		pg8.add(pg6);
		pg8.add(pg7);
		


		info_movie.add(show_movie, BorderLayout.CENTER);
		info_movie.add(pg8,BorderLayout.SOUTH);
		
		
	
		
		/*이 공간은 영화 목록이 나오고, 선택을 할 수 있는 패널
		 * 리스트 이용하여 DB랑 연동하면 예약가능한 리스트만 보이게 하자. 
		 */
		c_movie = new JPanel();
		c_movie.setLayout(new BorderLayout());		
		c_movie.setPreferredSize(new Dimension(40,60)); /*각 패널의 크기 제한*/
		c_movie.add(new JLabel(" [영화 선택] "),BorderLayout.NORTH);
		JList movie_name = new JList(); 
		/* *****나중에 여기에 db연동으로 집어넣기***** */
		jsp1 = new JScrollPane();
		jsp1.setViewportView(movie_name);
		c_movie.add(jsp1);
		
		
		/*극장 선택할 수 있는 패널*/
		c_room = new JPanel();
		c_room.setLayout(new BorderLayout());
		
		c_room.setPreferredSize(new Dimension(40,60)); /*각 패널의 크기 제한*/
		c_room.add(new JLabel(" [상영관 선택] "),BorderLayout.NORTH);
		JList movie_room = new JList();
		/* *****나중에 여기에 db연동으로 집어넣기***** */
		jsp2= new JScrollPane();
		jsp2.setViewportView(movie_room);
		c_room.add(jsp2);
		
		/*상영시간표 패널*/
		c_time = new JPanel();
		c_time.setLayout(new BorderLayout());		
		c_time.setPreferredSize(new Dimension(40,60));  /*각 패널의 크기 제한*/
		c_time.add(new JLabel(" [상영 시간표] "),BorderLayout.NORTH);
		JList movie_date = new JList();
		/* *****나중에 여기에 db연동으로 집어넣기***** */
		jsp3 = new JScrollPane(movie_date);
		c_time.add(jsp3);
		
		
		/*날짜 선택 하는 패널*/
		
		c_date = new JPanel();
		c_date.setLayout(new BorderLayout());
		c_date.setPreferredSize(new Dimension(250,300));
		c_date.add(new JLabel(" [날짜 선택] "),BorderLayout.NORTH);
		
		/*  *******날짜 API 갖고오기******* */
	
		c_date.add(cal,BorderLayout.CENTER);
		//파일보낼때 캘린더jar파일 같이보내기


		
	
		
		/*인원선택하는 패널*/
		c_people = new JPanel();
		c_people.setLayout(new BorderLayout());
		c_people.add(new JLabel(" [인원 선택] "),BorderLayout.NORTH);
		JLabel ad = new JLabel( " 성 인 " );
		JLabel ch = new JLabel( " 아 동 " );
		String[] a_peo = {"0","1","2","3","4","5","6","7","8","9","10"};
		String[] c_peo = {"0","1","2","3","4","5","6","7","8","9","10"};
		
		
		
		JPanel pg1= new JPanel();
		pg1.setLayout(new FlowLayout());
		
		adult = new JComboBox<>(a_peo);
		child = new JComboBox<>(c_peo);
		//ad.add(adult);
		//ch.add(child);
		
		pg1.add(ad);
		pg1.add(adult);
		pg1.add(ch);
		pg1.add(child);
		
		c_people.add(pg1);
		
		/*선택하는 공간 전체 패널 하나로 묶기*/
		JPanel pack = new JPanel();
		pack.setLayout(new GridLayout(2,3));
		
		pack.add(c_movie);  
		pack.add(c_room);
		pack.add(c_date);
		pack.add(c_time);
		pack.add(c_people);
		
		
		
		/*예매하기 버튼*/
		ticket_bt = new JButton("예매하기");
		ticket_bt.setLayout(new BorderLayout());
		JPanel pg2 = new JPanel();
		pg2.setLayout(new BorderLayout());
		pg2.add(ticket_bt, BorderLayout.EAST);
		
		
		
		
		
		/* 여백남기기 위해서 모든 패널 하나로 붙이기.*/
		JPanel packall = new JPanel();
		packall.setLayout(new BorderLayout());
		packall.setBorder(new EmptyBorder(0,10,10,10));
		//여백주기 
		
		//모든 패널들 프레임에 붙이기
		packall.add(v_point,BorderLayout.NORTH); //제일위의 포인트패널
		packall.add(info_movie,BorderLayout.EAST); //오른쪽의 영화정보
		packall.add(pack,BorderLayout.CENTER); //가운데의 그리드레이아웃들
		packall.add(pg2,BorderLayout.SOUTH);  //하단의버튼
		
		
		add(packall);
		
		
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		ticket_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ticket_seat con_seat = new ticket_seat();
				setVisible(false);
				
			}
		});
	
		
		/* *******각 모든 사항들을 선택하게 되면 선택한 영화정보에 보일 수 있도록 하기******  */
	}

	

	public static void main(String[] args) {
		new ticket_office_main();
		

	} // 메인
} // 클래스
