package home_;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import login.Login;
import server_getchar.Protocol;

public class Kategorie extends JPanel {

	Login login;
	ImageIcon lend_pur = new ImageIcon("src/images/lend_pur.png");
	ImageIcon alt_lend_pur = new ImageIcon("src/images/alt_lend_pur.png");
	ImageIcon sell = new ImageIcon("src/images/sell.png");
	ImageIcon alt_sell = new ImageIcon("src/images/alt_sell.png");
	public JButton new_al;
	public JButton my_info;
	
	public Kategorie(Login k22) {
		this.login = k22;

		setLayout(null);
		setBackground(Color.DARK_GRAY);

		JButton logOut_bt = new JButton("로그아웃");
		logOut_bt.setBorderPainted(false);
		logOut_bt.setFocusPainted(false);
		logOut_bt.setContentAreaFilled(false);
		logOut_bt.setHorizontalAlignment(SwingConstants.LEFT);
		logOut_bt.setBounds(25, 25, 130, 50);
		logOut_bt.setFont(new Font("HSSaemaul", Font.BOLD, 20));
		logOut_bt.setForeground(new Color(217, 171, 246));
		logOut_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(logOut_bt);

		JButton lend_pur_Bt = new JButton(lend_pur);
		lend_pur_Bt.setBorderPainted(false);
		lend_pur_Bt.setFocusPainted(false);
		lend_pur_Bt.setContentAreaFilled(false);
		lend_pur_Bt.setBounds(60, 182, 531, 240);
		lend_pur_Bt.setFont(new Font("HSSaemaul", Font.BOLD, 50));
		lend_pur_Bt.setForeground(Color.ORANGE);
		lend_pur_Bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lend_pur_Bt.setRolloverIcon(alt_lend_pur);
		add(lend_pur_Bt);

		JButton sell_Bt = new JButton(sell);
		sell_Bt.setBounds(635, 182, 289, 240);
		sell_Bt.setFont(new Font("HSSaemaul", Font.BOLD, 50));
		sell_Bt.setBorderPainted(false);
		sell_Bt.setFocusPainted(false);
		sell_Bt.setContentAreaFilled(false);
		sell_Bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sell_Bt.setRolloverIcon(alt_sell);
		add(sell_Bt);

		JButton adv_Bt = new JButton("광고");
		adv_Bt.setBounds(91, 527, 895, 97);
		adv_Bt.setForeground(Color.CYAN);
		adv_Bt.setBorderPainted(false);
		adv_Bt.setFocusPainted(false);
		adv_Bt.setContentAreaFilled(false);
		add(adv_Bt);

		my_info = new JButton("내 정보");
		my_info.setBounds(970, 35, 97, 23);
		my_info.setFont(new Font("HSSaemaul", Font.BOLD, 20));
		my_info.setForeground(Color.ORANGE);
		my_info.setBorderPainted(false);
		my_info.setFocusPainted(false);
		my_info.setContentAreaFilled(false);
		my_info.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(my_info);

		logOut_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 접속종료 프로토콜 + 로그아웃
				// 접속종료 및 로그아웃 코드
				int r = JOptionPane.showConfirmDialog(getParent(), "로그아웃 하시겠습니까 ?", "로그아웃", JOptionPane.YES_NO_OPTION);
				if (r == 0) {

					login.m_id = null;
					login.m_pw = null;
					login.p_list = null;
					login.c_list = null;
					login.pvo_vo = null;
					login.res = 0;
					login.reqVo = null;

					login.card.show(login.pg, "login");
				}
			}
		});

		my_info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login.member_info.setting();
			}
		});

		sell_Bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login.card.show(login.pg, "sell");
			}
		});

		lend_pur_Bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Protocol p = new Protocol();
				p.setCmd(5);
				try {
					login.out.writeObject(p);
					login.out.flush();
				} catch (IOException e1) {
				}
				login.card.show(login.pg, "list");
			}
		});

	}
}
