package project.LJH;

import java.io.Serializable;
import java.util.List;

import project.LJH.DB.VO;

public class Protocol implements Serializable{
	//cmd : 0 : 종료, 301:영화목록 출력 302: 상영시간표 출력 303 : 잔여포인트
	int cmd;
	int result;
	
	List<VO> list;
	VO vo;
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
	
	
	
	
	
	
	
	
	
	
	
}
