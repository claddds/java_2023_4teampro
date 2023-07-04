package project.LJH.DB;

import java.io.Serializable;
import java.util.List;

public class VO implements Serializable{

	//private String movie_name,start_time,end_time;
	private String theater_id;
	private int remaining_point;
	
	private List<VO> movie_name,start_time,end_time;

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

	public List<VO> getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(List<VO> movie_name) {
		this.movie_name = movie_name;
	}

	public List<VO> getStart_time() {
		return start_time;
	}

	public void setStart_time(List<VO> start_time) {
		this.start_time = start_time;
	}

	public List<VO> getEnd_time() {
		return end_time;
	}

	public void setEnd_time(List<VO> end_time) {
		this.end_time = end_time;
	}
	
	
	
	
	
}
	


