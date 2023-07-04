package project.LJH3;

import java.io.Serializable;
import java.util.List;

import project.LJH.DB.VO;

public class Protocol implements Serializable{
	//cmd : 300 : 종료, 301:영화목록 출력 302: 극장관 이름 출력
	//303: 상영시간표 출력 304 : 잔여포인트
	int cmd;
	int result;
	private String msg;
	private List<VO> list;
	private VO vo;
	
	
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
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
	
	
	
	
	
	
	
	
	
	
}
