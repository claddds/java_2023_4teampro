package common;

import Pay.Pay_DAO;
import Pay.Pay_VO;

// 현재 로그인 사용자의 ID를 전역적으로 관리하기 위해 만듦
public class Session {

	private static Pay_VO pay_vo;
	private static String currentUserId;

	// 현재 로그인한 회원 ID를 Pay_VO의 cust_id에 세팅
//	public static String getCurrentUserId() {
//		System.out.println("===Session 실행===");
//		// Pay_VO 객체를 생성하고 로그인한 회원의 ID
//		pay_vo = new Pay_VO();
//		currentUserId = Pay_DAO.getMemberLogin(pay_vo);
//		System.out.println("[Session] 현재 로그인한 회원은 " + currentUserId); //현재 로그인한 회원 아이디 콘솔에서 확인해보려고 넣었음.
//		return currentUserId;
//	}
}
