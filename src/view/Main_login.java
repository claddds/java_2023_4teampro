package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;

public class Main_login extends JFrame{
	Movie_chart_view1 v1 = new Movie_chart_view1();
	Movie_chart_view2 v2 = new Movie_chart_view2();
	
	CardLayout card = new CardLayout();
	
	public Main_login() {
		super("영화예매프로그램");
		getContentPane().setLayout(null);
		
		JPanel sign_panel = new JPanel();
		sign_panel.setBounds(0, 0, 786, 89);
		getContentPane().add(sign_panel);
		sign_panel.setLayout(null);
		
		JButton mobile_ticket_bt = new JButton("모바일 티켓");
		mobile_ticket_bt.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		mobile_ticket_bt.setBounds(29, 23, 122, 49);
		sign_panel.add(mobile_ticket_bt);
		
		JButton mypage_bt = new JButton("마이페이지");
		mypage_bt.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		mypage_bt.setBounds(485, 23, 122, 49);
		sign_panel.add(mypage_bt);
		
		JButton sign_out_bt = new JButton("로그아웃");
		sign_out_bt.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		sign_out_bt.setBounds(619, 23, 122, 49);
		sign_panel.add(sign_out_bt);
		
		JPanel logo_panel = new JPanel();
		logo_panel.setBounds(0, 85, 786, 151);
		getContentPane().add(logo_panel);
		logo_panel.setLayout(null);
		
		JButton logo_bt = new JButton("로고 이미지");
		logo_bt.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		logo_bt.setBounds(93, 10, 575, 131);
		logo_panel.add(logo_bt);
		
		
		JPanel chart_char_panel = new JPanel();
		chart_char_panel.setBounds(0, 238, 786, 67);
		getContentPane().add(chart_char_panel);
		chart_char_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("절찬 상영중");
		lblNewLabel.setBounds(12, 10, 194, 41);
		chart_char_panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		
		JPanel movie_chart_panel = new JPanel();
		
		movie_chart_panel.setLayout(card);
		movie_chart_panel.add("view1", v1);  //화면에 이름붙임.
		movie_chart_panel.add("view2",v2);
	    card.show(movie_chart_panel, "view1");  //실행하자 마자 보이는
		movie_chart_panel.setBounds(0, 306, 786, 383);
		getContentPane().add(movie_chart_panel);
		
		
		JPanel ticketing_panel = new JPanel();
		ticketing_panel.setBounds(0, 689, 786, 74);
		getContentPane().add(ticketing_panel);
		ticketing_panel.setLayout(null);
		
		JButton ticketing_bt = new JButton("빠른 예매");
		ticketing_bt.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		ticketing_bt.setBounds(255, 15, 122, 49);
		ticketing_panel.add(ticketing_bt);
		
		JButton snack_bt = new JButton("매점");
		snack_bt.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		snack_bt.setBounds(430, 15, 122, 49);
		ticketing_panel.add(snack_bt);
		

		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		sign_out_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mobile_ticket_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Main_login();
	}
}