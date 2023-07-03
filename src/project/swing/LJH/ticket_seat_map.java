package project.swing.LJH;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


	//좌석선택창에 필요한 좌석 배치도 배열을위해 하나의 Jpanel 클래스를 만듦.
	//ticket_seat에 가서 객체생성후 화면에불러오자.
public class ticket_seat_map extends JPanel {
    public ticket_seat_map() {
        setLayout(new GridLayout(5, 5)); // 5x5 그리드 레이아웃 설정

        char rowLabel = 'A';
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                String seatName = String.valueOf(rowLabel) + (col + 1);

                JCheckBox seatCheckBox = new JCheckBox(seatName);
                seatCheckBox.addActionListener(new SeatCheckBoxListener()); // 리스너 추가
                add(seatCheckBox);
            }
            rowLabel++;
        }
    }

    private class SeatCheckBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox sourceCheckBox = (JCheckBox) e.getSource();
            String seatName = sourceCheckBox.getText();
            boolean isChecked = sourceCheckBox.isSelected();
            System.out.println("선택한 좌석은 " + seatName + " 좌석이 " + (isChecked ? "선택되었습니다." : "취소되었습니다."));
            //seatName 이 선택된 좌석 이름이니 , 호출하거나 set사용할때 이 이름으로 사용하자.
        
        }
    }
    
    //각 극장을 눌렀을때, 선택된 체크들이 최기화 되도록.
    public void resetSeatSelection() {
        for (Component component : getComponents()) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                checkBox.setSelected(false);
            }
        }
    }
    //좌석의 사이즈.
    public static void main(String[] args) {
        JFrame frame = new JFrame("Seat Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ticket_seat_map());
        frame.setSize(450, 450);
        frame.setVisible(true);
    }
}