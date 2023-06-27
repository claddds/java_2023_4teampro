package project.swing.LJH;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ticket_Seat_Map extends JPanel{
	JCheckBox a_seat1 = new JCheckBox("A1");
	JCheckBox a_seat2 = new JCheckBox("A2");
	JCheckBox a_seat3 = new JCheckBox("A3");
	JCheckBox a_seat4 = new JCheckBox("A4");
	JCheckBox a_seat5 = new JCheckBox("A5");
	
	JCheckBox b_seat1 = new JCheckBox("B1");	
	JCheckBox b_seat2 = new JCheckBox("B2");	
	JCheckBox b_seat3 = new JCheckBox("B3");	
	JCheckBox b_seat4 = new JCheckBox("B4");	
	JCheckBox b_seat5 = new JCheckBox("B5");	
	
	JCheckBox c_seat1 = new JCheckBox("C1");	
	JCheckBox c_seat2 = new JCheckBox("C2");	
	JCheckBox c_seat3 = new JCheckBox("C3");	
	JCheckBox c_seat4 = new JCheckBox("C4");	
	JCheckBox c_seat5 = new JCheckBox("C5");	
	
	JCheckBox d_seat1 = new JCheckBox("D1");	
	JCheckBox d_seat2 = new JCheckBox("D2");	
	JCheckBox d_seat3 = new JCheckBox("D3");	
	JCheckBox d_seat4 = new JCheckBox("D4");	
	JCheckBox d_seat5 = new JCheckBox("D5");	
	
	JCheckBox e_seat1 = new JCheckBox("E1");	
	JCheckBox e_seat2 = new JCheckBox("E2");	
	JCheckBox e_seat3 = new JCheckBox("E3");	
	JCheckBox e_seat4 = new JCheckBox("E4");	
	JCheckBox e_seat5 = new JCheckBox("E5");	
	
	JCheckBox f_seat1 = new JCheckBox("F1");	
	JCheckBox f_seat2 = new JCheckBox("F2");	
	JCheckBox f_seat3 = new JCheckBox("F3");	
	JCheckBox f_seat4 = new JCheckBox("F4");	
	JCheckBox f_seat5 = new JCheckBox("F5");	
	
	JPanel seat_p, screen_p ;
	

	
	
	
	public ticket_Seat_Map() {
		
		
		seat_p = new JPanel();
		seat_p.setLayout(new GridLayout(5,5));
		
		seat_p.add(a_seat1);
		seat_p.add(b_seat1);
		seat_p.add(c_seat1);
		seat_p.add(d_seat1);
		seat_p.add(e_seat1);
		seat_p.add(f_seat1);
		
		
		seat_p.add(a_seat2);
		seat_p.add(b_seat2);
		seat_p.add(c_seat2);
		seat_p.add(d_seat2);
		seat_p.add(e_seat2);
		seat_p.add(f_seat2);
		
		
		seat_p.add(a_seat3);
		seat_p.add(b_seat3);
		seat_p.add(c_seat3);
		seat_p.add(d_seat3);
		seat_p.add(e_seat3);
		seat_p.add(f_seat3);
		
		
		seat_p.add(a_seat4);
		seat_p.add(b_seat4);
		seat_p.add(c_seat4);
		seat_p.add(d_seat4);
		seat_p.add(e_seat4);
		seat_p.add(f_seat4);
		
		seat_p.add(a_seat5);
		seat_p.add(b_seat5);
		seat_p.add(c_seat5);
		seat_p.add(d_seat5);	
		seat_p.add(e_seat5);
		seat_p.add(f_seat5);
		
		
		
		screen_p = new JPanel();
	


		add(seat_p, BorderLayout.CENTER);
		
		setSize(600,600);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new ticket_Seat_Map();
		
	}
}
