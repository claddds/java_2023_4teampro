package ticketbox;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import c_loginout.Sign_in;
//이걸로 합치기!
//좌석선택창에 필요한 좌석 배치도 배열을위해 하나의 Jpanel 클래스를 만듦.
//ticket_seat에 가서 객체생성후 화면에불러오자.
public class Ticket_seat_map extends JPanel {
	Sign_in sign_in;
	private ArrayList<String> selectedSeats = new ArrayList<>();
	JCheckBox seatCheckBox,sourceCheckBox;
	String seatName;

	public Ticket_seat_map(Sign_in signin) {

		
		this.sign_in = signin;
		
		setLayout(new GridLayout(5, 5)); // 5x5 그리드 레이아웃 설정

		JFrame frame = new JFrame("Seat Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().add(new Ticket_seat_map());
		frame.setSize(450, 450);
		//frame.setVisible(true);
		
		char rowLabel = 'A';
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				String seatName = String.valueOf(rowLabel) + (col + 1);

				seatCheckBox = new JCheckBox(seatName);
				seatCheckBox.addActionListener(new SeatCheckBoxListener()); // 리스너 추가
				add(seatCheckBox);
			}
			rowLabel++;
		}
		
		

		
	}

	private class SeatCheckBoxListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        sourceCheckBox = (JCheckBox) e.getSource();
	        seatName = sourceCheckBox.getText();
	        boolean isChecked = sourceCheckBox.isSelected();
	        if (isChecked) {
	        	selectedSeats.add(seatName);
	        } else {
	        	selectedSeats.remove(seatName);
	        }
	        System.out.println("선택한 좌석은 " + seatName + " 좌석이 " + (isChecked ? "선택되었습니다." : "취소되었습니다."));
	        
	        StringBuilder sb = new StringBuilder();

		    for (String seat : selectedSeats) {
		        sb.append(seat).append(", ");
		    }

		    if (sb.length() > 0) {
		        sb.setLength(sb.length() - 2);  // Remove the trailing comma and space
		    }

		    sign_in.t_seat.lblNewLabel_4.setText(sb.toString());
		}
	     
	    }
	
	
	private void updateSelectedSeatsLabel() {
	    StringBuilder sb = new StringBuilder();

	    for (String seat : selectedSeats) {
	        sb.append(seat).append(", ");
	    }

	    if (sb.length() > 0) {
	        sb.setLength(sb.length() - 2);  // Remove the trailing comma and space
	    }

	    sign_in.t_seat.lblNewLabel_4.setText(sb.toString());
	}
	
	// 각 극장을 눌렀을때, 선택된 체크들이 최기화 되도록.
	public void resetSeatSelection() {
		for (Component component : getComponents()) {
			if (component instanceof JCheckBox) {
				JCheckBox checkBox = (JCheckBox) component;
				checkBox.setSelected(false);
			}
		}
	}

	
	
	

	}
