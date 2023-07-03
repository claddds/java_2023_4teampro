package project.LJH.DB;

import java.io.Serializable;

public class VO implements Serializable{

	private String movie_name,start_time,end_time,theater_id;
	
	private int remaining_point;

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

	public String getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(String theater_id) {
		this.theater_id = theater_id;
	}

	public int getRemaining_point() {
		return remaining_point;
	}

	public void setRemaining_point(int remaining_point) {
		this.remaining_point = remaining_point;
	}
	
	

	}
