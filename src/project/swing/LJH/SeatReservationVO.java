package project.swing.LJH;

import java.io.Serializable;

public class SeatReservationVO implements Serializable{
	    private String roomName;
	    private String seatNumber;
	    private String userName;
	    private String movieName;

	    public String getMovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}

		public void setSeatNumber(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public SeatReservationVO(String roomName, String seatNumber, String userName) {
	        this.roomName = roomName;
	        this.seatNumber = seatNumber;
	        this.userName = userName;
	    }

	    public String getRoomName() {
	        return roomName;
	    }

	    public String getSeatNumber() {
	        return seatNumber;
	    }

	    public String getUserName() {
	        return userName;
	    }
	}

