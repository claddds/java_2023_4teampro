package project.swing.LJH;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

//매표소 만들기 
public class ticket_office extends JFrame {
	// 필요한 것들 선언하자
	JPanel c_movie, c_room, c_date, info_time,  c_people, info_movie;
	
	JRadioButton movie_rbt1, movie_rb2t, movie_rbt3, movie_rbt4,
	room_rbt1,room_rbt2,room_rbt3,room_rbt4,
	date_rbt1,date_rbt2,date_rbt3,date_rbt4,
	time_rbt1,time_rbt2,time_rbt3,time_rbt4;
	
	JButton ticket_bt;
	JComboBox<String> adult , child;
	JTextField point;
	JTextArea movie_view;
	JScrollPane jsp ;
	
	/*JPanel c_movie, c_room, c_date, info_time,  c_people, info_movie;
	 * --순서대로 영화 선택, 극장선택, 날짜선택, 상영시간표, 인원선택, 선택된 영화정보
	JRadioButton movie_rbt,room_rbt,date_rbt,time_rbt;
	 * --순서대로 라디오버튼들이다. 이것들은 몇개만 만들어놓고, 선택할수 있도록하자. 
	JButton ticket_bt;
	 * -- 예매하기버튼
	JComboBox<String> adult , child;
	 * -- 인원을 선택할 수 있는 콤보박스 형태. 
	JTextField point;
	 * -- 포인트를 알려주려는 텍스트필드 
	JTextArea movie_view;
	 * -- 선택된 영화의 정보를 알려주는 공간 
	 */

	public ticket_office() {
		super("매표소");
		
		
		/*제일 위의 잔여포인트 패널 
		*잔여포인트는 라벨명이고, 포인트칸은 텍스트필드로, 나중에 DB연동시
		*이 텍스트 필드 point에 붙여서 보일수 있도록 하자. 
		*/
		c_movie = new JPanel();
		c_movie.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel label1 = new JLabel("잔여포인트");
		
		point = new JTextField(10);
		
		c_movie.add(label1);
		c_movie.add(point);
		
		
		/*선택한 영화정보가 보이는 패널
		 *라디오버튼으로 선택한대로 이 곳에는 동적으로 변할 수 있도록
		 *나중에 DB연결하면 보일 수 있도록 하자. 
		 *이 공간은 textArea
		 */
		info_movie = new JPanel();
		info_movie.setLayout(new BorderLayout());
		
		info_movie.setPreferredSize(new Dimension(200,600));
		info_movie.add(new JLabel(" [선택한 영화]"), BorderLayout.NORTH);
		
		jsp = new JScrollPane();
		
		
		
		
		
		
		
		
		
		
		
		
		
		//모든 것 프레임에 붙이기
		add(c_movie,BorderLayout.NORTH);
		add(info_movie,BorderLayout.EAST);
		
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new ticket_office();

	} // 메인
} // 클래스
