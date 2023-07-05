package movie_server;

import java.io.Serializable;
import java.util.List;

public class Protocol implements Serializable{
	/*
		cmd 0 -> 종료(접속해제)
		
		cmd 501 -> 로그인
		cmd 502 -> 회원가입
		
	*/
	int cmd;
	List<CustomerVO> c_list;
	
	int result;
	public List<CustomerVO> getC_list() {
		return c_list;
	}

	public void setC_list(List<CustomerVO> c_list) {
		this.c_list = c_list;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	CustomerVO vo; // 직렬화를 미리 해두어야 함

	public CustomerVO getVo() {
		return vo;
	}

	public void setVo(CustomerVO vo) {
		this.vo = vo;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
}
