package project.PJH.Pay;

import project.PJH.Pay.Pay_DAO;
import project.PJH.Pay.Pay_VO;

// 현재 로그인 사용자의 ID를 전역적으로 관리하기 위해 만듦
public class Session {

	private static Pay_VO pay_vo;
	private static String currentUserId;

	// 현재 로그인한 회원 ID를 Pay_VO의 cust_id에 세팅
	public static String getCurrentUserId() {
		// Pay_VO 객체를 생성하고 로그인한 회원의 ID
		pay_vo = new Pay_VO();
		currentUserId = Pay_DAO.getMemberLogin(pay_vo);
		pay_vo.setCust_id(currentUserId);  //로그인한 사용자 아이디. 나중엔 변수에 담아서 해야함.
		System.out.println("현재 로그인한 회원은 " + currentUserId); //현재 로그인한 회원 아이디 콘솔에서 확인해보려고 넣었음.
		return currentUserId;
	}
}
