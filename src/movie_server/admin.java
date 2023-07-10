package movie_server;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class admin extends JPanel {

	
	public admin() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("회원 관리");
		btnNewButton.setBounds(12, 230, 180, 325);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("주문 관리");
		btnNewButton_1.setBounds(213, 230, 180, 325);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("영화 관리");
		btnNewButton_2.setBounds(408, 230, 180, 325);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("매점 관리");
		btnNewButton_3.setBounds(608, 230, 180, 325);
		add(btnNewButton_3);
		
		
		JLabel logo = new JLabel();
		//logo.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		logo.setBounds(95, 31, 575, 180); //131
		
		this.add(logo);
		
		ImageIcon originalIcon4 = new ImageIcon("src/images/logo.png");
		Image originalImage4 = originalIcon4.getImage();
		int lblWidth = logo.getWidth();  // 라벨의 크기를 얻어옵니다.
		int lblHeight = logo.getHeight();
		Image resizedImage4 = originalImage4.getScaledInstance(lblWidth, lblHeight,  java.awt.Image.SCALE_SMOOTH);

		
		JButton admin = new JButton("홈으로");
		admin.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		admin.setBounds(330, 680, 122, 49);
		this.add(admin);
	}
}
