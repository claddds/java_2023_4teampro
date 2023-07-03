package Ticket_Box;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import com.toedter.calendar.JDateChooser;

//날짜 캘린더 메서드, 객체생성해서 보기.
//윈도우빌더 이용하여 작성한 코드임.
//메인에 객체 생성후 붙이자.
public class Jcalendar {

	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jcalendar window = new Jcalendar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Jcalendar() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setSize(210,210);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JCalendar calendar = new JCalendar();
		panel.add(calendar, BorderLayout.CENTER);
		
		
		
	}

}
