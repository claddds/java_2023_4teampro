package project.swing.LJH;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ticket_cal extends JFrame implements ActionListener {
	Calendar cal;
	int year, month, date;
	JPanel cal_p = new JPanel();

	
	//버튼추가
	JButton bt1 = new JButton("<");
	JButton bt2 = new JButton(">");
	
	//라벨 추가
	JLabel year_lb = new JLabel("년");
	JLabel month_lb = new JLabel("월");
	
	//년월추가 
	JComboBox<Integer> yearcombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearmodel = new DefaultComboBoxModel<Integer>();
	JComboBox<Integer> monthcombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> monthmodel = new DefaultComboBoxModel<Integer>();
	
	//패널추가
	JPanel p1 = new JPanel(new BorderLayout());
	JPanel title = new JPanel(new GridLayout(1,7));
	String titleStr[] = {"일","월","화","수","목","금","토"};
	JPanel date_p = new JPanel(new GridLayout(0,7));

	public ticket_cal() {
		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		date= cal.get(Calendar.DATE);
		
		for(int i=year-100; i<=year+50; i++) {
			yearmodel.addElement(i);
		}
		yearcombo.setModel(yearmodel);
		yearcombo.setSelectedItem(year);
		
		for (int i = 1; i < 12; i++) {
			monthmodel.addElement(i);
			
		}
		monthcombo.setModel(monthmodel);
		monthcombo.setSelectedItem(month);
		
		for (int i = 0; i < titleStr.length; i++) {
			JLabel lb2 = new JLabel(titleStr[i], JLabel.CENTER);
			if(i==0) {
				lb2.setForeground(Color.red);				
			}else if(i==6) {
				lb2.setForeground(Color.blue);
			}
			title.add(lb2);
		}
		
		day(year,month);
		
		setTitle("날짜");
		cal_p.add(bt1);
		cal_p.add(yearcombo);
		cal_p.add(year_lb);
		cal_p.add(monthcombo);
		cal_p.add(month_lb);
		cal_p.add(bt2);
		cal_p.setBackground(Color.cyan);
		
		
		add(BorderLayout.NORTH,cal_p);
		p1.add(title,"North");
		p1.add(date_p);
		add(BorderLayout.CENTER,p1);
		
		setVisible(true);
		setSize(250,350);
		setResizable(false);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		yearcombo.addActionListener(this);
		monthcombo.addActionListener(this);
		
		
		
		
	}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventobj= e.getSource();
				if(eventobj instanceof JComboBox) {
					date_p.setVisible(false);
					date_p.removeAll();
					day((Integer)yearcombo.getSelectedItem(),(Integer)monthcombo.getSelectedItem());
					date_p.setVisible(true);
					
				} else if(eventobj instanceof JButton) {
					JButton eventbt =(JButton)eventobj;
					int yy =(Integer)yearcombo.getSelectedItem();
					int mm = (Integer)monthcombo.getSelectedItem();
					if(eventbt.equals(bt1)) {
						if(mm==1) {
							yy--; mm=12;
						}else {
							mm--;
						}
					}else if(eventbt.equals(bt2)) {
						if(mm==12) {
							yy++;mm=1;
						}else {
							mm++;
						}
					}
					yearcombo.setSelectedItem(yy);
					monthcombo.setSelectedItem(mm);
				}
				
			}
	
		
		
		
		
		
	
	
	
	public void day(int year, int month) {
		Calendar date = Calendar.getInstance();
		date.set(year, month-1,1);
		int week = date.get(Calendar.DAY_OF_WEEK);
		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for (int space=1; space<week; space++) {
			date_p.add(new JLabel("\t"));
			
			
		}
		for (int day = 1; day < lastDay; day++) {
			JLabel lb1 = new JLabel(String.valueOf(day),JLabel.CENTER);
			cal.set(year,month-1,day);
			int Week = cal.get(Calendar.DAY_OF_WEEK);
			if(Week==1) {
				lb1.setForeground(Color.red);
			} else if(Week==7) {
				lb1.setForeground(Color.blue);
			}
			date_p.add(lb1);
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		new ticket_cal();
		
	
	}
}
