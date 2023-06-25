package Ticket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class TicketList extends JFrame {
	JPanel Panel;
	JTable table;
	JButton ticketButton;

	public TicketList() {
		super("티켓 리스트");

		Panel = new JPanel(new BorderLayout());
		JPanel headerPanel = new JPanel(new BorderLayout());

		// "티켓 리스트" 라벨 추가
		JLabel titleLabel = new JLabel("티켓 리스트");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 25));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10)); // 여백 추가
		headerPanel.add(titleLabel, BorderLayout.NORTH);
		Panel.add(headerPanel, BorderLayout.NORTH);

		// JTable의 컬럼 이름 배열
		String[] columnNames = { "영화이름", "상영일자", "상영시간", "상영관", "좌석" };

		// JTable의 초기 데이터 배열
		Object[][] data = { { "스파이더맨", "2023-06-21", "10:00", "1층 (1관)", "A1, A2, A3" },
				{ "겨울왕국", "2023-06-22", "14:00", "2층 (2관)", "B1, B2, B3" }, 
				{ "해리포터", "2023-06-23", "18:00", "3층 (3관)", "C1, C2, C3" },
				{ "타이타닉", "2023-06-24", "19:00", "4층 (4관)", "D1, D2, D3" }};

		// DefaultTableModel을 사용하여 JTable 생성
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);

		// JScrollPane을 사용하여 JTable을 스크롤 가능하도록 추가
		JScrollPane scrollPane = new JScrollPane(table);
		// JScrollPane의 크기를 조정
		scrollPane.setPreferredSize(new Dimension(800, 400));
		// JPanel에 JScrollPane 추가
		Panel.add(headerPanel, BorderLayout.NORTH);
		Panel.add(scrollPane, BorderLayout.CENTER);

		// "티켓 확인" 버튼 생성
		JPanel ButtonPanel = new JPanel();
		ticketButton = new JButton("티켓 확인");
		ButtonPanel.add(ticketButton);
		Panel.add(ButtonPanel, BorderLayout.SOUTH);

		// JFrame에 Panel 추가
		add(Panel);

		setSize(350, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); // 크기 조절 비활성화

		// "티켓 확인" 버튼
		ticketButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

	public static void main(String[] args) {
		new TicketList();
	}
}
