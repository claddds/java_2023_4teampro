package Pay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Reservation_completed extends JFrame {
	JPanel mainPanel, textPanel, buttonPanel;
	JButton mobileTicket, main;

	public Reservation_completed() {
		super("예매 완료");

		setLayout(new BorderLayout());

		// 예매 완료 메시지를 담을 라벨 생성 및 설정
		JLabel messageLabel = new JLabel("예매가 완료되었습니다.");
		messageLabel.setFont(new Font("돋움", Font.BOLD, 20));
		//라벨이 messageLabel 안에서 가운데 정렬되도록 설정
		messageLabel.setHorizontalAlignment(JLabel.CENTER);
		messageLabel.setBorder(new EmptyBorder(20, 0, 0, 0));

		// 라벨을 중앙에 추가
		add(messageLabel, BorderLayout.CENTER);

		// 버튼 패널 생성
		JPanel buttonPanel = new JPanel();

		// 버튼 생성
		JButton mobileTicketButton = new JButton("모바일티켓");
		JButton homeButton = new JButton("처음으로");

		// 버튼 패널에 버튼 추가
		buttonPanel.add(mobileTicketButton);
		buttonPanel.add(homeButton);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		// 버튼 패널을 하단에 추가
		add(buttonPanel, BorderLayout.SOUTH);

		
		setSize(350, 250); 
		setLocationRelativeTo(null); 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

	}

	public static void main(String[] args) {
		new Reservation_completed();
	}
}