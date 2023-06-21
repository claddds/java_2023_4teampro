package Team_Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class MobileTicket extends JFrame {
	JPanel MainP, CenterWrapperPanel, ButtonPanel;
	JButton cancel;

	public MobileTicket() {
		super("모바일티켓");

		MainP = new JPanel();
		MainP.setLayout(new BoxLayout(MainP, BoxLayout.Y_AXIS));
		add(MainP);

		JPanel NorthPanel = new JPanel();
		JLabel titleLabel = new JLabel("모바일 티켓");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 25));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

		NorthPanel.add(titleLabel);

		// 센터 패널을 감싸는 패널
		CenterWrapperPanel = new JPanel(new BorderLayout());
		CenterWrapperPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		MainP.add(CenterWrapperPanel);

		// 예매 내용
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.setBackground(Color.WHITE);
		JLabel NameLabel = new JLabel("스파이더맨");
		NameLabel.setFont(new Font("굴림", Font.BOLD, 25));
		p1.add(NameLabel);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.setBackground(Color.WHITE);
		JLabel DayLabel = new JLabel("2023-06-20(화)");
		DayLabel.setFont(new Font("굴림", Font.BOLD, 15));
		p2.add(DayLabel);

		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3.setBackground(Color.WHITE);
		JLabel TimeLabel = new JLabel("10:30 ~ 11:50");
		TimeLabel.setFont(new Font("굴림", Font.BOLD, 18));
		p3.add(TimeLabel);

		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p4.setBackground(Color.WHITE);
		JLabel RoomLabel = new JLabel("1층 (1관)");
		// (roomNumber + "(1층) "+ seatStr + " 총(" +person+"명)");
		RoomLabel.setFont(new Font("굴림", Font.BOLD, 18));
		p4.add(RoomLabel);

		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p5.setBackground(Color.WHITE);
		JLabel SeatLabel = new JLabel("G열7 G열8");
		SeatLabel.setFont(new Font("굴림", Font.BOLD, 18));
		p5.add(SeatLabel);

		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p6.setBackground(Color.WHITE);
		JLabel line = new JLabel("============================================");
		p6.add(line);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		JPanel p7 = new JPanel(new BorderLayout());
		JTextArea text1 = new JTextArea("- 지연 입장에 의한 관람불편을 최소화하고자 본 영화는 약 10분 후에 시작됩니다.");
		text1.setLineWrap(true);
		text1.setWrapStyleWord(true);
		text1.setEditable(false);
		text1.setMargin(new Insets(0, 5, 0, 0)); // 상, 좌, 하, 우 여백 설정
		p7.add(text1, BorderLayout.CENTER);

		JPanel p8 = new JPanel(new BorderLayout());
		JTextArea text2 = new JTextArea("- 관람에티켓을 위한 사전입장을 부탁드립니다.");
		text2.setLineWrap(true);
		text2.setWrapStyleWord(true);
		text2.setEditable(false);
		text2.setMargin(new Insets(20, 5, 0, 0)); // 상, 좌, 하, 우 여백 설정
		p8.add(text2, BorderLayout.CENTER);
		
		// 한 패널에 붙이기(그리드로 만들기 위해)
		JPanel InfoPanel = new JPanel();
		InfoPanel.setBackground(Color.WHITE);
		InfoPanel.setPreferredSize(new Dimension(300, 300));
		InfoPanel.setLayout(new GridLayout(8, 1));

		InfoPanel.add(p1);
		InfoPanel.add(p2);
		InfoPanel.add(p3);
		InfoPanel.add(p4);
		InfoPanel.add(p5);
		InfoPanel.add(p6);
		InfoPanel.add(p7);
		InfoPanel.add(p8);

		// 센터 패널
		JPanel CenterPanel = new JPanel(new BorderLayout());
		CenterPanel.setPreferredSize(new Dimension(250, 430));
		CenterPanel.setBackground(Color.WHITE);
		Border border = BorderFactory.createLineBorder(Color.BLACK); // 테두리 생성
		CenterPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); // 테두리와 빈 여백 설정
		MainP.add(CenterPanel);

		// 이미지 크기 조정
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/barcode.png"));
		Image image = icon.getImage().getScaledInstance(300, 80, Image.SCALE_DEFAULT);
		ImageIcon resizedIcon = new ImageIcon(image);
		
		// 이미지를 JLabel에 추가
		JLabel img = new JLabel(resizedIcon);
		img.setHorizontalAlignment(JLabel.CENTER);
		
		CenterPanel.add(InfoPanel, BorderLayout.NORTH);
		CenterPanel.add(img, BorderLayout.SOUTH);
		
		CenterWrapperPanel.add(CenterPanel, BorderLayout.NORTH);
		
		// 버튼 패널
		ButtonPanel = new JPanel();
		cancel = new JButton("예매취소");
		// cancel.setFont(new Font("돋움", Font.BOLD, 10)); 버튼 크기
		ButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		// ButtonPanel의 테두리에 빈 여백 추가      상, 좌, 하, 우
		ButtonPanel.add(cancel);

		MainP.add(NorthPanel, BorderLayout.NORTH);
		MainP.add(CenterWrapperPanel, BorderLayout.CENTER);
		MainP.add(ButtonPanel, BorderLayout.SOUTH);

		setSize(350, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}

	public static void main(String[] args) {
		new MobileTicket();
	}
}