package project.LJH;

import java.io.Serializable;
import java.util.List;

import project.LJH.DB.VO;

public class Protocol implements Serializable{
	int cmd;
	//cmd : 500 : 종료, 501:영화목록 출력 502: 극장관 이름 출력, 503: 상영시간표 출력
	int result;
	List<VO> list;
	VO vo;
	String[] theater;
	String[] movie;
	String[] time;
	
	
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<VO> getList() {
		return list;
	}
	public void setList(List<VO> list) {
		this.list = list;
	}
	public VO getVo() {
		return vo;
	}
	public void setVo(VO vo) {
		this.vo = vo;
	}
	public String[] getTheater() {
		return theater;
	}
	public void setTheater(String[] theater) {
		this.theater = theater;
	}
	public String[] getMovie() {
		return movie;
	}
	public void setMovie(String[] movie) {
		this.movie = movie;
	}
	public String[] getTime() {
		return time;
	}
	public void setTime(String[] time) {
		this.time = time;
	}
	
	
	
	
	
}
