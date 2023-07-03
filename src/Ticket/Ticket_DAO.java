package Ticket;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.session.SqlSession;

import common.DB_Service;

public class Ticket_DAO {
	// 실제 사용하는 클래스
		private static SqlSession ss;
	 
		// 싱글턴 패턴(동기화 처리) : 프로그램 종료시까지 한 번 만들어진 객체를 재사용하는 형식
		private synchronized static SqlSession getsession() {
			if (ss == null) {
				ss = DB_Service.getFactory().openSession();
			}
			return ss;
		}
		
	//DB 처리하는 메서드들
		
	// 로그인한 회원의 예매 내역 리스트
	public ArrayList<Ticket_VO> getTicketList(String cust_id) {
		List<Ticket_VO> ticketList = getsession().selectList("getTicketList", cust_id);
		return  (ArrayList<Ticket_VO>) ticketList;
	}
	
	// 리스트에서 선택된 티켓 정보 가져오기
	public Ticket_VO getTicketByRow(JTable table, int row) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String ticketNum = model.getValueAt(row, 0).toString();
		String movieName = model.getValueAt(row, 1).toString();
        String movieDate = model.getValueAt(row, 2).toString();
        String startTime = model.getValueAt(row, 3).toString();
        String theaterId = model.getValueAt(row, 4).toString();
        String theaterSeat = model.getValueAt(row, 5).toString();
    
        Ticket_VO ticket = new Ticket_VO();
        ticket.setTicket_num(Integer.parseInt(ticketNum));
        ticket.setMovie_name(movieName);
        ticket.setMovie_date(Date.valueOf(movieDate));
        ticket.setStart_time(startTime);
        ticket.setTheater_id(theaterId);
        ticket.setTheater_seat(theaterSeat);
        
        return ticket;
	}
	
	// 예매 취소하기
	public static int cancelTicket(int ticket_num) {
		int result = getsession().delete("cancelTicket", ticket_num);
	    return result;
	}
}
