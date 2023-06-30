package project.swing.LJH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TickerSeatDAO {
	 private final String url = "jdbc:mysql://localhost:3306/db_name"; // 데이터베이스 URL
	    private final String username = "username"; // 데이터베이스 사용자 이름
	    private final String password = "password"; // 데이터베이스 비밀번호

	    // 좌석 예약 정보를 데이터베이스에 저장하는 메서드
	    public void reserveSeat(SeatReservationVO reservation) {
	        try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            String query = "INSERT INTO seat_reservation (room_name, seat_number, user_name) VALUES (?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(query);
	            statement.setString(1, reservation.getRoomName());
	            statement.setString(2, reservation.getSeatNumber());
	            statement.setString(3, reservation.getUserName());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // 좌석 예약 정보를 데이터베이스에서 조회하는 메서드
	    public SeatReservationVO getSeatReservation(String seatNumber) {
	        SeatReservationVO reservation = null;
	        try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            String query = "SELECT * FROM seat_reservation WHERE seat_number = ?";
	            PreparedStatement statement = conn.prepareStatement(query);
	            statement.setString(1, seatNumber);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                String roomName = resultSet.getString("room_name");
	                String userName = resultSet.getString("user_name");
	                reservation = new SeatReservationVO(roomName, seatNumber, userName);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return reservation;
	    }
	}