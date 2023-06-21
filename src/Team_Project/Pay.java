package Team_Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pay extends JFrame {
	JPanel northPanel, centerPanel, remainingPanel, payPanel, ButtonPanel;
	JButton pay, cancel;

	public Pay() {
		super("결제");
		
		getContentPane().setBackground(Color.WHITE);

		// 잔여포인트
		remainingPanel = new JPanel();
		remainingPanel.setLayout(new BoxLayout(remainingPanel, BoxLayout.Y_AXIS));
		
		JPanel remainingPanel_1 = new JPanel();
		remainingPanel_1.setPreferredSize(new Dimension(180, 50)); //remainingPanel_1 패널의 너비,높이
		// remainingPanel_1.setBackground(Color.WHITE);
		
		JPanel remainingPanel_2 = new JPanel();
		remainingPanel_2.setLayout(new BoxLayout(remainingPanel_2, BoxLayout.X_AXIS));
		JLabel jl1 = new JLabel("   잔여 포인트  :");  // 라벨 생성
		jl1.setFont(jl1.getFont().deriveFont(Font.BOLD, 15));  // 큰 글꼴 크기(16)로 설정
		JLabel jl2 = new JLabel("  10,000 ");
		jl2.setFont(jl1.getFont().deriveFont(Font.BOLD, 15));
		jl2.setBorder(BorderFactory.createEmptyBorder()); // 테두리 설정
		
		remainingPanel_2.add(jl1);
		remainingPanel_2.add(jl2);
		remainingPanel_2.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // 검은색 테두리
		remainingPanel_2.setMaximumSize(new Dimension(remainingPanel_1.getPreferredSize()));
		// 이거 없으면 테두리가 양옆으로 길어짐
		
		remainingPanel.add(remainingPanel_1);
		remainingPanel.add(remainingPanel_2);
		// remainingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		// 패널의 내부 여백 (상, 좌, 하, 우)

		// 결제포인트
		payPanel = new JPanel();
		payPanel.setLayout(new BoxLayout(payPanel, BoxLayout.Y_AXIS));
		JPanel payPanel_1 = new JPanel();
		payPanel_1.setPreferredSize(new Dimension(180, 0)); 
		
		JPanel payPanel_2 = new JPanel();
		payPanel_2.setLayout(new BoxLayout(payPanel_2, BoxLayout.X_AXIS));
		JLabel jl3 = new JLabel("   결제 포인트  :");
		jl3.setFont(jl3.getFont().deriveFont(Font.BOLD, 15));
		JLabel jl4 = new JLabel("  30,000 ");
		jl4.setFont(jl1.getFont().deriveFont(Font.BOLD, 15));
		jl4.setBorder(BorderFactory.createEmptyBorder());
		payPanel_2.add(jl3);
		payPanel_2.add(jl4);
		payPanel_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		payPanel_2.setMaximumSize(new Dimension(payPanel_1.getPreferredSize()));
		
		
		payPanel.add(payPanel_1);
		payPanel.add(payPanel_2);
		

		// 결제, 취소 버튼
		ButtonPanel = new JPanel();
		pay = new JButton("결제하기");
		cancel = new JButton("취소하기");
		ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		ButtonPanel.add(pay);
		ButtonPanel.add(Box.createHorizontalStrut(20));
		ButtonPanel.add(cancel);
		ButtonPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
						// ButtonPanel의 테두리에 빈 여백 추가      상, 좌, 하, 우

		setLayout(new BorderLayout());
		add(remainingPanel, BorderLayout.NORTH);
		add(payPanel, BorderLayout.CENTER);
		add(ButtonPanel, BorderLayout.SOUTH);
		add(Box.createVerticalStrut(20), BorderLayout.WEST);
		add(Box.createVerticalStrut(20), BorderLayout.EAST);

		setSize(350, 250);
		setLocationRelativeTo(null); //현재 화면의 중앙에 표시
		setVisible(true); // 닫힐 때 프로그램이 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); // 크기 조절 비활성화

	}

	public static void main(String[] args) {
		new Pay();
	}
}

