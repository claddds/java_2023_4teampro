package Ticket_Box;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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

	JPanel v_point, c_movie, c_room, c_date, c_time, c_people, info_movie;
	// 포인트표시 패널과 영화선택표시 , 상영관선택, 날짜 선택칸, 시간 선택칸, 인원선택칸, 선택한 영화표시패널을 선언함.
	JButton ticket_bt;
	// 예매하기버튼.
	JComboBox<String> adult, child;
	// 인원선택에 필요한 숫자 콤보벅스 선언,
	JLabel point, show_point, show_room, show_peo1, show_peo2, show_price1, show_price2, show_price3, show_date;
	// 각 타이틀과 화면에 선택한 내용들이 선택한 영화 정보 밑에 출력 될수 있기위한 라벨을 선언함.
	JTextArea show_movie;
	// 영화 포스터를 위한 자리 **나중에 area 말고, 다른 것으로 하게되면 변경해야함**
	JScrollPane jsp1, jsp2, jsp3;
	// **날짜 선택칸에 Jcalendar를 이용하여 만들었기에 객체를 생성하여 선언함.
	// 내용은 Jcalendar 클래스로 넘어가서 확인하자. - 윈도우빌더로 만든 클래스.

	JCalendar cal = new JCalendar();

	int res1, res2;
	String price_ad, price_ch;

	public ticket_office_main() {
		super("매표소");

		/*
		 * 제일 위의 잔여포인트 패널 잔여포인트는 라벨명이고, 포인트칸은 라벨로, 나중에 DB연동시 이 JLabel point에 붙여서 보일수 있도록
		 * 하자.
		 */
		v_point = new JPanel();
		v_point.setLayout(new FlowLayout(FlowLayout.RIGHT));
		v_point.setBorder(new EmptyBorder(10, 10, 10, 10));
		/* 각 패널별로 공간띄어주기함 */
		point = new JLabel("잔여포인트:       ");
		show_point = new JLabel(); // 포인트 DB에서 가져올 잔여포인트자리 .

		v_point.add(point);
		v_point.add(show_point);

		/*
		 * 선택한 영화정보가 보이는 패널 JList안에 있는 리스트들은 DB연동이 되어 보이는 것들로, 마우스로 선택한것들이 이 곳에는 동적으로 변할
		 * 수 있도록 나중에 DB연결하면 보일 수 있도록 하자.
		 */
		info_movie = new JPanel();
		// 선택한 영화정보 패널 선언.
		info_movie.setLayout(new BorderLayout());
		info_movie.setPreferredSize(new Dimension(200, 350));
		info_movie.add(new JLabel(" [선택한 영화]"), BorderLayout.NORTH);

		show_movie = new JTextArea(200, 210);
		/* 선택된대로 영화 이미지 가 보일 공간 */
		// 영화 포스터를 위한 자리 **나중에 area 말고, 다른 것으로 하게되면 변경해야함**

		show_room = new JLabel();
		show_date = new JLabel();
		show_peo1 = new JLabel();
		show_peo2 = new JLabel();
		show_peo1.setText("성인 :   " + " 명"); // default 로 보여줄 문구
		show_peo2.setText("아동 :   " + " 명"); // default 로 보여줄 문구
		show_price1 = new JLabel();
		show_price2 = new JLabel();
		show_price3 = new JLabel();
		

		// 각 라벨을 선언함. 이 위의 것들은 매표소에서 마우스로 클릭하여 선택한것들이
		// 보여지는 라벨이다. 동적으로 변하게 액션리스너 사용하자.

		JLabel j1 = new JLabel("극       장:    ");
		JLabel j2 = new JLabel("날       짜:    ");
		JLabel j3 = new JLabel("인       원:    ");
		JLabel j4 = new JLabel("금       액:    ");
		JLabel j5 = new JLabel("총 금 액:    ");
		// 탭 선언.

		// 각탭들을 그리드레이아웃하기 위해 각각 패널로 선언하여 집어넣음.
		JPanel pg4 = new JPanel();
		pg4.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pg5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pg6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pg7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pg9 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		pg4.add(j1);
		pg4.add(show_room);

		pg5.add(j2);
		pg5.add(show_date);

		pg6.add(j3);
		pg6.add(show_peo1);
		pg6.add(show_peo2);

		pg7.add(j4);
		pg7.add(show_price1);
		pg7.add(show_price2);

		pg9.add(j5);
		pg9.add(show_price3);

		// 각 탭을 그리드레이아웃할 패널 생성 하고붙이기.
		JPanel pg8 = new JPanel(new GridLayout(5, 1));
		pg8.add(pg4);
		pg8.add(pg5);
		pg8.add(pg6);
		pg8.add(pg7);
		pg8.add(pg9);

		// 선택한 영화패널인 info_movie에 포스터공간과 각 정보탭을 붙이기.
		info_movie.add(show_movie, BorderLayout.CENTER);
		info_movie.add(pg8, BorderLayout.SOUTH);

		/*
		 * 이 공간은 영화 목록이 나오고, 선택을 할 수 있는 패널 리스트 이용하여 DB랑 연동하면 예약가능한 리스트만 보이게 하자.
		 */

		c_movie = new JPanel();
		c_movie.setLayout(new BorderLayout());

		c_movie.setPreferredSize(new Dimension(40, 60)); /* 각 패널의 크기 제한 */
		c_movie.add(new JLabel(" [영화 선택] "), BorderLayout.NORTH);
		
		JList movie_name = new JList();
		
		//VO vo = new VO();
		//JList movie_name1 = DAO.getMovieName(vo);
		/* *****나중에 여기에 db연동으로 집어넣기***** */
			
		
		jsp1 = new JScrollPane();
		jsp1.setViewportView(movie_name);
		// ****"movie_name" 이 리스트 이고, db 연결시 이 곳에 뜰수있도록 해야한다. ****
		c_movie.add(jsp1);

		/* 극장 선택할 수 있는 패널 */
		c_room = new JPanel();
		c_room.setLayout(new BorderLayout());

		c_room.setPreferredSize(new Dimension(40, 60)); /* 각 패널의 크기 제한 */
		c_room.add(new JLabel(" [극장 선택] "), BorderLayout.NORTH);

		JList movie_room = new JList();
		/* *****나중에 여기에 db연동으로 집어넣기***** */

		jsp2 = new JScrollPane();
		
		jsp2.setViewportView(movie_room);
		// ****"movie_room" 이 리스트 이고, db 연결시 이 곳에 뜰수있도록 해야한다. ****
		c_room.add(jsp2);

		/* 상영시간표 패널 */
		c_time = new JPanel();
		c_time.setLayout(new BorderLayout());
		c_time.setPreferredSize(new Dimension(40, 60)); /* 각 패널의 크기 제한 */
		c_time.add(new JLabel(" [상영 시간표] "), BorderLayout.NORTH);

		JList movie_data = new JList();
		/* *****나중에 여기에 db연동으로 집어넣기***** */
		jsp3 = new JScrollPane(movie_data);
		// ****"movie_data" 이 리스트 이고, db 연결시 이 곳에 뜰수있도록 해야한다. ****
		c_time.add(jsp3);

		/* 날짜 선택 하는 패널 */

		c_date = new JPanel();
		c_date.setLayout(new BorderLayout());
		c_date.setPreferredSize(new Dimension(250, 300));
		c_date.add(new JLabel(" [날짜 선택] "), BorderLayout.NORTH);

		/* *******날짜 API 갖고오기******* */

		c_date.add(cal, BorderLayout.CENTER);
		// 파일보낼때 캘린더jar파일 같이보내기
		// 날짜를 선택한것이 바로 선택한영화정보 밑의 날짜에 출력될수있도록
		// ****캘린더+마우스리스너(또는 해당 리스너 또는 액션리스너 이용하기. 날짜캘린더 변수는 "cal"이다)******

		/* 날짜 선택시 일주일 이상 선택하지 못하게 하기. */
		Calendar today = Calendar.getInstance();
		Calendar maxDate = (Calendar) today.clone();
		maxDate.add(Calendar.WEEK_OF_YEAR, 1);

		cal.setMaxSelectableDate(maxDate.getTime());

		/* 인원선택하는 패널 */
		c_people = new JPanel();
		c_people.setLayout(new BorderLayout());
		c_people.add(new JLabel(" [인원 선택] "), BorderLayout.NORTH);

		JLabel ad = new JLabel(" 성 인 ");
		JLabel ch = new JLabel(" 아 동 ");
		String[] a_peo = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		String[] c_peo = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		JPanel pg1 = new JPanel();
		// 성인, 아동 라벨과 각 콤보를 하나로 만들기위한 패널 생성.
		pg1.setLayout(new FlowLayout());
		// 한줄로 출력될수있도록 만들기.

		adult = new JComboBox<>(a_peo);
		child = new JComboBox<>(c_peo);

		pg1.add(ad);
		pg1.add(adult);
		pg1.add(ch);
		pg1.add(child);
		c_people.add(pg1);

		/* 선택하는 공간 전체 패널 하나로 묶기 */
		JPanel pack = new JPanel();
		pack.setLayout(new GridLayout(2, 3));

		pack.add(c_movie);
		pack.add(c_room);
		pack.add(c_date);
		pack.add(c_time);
		pack.add(c_people);

		/* 예매하기 버튼 */
		ticket_bt = new JButton("예매하기");

		JPanel pg2 = new JPanel();
		// 버튼을 보더레이아웃으로 만들어 오른쪽에 붙이기 위한 패널 생성.

		pg2.setLayout(new BorderLayout());
		pg2.add(ticket_bt, BorderLayout.EAST);

		/* 여백남기기 위해서 모든 패널 하나로 붙이기. */
		JPanel packall = new JPanel();
		packall.setLayout(new BorderLayout());
		packall.setBorder(new EmptyBorder(0, 10, 10, 10));
		// 여백주기

		// 모든 패널들 프레임에 붙이기
		packall.add(v_point, BorderLayout.NORTH); // 제일위의 포인트패널
		packall.add(info_movie, BorderLayout.EAST); // 오른쪽의 영화정보
		packall.add(pack, BorderLayout.CENTER); // 가운데의 그리드레이아웃들 (선택할 것들, 영화선택, 상영관 날짜, 상영시간표, 인원등)
		packall.add(pg2, BorderLayout.SOUTH); // 하단의버튼

		add(packall);

		// 매표소의 창 크기 지정.
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// 예매하기 버튼을 눌렀을경우에 좌석 선택창으로 넘어가진다.
		// 매표소는 숨겨지고, 좌석확인창을 객체 생성하여 보이게 한다.
		ticket_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ticket_seat con_seat = new ticket_seat();
				setVisible(false);

			}
		});

		// 날짜를 선택했을때, 선택한 영화정보 탭의 날짜에 표시하게하는 이벤트

		cal.addPropertyChangeListener("calendar", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("calendar")) {
					Calendar selectedDate = (Calendar) evt.getNewValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String formattedDate = dateFormat.format(selectedDate.getTime());
					show_date.setText(formattedDate);
				}
			}
		});

		// 성인과 아동 인원을 선택하였을 경우, 선택한 영화정보에 동적으로 바뀔수있도록 출력하기.
		adult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String selectedOption = (String) combo.getSelectedItem();
				show_peo1.setText("성인 : " + selectedOption + " 명");
				if (selectedOption == "0") {
					show_peo1.setText("성인 :   " + " 명");
				}

				if (selectedOption != null) {
					int ad = Integer.parseInt(selectedOption);
					res1 = ad * 10000;
					price_ad = String.valueOf(res1);
					show_price1.setText(price_ad);
				}

			}
		});

		child.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String selectedOption = (String) combo.getSelectedItem();
				show_peo2.setText("아동 : " + selectedOption + " 명");
				if (selectedOption == "0") {
					show_peo2.setText("아동 :   " + " 명");
				}
				if (selectedOption != null) {
					int ad = Integer.parseInt(selectedOption);
					res2 = ad * 5000;
					price_ch = String.valueOf(res2);
					show_price2.setText(price_ch);

				}

			}
		});

	
		
	
		
	}

	public static void main(String[] args) {
		new ticket_office_main();

	} // 메인

} // 클래스
