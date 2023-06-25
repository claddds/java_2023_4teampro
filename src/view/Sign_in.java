package view;

import javax.swing.JFrame;

public class Sign_in extends JFrame{
	public Sign_in() {
		super("영화예매프로그램");
		
		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Sign_in();
	}

}
