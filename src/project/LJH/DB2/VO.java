package project.LJH.DB2;

import java.io.Serializable;

public class VO implements Serializable{

	private String movie_name, movie_time, movie_theater;
	private int point;
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_time() {
		return movie_time;
	}
	public void setMovie_time(String movie_time) {
		this.movie_time = movie_time;
	}
	public String getMovie_theater() {
		return movie_theater;
	}
	public void setMovie_theater(String movie_theater) {
		this.movie_theater = movie_theater;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	

	}
