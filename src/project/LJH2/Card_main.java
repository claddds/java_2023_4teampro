package project.LJH2;

import java.awt.CardLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Card_main extends JFrame implements Runnable {
	CardLayout cardlayout;
	Socket s = null;
	ObjectOutputStream out = null;
	ObjectInputStream in = null;
	Box_one one;
	Box_two two;
	Box_three thr;
	JPanel pg1, pg2,pg3;

	public Card_main() {
		super("영화예매ver0.1");
		
		cardlayout = new CardLayout();
		
		pg1 = new JPanel();
		//pg1.setBorder(new EmptyBorder(0, 10, 10, 10));
		pg1.setLayout(cardlayout);
		//카드생성
		
		one = new Box_one(this);
		two = new Box_two(this);
		thr = new Box_three(this);
		
		
		
		pg1.add("ticket_box", one);
		pg1.add("ticket_seat", two);
		pg1.add("con_pay", thr);
		
		cardlayout.show(pg1, "con_pay");
		
		
		add(pg1);
		setSize(800,800);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		
		
		
		
		
		
		
		
		
	} //화면단 메인 끝
	





	public boolean connected() {
		boolean value = true;
		try {
			s = new Socket("192.168.0.80", 7779);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());

			new Thread(this).start();
			return value;
		} catch (Exception e) {

		}
		return false;
	}

	public void closed() {
		try {
			out.close();
			in.close();
			s.close();

		} catch (Exception e) {

		}
	}

	@Override
	public void run() {


	}

	public static void main(String[] args) {
		new Card_main();
	}
}
