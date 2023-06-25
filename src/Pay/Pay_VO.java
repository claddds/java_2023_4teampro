package Pay;

import java.io.Serializable;
import java.sql.Date;

public class Pay_VO implements Serializable{
	private String movie_name, start_time, end_time, theater_seat, movie_date;
	private int ticket_num, movie_id, cust_number, theater_id;
	
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getTheater_seat() {
		return theater_seat;
	}
	public void setTheater_seat(String theater_seat) {
		this.theater_seat = theater_seat;
	}
	public int getTicket_num() {
		return ticket_num;
	}
	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getCust_number() {
		return cust_number;
	}
	public void setCust_number(int cust_number) {
		this.cust_number = cust_number;
	}
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public String getMovie_date() {
		return movie_date;
	}
	public void setMovie_date(String movie_date) {
		this.movie_date = movie_date;
	}
	
} 
