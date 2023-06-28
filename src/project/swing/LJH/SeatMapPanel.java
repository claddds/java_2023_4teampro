package project.swing.LJH;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SeatMapPanel extends JPanel {
    private JCheckBox[][] seats;
    private boolean[][] seatAvailability;

    public SeatMapPanel() {
        setLayout(new GridLayout(5, 5));

        seats = new JCheckBox[5][5];
        seatAvailability = new boolean[5][5];

        // 좌석 예약 가능 여부 초기화
        for (int row = 0; row < 5; row++) { 
            for (int col = 0; col < 5; col++) {
                seatAvailability[row][col] = true;
            }
        }

        // 좌석표 체크박스 생성 및 패널에 추가
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                seats[row][col] = new JCheckBox();
               // seats[row][col].setEnabled(false); // 초기에는 모든 좌석을 선택할 수 없도록 비활성화
                add(seats[row][col]);
            }
        }
        
    }
     

    // 좌석 예약 가능 여부 업데이트
    private void updateSeatAvailability() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                seats[row][col].setEnabled(seatAvailability[row][col]);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Seat Map Frame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                SeatMapPanel seatMapPanel = new SeatMapPanel();
                frame.getContentPane().add(seatMapPanel);

                frame.setSize(450,450);
                frame.setVisible(true);

            }
        });
    }
}