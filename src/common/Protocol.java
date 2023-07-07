package common;

import java.io.Serializable;
import java.util.ArrayList;

import pay.Pay_VO;
import ticket.Ticket_VO;

public class Protocol implements Serializable{

	// 100: 종료
	// 101: 로그인 한 회원 찾기 (나중에)
	// 102: 로그인한 회원 잔여포인트 가져오기
	// 103: 결제 완료 후 티켓 INSERT
	// 104: 현재 로그인 회원의 티켓 리스트 출력
	
	private int cmd;
	private String msg;
	private int result;
	private Pay_VO pay_vo;
	private Ticket_VO ticket_vo;
	private ArrayList<Ticket_VO> list;
	
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
	public Ticket_VO getTicket_vo() {
		return ticket_vo;
	}
	public void setTicket_vo(Ticket_VO ticket_vo) {
		this.ticket_vo = ticket_vo;
	}
	public ArrayList<Ticket_VO> getList() {
		return list;
	}
	public void setList(ArrayList<Ticket_VO> list) {
		this.list = list;
	}
}