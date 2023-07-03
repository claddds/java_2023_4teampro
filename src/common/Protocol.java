package common;

import java.io.Serializable;

import Pay.Pay_VO;

public class Protocol implements Serializable{

	// 0: 현재 로그인한 회원 찾기
	// 1: 로그인한 회원 잔여포인트 가져오기
	// 2: 결제 완료 후 티켓 INSERT
	
	int cmd;
	String msg;
	
	int result;
	Pay_VO pay_vo;
	
	
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Pay_VO getPay_vo() {
		return pay_vo;
	}
	public void setPay_vo(Pay_VO pay_vo) {
		this.pay_vo = pay_vo;
	}
}