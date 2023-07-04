package project.LJH.DB3;

import java.io.Serializable;

public class VO implements Serializable{

	private String movie_name,start_time,end_time;
	private int theater_id;
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
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public int getRemaining_point() {
		return remaining_point;
	}
	public void setRemaining_point(int remaining_point) {
		this.remaining_point = remaining_point;
	}

	/*
	 * @Override public String toString() { return "VO [movie_name=" + movie_name +
	 * ", theater_id=" + theater_id + ", start_time=" + start_time + ", end_time=" +
	 * end_time + "]"; }
	 */
}
	


